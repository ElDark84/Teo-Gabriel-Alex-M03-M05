import java.io.*;               //Liberia para uso, lectura y escritura en archivos
import java.util.ArrayList;     //Liberia para uso de Arrays y ArrayList
import java.util.Scanner;      
import objetos.*; //Liberia para uso de Scanner

public class Main {
    public static void main(String[] args) throws Exception {
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

public void seleccionarLibro() { //GIT TEO
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nIntroduce el título del libro que deseas prestar: ");
    String tituloLibro = scanner.nextLine();


public int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMenu Gestión de la Biblioteca:");
        System.out.println("1. Iniciar programa");
        System.out.println("2. Salir del programa\n");
        System.out.print("Seleccione una opción: ");
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            if (opcion == 1 || opcion == 2) {
                System.out.println("Opción válida.");
                return opcion;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                return mostrarMenu(); // Llamada recursiva para volver a mostrar el menú
            }
        } else {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next(); // Limpiar el buffer de entrada
            return mostrarMenu(); // Llamada recursiva para volver a mostrar el menú
        }
    }

    for (Libro libro : librosDisponibles) {
        if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
            libroSeleccionado = libro;
            System.out.println("Libro seleccionado: " + libro.getTitulo());
            return;
        }
    }

    System.out.println("Libro no encontrado en la biblioteca.");
}

