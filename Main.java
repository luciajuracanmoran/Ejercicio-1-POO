import java.util.Scanner;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    crearNuevoComprador();
                    break;
                case 2:
                    sistema.procesarSolicitudBoletos();
                    break;
                case 3:
                    sistema.mostrarDisponibilidadTotal();
                    break;
                case 4:
                    consultarDisponibilidadIndividual();
                    break;
                case 5:
                    sistema.mostrarReporteCaja();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println(); // línea en blanco entre ciclos
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("====== Menú Principal ======");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
    }

    private static void crearNuevoComprador() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese cantidad de boletos deseados: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese presupuesto máximo: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer

        Comprador nuevo = new Comprador(nombre, email, cantidad, presupuesto);
        sistema.setComprador(nuevo);
    }

    private static void consultarDisponibilidadIndividual() {
        System.out.print("Ingrese nombre de la localidad (ej. Localidad 1): ");
        String nombre = scanner.nextLine();
        sistema.mostrarDisponibilidadPorNombre(nombre);
    }
}
