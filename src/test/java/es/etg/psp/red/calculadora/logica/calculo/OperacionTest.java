package es.etg.psp.red.calculadora.logica.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OperacionTest {

    private final static int NUM1=10;
    private final static int NUM2=2;


    @Test
    public void sumar(){
        
        int esperado = 12;
        Operacion operacion = OperacionFactory.crear(NUM1, NUM2, OperacionEnum.SUMA);

        assertEquals(esperado, operacion.calcular());
    }

    @Test
    public void restar(){
        
        int esperado = 8;
        Operacion operacion = OperacionFactory.crear(NUM1, NUM2, OperacionEnum.RESTA);

        assertEquals(esperado, operacion.calcular());
    }
}
