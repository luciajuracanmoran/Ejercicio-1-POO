public class Comprador {
    private String nombre;
    private String email;
    private int cantidadDeseada;
    private double presupuesto;

    public Comprador(String nombre, String email, int cantidadDeseada, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadDeseada = cantidadDeseada;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadDeseada() {
        return cantidadDeseada;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    @Override
    public String toString() {
        return "Comprador: " + nombre + " (" + email + "), desea " + cantidadDeseada + " boletos, presupuesto: $" + presupuesto;
    }
}
