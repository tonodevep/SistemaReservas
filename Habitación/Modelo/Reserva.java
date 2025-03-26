import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Clase Reserva donde se encapsularan los métodos y datos relacionados a las reservas
public class Reserva {
    
    //Atributos
    private static int IDReservaCounter = 0;
    private int IDReserva;
    private List<Habitacion> habitacionReservada;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int precioTotal;

    //Constructor
    public Reserva(LocalDate checkIn, LocalDate checkOut, int precioTotal){
        this.IDReserva = ++IDReservaCounter;
        this.habitacionReservada = new ArrayList<>();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precioTotal = precioTotal;
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

    public int getPrecioTotal() {
        return precioTotal;
    }

    //Setters
    public void setIDReserva(int iDReserva) {
        IDReserva = iDReserva;
    }

    public void setHabitacionReservada(List<Habitacion> habitacionReservada) {
        this.habitacionReservada = habitacionReservada;
    }

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
