import java.util.ArrayList;

public class Reserva {
    private String clienteNombre;
    private String clienteCedula;
    private Habitacion habitacion;
    private boolean pagada;

    public Reserva(String clienteNombre, String clienteCedula, Habitacion habitacion) {
        this.clienteNombre = clienteNombre;
        this.clienteCedula = clienteCedula;
        this.habitacion = habitacion;
        this.pagada = false;
        habitacion.setDisponible(false);
    }

    public String getClienteCedula() {
        return clienteCedula;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void pagar() {
        this.pagada = true;
    }

    @Override
    public String toString() {
        return "Reserva:\n" +
                "Cliente: " + clienteNombre + "\n" +
                "Cedula: " + clienteCedula + "\n"
                + habitacion + "Pagada: " + pagada + '\n';
    }

    public static Reserva buscarReservaPorCedula(ArrayList<Reserva> reservas, String cedula) {
        for (Reserva r : reservas) {
            if (r.getClienteCedula().equals(cedula)) {
                return r;
            }
        }
        return null;
    }
}

