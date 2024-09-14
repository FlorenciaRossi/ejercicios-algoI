public class Termometro implements Medible {
    private float temperatura;

    public Termometro(float temp) {
        // Podría tirar una excepción
        if (!(temp < -273)) {
            temperatura = temp;
        } else {
            temperatura = 0;
        }
    }

    @Override
    public float getMedida() {
        return temperatura;
    }

    @Override
    public void incrementar(float inc) {
        temperatura += inc;
    }

    @Override
    public boolean decrementar(float dec) {
        boolean huboError = false;
        float temp = temperatura - dec;

        if (temp < -273) {
            huboError = true;
        } else {
            temperatura = temp;
        }
        return huboError;
    }

    @Override
    public String toString() {
        return "Termómetro";
    }
}
