public class cuentabancaria {

    private static final double SALDO_MINIMO = -50;
    private static final double LIMITE_HACIENDA = 3000;
    private static final int MAX_MOVIMIENTOS = 100;

    private String IBAN;
    private String Titular;
    private double Saldo;
    private Movimiento[] Movimientos;
    private int contadorMovimientos;

    public cuentabancaria(String IBAN, String Titular) {

        if (!validarIBAN(IBAN)) {
            throw new IllegalArgumentException("El titular esta vacio");
        }

        if (Titular == null || Titular.isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacio");
        }
        this.IBAN = IBAN;
        this.Titular = Titular;
        this.Saldo = 0;
        this.Movimientos = new Movimiento[MAX_MOVIMIENTOS];
        this.contadorMovimientos = 0;
    }

    public String getIBAN() {
        return IBAN;
    }
    public String getTitular() {
        return Titular;
    }
    public double getSaldo() {
        return Saldo;
    }
    public Movimiento[] getMovimientos() {
        return Movimientos;
    }

    private boolean validarIBAN(String IBAN) {

        if (IBAN.length() != 24) return false;

        String letras = IBAN.substring(0, 2);
        String numeros = IBAN.substring(2);

        if (!letras.matches("[A-Za-z]{2}")) return false;

        // Comprobar que las 22 posiciones restantes son números
        if (!numeros.matches("[0-9]{22}")) return false;

        return true;
    }

    private void registrarMovimiento(Movimiento mov) {
        if (contadorMovimientos < MAX_MOVIMIENTOS) {
            Movimientos[contadorMovimientos] = mov;
            contadorMovimientos++;
        }
    }

    public void ingresar(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida");
            return;
        }

        if (cantidad > LIMITE_HACIENDA) {
            System.out.println("AVISO: Notificar a hacienda");
        }

        Saldo += cantidad;

        Movimiento m = new Movimiento("Ingreso", cantidad);
        registrarMovimiento(m);
    }

    public void retirar(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida");
            return;
        }

        double saldoFinal = Saldo - cantidad;

        if (saldoFinal < SALDO_MINIMO) {
            System.out.println("No se puede realizar la operación, saldo insuficiente");
            return;
        }

        if (saldoFinal < 0) {
            System.out.println("AVISO: Saldo negativo");
        }

        if (cantidad > LIMITE_HACIENDA) {
            System.out.println("AVISO: Notificar a hacienda");
        }

        Saldo = saldoFinal;

        Movimiento m = new Movimiento("Retirada", cantidad);
        registrarMovimiento(m);
    }
}
