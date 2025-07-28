import java.util.Random;

public class Ticket {
    private int numeroTicket;
    private int rangoInicio;
    private int rangoFin;
    private boolean esApto;

    public Ticket() {
        generarTicket();
    }

    public void generarTicket() {
        Random random = new Random();
        numeroTicket = random.nextInt(15000) + 1;
        rangoInicio = random.nextInt(15000) + 1;
        rangoFin = random.nextInt(15000) + 1;

        int min = Math.min(rangoInicio, rangoFin);
        int max = Math.max(rangoInicio, rangoFin);

        esApto = (numeroTicket >= min && numeroTicket <= max);
    }

    public boolean esTicketApto() {
        return esApto;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getRangoInicio() {
        return rangoInicio;
    }

    public int getRangoFin() {
        return rangoFin;
    }

    public boolean getEsApto() {
        return esApto;
    }

    @Override
    public String toString() {
        return "Ticket #" + numeroTicket + " | Rango válido: [" + Math.min(rangoInicio, rangoFin)
                + " - " + Math.max(rangoInicio, rangoFin) + "] -> " + (esApto ? "APTO" : "NO APTO");
    }
}
