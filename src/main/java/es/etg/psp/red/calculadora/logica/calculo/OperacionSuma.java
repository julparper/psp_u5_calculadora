package es.etg.psp.red.calculadora.logica.calculo;

public class OperacionSuma extends Operacion{

    public OperacionSuma(int num1, int num2){
        super(num1, num2);
    }


    @Override
    public int calcular() {
        return num1 + num2;
    }
    
}
