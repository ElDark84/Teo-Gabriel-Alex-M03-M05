import java.io.*;               //Liberia para uso, lectura y escritura en archivos
import java.util.ArrayList;     //Liberia para uso de Arrays y ArrayList
import java.util.Scanner;      
import objetos.*; //Liberia para uso de Scanner

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

}

