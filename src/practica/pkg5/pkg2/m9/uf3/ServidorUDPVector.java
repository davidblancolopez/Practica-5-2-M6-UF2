
package practica.pkg5.pkg2.m9.uf3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class ServidorUDPVector {
    
     public static void main(String[] args) throws ClassNotFoundException {

        final int PORT = 54552;

        try {
            
            //Es crea el DatagramPacket que rebra una comunicació.
            DatagramSocket socketUDP = new DatagramSocket(PORT, InetAddress.getLocalHost());
            byte[] buffer = new byte[1000];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(dp);

            //Creem l'objecte que enviarem com a resposta.
            ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            VectorString vs = (VectorString) ois.readObject();

            for (String string : vs.getArrayStrings()) {
                System.out.println(string);
            }

            
            //Es crea y s'envia el missatge de resposta.
            String estat = "OK";
            byte[] arrayBytes = estat.getBytes();

            DatagramPacket dpRebut = new DatagramPacket(arrayBytes, arrayBytes.length, dp.getAddress(), dp.getPort());
            socketUDP.send(dpRebut);

            socketUDP.close();
        } catch (SocketException ex) {
            System.out.println(ex);
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
     
}
