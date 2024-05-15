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
            System.out.println("\nError al escribir el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregamos algunos libros de ejemplo
        biblioteca.agregarLibro(new LibroFiccion("El Señor de los Anillos", "J.R.R. Tolkien", 1000));
        biblioteca.agregarLibro(new LibroNoFiccion("Historia del Arte", "E.H. Gombrich", "Arte"));

        int opcion;
        do {
            opcion = biblioteca.mostrarMenu();
            switch (opcion) {
                case 1:
                    // Mostramos los libros disponibles
                    biblioteca.mostrarLibros();

                    // Seleccionamos un libro al principio
                    biblioteca.seleccionarLibro();

                    // Ejemplo de lectura de entrada por consola y actualización del archivo
                    biblioteca.leerEntradaPorConsola();
                    break;
                case 2:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 2);
    }

}

