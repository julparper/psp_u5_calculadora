package es.etg.psp.red.calculadora;

import java.net.ServerSocket;
import java.net.Socket;

import es.etg.psp.red.calculadora.logica.Tarea;

public class Servidor implements ISocket {

    private ServerSocket server = null;

    public Servidor()  throws Exception{
        server = new ServerSocket(PUERTO_SERVIDOR);
    }

    public ServerSocket getServer(){
        return server;
    }


    public static void main(String[] args) throws Exception{
        Servidor server = new Servidor();

        while(true){

            // Esperando peticiones:
            Socket cliente = server.getServer().accept(); 

            //Creo un hilo
            Tarea tarea = new Tarea(cliente);
            new Thread(tarea).start();
        }
    }
    
}
