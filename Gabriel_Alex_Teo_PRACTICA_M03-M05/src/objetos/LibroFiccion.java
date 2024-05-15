package objetos;

public class LibroFiccion extends Libro {
    int paginas;

    public LibroFiccion(String titulo, String autor, int paginas) {
        super(titulo, autor);
        this.paginas = paginas;
    }

    @Override
    public double calcularPrecio() {
        // Precio base para libros de ficción
        return paginas * 0.1;
    }
}