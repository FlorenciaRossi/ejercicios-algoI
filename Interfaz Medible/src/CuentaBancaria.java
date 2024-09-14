public class CuentaBancaria implements Medible {
    private float saldo;

    public CuentaBancaria() {
        saldo = 0;
    }

    @Override
    public float getMedida() {
        return saldo;
    }

    @Override
    public void incrementar(float inc) {
        saldo += inc;
    }

    @Override
    public boolean decrementar(float dec) {
        boolean huboError = false;
        float saldoTemp = saldo - dec;

        if (saldoTemp < 0) {
            huboError = true;
        } else {
            saldo = saldoTemp;
        }
        return huboError;
    }

    @Override
    public String toString() {
        return "Cuenta bancaria";
    }
}
