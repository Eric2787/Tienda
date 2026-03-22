import java.util.HashMap;
import java.util.Map;

public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        productoPorNombre.put(nombre, this);
    }

    public abstract double calcularPrecioFinal();

    public void reducirCantidad(int cantidad) throws Exception{
        if(cantidad>stock){
            throw  new Exception("No hay stock suficiente para: " + this.nombre);
        } else {
            this.stock -= cantidad;
        }
    }

    private static final Map<String, Producto> productoPorNombre = new HashMap<>();

    public static Producto buscarPorNombre(String nombre){
        return productoPorNombre.get(nombre);
    }
}
