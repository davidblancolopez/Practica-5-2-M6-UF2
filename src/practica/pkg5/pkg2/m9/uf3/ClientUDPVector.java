
package practica.pkg5.pkg2.m9.uf3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class ClientUDPVector {
    private static final String[] Vector = {"enviant", "un", "missatge", "de", "cinc"};
    private static VectorString v = new VectorString(Vector);
    
    /**
     * Metode per enviar l'objecte.
     * @param o
     * @return
     * @throws IOException 
     */
    public static byte[] enviarObjecte(Object o) throws IOException(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        
        oos.writeObject(o);
        
        oos.close();
        
        return baos.toByteArray();
    }
    
    /**
     * Metode per rebre un objecte.
     * @param bytes
     * @return
     * @throws IOException 
     */
    public static VectorString rebreObjecte(byte[] bytes) throws IOException, ClassNotFoundException{
        return (VectorString) new ObjectOutputStream(new ByteArrayInputStream(bytes)).readObject();
        
    }
    
    public static void main(String args[]) {
        
    }
}
