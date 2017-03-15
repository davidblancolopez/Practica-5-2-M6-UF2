
package practica.pkg5.pkg2.m9.uf3;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


public class ClientUDPVector {
        
    
        

   public static void main(String[] args) throws IOException {
        final int PORT = 54552;
        String[] missatge = new String[5];
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            
            DatagramSocket socketUDP = new DatagramSocket();

            //Posem 5 paraules.
            for (int i = 0; i < 5; i++) {
                missatge[i] = JOptionPane.showInputDialog(null, "Mensaje nº: " + (i+1), "Introduce el mensaje", 1);
            }
            //Es crea l'objecte que s'enviara despres.
            oos.writeObject(new VectorString(missatge));
            
            
            oos.flush();

            byte[] arrayBytes = baos.toByteArray();

            //Utilitzem el DataGramPacket per enviar l'objecte.
            DatagramPacket dp = new DatagramPacket(arrayBytes, arrayBytes.length, InetAddress.getLocalHost(), PORT);
            socketUDP.send(dp);
            
            //Es crea un array de bytes per rebre la resposta.
            byte[] buffer = new byte[1000];

            //Es rep la resposta.
            DatagramPacket dpRebut = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(dpRebut);

            System.out.println("Resposta: " + new String(dpRebut.getData()));
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
