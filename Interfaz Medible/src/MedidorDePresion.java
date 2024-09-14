public class MedidorDePresion implements Medible {
    private float presion;
    private int cantIncrementos;
    private boolean ultimoMovimientoFueIncremento;

    public MedidorDePresion() {
        presion = 0;
        cantIncrementos = 0;
        ultimoMovimientoFueIncremento = false;
    }

    @Override
    public float getMedida() {
        return presion;
    }

    @Override
    public void incrementar(float inc) {
        presion += inc;
        cantIncrementos++;
        ultimoMovimientoFueIncremento = true;
    }

    @Override
    public boolean decrementar(float dec) {
        boolean huboError = false;
        if (!ultimoMovimientoFueIncremento) {
            huboError = true;
        } else {
            presion = dec / cantIncrementos;
            cantIncrementos = 0;
            ultimoMovimientoFueIncremento = false;
        }
        return huboError;
    }

    @Override
    public String toString() {
        return "Medidor de presión";
    }

}
