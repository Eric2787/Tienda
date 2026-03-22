import java.util.ArrayList;

public class Menu {

    Producto tv = new Electronico("TV 50\"", 8000, 5);
    Producto camisa = new HombreFormal("Camisa Formal", 500, 10);
    Producto vestido = new MujerNoche("Vestido", 700, 15);
    Producto trajeBanio = new MujerPlaya("Traje de baño", 900, 20);
    Producto playera = new HombreInformal("Playera", 300, 10);
    Producto balon = new Balon("Balon", 100, 50);
    Producto AlimentoPerro = new AlimentoPerro("Alimento Perro 20KG", 650, 10);

    private final ArrayList<String> productos;
    public Menu() {
        productos = new ArrayList<>();
        productos.add(tv.nombre);
        productos.add(camisa.nombre);
        productos.add(vestido.nombre);
        productos.add(trajeBanio.nombre);
        productos.add(playera.nombre);
        productos.add(balon.nombre);
        productos.add(AlimentoPerro.nombre);
    }

    public void mostrarMenu(){
        for(int i = 0; i < productos.size(); i++){
            System.out.println(i+1 + ". " + productos.get(i));
        }
    }

}
