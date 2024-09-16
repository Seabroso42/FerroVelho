package seabroso.exceptions;

public class FormatoInvalidoException extends Exception{
    public FormatoInvalidoException(String campo){
        super("insira o dado correto no " + campo +" por favor." );
    }
}
