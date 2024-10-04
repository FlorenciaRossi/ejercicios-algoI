import java.time.LocalDate;

public class Reserva {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Cliente cliente;
    private Habitacion habitacion;
    private int costo;

    public Reserva(int id, LocalDate fi, LocalDate ff, Cliente cliente, Habitacion habitacion, int costo) {
        this.id = id;
        this.fechaInicio = fi;
        this.fechaFin = ff;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.costo = costo;
    }

    public boolean seSolapa(LocalDate fechaInicio2, LocalDate fechaFin2) {
        if (fechaInicio2 == fechaInicio || fechaFin == fechaFin2) {
            return true;
        }
        if (fechaInicio2.isBefore(fechaFin) && fechaFin2.isAfter(fechaInicio)) {
            return true;
        } else {
            return false;
        }
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }
    @Override
    public String toString() {
        return "Reserva: " + id +
                "\nCliente: " + cliente +
                "\nDesde: " + fechaInicio +
                "\nHasta: " + fechaFin +
                "\n" + habitacion + 
                "\nCosto: " + costo;
  
    }
}
