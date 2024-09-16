package seabroso.exceptions;

public class PecaNotFoundException extends Exception{
    public PecaNotFoundException(){
        super("Peça não encontrada.");
    }
}
