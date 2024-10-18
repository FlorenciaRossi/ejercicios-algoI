package hospital.estudios;

public class EstudioLaboratorio extends Estudio{
    private int cantItems;

    public EstudioLaboratorio(int cantItems){
        super("Laboratorio", "Estudio de laboratorio", Estado.PENDIENTE);
        this.cantItems =  cantItems;
    }
}
