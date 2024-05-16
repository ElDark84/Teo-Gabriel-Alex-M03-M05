package objetos;

public class LibroFiccion extends Libro {
    public int paginas;

    public LibroFiccion(String titulo, String autor, int paginas) {
        super(titulo, autor);
        this.paginas = paginas;
    }

    @Override
    public double calcularPrecio() {
        // Precio base para libros de no ficción
        return paginas * 0.1;
    }
}