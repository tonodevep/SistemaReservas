package App;

import Controlador.*;
import Modelo.*;
import Excepciones.*;
import Vista.VistaConsola;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Inicializamos controladores
        ControladorHabitacion controladorHabitacion = new ControladorHabitacion();
        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorReserva controladorReserva = new ControladorReserva();
        VistaConsola vista = new VistaConsola(controladorCliente, controladorReserva, controladorHabitacion);

        // Registramos nuestros clientes
        Cliente leon = new Cliente("Leon Kennedy");
        Cliente chris = new Cliente("Chris Redfield");
        Cliente jill = new Cliente("Jill Valentine");
        
        controladorCliente.agregarCliente(leon);
        controladorCliente.agregarCliente(chris);
        controladorCliente.agregarCliente(jill);

        // Mostramos el estado inicial
        System.out.println("=== ESTADO INICIAL ===");
        vista.mostrarInfoClientes();
        vista.mostrarInfoHabitaciones(controladorHabitacion.getTodasLasHabitaciones());

        // Simulamos las reservas
        System.out.println("\n=== SIMULACIÓN DE RESERVAS ===");
        try {
            System.out.print("\n Leon va a reservar la suite 105");
            Reserva reservaLeon = controladorReserva.reservarHabitacion(
                controladorHabitacion.buscarHabitacion(105),
                leon,
                LocalDate.of(2023, 12, 15),
                LocalDate.of(2023, 12, 20)
            );
            controladorCliente.agregarReserva(leon.getIDCliente(), reservaLeon);

            // Chris reserva la habitación doble 103
            System.out.print("\n Chris va a reservar la suite 103");
            Reserva reservaChris = controladorReserva.reservarHabitacion(
                controladorHabitacion.buscarHabitacion(103),
                chris,
                LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 15)
            );

            // Jill intenta reservar la misma habitación (debería fallar)
            try {
                System.out.print("\n Jill va a reservar la suite 103");
                Reserva reservaJill = controladorReserva.reservarHabitacion(
                    controladorHabitacion.buscarHabitacion(103),
                    jill,
                    LocalDate.now(),
                    LocalDate.now().plusDays(3)
                );
            } catch (ReservaNoDisponibleException e) {
                System.out.println("\n Error al reservar para Jill: " + e.getMessage());
            }

            // Jill reserva otra habitación
            Reserva reservaJill = controladorReserva.reservarHabitacion(
                controladorHabitacion.buscarHabitacion(201),
                jill,
                LocalDate.of(2023, 12, 5),
                LocalDate.of(2023, 12, 10)
            );
            controladorCliente.agregarReserva(jill.getIDCliente(), reservaJill);

        } catch (ReservaNoDisponibleException | ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Mostrar estado después de reservas
        System.out.println("\n=== DESPUÉS DE RESERVAS ===");
        vista.mostrarInfoClientes();
        vista.mostrarInfoReservas();
        vista.mostrarInfoHabitaciones(controladorHabitacion.listarHabitacionesDisponibles());

        // 5. Simulación de cancelación/finalización
        System.out.println("\n=== FINALIZACIÓN/CANCELACIÓN ===");
        try {
            // Leon finaliza su reserva
            controladorCliente.finalizarReserva(leon.getIDCliente(), 
                controladorReserva.buscarReserva(1));
            
            // Chris cancela su reserva
            controladorReserva.cancelarReserva(2);
            
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error al finalizar reserva: " + e.getMessage());
        }
        
        System.out.println("\n=== PRUEBA: INTENTAR SUPERAR EL LÍMITE DE RESERVAS ===");

        try {
            
            Habitacion habitacionAdicional = controladorHabitacion.buscarHabitacion(306);
            System.out.println("\n Chris intenta reservar la habitación 306");
    
            Reserva reservaAdicional = controladorReserva.reservarHabitacion(
            habitacionAdicional,
            chris,
            LocalDate.of(2025, 12, 18),
            LocalDate.of(2025, 12, 23)
            );
        } catch (ReservaNoDisponibleException e) {
            
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            
            Habitacion habitacionAdicional = controladorHabitacion.buscarHabitacion(205);
            System.out.println("\n Chris intenta reservar la habitación 205");
    
            Reserva reservaAdicional = controladorReserva.reservarHabitacion(
            habitacionAdicional,
            chris,
            LocalDate.of(2025, 12, 18),
            LocalDate.of(2025, 12, 23)
            );
        } catch (ReservaNoDisponibleException e) {
          
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
          
            Habitacion habitacionAdicional = controladorHabitacion.buscarHabitacion(304);
            System.out.println("\n Chris intenta reservar la habitación 304");
    
            Reserva reservaAdicional = controladorReserva.reservarHabitacion(
            habitacionAdicional,
            chris,
            LocalDate.of(2025, 12, 18),
            LocalDate.of(2025, 12, 23)
            );
        } catch (ReservaNoDisponibleException e) {
            
            System.out.println("Error: " + e.getMessage());
        }

        // 6. Estado final
        System.out.println("\n=== ESTADO FINAL ===");
        vista.mostrarInfoClientes();
        vista.mostrarInfoReservas();
        vista.mostrarInfoHabitaciones(controladorHabitacion.getTodasLasHabitaciones());
    
    }
}
