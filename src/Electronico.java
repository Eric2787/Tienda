public class Electronico extends Producto {

    public Electronico(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio * 0.16;
    }
}
