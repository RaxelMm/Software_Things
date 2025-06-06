import mysql.connector
from datetime import datetime
from pywebio.input import *
from pywebio.output import *
from pywebio.session import info as session_info, run_js, set_env
from pywebio import start_server
from flask import Flask
from pywebio.platform.flask import webio_view
import os
from functools import partial

# --- CONEXIÓN A BD Y LÓGICA DE NEGOCIO ---
def conectar():
    """Establece la conexión con la base de datos MySQL."""
    try:
        db_host = os.environ.get("DB_HOST", "shortline.proxy.rlwy.net")
        db_port = int(os.environ.get("DB_PORT", 47316))
        db_user = os.environ.get("DB_USER", "root")
        db_password = os.environ.get("DB_PASSWORD", "cHHzHOJVpxFjPXLJsUQPHMNiZhCECXfJ")
        db_name = os.environ.get("DB_NAME", "gamestore_db")

        conn = mysql.connector.connect(
            host=db_host,
            port=db_port,
            user=db_user,
            password=db_password,
            database=db_name
        )
        print(f"Conectando a: {db_host}:{db_port} como {db_user} a la BD {db_name}")
        return conn
    except mysql.connector.Error as err:
        print(f"Error de conexión a la base de datos: {err}")
        return None
    except ValueError as verr:
        print(f"Error en la configuración del puerto: {verr}")
        return None

class GameStoreManager:
    def __init__(self):
        self.db_conn = conectar()
        if self.db_conn:
            print("GameStoreManager: Conectado a la base de datos.")
            self._crear_tablas_si_no_existen()
        else:
            print("GameStoreManager: No se pudo conectar a la base de datos.")

    def _execute_query(self, query, params=None, fetch=None, commit=False, is_ddl=False):
        if not self.db_conn or not self.db_conn.is_connected():
            print("GameStoreManager: Intentando reconectar...")
            self.db_conn = conectar()
            if not self.db_conn:
                print("GameStoreManager: Fallo al reconectar.")
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
            return True
        except mysql.connector.Error as err:
            print(f"GameStoreManager DB Error: {err}")
            if self.db_conn and self.db_conn.is_connected() and (commit or is_ddl):
                try: self.db_conn.rollback()
                except mysql.connector.Error as roll_err: print(f"Rollback Error: {roll_err}")
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
            except Exception as e:
                print(f"GameStoreManager: Error al crear/verificar tabla '{tabla}': {e}")

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
            put_error(f"Error al obtener catálogo: {e}")
            return []

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

            self._execute_query(query_venta, params_venta, commit=True)

            nuevo_stock = stock_actual - cantidad_a_vender
            query_actualizar_stock = "UPDATE videojuegos SET cantidad = %s WHERE id = %s"
            params_actualizar_stock = (nuevo_stock, id_videojuego)
            
            self._execute_query(query_actualizar_stock, params_actualizar_stock, commit=True)
            return True, f"Venta de '{nombre_videojuego_vendido}' (x{cantidad_a_vender}) completada. Stock actualizado a {nuevo_stock}."
        except Exception as e: 
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
            else: 
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
            if report_data is None: 
                return None, "Error al generar el informe de ventas por cliente."
            if not report_data: 
                return [], "No hay ventas registradas o clientes con ventas."
            return report_data, "Informe de ventas por cliente generado."
        except Exception as e:
            put_error(f"Error al obtener ventas por cliente: {e}")
            return None, f"Error al generar el informe de ventas por cliente: {e}"

    def cerrar_conexion(self):
        if self.db_conn and self.db_conn.is_connected():
            self.db_conn.close()
            print("GameStoreManager: Conexión cerrada.")

# --- INTERFAZ PYWEBIO ---
manager = GameStoreManager()

def go_home():
    run_js('window.location.reload()')

def pywebio_add_videojuego():
    clear()
    put_markdown("## ➕ Agregar Nuevo Videojuego")
    
    put_button("← Volver al Menú", onclick=gamestore_web_app, color="light", outline=True)
    put_html("<hr>")
    
    data = input_group("Datos del Videojuego", [
        input("Nombre (*)", name="nombre", type=TEXT, required=True),
        input("Categoría", name="categoria", type=TEXT),
        input("Precio (*)", name="precio", type=FLOAT, required=True, 
              validate=lambda p: "El precio no puede ser negativo" if p < 0 else None),
        input("Consola", name="consola", type=TEXT),
        input("Género", name="genero", type=TEXT),
        input("Cantidad Inicial (*)", name="cantidad", type=NUMBER, required=True, 
              validate=lambda c: "La cantidad no puede ser negativa" if c < 0 else None)
    ])
    
    if data:
        success, message = manager.add_videojuego_gui(
            data['nombre'], data['categoria'], data['precio'],
            data['consola'], data['genero'], data['cantidad']
        )
        if success:
            toast(message, color='success', duration=5)
            pywebio_view_catalogo()
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_add_videojuego, color="warn")
    
    put_html("<hr>")
    put_button("← Volver al Menú", onclick=gamestore_web_app, color="light", outline=True)


def pywebio_update_stock():
    clear()
    put_markdown("## 🔄 Modificar Stock de Videojuego")
    
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
    videojuegos = manager.get_catalogo_videojuegos() 
    if not videojuegos:
        put_warning("No hay videojuegos registrados para modificar stock.")
        return

    options = [{'label': f"{j['nombre']} (ID: {j['id']}, Stock actual: {j['cantidad']})", 
                'value': j['id']} for j in videojuegos]
    
    selected_id = select("Seleccionar Videojuego", options=options)
    
    juego_seleccionado = next((j for j in videojuegos if j['id'] == selected_id), None)
    if juego_seleccionado:
        put_text(f"Stock actual de '{juego_seleccionado['nombre']}': {juego_seleccionado['cantidad']}")

    nueva_cantidad = input("Nueva Cantidad Total (*)", type=NUMBER, required=True,
                         validate=lambda c: "La cantidad no puede ser negativa" if c < 0 else None)

    if nueva_cantidad is not None: 
        success, message = manager.update_videojuego_stock_gui(selected_id, nueva_cantidad)
        if success:
            toast(message, color='success', duration=5)
            pywebio_view_catalogo()
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_update_stock, color="warn")

def pywebio_add_cliente():
    clear()
    put_markdown("## 👤 Agregar Nuevo Cliente")
    
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
    data = input_group("Datos del Cliente", [
        input("Nombre (*)", name="nombre", type=TEXT, required=True),
        input("Email (opcional)", name="email", type=TEXT)
    ])
    
    if data:
        success, message = manager.add_cliente_gui(data['nombre'], data['email'])
        if success:
            toast(message, color='success', duration=5)
            put_button("Agregar Otro Cliente", onclick=pywebio_add_cliente)
        else:
            toast(message, color='error', duration=5)
            put_button("Intentar de Nuevo", onclick=pywebio_add_cliente, color="warn")

def pywebio_delete_cliente():
    clear()
    put_markdown("## 🗑️ Borrar Cliente")
    
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
    clientes = manager.get_clientes_for_selection()
    if not clientes:
        put_warning("No hay clientes registrados.")
        return

    options = [{'label': f"{c['nombre']} (ID: {c['id']}) - Email: {c.get('email', 'N/A')}", 
               'value': c['id']} for c in clientes]
    cliente_id = select("Seleccionar Cliente a Borrar", options=options)
    
    if cliente_id is not None:
        confirm = actions(buttons=[
            {'label': 'Confirmar Borrado', 'value': True, 'color': 'danger'},
            {'label': 'Cancelar', 'value': False, 'color':'secondary'}
        ], help_text=f"¿Seguro que desea borrar al cliente ID {cliente_id}?")
        
        if confirm:
            success, message = manager.delete_cliente_gui(cliente_id)
            if success:
                toast(message, color='success', duration=5)
            else:
                toast(message, color='error', duration=5)
        else:
            toast("Borrado cancelado.", duration=3)

def pywebio_view_catalogo(show_menu_button=True):
    clear()
    put_markdown("## 🎮 Catálogo de Videojuegos")
    
    if show_menu_button:
        put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
    catalogo = manager.get_catalogo_videojuegos()
    if catalogo is None: 
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

def pywebio_realizar_venta():
    clear()
    put_markdown("## 🛒 Realizar Venta")
    
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
    juegos_stock = manager.get_catalogo_videojuegos(solo_con_stock=True)
    if not juegos_stock:
        put_warning("No hay videojuegos con stock disponible para la venta.")
        return

    clientes = manager.get_clientes_for_selection()

    juego_options = [{'label': f"{j['nombre']} (${j['precio']:.2f}) - Stock: {j['cantidad']}",
                    'value': j['id']} for j in juegos_stock]
    
    cliente_options = [{'label': "[Cliente Anónimo/Invitado]", 'value': None}]
    cliente_options.extend([{'label': f"{c['nombre']} (ID: {c['id']})", 'value': c['id']} for c in clientes])

    data = input_group("Detalles de la Venta", [
        select("Videojuego (*)", name="id_videojuego", options=juego_options, required=True),
        select("Cliente", name="id_cliente", options=cliente_options), 
        input("Cantidad a Vender (*)", name="cantidad", type=NUMBER, value=1, required=True,
              validate=lambda c: "La cantidad debe ser al menos 1" if c <= 0 else None)
    ])

    if data:
        juego_seleccionado_info = next((j for j in juegos_stock if j['id'] == data['id_videojuego']), None)
        if not juego_seleccionado_info:
            toast("Videojuego seleccionado no es válido.", color='error', duration=5)
            put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
            return

        if juego_seleccionado_info['cantidad'] < data['cantidad']:
            toast(f"Stock insuficiente para '{juego_seleccionado_info['nombre']}'. Disponible: {juego_seleccionado_info['cantidad']}", 
                 color='error', duration=5)
            put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
            return
            
        precio_total_estimado = juego_seleccionado_info['precio'] * data['cantidad']
        cliente_nombre_display = next((opt['label'] for opt in cliente_options if opt['value'] == data['id_cliente']), "Desconocido")

        confirm_msg = (f"Vender {data['cantidad']} unidad(es) de '{juego_seleccionado_info['nombre']}'\n"
                      f"Precio Unitario: ${juego_seleccionado_info['precio']:.2f}\n"
                      f"Precio Total: ${precio_total_estimado:.2f}\n"
                      f"Al cliente: {cliente_nombre_display}\n"
                      f"Stock actual: {juego_seleccionado_info['cantidad']} -> Nuevo stock: {juego_seleccionado_info['cantidad'] - data['cantidad']}")
        
        confirm = actions(buttons=[
            {'label': 'Confirmar Venta', 'value': True, 'color': 'success'},
            {'label': 'Cancelar', 'value': False, 'color':'secondary'}
        ], help_text=confirm_msg)
        
        if confirm:
            success, message = manager.realizar_venta_gui(
                data['id_videojuego'], data['id_cliente'], data['cantidad']
            )
            if success:
                toast(message, color='success', duration=5)
                pywebio_view_catalogo() 
            else:
                toast(message, color='error', duration=10) 
                put_button("Reintentar Venta", onclick=pywebio_realizar_venta, color="warn")
        else:
            toast("Venta cancelada.", duration=3)

def pywebio_show_informes():
    clear()
    put_markdown("## 📊 Informes de Ventas")
    
    put_button("Volver al Menú", onclick=gamestore_web_app, color="secondary")
    
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
                put_text(message)
            else:
                put_error(message)
    
    def show_sales_by_client_report():
        with use_scope("report_area", clear=True):
            data, message = manager.get_sales_by_client_report()
            if data is None: 
                put_error(message)
                return
            if not data: 
                put_info(message) 
                return
            
            header = ['Cliente', 'Nº Transacciones', 'Total Juegos', 'Total Gastado ($)']
            rows = [[
                r['nombre_cliente'], r['numero_transacciones'],
                r['total_juegos_comprados'], f"${r['total_gastado']:.2f}"
            ] for r in data]
            put_table([header] + rows)

    put_buttons([
        {'label': "Todas las Ventas", 'value': "all", 'color': 'primary'},
        {'label': "Ingresos Totales", 'value': "total", 'color': 'primary'},
        {'label': "Ventas por Cliente", 'value': "client", 'color': 'primary'}
    ], onclick=[
        lambda: show_all_sales(),
        lambda: show_total_revenue_report(),
        lambda: show_sales_by_client_report()
    ])
    
    put_scope("report_area")
    show_all_sales()

# --- FUNCIÓN PRINCIPAL ---
def gamestore_web_app():
    set_env(title="GameStore Manager Web", output_max_width="80%")
    clear()

    if not manager.is_connected():
        put_error("CRÍTICO: No se pudo conectar a la base de datos al iniciar la aplicación.")
        put_button("Reintentar Conexión", onclick=go_home, color="danger")
        return

    put_markdown("# 🏪 GameStore Manager Web")
    put_html("<hr>")
    
    with use_scope("menu", clear=True):
        menu_items = [
            {'label': "🎮 Ver Catálogo", 'action': pywebio_view_catalogo, 'color': 'primary', 'outline': True},
            {'label': "➕ Agregar Videojuego", 'action': pywebio_add_videojuego, 'color': 'primary', 'outline': True},
            {'label': "🔄 Modificar Stock", 'action': pywebio_update_stock, 'color': 'primary', 'outline': True},
            {'label': "👤 Agregar Cliente", 'action': pywebio_add_cliente, 'color': 'primary', 'outline': True},
            {'label': "🗑️ Borrar Cliente", 'action': pywebio_delete_cliente, 'color': 'danger', 'outline': True},
            {'label': "🛒 Realizar Venta", 'action': pywebio_realizar_venta, 'color': 'success', 'outline': True},
            {'label': "📊 Informes de Ventas", 'action': pywebio_show_informes, 'color': 'info', 'outline': True}
        ]
        
        for item in menu_items:
            put_html(f'<div style="margin-bottom: 8px;">') 
            put_button(item['label'], onclick=item['action'], color=item['color'], outline=item['outline'])
            put_html(f'</div>')
        
        put_html("<br>" * 2) 
        
        put_markdown("---")
        put_text("Sistema de Gestión GameStore v1.0")
        put_text("© 2025 - Todos los derechos reservados")

# --- CONFIGURACIÓN PARA FLASK ---
# La variable de la aplicación Flask se renombra de 'app_flask' a 'app'
app = Flask(__name__)  # RENOMBRADO AQUÍ
# Se usa la nueva variable 'app' para añadir la regla URL
app.add_url_rule('/gamestore', 'webio_view', webio_view(gamestore_web_app, cdn=True), # ACTUALIZADO AQUÍ
                     methods=['GET', 'POST', 'OPTIONS'])

if __name__ == '__main__':
    print("Iniciando con Flask localmente en http://localhost:8080/gamestore")
    port = int(os.environ.get("PORT", 8080)) 
    debug_mode = os.environ.get("FLASK_DEBUG", "True").lower() == "true"
    
    if os.environ.get("RAILWAY_ENVIRONMENT") == "production": # Corregido para la variable de entorno común de Railway
        debug_mode = False
        print("Ejecutando en modo producción (debug=False).")
    else:
        # Si no es Railway production, o la variable no está, respeta FLASK_DEBUG o default.
        # Esto ayuda a mantener debug=True para desarrollo local si RAILWAY_ENVIRONMENT no está definida.
        print(f"Ejecutando en modo debug ({debug_mode}).")

    # Se usa la nueva variable 'app' para ejecutar la aplicación
    app.run(host='0.0.0.0', port=port, debug=debug_mode) # ACTUALIZADO AQUÍ