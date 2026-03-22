public class TarjetaDebito implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        double impuesto = monto * 0.03;
        monto += impuesto;
        System.out.println("Impuesto a pagar: $" + impuesto);
        System.out.println("Pagando con: Tarjeta de Debito: $" + monto);
    }
}
