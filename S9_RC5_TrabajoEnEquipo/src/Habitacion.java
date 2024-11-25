public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Info. de Habitacion\n" +
                "Numero: " + numero +
                ", Tipo: " + tipo +
                ", Precio: " + precio +
                ", Disponible: " + disponible +
                '\n';
    }
}

