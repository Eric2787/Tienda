public class HombreInformal extends RopaHombre{
    public HombreInformal(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
}
