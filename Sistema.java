import java.util.ArrayList;
import java.util.Random;

public class Sistema {
    private Comprador compradorActual;
    private ArrayList<Localidad> localidades;
    private double totalGenerado;
    private int boletosVendidos;

    public Sistema() {
        localidades = new ArrayList<>();
        localidades.add(new Localidad("Localidad 1", 100.0, 20));
        localidades.add(new Localidad("Localidad 5", 500.0, 20));
        localidades.add(new Localidad("Localidad 10", 1000.0, 20));
        totalGenerado = 0;
        boletosVendidos = 0;
    }

    public void setComprador(Comprador c) {
        this.compradorActual = c;
        System.out.println("Nuevo comprador registrado:");
        System.out.println(c);
    }

    public void procesarSolicitudBoletos() {
        if (compradorActual == null) {
            System.out.println("No hay comprador activo. Cree uno primero.");
            return;
        }

        Ticket ticket = new Ticket();
        System.out.println(ticket);

        if (!ticket.esTicketApto()) {
            System.out.println("Este ticket no es apto para comprar boletos.");
            return;
        }

        Localidad seleccionada = seleccionarLocalidadAleatoria();
        System.out.println("Localidad seleccionada: " + seleccionada.getNombre());

        int cantidadSolicitada = compradorActual.getCantidadDeseada();
        double presupuesto = compradorActual.getPresupuesto();
        double precioLocalidad = seleccionada.getPrecio();

        if (!seleccionada.hayEspacio(1)) {
            System.out.println("La localidad ya no tiene espacio.");
            return;
        }

        if (!seleccionada.hayEspacio(cantidadSolicitada)) {
            System.out.println("Solo hay espacio para menos boletos de los que solicitó.");
        }

        int cantidadFinal = Math.min(cantidadSolicitada, seleccionada.boletosDisponibles());
        double costoTotal = cantidadFinal * precioLocalidad;

        if (costoTotal > presupuesto) {
            System.out.println("Su presupuesto no alcanza para esta compra. Rechazada.");
            return;
        }

        int vendidos = seleccionada.venderBoletos(cantidadFinal);
        totalGenerado += vendidos * precioLocalidad;
        boletosVendidos += vendidos;

        System.out.println("Compra realizada con éxito.");
        System.out.println("Boletos vendidos: " + vendidos + " | Total: $" + (vendidos * precioLocalidad));
    }

    private Localidad seleccionarLocalidadAleatoria() {
        Random random = new Random();
        return localidades.get(random.nextInt(localidades.size()));
    }

    public void mostrarDisponibilidadTotal() {
        System.out.println("Disponibilidad total de localidades:");
        for (Localidad loc : localidades) {
            System.out.println("- " + loc.getNombre() + ": " + loc.boletosDisponibles() + " disponibles / " + loc.getVendidos() + " vendidos");
        }
    }

    public void mostrarDisponibilidadPorNombre(String nombre) {
        for (Localidad loc : localidades) {
            if (loc.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Disponibilidad de " + nombre + ": " + loc.boletosDisponibles() + " boletos");
                return;
            }
        }
        System.out.println("No se encontró una localidad con ese nombre.");
    }

    public void mostrarReporteCaja() {
        System.out.println("Reporte de caja:");
        System.out.println("Boletos vendidos totales: " + boletosVendidos);
        System.out.println("Total generado: $" + totalGenerado);
    }
}

