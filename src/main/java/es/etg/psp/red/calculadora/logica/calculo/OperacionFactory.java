package es.etg.psp.red.calculadora.logica.calculo;


public class OperacionFactory {
    
    public static Operacion crear(int num1, int num2, OperacionEnum op){
        switch (op) {
            case SUMA -> {
                return new OperacionSuma(num1, num2);
            }
            case RESTA -> {
                return new OperacionResta(num1, num2);
            }
            case MULTIPLICACION -> {
                return new OperacionMultiplicacion(num1, num2);
            }
            case DIVISION -> {
                return new OperacionDivision(num1, num2);
            }
            default -> throw new AssertionError();
        }
    }
}
