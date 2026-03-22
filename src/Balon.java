public class Balon extends Producto{

    public Balon(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio + (precio * 0.124);
    }
}
