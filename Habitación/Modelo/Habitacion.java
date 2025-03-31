
public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precio;
    private EstadoHabitacion estado;
    private String descripcion;


    //Enum de tipo de habitación
    public enum TipoHabitacion {
        INDIVIDUAL, // 50€
        DOBLE,      // 80€
        SUITE       // 150€

        //Campo final que almacena el precio por noche
        private final double precioPorNoche;

        //Constructor del enum
        TipoHabitacion(double precioPorNoche){
            this.precioPorNoche = precioPorNoche;
        }

        //Getter de precioPorNoche
        public double getPrecioPorNoche(){
            return precioPorNoche;
        }
    }

    //Enum de estado de habitación
    public enum EstadoHabitacion {
        DISPONIBLE,
        RESERVADA,
        OCUPADA
    }

    public Habitacion(int numero, TipoHabitacion tipo, double precio, EstadoHabitacion estado, String descripcion) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.descripcion = descripcion;
    }


    // Getters y Setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}


