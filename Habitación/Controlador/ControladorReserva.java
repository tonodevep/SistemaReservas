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
    
    // If para verificar el estado de la habitación
    if (habitacion.getEstado() != EstadoHabitacion.DISPONIBLE) {
        throw new ReservaNoDisponibleException("La habitación " + habitacion.getNumero() + " no está disponible.");
    }

    // If para verificar que el cliente no sea nulo
    if (cliente == null) {
        throw new NullPointerException("Cliente no puede ser nulo.");
    }

    // Se crea la reserva
    int id = ++IDReservaCounter;
    Reserva nuevaReserva = new Reserva(id, habitacion, cliente, checkIn, checkOut);
    
    // Se añade la habitación a la reserva
    nuevaReserva.getHabitacionReservada().add(habitacion);
    
    // Actualiza el estado de la habitación
    habitacion.setEstado(EstadoHabitacion.RESERVADA);
    
    // Se guarda la reserva
    reservas.add(nuevaReserva);
    
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

