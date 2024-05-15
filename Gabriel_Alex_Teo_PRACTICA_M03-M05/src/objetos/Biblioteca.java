package objetos;

// Clase para gestionar la biblioteca
public class Biblioteca {
    private ArrayList<Libro> librosDisponibles = new ArrayList<>();
    private Libro libroSeleccionado;

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    
}
