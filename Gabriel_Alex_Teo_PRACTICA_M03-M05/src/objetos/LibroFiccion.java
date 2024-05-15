public class LibroFiccion extends Libro {
    private int paginas;

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

public void mostrarLibros() {
        System.out.println("\nLibros disponibles:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " (" + libro.getAutor() + ")");
        }
    }