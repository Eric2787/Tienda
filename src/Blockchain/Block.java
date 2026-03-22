package Blockchain;

import java.util.Date;
import java.util.List;

public class Block {
    public String hash;
    public String hashAnterior;
    private final List<Transaccion> transacciones;
    private final long selloTiempo;
    private int nonce;

    public Block(String hashAnterior, List<Transaccion> transacciones) throws BlockchainExeption {
        this.hashAnterior = hashAnterior;
        this.transacciones = transacciones;
        this.selloTiempo = new Date().getTime();
        this.hash = calcularHash();
    }

    public String calcularHash() throws BlockchainExeption {
        String dataTransacciones = "";
        for (Transaccion t : transacciones) {
            dataTransacciones += t.toString();
        }

        return HashUtil.aplicarSHA256(
                hashAnterior +
                        selloTiempo +
                        nonce +
                        dataTransacciones
        );
    }

    public void minarBloque(int dificultad) throws BlockchainExeption {
        String objetivo = new String(new char[dificultad]).replace('\0', '0');
        while (!hash.substring(0, dificultad).equals(objetivo)) {
            nonce++;
            hash = calcularHash();
        }
        System.out.println("Bloque minado: " + hash);
    }
}
