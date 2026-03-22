import Blockchain.*;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class PagoBitcoin implements MetodoPago{
    @Override
    public void procesarPago(double monto) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ---- Iniciando red P2P ----");
        System.out.println("Pagando con: Bitcoin: $" + monto);
        try {

            Cartera carteraPrueba = new Cartera();
            Cartera carteraTienda = new Cartera();

            String pubKeyPrueba = CriptoUtil.llaveAString(carteraPrueba.llavePublica);
            String privKeyPrueba = CriptoUtil.llaveAString(carteraPrueba.llavePrivada);

            System.out.println("Para usar la llave publica de prueba presiona 1");
            System.out.println("Por favor, PEGUE su Llave Pública (o escriba '1' para usar la de prueba):");
            String strLlavePublica = sc.nextLine();

            if (strLlavePublica.equals("1")){
                strLlavePublica = pubKeyPrueba;
                System.out.println("> Usando Llave Pública de Prueba");
            }

            strLlavePublica = strLlavePublica.replaceAll("\\s+", "");
            PublicKey llavePublicaCliente = CriptoUtil.stringLlavePub(strLlavePublica);

            System.out.println("\nPor favor, PEGUE su Llave Privada para FIRMAR (o escriba '1' para usar la de prueba):");
            String strLlavePrivada = sc.nextLine();

            if (strLlavePrivada.equals("1")){
                strLlavePrivada = privKeyPrueba;
                System.out.println("> Usando Llave Privada de Prueba");
            }
            strLlavePrivada = strLlavePrivada.replaceAll("\\s+", "");
            PrivateKey llavePrivadaCliente = CriptoUtil.stringLlavePriv(strLlavePrivada);

            Transaccion trans = new Transaccion(llavePublicaCliente, carteraTienda.llavePublica, monto);
            trans.generarFirma(llavePrivadaCliente);

            if (trans.verificarFirma()){
                System.out.println("Transaccion firmada correctamente");

                ArrayList<Transaccion> transaccionesPendientes = new ArrayList<>();
                transaccionesPendientes.add(trans);

                System.out.println("Minando el bloque para asegurar la transaccion...");
                Block bloque = new Block("0", transaccionesPendientes);

                bloque.minarBloque(4);

                System.out.println("Pago realizado y registrado con exito");
            } else {
                System.out.println("Error al firmar la transaccion. Transaccion rechazada");
            }

        } catch (Exception e) {
            System.out.println("Error procesando pago criptográfico: Formato de llave incorrecto o datos corruptos.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
