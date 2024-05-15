package objetos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Clase para gestionar la biblioteca
public class Biblioteca {
    private ArrayList<Libro> librosDisponibles = new ArrayList<>();
    private Libro libroSeleccionado;

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }



    public void leerEntradaPorConsola() { //GIT ALEX
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduce tu nombre: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("¡Hola, " + nombreUsuario + "!");
        
        // Escritura de archivo de texto en una carpeta específica
        try {
            File carpeta = new File("prestamos");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter archivoSalida = new FileWriter("prestamos/prestamos.txt", true);
            BufferedWriter escritor = new BufferedWriter(archivoSalida);
            escritor.newLine();
            escritor.write("Usuario: " + nombreUsuario);
            escritor.write(" - Libro prestado: " + libroSeleccionado.getTitulo());
            escritor.close();
            System.out.println("\nInformación de préstamo actualizada en prestamos/prestamos.txt");
        } catch (IOException e) {
            System.err.println("\nError al escribir el archivo: " + e.getMessage());
        }
    }
    
    
}
