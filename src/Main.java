import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws RuntimeException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido a mi tienda");

            Menu menu = new Menu();

            int opc;

            do {

                Carrito carrito = new Carrito();

                do {

                    menu.mostrarMenu();

                    System.out.println("Ingrese el nombre del producto");
                    String sprod = sc.nextLine();

                    Producto productoSeleccionado = Producto.buscarPorNombre(sprod);
                    if (productoSeleccionado != null) {
                        carrito.agregarProducto(productoSeleccionado);
                        carrito.realizarCheckOut();
                    } else {
                        System.out.println("Producto no encontrado");
                    }

                    System.out.println("¿Desea agregar otro producto? 1.Si 2.No");
                    opc = sc.nextInt();
                    sc.nextLine();

                } while (opc != 2);

                System.out.println("¿Que metodo de pago desea usar?");
                System.out.println("1. Tarjeta de Credito");
                System.out.println("2. Tarjeta de Debito");
                System.out.println("3. Efectivo");
                System.out.println("4. Bitcoin");
                int mpago = sc.nextInt();
                sc.nextLine();
                switch (mpago) {
                    case 1:
                        new TarjetaCredito().procesarPago(carrito.realizarCheckOut());
                        break;
                    case 2:
                        new TarjetaDebito().procesarPago(carrito.realizarCheckOut());
                        break;
                    case 3:
                        new PagoEfectivo().procesarPago(carrito.realizarCheckOut());
                        break;
                    case 4:
                        new PagoBitcoin().procesarPago(carrito.realizarCheckOut());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                System.out.println("Gracias por su compra. ¿Desea salir? 1.Si 2.No");
                opc = sc.nextInt();
                sc.nextLine();
            } while (opc != 1);

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
