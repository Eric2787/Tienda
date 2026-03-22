package Blockchain;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CriptoUtil {

    public static byte[] firmarDatos(String datos, PrivateKey llavePrivada) throws BlockchainExeption {
        try {
            Signature firma = Signature.getInstance("SHA256withRSA");
            firma.initSign(llavePrivada);
            firma.update(datos.getBytes(StandardCharsets.UTF_8));
            return firma.sign();
        } catch (Exception e){
            throw new BlockchainExeption("Error al firmar datos: " + e.getMessage());
        }
    }

    public static boolean verificarFirma(PublicKey llavePublica, String datos, byte[] firmaAVerificar){
        try{
            Signature verificador = Signature.getInstance("SHA256withRSA");
            verificador.initVerify(llavePublica);
            verificador.update(datos.getBytes(StandardCharsets.UTF_8));
            return verificador.verify(firmaAVerificar);
        } catch (Exception e){
            return  false;
        }
    }

    public static String llaveAString(java.security.Key llave){
        return Base64.getEncoder().encodeToString(llave.getEncoded());
    }

    public static PublicKey stringLlavePub(String llaveBase64) throws Exception {
        byte[] datosDecodificados = Base64.getDecoder().decode(llaveBase64);
        X509EncodedKeySpec especificacion = new X509EncodedKeySpec(datosDecodificados);
        KeyFactory fabrica = KeyFactory.getInstance("RSA");
        return fabrica.generatePublic(especificacion);
    }

    public static PrivateKey stringLlavePriv(String llaveBase64) throws Exception {
        byte[] datosDecodificados = Base64.getDecoder().decode(llaveBase64);
        PKCS8EncodedKeySpec especificacion = new PKCS8EncodedKeySpec(datosDecodificados);
        KeyFactory fabrica = KeyFactory.getInstance("RSA");
        return fabrica.generatePrivate(especificacion);
    }

}
