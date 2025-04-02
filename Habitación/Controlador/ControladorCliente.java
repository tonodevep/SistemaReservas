package Controlador;

import java.util.ArrayList;
import java.util.List;
import Modelo.Cliente;
import Modelo.Reserva;
import Excepciones.ClienteNoEncontradoException;

public class ControladorCliente {
    
    private List<Cliente> clientes = new ArrayList<>();

    // Constructor para iniciar clientes:
    public ControladorCliente() {
        this.clientes = new ArrayList<>();
    }

    //Método para agregar a los clientes al array
    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    //Método para buscar clientes
    public Cliente buscarCliente(int IDCliente) throws ClienteNoEncontradoException {
    for (Cliente c : clientes) {
        if (c.getIDCliente() == IDCliente) {
            return c;
        }
    }
    throw new ClienteNoEncontradoException("Cliente con ID " + IDCliente + " no encontrado.");
}
    //Getter de reservas activas
    public List<Reserva> getReservasActivas(int IDCliente) throws ClienteNoEncontradoException {
        Cliente cliente = buscarCliente(IDCliente);
        return cliente != null ? cliente.getReservasActivas() : new ArrayList<>();
    }

    //Método que verifica si es posible hacer una reserva
    public boolean puedeHacerReserva(int IDCliente) throws ClienteNoEncontradoException {
        Cliente cliente = buscarCliente(IDCliente);
        return cliente != null && cliente.puedeReservar();
    }

    //Método que agrega reservas
    public void agregarReserva(int IDCliente, Reserva reserva) throws ClienteNoEncontradoException {
        Cliente cliente = buscarCliente(IDCliente);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("No se ha podido encontrar al cliente.");
        }
        cliente.agregarReserva(reserva);
        System.out.println("\n Reserva hecha con éxito");
    }

    //Método para finalizar la reserva
    public void finalizarReserva(int IDCliente, Reserva reserva) throws ClienteNoEncontradoException {
        Cliente cliente = buscarCliente(IDCliente);
        if (cliente != null) {
            cliente.finalizarReserva(reserva);
        }else{
            throw new ClienteNoEncontradoException("No se ha podido encontrar al cliente, por lo que no se ha podido finalizar ninguna reserva");
        }
    }
    //Getter
    public List<Cliente> getTodosClientes() {
        return new ArrayList<>(clientes);
    }
}
