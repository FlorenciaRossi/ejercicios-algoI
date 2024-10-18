package hospital.estudios;

public class EstudioRX extends Estudio{
    private String zona;
    
    public EstudioRX(String zona){
        super("RX", "Estudio de imagen RX" + zona, Estado.PENDIENTE);
        this.zona = zona;
    }

    
}
