import java.io.*;               //Liberia para uso, lectura y escritura en archivos
import java.util.ArrayList;     //Liberia para uso de Arrays y ArrayList
import java.util.Scanner;       //Liberia para uso de Scanner
import objetos.*;

public class Main {
    public ArrayList<Libro> librosDisponibles = new ArrayList<>();
    public Libro libroSeleccionado;

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
        String tituloLibro = scanner.nextLine().trim().toLowerCase();

        for (Libro libro : librosDisponibles) {
            if (libro.getTitulo().toLowerCase().equals(tituloLibro)) {
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
        if (libroSeleccionado != null) {
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
        } else {
            System.out.println("\nNo se ha seleccionado ningún libro.");
        }
    
    }

    public int mostrarMenu() { //GIT GABRIEL
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

    public static void main(String[] args) {
        Main biblioteca = new Main();

        // Agregamos algunos libros de ejemplo
        biblioteca.agregarLibro(new LibroNoFiccion("Historia del Arte", "E.H. Gombrich", "Arte"));
        biblioteca.agregarLibro(new LibroNoFiccion("Kamasutra", "India", "Cultura"));
        biblioteca.agregarLibro(new LibroFiccion("El Senior de los Anillos", "J.K.Rowling", 903));
        biblioteca.agregarLibro(new LibroFiccion("La Guerra de los Mundos", "H.G. Wells", 216));
        biblioteca.agregarLibro(new LibroNoFiccion("Sapiens: De Animales a Dioses", "Yuval Noaḥ Harari", "Historia"));
        biblioteca.agregarLibro(new LibroFiccion("1984", "George Orwell", 352));
        biblioteca.agregarLibro(new LibroNoFiccion("El Origen de las Especies", "Charles Darwin", "Ciencia"));
        biblioteca.agregarLibro(new LibroFiccion("Cien años de soledad", "Gabriel García Márquez", 496));
        biblioteca.agregarLibro(new LibroNoFiccion("El problema de los tres cuerpos", "Cixin Liu", "Ciencia"));
        biblioteca.agregarLibro(new LibroFiccion("Fahrenheit 45", "Ray Bradbury", 176));
        biblioteca.agregarLibro(new LibroNoFiccion("El arte de la guerra", "Sun Tzu", "Filosofía"));
        biblioteca.agregarLibro(new LibroFiccion("El Codigo Da Vinci", "Dan Brown", 624));
        biblioteca.agregarLibro(new LibroNoFiccion("El poder del ahora", "Eckhart Tolle", "Autoayuda"));
        biblioteca.agregarLibro(new LibroFiccion("El Hobbit", "J.R.R. Tolkien", 288));
        biblioteca.agregarLibro(new LibroNoFiccion("El hombre en busca de sentido", "Viktor Frankl", "Psicología"));
        biblioteca.agregarLibro(new LibroFiccion("El arte de la seducción", "Robert Green", 512));

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

