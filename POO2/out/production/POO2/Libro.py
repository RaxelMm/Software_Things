class Libro:
    def __init__(self, titulo, autor, fecha):
        self.titulo = titulo
        self.autor = autor
        self.fecha = fecha

    def es_antiguo(self):
        return self.fecha < 2000

    @staticmethod
    def capturar_datos():
        titulo = input("Ingrese el título del libro: ")
        autor = input("Ingrese el autor del libro: ")
        fecha = int(input("Ingrese el año de publicación: "))
        return Libro(titulo, autor, fecha)

    def mostrar_info(self):
        return f"Libro [Título={self.titulo}, Autor={self.autor}, Fecha={self.fecha}, Antiguo={self.es_antiguo()}]"

if __name__ == "__main__":
    libro = Libro.capturar_datos()
    print(libro.mostrar_info())
