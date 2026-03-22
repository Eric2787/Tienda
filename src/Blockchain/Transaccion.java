package Blockchain;

public class Transaccion {
    String remitente;
    String destino;
    double monto;

    public Transaccion(String remitente, String destino, double monto) {
        this.remitente = remitente;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public String toString(){return remitente + " - " + destino + " - " + monto;}

}
