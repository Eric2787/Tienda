public class PagoEfectivo implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagando con: Efectivo: $" + monto);
    }
}
