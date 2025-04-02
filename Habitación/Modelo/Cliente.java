package Modelo;

import java.util.ArrayList;
import java.util.List;


//Clase Cliente donde se encapsularan los métodos y datos relacionados al cliente
public class Cliente {
    
    //Atributos
    private static int IDClienteCounter = 0;
    private int IDCliente;
    private String nombreCliente;
    private List<Reserva> reservasActivas = new ArrayList<>();
    private List<Reserva> historialReservas = new ArrayList<>();

    //Constructor
    public Cliente(String nombreCliente) { 
        this.nombreCliente = nombreCliente;
        this.reservasActivas = new ArrayList<>();
        this.historialReservas = new ArrayList<>();
        this.IDCliente = ++IDClienteCounter;
    }

    //Para establecer el límite de reservas activas
    public boolean puedeReservar() {
        return reservasActivas.size() < 3;
    }

    //Getters
    public int getIDCliente() {
        return IDCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Reserva> getHistorialReservas() {
        return historialReservas;
    }
    
    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }

    //Setters
    public void setIDCliente(int iDCliente) {
        IDCliente = iDCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setHistorialReservas(List<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }

    public void setReservasActivas(List<Reserva> reservasActivas) {
        this.reservasActivas.clear();
        this.reservasActivas.addAll(reservasActivas);
    }
    //Método para agregar las reservas
    public void agregarReserva(Reserva reserva) {
    if (puedeReservar()) {
        reservasActivas.add(reserva);
    }
}
    //Método para finalizar reserva
    public void finalizarReserva(Reserva reserva) {
        reservasActivas.remove(reserva);
        historialReservas.add(reserva);
    }

//Método para guardar las reservas agregadas
public void guardarReserva(Reserva reserva) {
        reservasActivas.remove(reserva);
        historialReservas.add(reserva);
    }
    
}
