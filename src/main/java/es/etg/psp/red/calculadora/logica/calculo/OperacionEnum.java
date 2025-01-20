package es.etg.psp.red.calculadora.logica.calculo;

public enum OperacionEnum {
    
    SUMA("+"), RESTA("-"), MULTIPLICACION("*"), DIVISION("/");

    private final String simbolo;

    private OperacionEnum(final String simbolo){
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return simbolo;
    }

    public boolean equals(String value){
        return simbolo.equals(value);
    }


}
