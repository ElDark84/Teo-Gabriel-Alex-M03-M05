package objetos;

public class LibroNoFiccion extends Libro { //GIT TEO
    public String tema;

    public LibroNoFiccion(String titulo, String autor, String tema) {
        super(titulo, autor);
        this.tema = tema;
    }

    @Override
    public double calcularPrecio() {
        // Precio base para libros de no ficción
        return 20.0;
    }
}
