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
