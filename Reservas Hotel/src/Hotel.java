import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private int precioHabitacion;
    private int idHabitacion;
    private int idReserva;


    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
        precioHabitacion = 0;
        idHabitacion = 0;
        idReserva = 0;
    }

    public void setPrecioPorHabitacion(int precio) {
       precioHabitacion = precio;
    }

    public void agregarHabitacion(int capacidadHabitacion) {
        habitaciones.add(new Habitacion(idHabitacion, capacidadHabitacion));
        idHabitacion++;
    }

    public boolean consultarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesDisponibles = habitacionesDisponibles(fechaInicio, fechaFin);
        if (habitacionesDisponibles.size() > 0){
            return true;
        } else {
            return false; 
        }
    }

    public void reservar(Cliente cliente, LocalDate fi, LocalDate ff, int cantPersonas) throws BusinessException {
       List<Habitacion> habitacionesDisponibles = habitacionesDisponibles(fi, ff, cantPersonas);
       if (habitacionesDisponibles.size() == 0){
            throw new BusinessException("Lo sentimos, no hay disponibilidad :(");
       }
       int cantDias = (int) ChronoUnit.DAYS.between(fi, ff);
       reservas.add(new Reserva(idReserva, fi, ff, cliente, habitacionesDisponibles.getFirst(), cantDias*precioHabitacion));
    }
    
    public void infoReservas(Cliente cliente) {
      List<Reserva> reservasCliente = reservasCliente(cliente);
      if (reservasCliente.size() == 0){
        System.out.println("No hay reservas.");
      }
      for (Reserva res : reservasCliente){
        System.out.println(res);
      }
    }
    
    public void cancelarReserva(Cliente cliente) {
       reservas.removeAll(reservasCliente(cliente));
    }

    private List<Reserva> reservasCliente(Cliente cliente) {
        List<Reserva> reservasC = new ArrayList<>();
        for (Reserva reserva : reservas){
            if (reserva.getCliente() == cliente){
                reservasC.add(reserva);
            }
        }
        return reservasC;
    }

    private List<Habitacion> habitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesDisp = new ArrayList<>(habitaciones);

        for (Reserva res: reservas){
            if (res.seSolapa(fechaInicio, fechaFin)){
                habitacionesDisp.remove(res.getHabitacion());
            }
        }
        
        return habitacionesDisp;
    }

    private List<Habitacion> habitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin, int capacidad) {
        List<Habitacion> habitacionesDisp = habitacionesDisponibles(fechaInicio, fechaFin);

        for(Habitacion habitacion: habitacionesDisponibles(fechaInicio, fechaFin)){
            if (habitacion.getCapacidad() < capacidad){
                habitacionesDisp.remove(habitacion);
            }
        }
        return habitacionesDisp;
    }

   



   

}
