package es.etg.psp.red.calculadora;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import es.etg.psp.red.calculadora.logica.calculo.OperacionEnum;

public class ServidorTest extends GestorMensajes {
    
    public static final String HOST = "localhost";
    private static final String NUM1="10";
    private static final String NUM2="2";


    @Test
    public void sumarTest() throws Exception{
        Socket cliente = new Socket( HOST, Servidor.PUERTO_SERVIDOR );
        int esperado = 12;
        int real  = 0; 

        enviar(cliente, NUM1);
        enviar(cliente, OperacionEnum.SUMA.toString());
        enviar(cliente, NUM2);

        real = recibir(cliente);

        assertEquals(esperado, real);
    }

    @Test
    public void restarTest() throws Exception{
        Socket cliente = new Socket( HOST, Servidor.PUERTO_SERVIDOR );
        int esperado = 8;
        int real  = 0; 

        enviar(cliente, NUM1);
        enviar(cliente, OperacionEnum.RESTA.toString());
        enviar(cliente, NUM2);

        real = recibir(cliente);

        assertEquals(esperado, real);
    }


    @Test
    public void multiplicarTest() throws Exception{
        Socket cliente = new Socket( HOST, Servidor.PUERTO_SERVIDOR );
        int esperado = 20;
        int real  = 0; 

        enviar(cliente, NUM1);
        enviar(cliente, OperacionEnum.MULTIPLICACION.toString());
        enviar(cliente, NUM2);

        real = recibir(cliente);

        assertEquals(esperado, real);
    }

    @Test
    public void dividirTest() throws Exception{
        Socket cliente = new Socket( HOST, Servidor.PUERTO_SERVIDOR );
        int esperado = 5;
        int real  = 0; 

        enviar(cliente, NUM1);
        enviar(cliente, OperacionEnum.DIVISION.toString());
        enviar(cliente, NUM2);

        real = recibir(cliente);

        assertEquals(esperado, real);
    }


    public int recibir(Socket cliente) throws Exception{
        return Integer.parseInt(leerString(cliente));
    }
}
