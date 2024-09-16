package seabroso.exceptions;

public class EstoqueInsuficienteException extends Exception{
    public EstoqueInsuficienteException(){
        super("Não há estoque suficiente.");
    }
}
