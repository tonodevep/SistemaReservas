package Modelo;

import java.util.ArrayList;
import java.util.List;


//Clase Cliente donde se encapsularan los métodos y datos relacionados al cliente
public class Cliente {
    
    //Atributos
    private static int IDClienteCounter = 0;
    private int IDCliente;
    private String nombreCliente;
    private List<Reserva> historialReservas;
    private final List<Reserva> reservasActivas;

    //Constructor
    public Cliente(String nombreCliente, int IDCliente, List<Reserva> reservasActivas){
        this.reservasActivas = reservasActivas;
        this.IDCliente = ++IDClienteCounter;
        this.nombreCliente = nombreCliente;
        this.historialReservas = new ArrayList<>();
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
    
    public static int getReservasActivas() {
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

    public static void setReservasActivas(int reservasActivas) {
        Cliente.reservasActivas = reservasActivas;
    }
    
    
}
