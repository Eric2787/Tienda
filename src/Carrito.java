import java.util.ArrayList;

public class Carrito {
    private final ArrayList<Producto> lista;

    public Carrito() {
        lista = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        lista.add(producto);
        System.out.println("Producto agregado");
    }

    public double realizarCheckOut() {
        double total = 0;
        System.out.println("Resumen de compra");
        try {
            for (Producto p : lista) {
                p.reducirCantidad(1);
                double subtotal = p.calcularPrecioFinal();
                System.out.println("- " + p.nombre + ": $"+ subtotal);
                total += subtotal;
            }
        } catch (Exception e) {
            System.out.println("Error al realizar compra: " + e.getMessage());
        }
        return total;
    }
}
