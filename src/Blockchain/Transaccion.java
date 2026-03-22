package Blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Transaccion {
    public PublicKey remitente;
    public PublicKey destino;
    public double monto;
    public byte[] firma;

    public Transaccion(PublicKey remitente, PublicKey destino, double monto) {
        this.remitente = remitente;
        this.destino = destino;
        this.monto = monto;
    }

    private String obtenerDatosParaFirma(){
        String keyRemitente = Base64.getEncoder().encodeToString(remitente.getEncoded());
        String keyDestino = Base64.getEncoder().encodeToString(destino.getEncoded());
        return keyRemitente + keyDestino + monto;
    }

    public void generarFirma(PrivateKey llavePrivada) throws BlockchainExeption {
        String datos = obtenerDatosParaFirma();
        this.firma = CriptoUtil.firmarDatos(datos, llavePrivada);
    }

    public boolean verificarFirma(){
        String datos = obtenerDatosParaFirma();
        return CriptoUtil.verificarFirma(remitente, datos, firma);
    }

    @Override
    public String toString(){
        return  "Transaccion{"+ "monto=" + monto + "}";
    }
}
