package seabroso.exceptions;

public class AcessoNegadoException extends RuntimeException {
    public AcessoNegadoException() {
        super("Você não tem acesso!");
    }
}
