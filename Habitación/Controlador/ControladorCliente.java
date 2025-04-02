package Controlador;

import java.util.ArrayList;
import java.util.List;
import Modelo.Cliente;

import Excepciones.ReservaNoDisponibleException;

public class ControladorCliente {
    private final List<Cliente> clientes;
    private int IDClienteCounter = 0;

    public ControladorCliente() {
        this.clientes = new ArrayList<>();
        // Crear 3 clientes predefinidos
        clientes.add(new Cliente(++IDClienteCounter, "Juan Pérez"));
        clientes.add(new Cliente(++IDClienteCounter, "María García"));
        clientes.add(new Cliente(++IDClienteCounter, "Carlos López"));
    }

    public Cliente buscarCliente(int IDCliente) throws ClienteNoEncontradoException{
        for (Cliente c : clientes) {
            if (c.getIDCliente() == IDCliente) {
                return c;
            }else{
                throw new ClienteNoEncontradoException("No se ha podido encontrar al cliente.");
            }
        }
        return null;
    }

    public List<Reserva> getReservasActivas(int IDCliente) {
        Cliente cliente = buscarCliente(IDCliente);
        return cliente != null ? cliente.getReservasActivas() : new ArrayList<>();
    }

    public boolean puedeHacerReserva(int IDCliente) {
        Cliente cliente = buscarCliente(IDCliente);
        return cliente != null && cliente.puedeReservar();
    }

    public void agregarReserva(int IDCliente, Reserva reserva) throws ClienteNoEncontradoException {
        Cliente cliente = buscarCliente(IDCliente);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("No se ha podido encontrar al cliente.");
        }
        cliente.agregarReserva(reserva);
    }

    public void finalizarReserva(int IDCliente, Reserva reserva) {
        Cliente cliente = buscarCliente(IDCliente);
        if (cliente != null) {
            cliente.finalizarReserva(reserva);
        }
    }

    public List<Cliente> getTodosClientes() {
        return new ArrayList<>(clientes);
    }
}
