public class MujerPlaya extends RopaMujer{
    public MujerPlaya(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
}
