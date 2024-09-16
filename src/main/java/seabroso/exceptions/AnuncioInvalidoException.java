package seabroso.exceptions;

public class AnuncioInvalidoException extends Exception{
    public AnuncioInvalidoException(){
        super("Esse Anúncio não está em conformidade com o padrão!");
    }
}
