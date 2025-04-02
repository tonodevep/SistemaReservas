package Vista;

import Controlador.*;
import Modelo.*;
import java.util.List;

public class VistaConsola {
    //Inicialización de controladores
    private ControladorCliente controladorCliente;
    private ControladorReserva controladorReserva;
    private ControladorHabitacion controladorHabitacion;

    //Constructor
    public VistaConsola(ControladorCliente controladorCliente, ControladorReserva controladorReserva, ControladorHabitacion controladorHabitacion) {
        this.controladorCliente = controladorCliente;
        this.controladorReserva = controladorReserva;
        this.controladorHabitacion = controladorHabitacion;
    }

    //Método para mostrar la información de los clientes
    public void mostrarInfoClientes() {
    List<Cliente> clientes = controladorCliente.getTodosClientes();
    System.out.println("\n--- Lista de Clientes ---");
    
    for (Cliente cliente : clientes) {
        System.out.println("\nID: " + cliente.getIDCliente() + " | Nombre: " + cliente.getNombreCliente());
        
        // 1. Reservas activas
        System.out.println("→ Reservas Activas:");
        List<Reserva> reservasActivas = cliente.getReservasActivas();
        if (reservasActivas.isEmpty()) {
            System.out.println("   No tiene reservas activas.");
        } else {
            for (Reserva reserva : reservasActivas) {
                imprimirDetallesReserva(reserva); // Método helper para reutilizar código
            }
        }
        System.out.println("→ Historial de Reservas:");
        List<Reserva> historial = cliente.getHistorialReservas();
        if (historial.isEmpty()) {
            System.out.println("   No tiene reservas pasadas.");
        } else {
            for (Reserva reserva : historial) {
                imprimirDetallesReserva(reserva);
            }
        }
    }
}
    //Método para mostrar la información de las reservas
    private void imprimirDetallesReserva(Reserva reserva) {
    System.out.println("   ID Reserva: " + reserva.getIDReserva() +
            " | Check-in: " + reserva.getCheckIn() +
            " | Check-out: " + reserva.getCheckOut() +
            " | Precio: " + reserva.getPrecioTotal() +
            " | Habitación: " + reserva.getHabitacionReservada().get(0).getNumero());}

    //Método para mostrar la información de las habitaciones
    public void mostrarInfoHabitaciones(List<Habitacion> habitaciones) {
        System.out.println("\n--- Lista de Habitaciones ---");
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Número: " + habitacion.getNumero() +
                    " | Tipo: " + habitacion.getTipo() +
                    " | Precio: " + habitacion.getPrecio() +
                    " | Estado: " + habitacion.getEstado());
        }
    }

    //Método para mostrar la información de las reservas
    public void mostrarInfoReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva reserva : controladorReserva.getReservas()) {
            System.out.println("ID Reserva: " + reserva.getIDReserva() +
                    " | Cliente: " + reserva.getCliente().getNombreCliente() +
                    " | Check-in: " + reserva.getCheckIn() +
                    " | Check-out: " + reserva.getCheckOut() +
                    " | Precio Total: " + reserva.getPrecioTotal());
        }
    }
}
