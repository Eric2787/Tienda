public class AlimentoPerro extends AlimentosMascotas {

    public AlimentoPerro(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public double calcularPrecioFinal() {
        return precio + (precio * 0.30);
    }
}
