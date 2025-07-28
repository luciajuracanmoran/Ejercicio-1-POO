public class Localidad {
    private String nombre;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(String nombre, double precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    public boolean hayEspacio(int cantidad) {
        return vendidos + cantidad <= capacidad;
    }

    public int venderBoletos(int cantidad) {
        int disponibles = capacidad - vendidos;
        int aVender = Math.min(disponibles, cantidad);
        vendidos += aVender;
        return aVender;
    }

    public int boletosDisponibles() {
        return capacidad - vendidos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVendidos() {
        return vendidos;
    }
}
