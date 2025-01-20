package es.etg.psp.red.calculadora.logica.calculo;

public abstract class Operacion {
    
    protected int num1;
    protected int num2;

    public Operacion(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract int calcular();
}
