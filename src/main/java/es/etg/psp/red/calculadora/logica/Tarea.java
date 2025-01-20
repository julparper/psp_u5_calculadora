package es.etg.psp.red.calculadora.logica;



import java.io.IOException;
import java.net.Socket;

import es.etg.psp.red.calculadora.GestorMensajes;
import es.etg.psp.red.calculadora.logica.calculo.OperacionEnum;
import es.etg.psp.red.calculadora.logica.calculo.OperacionFactory;




public class Tarea extends GestorMensajes implements Runnable {

    private Socket cliente  = null;

    public Tarea(Socket c){
        this.cliente = c;
    }

    @Override
    public void run() throws RuntimeException{

        //Leo un numero, simbolo, numero
        try{
            int num1 = leerNumero(cliente);
            OperacionEnum oper = leerOperacion(cliente);
            int num2 = leerNumero(cliente);

            int resultado =  OperacionFactory.crear(num1, num2, oper).calcular();

            enviar(cliente, Integer.toString(resultado));

            System.out.println(String.format("Procesado %s %s %s = %s", num1, oper, num2, resultado));
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try {
                this.cliente.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    }


    public int leerNumero(Socket socket) throws Exception{
        String msg = leerString(socket);
        return Integer.parseInt(msg);
    }

    public OperacionEnum leerOperacion(Socket socket) throws Exception{
        OperacionEnum operacion = null;
        String msg = leerString(socket);

        if (OperacionEnum.SUMA.equals(msg)){
            operacion = OperacionEnum.SUMA;
        }else if (OperacionEnum.RESTA.equals(msg)){
            operacion = OperacionEnum.RESTA;
        }else if (OperacionEnum.MULTIPLICACION.equals(msg)){
            operacion = OperacionEnum.MULTIPLICACION;
        }else if (OperacionEnum.DIVISION.equals(msg)){
            operacion = OperacionEnum.DIVISION;
        }
        return operacion;
    }

    
}
