package Blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Cartera {
    public PrivateKey llavePrivada;
    public PublicKey llavePublica;

    public Cartera() throws BlockchainExeption{
        generarParLlaves();
    }

    private void generarParLlaves() throws BlockchainExeption{
        try{
            KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
                generador.initialize(2048);
                KeyPair parLlaves = generador.generateKeyPair();

                this.llavePrivada = parLlaves.getPrivate();
                this.llavePublica = parLlaves.getPublic();
        }catch (Exception e){
            throw new BlockchainExeption("Error al generar par de llaves: " + e.getMessage());
        }
    }
}
