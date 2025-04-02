package Controlador;

import java.util.ArrayList;
import java.util.List;
import Modelo.Habitacion;
import Modelo.Habitacion.TipoHabitacion;
import Modelo.Habitacion.EstadoHabitacion;

public class ControladorHabitacion {
    private List<Habitacion> habitaciones;

    public ControladorHabitacion() {
        this.habitaciones = new ArrayList<>();
        inicializarHabitaciones();
    }

    // Inicializa todas las habitaciones del hotel en formato compacto por plantas
    private void inicializarHabitaciones() {
        // Planta 1 (Habitaciones 101-110)
        habitaciones.add(new Habitacion(101, TipoHabitacion.INDIVIDUAL, "Habitación individual con cama twin"));
        habitaciones.add(new Habitacion(102, TipoHabitacion.INDIVIDUAL, "Habitación individual con vista al jardín"));
        habitaciones.add(new Habitacion(103, TipoHabitacion.DOBLE, "Habitación doble con dos camas full"));
        habitaciones.add(new Habitacion(104, TipoHabitacion.DOBLE, "Habitación doble con cama queen"));
        habitaciones.add(new Habitacion(105, TipoHabitacion.SUITE, "Suite con sala de estar y jacuzzi"));
        
        // Planta 2 (Habitaciones 201-210)
        habitaciones.add(new Habitacion(201, TipoHabitacion.INDIVIDUAL, "Habitación individual premium"));
        habitaciones.add(new Habitacion(202, TipoHabitacion.DOBLE, "Habitación doble con balcón"));
        habitaciones.add(new Habitacion(203, TipoHabitacion.DOBLE, "Habitación doble familiar"));
        habitaciones.add(new Habitacion(204, TipoHabitacion.SUITE, "Suite ejecutiva con oficina"));
        habitaciones.add(new Habitacion(205, TipoHabitacion.SUITE, "Suite presidencial"));
        
        // Planta 3 (Habitaciones 301-310)
        habitaciones.add(new Habitacion(301, TipoHabitacion.INDIVIDUAL, "Habitación individual con escritorio"));
        habitaciones.add(new Habitacion(302, TipoHabitacion.INDIVIDUAL, "Habitación individual silenciosa"));
        habitaciones.add(new Habitacion(303, TipoHabitacion.DOBLE, "Habitación doble con vista al mar"));
        habitaciones.add(new Habitacion(304, TipoHabitacion.DOBLE, "Habitación doble con terraza"));
        habitaciones.add(new Habitacion(305, TipoHabitacion.SUITE, "Suite nupcial con jacuzzi"));
        habitaciones.add(new Habitacion(306, TipoHabitacion.SUITE, "Suite familiar grande"));
    }

    // Método para buscar una habitación por su número
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    //Método para listar todas las habitaciones disponibles
    public List<Habitacion> listarHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getEstado() == EstadoHabitacion.DISPONIBLE) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    //Método para obtener todas las habitaciones
    public List<Habitacion> getTodasLasHabitaciones() {
        return new ArrayList<>(habitaciones);
    }
}
