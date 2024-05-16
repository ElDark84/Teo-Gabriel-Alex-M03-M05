package objetos;

public abstract class Libro {
    public String titulo;
    public String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    // Método abstracto para calcular el precio del libro
    public abstract double calcularPrecio();
}