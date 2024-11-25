import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Hotel> hoteles = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        Hotel danCarlton = new Hotel("Dan Carlton");
        danCarlton.agregarHabitacion(new Habitacion(1, "simple", 90));
        danCarlton.agregarHabitacion(new Habitacion(2, "doble", 120));
        danCarlton.agregarHabitacion(new Habitacion(3, "triple", 160));

        Hotel swissotel = new Hotel("Swissotel");
        swissotel.agregarHabitacion(new Habitacion(4, "simple", 65));
        swissotel.agregarHabitacion(new Habitacion(5, "doble", 100));
        swissotel.agregarHabitacion(new Habitacion(6, "triple", 140));

        Hotel sheraton = new Hotel("Sheraton");
        sheraton.agregarHabitacion(new Habitacion(7, "simple", 85));
        sheraton.agregarHabitacion(new Habitacion(8, "doble", 110));
        sheraton.agregarHabitacion(new Habitacion(9, "triple", 150));

        hoteles.add(danCarlton);
        hoteles.add(swissotel);
        hoteles.add(sheraton);

        int opcion;
        do {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Buscar Habitacion");
            System.out.println("2. Realizar Reserva");
            System.out.println("3. Ver Reservas");
            System.out.println("4. Pagar Reserva");
            System.out.println("5. Salir");
            System.out.print(">> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de habitacion (simple/doble/triple): ");
                    sc.nextLine();
                    String tipo = sc.nextLine();

                    for (Hotel hotel : hoteles) {
                        ArrayList<Habitacion> habitaciones = hotel.buscarPorTipo(tipo);
                        for (Habitacion h : habitaciones) {
                            System.out.println("Hotel: " + hotel.getNombre() + ", " + h);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese su nombre: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese su cedula: ");
                    String cedula = sc.nextLine();

                    System.out.print("Ingrese el numero de habitacion que desea reservar: ");
                    int numero = sc.nextInt();

                    Habitacion habitacionSeleccionada = null;
                    for (Hotel hotel : hoteles) {
                        habitacionSeleccionada = hotel.buscarHabitacionPorNumero(numero);
                        if (habitacionSeleccionada != null && habitacionSeleccionada.isDisponible()) {
                            break;
                        }
                    }

                    if (habitacionSeleccionada != null && habitacionSeleccionada.isDisponible()) {
                        Reserva reserva = new Reserva(nombre, cedula, habitacionSeleccionada);
                        reservas.add(reserva);
                        System.out.println("Reserva realizada con exito.\n");
                    } else {
                        System.out.println("Habitacion no disponible.\n");
                    }
                    break;

                case 3:
                    for (Reserva r : reservas) {
                        System.out.println(r);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese su cédula: ");
                    sc.nextLine();
                    cedula = sc.nextLine();

                    Reserva reservaPagada = Reserva.buscarReservaPorCedula(reservas, cedula);

                    if (reservaPagada != null && !reservaPagada.isPagada()) {
                        reservaPagada.pagar();
                        System.out.println("Reserva pagada con exito.\n");
                    } else {
                        System.out.println("No se encontro una reserva pendiente de pago.\n");
                    }
                    break;

                case 5:
                    System.out.println("Gracias!");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

