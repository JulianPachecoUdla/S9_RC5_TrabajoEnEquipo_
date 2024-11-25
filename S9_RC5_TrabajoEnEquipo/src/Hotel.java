import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public ArrayList<Habitacion> buscarPorTipo(String tipo) {
        ArrayList<Habitacion> resultado = new ArrayList<>();
        for (Habitacion h : habitaciones) {
            if (h.getTipo().equalsIgnoreCase(tipo) && h.isDisponible()) {
                resultado.add(h);
            }
        }
        return resultado;
    }

    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                return h;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hotel\n" +
                "Nombre: " + nombre +
                ", Habitaciones: " + habitaciones + "\n";
    }
}
