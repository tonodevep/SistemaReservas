package Controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Habitacion;
import Modelo.Habitacion.EstadoHabitacion;
import Modelo.Reserva;
import Modelo.Cliente;

public class ControladorReserva {
    private ArrayList<Reserva> reservas;
    private static int IDReservaCounter = 0;
    
    public ControladorReserva() {
        this.reservas = new ArrayList<>();
    }

    public Reserva reservarHabitacion(Habitacion habitacion, Cliente cliente, LocalDate checkIn, LocalDate checkOut) throws ReservaNoDisponibleException{
        if (habitacion.getEstado() == EstadoHabitacion.DISPONIBLE) {
            int id = ++IDReservaCounter;
            Reserva nuevaReserva = new Reserva(id, habitacion, cliente, checkIn, checkOut);
            reservas.add(nuevaReserva);
            habitacion.setEstado(EstadoHabitacion.RESERVADA);
            System.out.println("Reserva realizada con éxito. ID de reserva: " + nuevaReserva.getIDReserva());
            return nuevaReserva;
        } else {
            throw new ReservaNoDisponibleException("La habitación no está disponible actualmente para reserva.");
        }
    }

    public void cancelarReserva(int IDReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIDReserva() == IDReserva) {
                for (Habitacion hab : reserva.getHabitacionesReservadas()) {
                    hab.setEstado(EstadoHabitacion.DISPONIBLE);
                }
                reservas.remove(reserva);
                System.out.println("Reserva cancelada con éxito. ID de reserva: " + IDReserva);
                return;
            }
        }
        System.out.println("No se encontró la reserva con ID: " + IDReserva);
    }

    public Reserva buscarReserva(int IDReserva) {
        for (Reserva r : reservas) {
            if (r.getIDReserva() == IDReserva) {
                return r;
            }
        }
        return null;
    }
}
