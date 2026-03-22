public class HombreFormal extends RopaHombre{
    public HombreFormal(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
}
