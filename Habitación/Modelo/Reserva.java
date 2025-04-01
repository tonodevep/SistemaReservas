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
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double precioTotal;

    //Constructor
    public Reserva(LocalDate checkIn, LocalDate checkOut, double precioTotal){
        this.IDReserva = ++IDReservaCounter;
        this.habitacionReservada = new ArrayList<>();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precioTotal = calcularPrecioTotal();
    }

    //Método que calcula el precio total dependiendo el tipo de habitación y la estancia
    private double calcularPrecioTotal(){

        long noches = ChronoUnit.DAYS.between(checkIn, checkOut);
        return noches * Habitacion.getTipo().getPrecioPorNoche();
    }

    //Getters
    public int getIDReserva() {
        return IDReserva;
    }

    public List<Habitacion> getHabitacionReservada() {
        return habitacionReservada;
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

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
        
}

