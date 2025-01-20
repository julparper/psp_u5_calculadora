package es.etg.psp.red.calculadora;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class GestorMensajes {
   
    public String leerString(Socket socket) throws Exception{
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int size = dis.readInt();
        byte[] data = new byte[size];
        dis.readFully(data);
        String msg = new String(data); 
        return msg;
    }

    public void enviar(Socket cliente, String msg) throws Exception{

        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
        byte[] data = msg.getBytes(); 
        dos.writeInt(data.length);
        dos.write(data);
        dos.flush();

    }

}
