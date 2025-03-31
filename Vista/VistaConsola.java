import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;
    
    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarHabitacionesDisponibles(List<Habitacion> habitaciones) {
        System.out.println("\n=== HABITACIONES DISPONIBLES ===");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getEstado() == Habitacion.EstadoHabitacion.DISPONIBLE) {
                System.out.println("Habitación " + habitacion.getNumero() + ": " +
                        habitacion.getTipo() + " - " +
                        habitacion.getPrecio() + "€/noche - " +
                        (habitacion.getDescripcion() != null ? habitacion.getDescripcion() : ""));
            }
        }
    }

    public int solicitarNumeroHabitacion() {
        System.out.print("Ingrese el número de habitación: ");
        return scanner.nextInt();
    }
    
    public void mostrarMenu(ControladorReserva controlador) {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver habitaciones disponibles");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch(opcion) {
                case 1: 
                    controlador.mostrarHabitacionesDisponibles(); 
                    break;
                case 2: 
                    mostrarMensaje("Ingrese el número de habitación a reservar:");
                    int numReserva = solicitarNumeroHabitacion();
                    controlador.reservarHabitacion(numReserva);
                    break;
                case 3:
                    mostrarMensaje("Ingrese el número de habitación a cancelar:");
                    int numCancelar = solicitarNumeroHabitacion();
                    controlador.cancelarReserva(numCancelar);
                    break;
                case 4:
                    mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    mostrarMensaje("Opción no válida");
            }
        } while(opcion != 4);
    }
    
    public void cerrar() {
        scanner.close();
    }
}

