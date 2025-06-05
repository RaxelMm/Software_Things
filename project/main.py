import mysql.connector
from datetime import datetime
from pywebio.input import *
from pywebio.output import *
from pywebio.session import info as session_info, run_js, set_env
from pywebio import start_server
from flask import Flask
from pywebio.platform.flask import webio_view

# --- COPIADO DE TU CÓDIGO: CONEXIÓN A BD Y LÓGICA DE NEGOCIO ---
def conectar():
    """Establece la conexión con la base de datos MySQL."""
    try:
        conn = mysql.connector.connect(
            host="shortline.proxy.rlwy.net",
            port=47316,
            user="root",
            password="cHHzHOJVpxFjPXLJsUQPHMNiZhCECXfJ", # Considera usar variables de entorno para la contraseña
            database="gamestore_db"
        )
        return conn
    except mysql.connector.Error as err:
        print(f"Error de conexión a la base de datos (desde conectar()): {err}")
        # En PyWebIO, es mejor lanzar un error o mostrarlo en la UI
        # En lugar de solo imprimir en la consola del servidor.
        # Para este ejemplo, lo mantenemos simple.
        return None

class GameStoreManager:
    def __init__(self):
        self.db_conn = conectar()
        if self.db_conn:
            print("GameStoreManager: Conectado a la base de datos.")
            self._crear_tablas_si_no_existen()
        else:
            print("GameStoreManager: No se pudo conectar a la base de datos.")
            # Esto es un problema crítico para la app web, se debe notificar al usuario

    def _execute_query(self, query, params=None, fetch=None, commit=False, is_ddl=False):
        if not self.db_conn or not self.db_conn.is_connected():
            print("GameStoreManager: Intentando reconectar...")
            self.db_conn = conectar()
            if not self.db_conn:
                print("GameStoreManager: Fallo al reconectar.")
                # En PyWebIO, esto debería resultar en un error visible para el usuario
                raise Exception("Error de base de datos: No se pudo reconectar.")

        use_dictionary_cursor = isinstance(fetch, str) and 'dict' in fetch
        cursor = None
        try:
            cursor = self.db_conn.cursor(dictionary=use_dictionary_cursor)
            cursor.execute(query, params or ())
            if commit or is_ddl:
                self.db_conn.commit()
            if fetch:
                if fetch == 'one' or fetch == 'dict_one':
                    return cursor.fetchone()
                elif fetch == 'all' or fetch == 'dict_all':
                    return cursor.fetchall()
            return True # Para operaciones de commit o DDL exitosas
        except mysql.connector.Error as err:
            print(f"GameStoreManager DB Error: {err} (Query: {query[:100]}... Params: {params})")
            if self.db_conn and self.db_conn.is_connected() and (commit or is_ddl): # Rollback en DDL tambien si falla
                try: self.db_conn.rollback()
                except mysql.connector.Error as roll_err: print(f"Rollback Error: {roll_err}")
            # Propagar el error para que la UI lo maneje
            raise Exception(f"Error en la operación de base de datos: {err}")
        finally:
            if cursor: cursor.close()

    def _crear_tablas_si_no_existen(self):
        queries = {
            "videojuegos": """
                CREATE TABLE IF NOT EXISTS videojuegos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(255) NOT NULL,
                    categoria VARCHAR(100),
                    precio DECIMAL(10, 2) NOT NULL,
                    consola VARCHAR(100),
                    genero VARCHAR(100),
                    cantidad INT DEFAULT 0
                );""",
            "clientes": """
                CREATE TABLE IF NOT EXISTS clientes (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(255) NOT NULL,
                    email VARCHAR(255) UNIQUE
                );""",
            "ventas": """
                CREATE TABLE IF NOT EXISTS ventas (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    id_cliente INT,
                    id_videojuego INT,
                    nombre_videojuego_vendido VARCHAR(255) NOT NULL,
                    precio_venta DECIMAL(10, 2) NOT NULL,
                    cantidad_vendida INT DEFAULT 1,
                    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE SET NULL,
                    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id) ON DELETE RESTRICT
                );"""
        }
        for tabla, query in queries.items():
            try:
                if self._execute_query(query, is_ddl=True):
                    print(f"GameStoreManager: Tabla '{tabla}' verificada/creada.")
                else: # _execute_query ahora devuelve True o lanza excepción
                    print(f"GameStoreManager: Problema al crear/verificar tabla '{tabla}' (no debería llegar aquí si lanza excepción).")
            except Exception as e:
                 print(f"GameStoreManager: Error al crear/verificar tabla '{tabla}': {e}")
                 # Esto es crítico, la app podría no funcionar.

    def is_connected(self):
        return self.db_conn and self.db_conn.is_connected()

    def add_videojuego_gui(self, nombre, categoria, precio, consola, genero, cantidad):
        if not nombre or precio is None or cantidad is None:
            return False, "Nombre, Precio y Cantidad son obligatorios."
        try:
            precio_float = float(precio)
            cantidad_int = int(cantidad)
            if precio_float < 0: return False, "El precio no puede ser negativo."
            if cantidad_int < 0: return False, "La cantidad no puede ser negativa."
        except ValueError:
            return False, "Precio y Cantidad deben ser números válidos."

        query = "INSERT INTO videojuegos (nombre, categoria, precio, consola, genero, cantidad) VALUES (%s, %s, %s, %s, %s, %s)"
        params = (nombre, categoria, precio_float, consola, genero, cantidad_int)
        try:
            self._execute_query(query, params, commit=True)
            return True, f"Videojuego '{nombre}' agregado exitosamente con stock {cantidad_int}."
        except Exception as e:
            return False, f"Error al agregar videojuego '{nombre}': {e}"

    def update_videojuego_stock_gui(self, juego_id, nueva_cantidad_total):
        if juego_id is None: return False, "No se seleccionó ningún videojuego."
        try:
            cantidad_int = int(nueva_cantidad_total)
            if cantidad_int < 0: return False, "La nueva cantidad total no puede ser negativa."
        except ValueError:
            return False, "La nueva cantidad total debe ser un número entero válido."

        query = "UPDATE videojuegos SET cantidad = %s WHERE id = %s"
        params = (cantidad_int, juego_id)
        try:
            self._execute_query(query, params, commit=True)
            return True, f"Stock del videojuego ID {juego_id} actualizado a {cantidad_int} unidades."
        except Exception as e:
            return False, f"Error al actualizar el stock del videojuego ID {juego_id}: {e}"

    def add_cliente_gui(self, nombre, email):
        if not nombre: return False, "El nombre del cliente es obligatorio."
        email_param = email if email else None
        query = "INSERT INTO clientes (nombre, email) VALUES (%s, %s)"
        params = (nombre, email_param)
        try:
            self._execute_query(query, params, commit=True)
            return True, f"Cliente '{nombre}' agregado exitosamente."
        except Exception as e:
            # Podría ser un error de email duplicado (UNIQUE constraint)
            return False, f"Error al agregar cliente '{nombre}'. Verifique si el email ya existe o detalle: {e}"

    def delete_cliente_gui(self, cliente_id):
        if cliente_id is None: return False, "No se seleccionó ningún cliente."
        query = "DELETE FROM clientes WHERE id = %s"
        try:
            self._execute_query(query, (cliente_id,), commit=True)
            return True, f"Cliente ID {cliente_id} borrado exitosamente."
        except Exception as e:
            return False, f"Error al borrar el cliente ID {cliente_id}: {e}"

    def get_catalogo_videojuegos(self, solo_con_stock=False):
        query = "SELECT id, nombre, categoria, precio, consola, genero, cantidad FROM videojuegos"
        if solo_con_stock: query += " WHERE cantidad > 0"
        query += " ORDER BY nombre"
        try:
            return self._execute_query(query, fetch='dict_all')
        except Exception as e:
            put_error(f"Error al obtener catálogo: {e}") # Mostrar error en UI
            return [] # Devolver lista vacía para que la UI no rompa

    def get_clientes_for_selection(self):
        query = "SELECT id, nombre, email FROM clientes ORDER BY nombre"
        try:
            return self._execute_query(query, fetch='dict_all')
        except Exception as e:
            put_error(f"Error al obtener clientes: {e}")
            return []

    def get_videojuego_by_id(self, juego_id):
        query = "SELECT id, nombre, precio, cantidad FROM videojuegos WHERE id = %s"
        try:
            return self._execute_query(query, (juego_id,), fetch='dict_one')
        except Exception as e:
            put_error(f"Error al obtener videojuego por ID: {e}")
            return None

    def realizar_venta_gui(self, id_videojuego, id_cliente, cantidad_a_vender):
        if not isinstance(cantidad_a_vender, int) or cantidad_a_vender <= 0:
            return False, "La cantidad a vender debe ser un número entero positivo."
        try:
            juego_info = self.get_videojuego_by_id(id_videojuego)
            if not juego_info: return False, f"Error: Videojuego con ID {id_videojuego} no encontrado."

            nombre_videojuego_vendido = juego_info['nombre']
            precio_venta_unitario = juego_info['precio']
            stock_actual = juego_info['cantidad']

            if stock_actual < cantidad_a_vender:
                return False, f"Stock insuficiente para '{nombre_videojuego_vendido}'. Disponible: {stock_actual}, Solicitado: {cantidad_a_vender}."

            cliente_id_param = id_cliente if id_cliente is not None else None
            query_venta = "INSERT INTO ventas (id_cliente, id_videojuego, nombre_videojuego_vendido, precio_venta, cantidad_vendida, fecha_venta) VALUES (%s, %s, %s, %s, %s, %s)"
            fecha_actual = datetime.now()
            params_venta = (cliente_id_param, id_videojuego, nombre_videojuego_vendido, precio_venta_unitario, cantidad_a_vender, fecha_actual)

            self._execute_query(query_venta, params_venta, commit=True) # Primera transacción: Registrar venta

            nuevo_stock = stock_actual - cantidad_a_vender
            query_actualizar_stock = "UPDATE videojuegos SET cantidad = %s WHERE id = %s"
            params_actualizar_stock = (nuevo_stock, id_videojuego)
            
            self._execute_query(query_actualizar_stock, params_actualizar_stock, commit=True) # Segunda transacción: Actualizar stock
            return True, f"Venta de '{nombre_videojuego_vendido}' (x{cantidad_a_vender}) completada. Stock actualizado a {nuevo_stock}."
        except Exception as e: # Si algo falla, la lógica de rollback está en _execute_query (parcialmente)
                               # Idealmente, estas dos operaciones (venta y actualización de stock) deberían ser una transacción atómica.
                               # MySQL Connector/Python no soporta transacciones multi-statement fácilmente sin Stored Procedures.
                               # Por ahora, si el primer _execute_query (venta) tiene éxito y el segundo (stock) falla,
                               # el mensaje de error lo indicará. La lógica de rollback en _execute_query maneja el commit/rollback individual.
            return False, f"Error durante la venta: {e}. Verifique el estado del stock y la venta."


    def get_all_sales_report(self):
        query = """
            SELECT v.id, c.nombre AS nombre_cliente, v.nombre_videojuego_vendido,
                   v.precio_venta, v.cantidad_vendida, v.fecha_venta
            FROM ventas v
            LEFT JOIN clientes c ON v.id_cliente = c.id
            ORDER BY v.fecha_venta DESC;
        """
        try:
            return self._execute_query(query, fetch='dict_all')
        except Exception as e:
            put_error(f"Error al obtener reporte de ventas: {e}")
            return []

    def get_total_revenue_report(self):
        query = "SELECT SUM(precio_venta * cantidad_vendida) AS total FROM ventas"
        try:
            resultado = self._execute_query(query, fetch='dict_one')
            if resultado and resultado['total'] is not None:
                return resultado['total'], "Ingresos totales calculados."
            elif resultado and resultado['total'] is None:
                return 0.0, "No hay ventas registradas."
            else: # Esto no debería pasar si la query es correcta y la tabla existe
                return 0.0, "No se pudo calcular, asumiendo 0 ventas."
        except Exception as e:
            put_error(f"Error al obtener ingresos totales: {e}")
            return None, f"Error al calcular ingresos totales: {e}"


    def get_sales_by_client_report(self):
        query = """
            SELECT c.nombre AS nombre_cliente, COUNT(v.id) AS numero_transacciones,
                   SUM(v.cantidad_vendida) AS total_juegos_comprados,
                   SUM(v.precio_venta * v.cantidad_vendida) AS total_gastado
            FROM clientes c
            JOIN ventas v ON c.id = v.id_cliente
            GROUP BY c.id, c.nombre
            ORDER BY total_gastado DESC;
        """
        try:
            report_data = self._execute_query(query, fetch='dict_all')
            if report_data is None: # Error en _execute_query que devuelve None
                return None, "Error al generar el informe de ventas por cliente."
            if not report_data: # Lista vacía (sin error)
                return [], "No hay ventas registradas o clientes con ventas."
            return report_data, "Informe de ventas por cliente generado."
        except Exception as e:
            put_error(f"Error al obtener ventas por cliente: {e}")
            return None, f"Error al generar el informe de ventas por cliente: {e}"


    def cerrar_conexion(self):
        if self.db_conn and self.db_conn.is_connected():
            self.db_conn.close()
            print("GameStoreManager: Conexión cerrada.")

# --- FIN CÓDIGO COPIADO Y LIGERAMENTE AJUSTADO ---

# --- FUNCIONES DE LA INTERFAZ PYWEBIO ---
manager = GameStoreManager() # Instancia global para esta demo sencilla.
                             # En una app Flask más robusta, se podría manejar por sesión o request.

def go_home():
    """Redirige a la página principal (recarga la app PyWebIO)."""
    run_js('window.location.reload()') # Simple para recargar la app/sesión

def pywebio_add_videojuego():
    clear()
    put_markdown("## ➕ Agregar Nuevo Videojuego")
    data = input_group("Datos del Videojuego", [
        input("Nombre (*)", name="nombre", type=TEXT, required=True),
        input("Categoría", name="categoria", type=TEXT),
        input("Precio (*)", name="precio", type=FLOAT, required=True, validate=lambda p: "El precio no puede ser negativo" if p < 0 else None),
        input("Consola", name="consola", type=TEXT),
        input("Género", name="genero", type=TEXT),
        input("Cantidad Inicial (*)", name="cantidad", type=NUMBER, required=True, validate=lambda c: "La cantidad no puede ser negativa" if c < 0 else None)
    ])
    if data:
        success, message = manager.add_videojuego_gui(
            data['nombre'], data['categoria'], data['precio'],
            data['consola'], data['genero'], data['cantidad']
        )
        if success:
            toast(message, color='success', duration=5)
            pywebio_view_catalogo() # Mostrar catálogo actualizado
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_add_videojuego, color="warn")
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")


def pywebio_update_stock():
    clear()
    put_markdown("## 🔄 Modificar Stock de Videojuego")
    
    videojuegos = manager.get_catalogo_videojuegos() # Todos
    if not videojuegos:
        put_warning("No hay videojuegos registrados para modificar stock.")
        put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
        return

    options = [{'label': f"{j['nombre']} (ID: {j['id']}, Stock actual: {j['cantidad']})", 'value': j['id']} for j in videojuegos]
    
    selected_id = select("Seleccionar Videojuego", options=options)
    
    juego_seleccionado = next((j for j in videojuegos if j['id'] == selected_id), None)
    if juego_seleccionado:
        put_text(f"Stock actual de '{juego_seleccionado['nombre']}': {juego_seleccionado['cantidad']}")

    nueva_cantidad = input("Nueva Cantidad Total (*)", type=NUMBER, required=True,
                           validate=lambda c: "La cantidad no puede ser negativa" if c < 0 else None)

    if nueva_cantidad is not None: # El input devuelve None si se cancela un grupo, aquí es individual
        success, message = manager.update_videojuego_stock_gui(selected_id, nueva_cantidad)
        if success:
            toast(message, color='success', duration=5)
            pywebio_view_catalogo()
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_update_stock, color="warn")
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")


def pywebio_add_cliente():
    clear()
    put_markdown("## 👤 Agregar Nuevo Cliente")
    data = input_group("Datos del Cliente", [
        input("Nombre (*)", name="nombre", type=TEXT, required=True),
        input("Email (opcional)", name="email", type=TEXT)
    ])
    if data:
        success, message = manager.add_cliente_gui(data['nombre'], data['email'])
        if success:
            toast(message, color='success', duration=5)
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_add_cliente, color="warn")
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")


def pywebio_delete_cliente():
    clear()
    put_markdown("## 🗑️ Borrar Cliente")
    clientes = manager.get_clientes_for_selection()
    if not clientes:
        put_warning("No hay clientes registrados.")
        put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
        return

    options = [{'label': f"{c['nombre']} (ID: {c['id']}) - Email: {c.get('email', 'N/A')}", 'value': c['id']} for c in clientes]
    cliente_id = select("Seleccionar Cliente a Borrar", options=options)
    
    if cliente_id is not None:
        confirm = actions(buttons=[{'label': 'Confirmar Borrado', 'value': True, 'color': 'danger'},
                                   {'label': 'Cancelar', 'value': False, 'color':'secondary'}],
                          help_text=f"¿Seguro que desea borrar al cliente ID {cliente_id}? Esto no borrará sus ventas, pero se desvincularán.")
        if confirm:
            success, message = manager.delete_cliente_gui(cliente_id)
            if success:
                toast(message, color='success', duration=5)
            else:
                toast(message, color='error', duration=5)
        else:
            toast("Borrado cancelado.", duration=3)
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")


def pywebio_view_catalogo(show_menu_button=True):
    clear()
    put_markdown("## 🎮 Catálogo de Videojuegos")
    catalogo = manager.get_catalogo_videojuegos()
    if catalogo is None: # Error ya manejado en get_catalogo_videojuegos
        put_error("Hubo un error al cargar el catálogo.")
    elif not catalogo:
        put_info("El catálogo de videojuegos está vacío.")
    else:
        header = ['ID', 'Nombre', 'Categoría', 'Precio ($)', 'Consola', 'Género', 'Stock']
        data_rows = [[
            j['id'], j['nombre'], j.get('categoria', '-'),
            f"{j['precio']:.2f}",
            j.get('consola', '-'), j.get('genero', '-'),
            j.get('cantidad', 0)
        ] for j in catalogo]
        put_table([header] + data_rows)
    
    if show_menu_button:
        put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")

def pywebio_realizar_venta():
    clear()
    put_markdown("## 🛒 Realizar Venta")

    juegos_stock = manager.get_catalogo_videojuegos(solo_con_stock=True)
    if not juegos_stock:
        put_warning("No hay videojuegos con stock disponible para la venta.")
        put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
        return

    clientes = manager.get_clientes_for_selection()

    juego_options = [{'label': f"{j['nombre']} (${j['precio']:.2f}) - Stock: {j['cantidad']}",
                      'value': j['id']} for j in juegos_stock]
    
    cliente_options = [{'label': "[Cliente Anónimo/Invitado]", 'value': None}]
    cliente_options.extend([{'label': f"{c['nombre']} (ID: {c['id']})", 'value': c['id']} for c in clientes])

    data = input_group("Detalles de la Venta", [
        select("Videojuego (*)", name="id_videojuego", options=juego_options, required=True),
        select("Cliente", name="id_cliente", options=cliente_options), # No 'required' para permitir anónimo
        input("Cantidad a Vender (*)", name="cantidad", type=NUMBER, value=1, required=True,
              validate=lambda c: "La cantidad debe ser al menos 1" if c <= 0 else None)
    ])

    if data:
        juego_seleccionado_info = next((j for j in juegos_stock if j['id'] == data['id_videojuego']), None)
        if not juego_seleccionado_info:
            toast("Videojuego seleccionado no es válido.", color='error', duration=5)
            put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
            put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
            return

        if juego_seleccionado_info['cantidad'] < data['cantidad']:
            toast(f"Stock insuficiente para '{juego_seleccionado_info['nombre']}'. Disponible: {juego_seleccionado_info['cantidad']}", color='error', duration=5)
            put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
            put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
            return
            
        precio_total_estimado = juego_seleccionado_info['precio'] * data['cantidad']
        cliente_nombre_display = next((opt['label'] for opt in cliente_options if opt['value'] == data['id_cliente']), "Desconocido")

        confirm_msg = (f"Vender {data['cantidad']} unidad(es) de '{juego_seleccionado_info['nombre']}'\n"
                       f"Precio Unitario: ${juego_seleccionado_info['precio']:.2f}\n"
                       f"Precio Total: ${precio_total_estimado:.2f}\n"
                       f"Al cliente: {cliente_nombre_display}\n"
                       f"Stock actual: {juego_seleccionado_info['cantidad']} -> Nuevo stock: {juego_seleccionado_info['cantidad'] - data['cantidad']}")
        
        confirm = actions(buttons=[{'label': 'Confirmar Venta', 'value': True, 'color': 'success'},
                                   {'label': 'Cancelar', 'value': False, 'color':'secondary'}],
                          help_text=confirm_msg)
        if confirm:
            success, message = manager.realizar_venta_gui(
                data['id_videojuego'], data['id_cliente'], data['cantidad']
            )
            if success:
                toast(message, color='success', duration=5)
                pywebio_view_catalogo() # Mostrar catálogo actualizado
            else:
                toast(message, color='error', duration=10) # Más tiempo para leer errores complejos
                put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
        else:
            toast("Venta cancelada.", duration=3)

    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")

def pywebio_show_informes():
    clear()
    put_markdown("## 📊 Informes de Ventas")

    def show_all_sales():
        with use_scope("report_area", clear=True):
            sales_data = manager.get_all_sales_report()
            if not sales_data:
                put_info("No hay ventas registradas.")
                return
            header = ['ID Venta', 'Cliente', 'Videojuego', 'Precio Unit.', 'Cant.', 'Total Venta', 'Fecha']
            rows = [[
                v['id'], v.get('nombre_cliente', 'Anónimo'), v['nombre_videojuego_vendido'],
                f"${v['precio_venta']:.2f}", v.get('cantidad_vendida', 1),
                f"${v['precio_venta'] * v.get('cantidad_vendida', 1):.2f}",
                v['fecha_venta'].strftime('%Y-%m-%d %H:%M:%S') if v.get('fecha_venta') else 'N/A'
            ] for v in sales_data]
            put_table([header] + rows)

    def show_total_revenue_report():
        with use_scope("report_area", clear=True):
            total, message = manager.get_total_revenue_report()
            if total is not None:
                put_markdown(f"### Ingresos Totales: `${total:.2f}`")
            else:
                put_error(message)
    
    def show_sales_by_client_report():
        with use_scope("report_area", clear=True):
            data, message = manager.get_sales_by_client_report()
            if data is None: # Error
                put_error(message)
                return
            if not data: # Vacío
                put_info(message) # "No hay ventas..."
                return
            
            header = ['Cliente', 'Nº Transacciones', 'Total Juegos', 'Total Gastado ($)']
            rows = [[
                r['nombre_cliente'], r['numero_transacciones'],
                r['total_juegos_comprados'], f"${r['total_gastado']:.2f}"
            ] for r in data]
            put_table([header] + rows)

    put_buttons([
        dict(label="Todas las Ventas", value="all", onclick=show_all_sales, color="primary"),
        dict(label="Ingresos Totales", value="total", onclick=show_total_revenue_report, color="primary"),
        dict(label="Ventas por Cliente", value="client", onclick=show_sales_by_client_report, color="primary")
    ], group=True)
    
    put_scope("report_area") # Contenedor para los reportes
    show_all_sales() # Mostrar el primero por defecto

    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary", scope=GLOBAL)


# --- FUNCIÓN PRINCIPAL DE PYWEBIO ---
def gamestore_web_app():
    """Punto de entrada principal de la aplicación PyWebIO."""
    set_env(title="GameStore Manager Web", output_max_width="80%")
    clear() # Limpia la pantalla en cada "navegación" al menú principal

    if not manager.is_connected():
        put_error("CRÍTICO: No se pudo conectar a la base de datos al iniciar la aplicación. "
                  "Por favor, revise la configuración y la consola del servidor.")
        return

    put_markdown("# 🏪 GameStore Manager Web")
    put_buttons([
        dict(label="🎮 Ver Catálogo", value="catalogo", onclick=lambda: pywebio_view_catalogo(show_menu_button=True), color="primary"),
        dict(label="➕ Agregar Videojuego", value="add_juego", onclick=pywebio_add_videojuego),
        dict(label="🔄 Modificar Stock", value="update_stock", onclick=pywebio_update_stock),
        dict(label="👤 Agregar Cliente", value="add_cliente", onclick=pywebio_add_cliente),
        dict(label="🗑️ Borrar Cliente", value="delete_cliente", onclick=pywebio_delete_cliente),
        dict(label="🛒 Realizar Venta", value="venta", onclick=pywebio_realizar_venta, color="success"),
        dict(label="📊 Informes de Ventas", value="informes", onclick=pywebio_show_informes, color="info")
    ], onclick=None) # onclick=None para que los onclick de cada botón individual funcionen

# --- CONFIGURACIÓN PARA FLASK (PARA RAILWAY) ---
# Railway buscará una forma de ejecutar una app web, Flask es una opción común.
# Necesitarás un archivo `requirements.txt` con:
# Flask
# PyWebIO
# mysql-connector-python
# gunicorn (recomendado para producción en Railway)

# Y un `Procfile` (si Railway no detecta Flask automáticamente con gunicorn):
# web: gunicorn main:app_flask -w 1 # Asumiendo que este archivo se llama main.py

app_flask = Flask(__name__)
app_flask.add_url_rule('/gamestore', 'webio_view', webio_view(gamestore_web_app, cdn=True),
                       methods=['GET', 'POST', 'OPTIONS']) # cdn=True es bueno para PyWebIO

if __name__ == '__main__':
    # Para probar localmente con Flask (recomendado antes de Railway):
    print("Iniciando con Flask localmente en http://localhost:8080/gamestore")
    app_flask.run(host='0.0.0.0', port=8080, debug=True)
    
    # O para probar localmente con el servidor standalone de PyWebIO (más simple para desarrollo rápido):
    # print("Iniciando con PyWebIO standalone localmente en http://localhost:8080")
    # start_server(gamestore_web_app, port=8080, debug=True, cdn=True)

    # Es importante cerrar la conexión a la BD cuando la app principal termina
    # Esto es más complejo en un entorno de servidor web persistente.
    # La instancia 'manager' es global aquí; su conexión se cerraría al terminar el script.
    # En un servidor real, la conexión podría persistir o manejarse por sesión/request.
    # El manager.cerrar_conexion() al final es más para scripts simples.
    # En Flask/Gunicorn, la app no "termina" así. El __del__ de GameStoreManager podría cerrarla
    # o se pueden usar hooks de la app Flask/Gunicorn si es necesario un cierre explícito y global.
    # Por ahora, confiamos en que la conexión se cierre al finalizar el proceso, o
    # que la base de datos maneje conexiones inactivas.
    # Para Railway, el ciclo de vida del proceso es gestionado por la plataforma.
    # Si la conexión se cae, el reconnect en _execute_query intentará restaurarla.