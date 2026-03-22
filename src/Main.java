import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a mi tienda");

        Menu menu = new Menu();

        int opc;
        boolean exit = false;

        do {
            try {
                Carrito carrito = new Carrito();

                do {
                    menu.mostrarMenu();

                    System.out.println("Ingrese el nombre del producto");
                    String sprod = sc.nextLine();

                    Producto productoSeleccionado = Producto.buscarPorNombre(sprod);
                    if (productoSeleccionado != null) {
                        carrito.agregarProducto(productoSeleccionado);
                    } else {
                        System.out.println("Producto no encontrado");
                    }

                    System.out.println("¿Desea agregar otro producto? 1.Si 2.No");
                    opc = sc.nextInt();
                    sc.nextLine();

                    if (opc != 1 && opc != 2) {
                        System.out.println("Opcion no valida");
                        opc = 2;
                    }

                } while (opc != 2);

                double total = carrito.realizarCheckOut();

                if (total > 0) {
                    int mpago;
                    int aux = 0;
                    do {
                        System.out.println("¿Que metodo de pago desea usar?");
                        System.out.println("1. Tarjeta de Credito");
                        System.out.println("2. Tarjeta de Debito");
                        System.out.println("3. Efectivo");
                        System.out.println("4. Bitcoin");
                        mpago = sc.nextInt();
                        sc.nextLine();
                        switch (mpago) {
                            case 1:
                                new TarjetaCredito().procesarPago(total);
                                aux = 1;
                                break;
                            case 2:
                                new TarjetaDebito().procesarPago(total);
                                aux = 1;
                                break;
                            case 3:
                                new PagoEfectivo().procesarPago(total);
                                aux = 1;
                                break;
                            case 4:
                                new PagoBitcoin().procesarPago(total);
                                aux = 1;
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    } while (aux != 1);
                }

                System.out.println("Gracias por su compra. ¿Desea salir? 1.Si 2.No");
                opc = sc.nextInt();
                sc.nextLine();
                
                if (opc == 1) {
                    exit = true;
                }

            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
                sc = new Scanner(System.in);
            }
        } while (!exit);
    }
}
