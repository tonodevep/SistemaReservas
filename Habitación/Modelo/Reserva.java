package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import Modelo.Habitacion;

//Clase Reserva donde se encapsularan los métodos y datos relacionados a las reservas
public class Reserva {
    
    //Atributos
    private static int IDReservaCounter = 0;
    private int IDReserva;
    private List<Habitacion> habitacionReservada;
    private Cliente cliente;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double precioTotal;

    //Constructor
    public Reserva(int IDReserva, Habitacion habitacion, Cliente cliente, LocalDate checkIn, LocalDate checkOut){
        this.IDReserva = ++IDReservaCounter;
        this.habitacionReservada = new ArrayList<>();
        this.habitacionReservada.add(habitacion);
        this.cliente = cliente;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precioTotal = calcularPrecioTotal();
    }

    //Método que calcula el precio total dependiendo el tipo de habitación y la estancia
    private double calcularPrecioTotal() {
    long noches = ChronoUnit.DAYS.between(checkIn, checkOut);
    double precio = 0.0;
    for (Habitacion hab : habitacionReservada) {
        precio += noches * hab.getTipo().getPrecioPorNoche();
    }
    return precio;
}

    //Getters
    public int getIDReserva() {
        return IDReserva;
    }

    public List<Habitacion> getHabitacionReservada() {
        return habitacionReservada;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    //Setters
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }       
}
