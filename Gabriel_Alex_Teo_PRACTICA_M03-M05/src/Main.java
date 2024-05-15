import java.io.*;               //Liberia para uso, lectura y escritura en archivos
import java.util.ArrayList;     //Liberia para uso de Arrays y ArrayList
import java.util.Scanner;       //Liberia para uso de Scanner
import objetos.*;

public class Main {
    private ArrayList<Libro> librosDisponibles = new ArrayList<>();
    private Libro libroSeleccionado;

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void mostrarLibros() {
        System.out.println("\nLibros disponibles:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " (" + libro.getAutor() + ")");
        }
    }

    
    //Método para seleccionar un libro al principio
    public void seleccionarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduce el título del libro que deseas prestar: ");
        String tituloLibro = scanner.nextLine();

        for (Libro libro : librosDisponibles) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libroSeleccionado = libro;
                System.out.println("Libro seleccionado: " + libro.getTitulo());
                return;
            }
        }

        System.out.println("Libro no encontrado en la biblioteca.");
    }

}

