import java.util.ArrayList;
import java.util.List;


//Clase Cliente donde se encapsularan los métodos y datos relacionados al cliente
public class Cliente {
    
    //Atributos
    private static int IDClienteCounter = 0;
    private int IDCliente;
    private String nombreCliente;
    private List<Reservas> historialReservas;
    private static int reservasActivas = 0;

    //Constructor
    public Cliente(String nombreCliente, int ID){
        this.IDCliente = ++IDClienteCounter;
        this.nombreCliente = nombreCliente;
        this.historialReservas = new ArrayList<>();
    }

    //Getters
    public int getIDCliente() {
        return IDCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Reservas> getHistorialReservas() {
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

    public void setHistorialReservas(List<Reservas> historialReservas) {
        this.historialReservas = historialReservas;
    }

    public static void setReservasActivas(int reservasActivas) {
        Cliente.reservasActivas = reservasActivas;
    }
    
    
}
