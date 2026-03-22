import java.util.Scanner;

public class TarjetaCredito implements MetodoPago{
    Scanner sc = new Scanner(System.in);

    @Override
    public void procesarPago(double monto) {
        System.out.println("¿Desea pagar a meses? 1.Si 2.No");
        int opc = sc.nextInt();
        if (opc == 1) {
            System.out.println("¿Cuantos meses desea pagar?");
            int meses = sc.nextInt();
            double cuota = monto / meses;
            System.out.println("Cuota a pagar: $" + cuota + " + intereses");
            double intereses = (cuota * 0.45);
            double total = monto + intereses;
            System.out.println("Intereses a pagar: $" + intereses);
            monto = total;
            System.out.println("Total a pagar: $" + monto);

        } else {
            System.out.println("Pago de contado");
        }

        System.out.println("Pagando con: Tarjeta de Credito: $" + monto);
    }
}
