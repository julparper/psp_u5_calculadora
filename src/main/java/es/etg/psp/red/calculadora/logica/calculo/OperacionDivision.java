package es.etg.psp.red.calculadora.logica.calculo;

public class OperacionDivision extends Operacion{

    public OperacionDivision(int num1, int num2){
        super(num1, num2);
    }


    @Override
    public int calcular() {
        return num1 / num2;
    }
    
}
