package Vista;

import Controlador.*;
import Modelo.*;
import java.util.List;

public class VistaConsola {
    private ControladorCliente controladorCliente;
    private ControladorReserva controladorReserva;
    private ControladorHabitacion controladorHabitacion;

    public VistaConsola(ControladorCliente controladorCliente, ControladorReserva controladorReserva, ControladorHabitacion controladorHabitacion) {
        this.controladorCliente = controladorCliente;
        this.controladorReserva = controladorReserva;
        this.controladorHabitacion = controladorHabitacion;
    }

    public void mostrarInfoClientes() {
        List<Cliente> clientes = controladorCliente.getTodosClientes();
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getIDCliente() + " | Nombre: " + cliente.getNombre());
        }

        List<Reserva> reservasActivas = cliente.getReservasActivas();
        System.out.println("→ Reservas Activas:");
        if (reservasActivas.isEmpty()) {
            System.out.println("   No tiene reservas activas.");
        } else {
            for (Reserva reserva : reservasActivas) {
                System.out.println("   ID Reserva: " + reserva.getIDReserva() +
                        " | Check-in: " + reserva.getCheckIn() +
                        " | Check-out: " + reserva.getCheckOut() +
                        " | Precio: " + reserva.getPrecioTotal());
            }
        }

        List<Reserva> historial = cliente.getHistorialReservas();
        System.out.println("→ Historial de Reservas:");
        if (historial.isEmpty()) {
            System.out.println("   No tiene reservas pasadas.");
        } else {
            for (Reserva reserva : historial) {
                System.out.println("   ID Reserva: " + reserva.getIDReserva() +
                        " | Check-in: " + reserva.getCheckIn() +
                        " | Check-out: " + reserva.getCheckOut() +
                        " | Precio: " + reserva.getPrecioTotal());
            }
        }
    }
    }

    public void mostrarInfoHabitaciones(List<Habitacion> habitaciones) {
        System.out.println("\n--- Lista de Habitaciones ---");
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Número: " + habitacion.getNumero() +
                    " | Tipo: " + habitacion.getTipo() +
                    " | Precio: " + habitacion.getPrecio() +
                    " | Estado: " + habitacion.getEstado());
        }
    }

    public void mostrarInfoReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva reserva : controladorReserva.getReservas()) {
            System.out.println("ID Reserva: " + reserva.getIDReserva() +
                    " | Cliente: " + reserva.getCliente().getNombre() +
                    " | Check-in: " + reserva.getCheckIn() +
                    " | Check-out: " + reserva.getCheckOut() +
                    " | Precio Total: " + reserva.getPrecioTotal());
        }
    }
}
