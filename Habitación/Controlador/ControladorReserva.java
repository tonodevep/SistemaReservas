package Controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Habitacion;
import Modelo.Habitacion.EstadoHabitacion;
import Modelo.Reserva;
import Modelo.Cliente;
import Excepciones.*;
import java.util.List;

public class ControladorReserva {
    private ArrayList<Reserva> reservas;
    private static int IDReservaCounter = 0;
    
    public ControladorReserva() {
        this.reservas = new ArrayList<>();
    }
    //Getter
    public List<Reserva> getReservas() {
        return this.reservas; 
    }

    //Método para reservar habitaciones
    public Reserva reservarHabitacion(Habitacion habitacion, Cliente cliente, LocalDate checkIn, LocalDate checkOut) 
    throws ReservaNoDisponibleException {
    
    // Validación 1: Cliente no nulo
    if (cliente == null) {
        throw new NullPointerException("Cliente no puede ser nulo");
    }

    // Validación 2: Límite de reservas
    if (!cliente.puedeReservar()) {
        throw new ReservaNoDisponibleException(cliente.getNombreCliente() + " alcanzó el límite de 3 reservas");
    }

    // Validación 3: Habitación disponible
    if (habitacion.getEstado() != EstadoHabitacion.DISPONIBLE) {
        throw new ReservaNoDisponibleException("Habitación " + habitacion.getNumero() + " no disponible");
    }

    // Creación de la reserva
    Reserva nuevaReserva = new Reserva(
        ++IDReservaCounter,
        habitacion,
        cliente,
        checkIn,
        checkOut
    );

    // Añadir habitación a la reserva
    nuevaReserva.getHabitacionReservada().add(habitacion);

    // Actualizar estados
    habitacion.setEstado(EstadoHabitacion.RESERVADA);
    reservas.add(nuevaReserva);
    cliente.getReservasActivas().add(nuevaReserva);

    System.out.println("Reserva: " + nuevaReserva.getIDReserva() + 
                      " creada para " + cliente.getNombreCliente() +
                      " (Total: " + cliente.getReservasActivas().size() + "/3)");
    
    return nuevaReserva;
}

    //Método que cancela una reserva
    public void cancelarReserva(int IDReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIDReserva() == IDReserva) {
                for (Habitacion hab : reserva.getHabitacionReservada()) {
                    hab.setEstado(EstadoHabitacion.DISPONIBLE);
                }
                //Se elimina la reserva
                reservas.remove(reserva);
                System.out.println("Reserva cancelada con éxito. ID de reserva: " + IDReserva);
                return;
            }
        }
        System.out.println("No se encontró la reserva con ID: " + IDReserva);
    }
    
    //Método para buscar reservas
    public Reserva buscarReserva(int IDReserva) {
        for (Reserva r : reservas) {
            if (r.getIDReserva() == IDReserva) {
                return r;
            }
        }
        return null;
    }
}
