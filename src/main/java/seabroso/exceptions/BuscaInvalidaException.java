package seabroso.exceptions;

public class BuscaInvalidaException extends RuntimeException {
    public BuscaInvalidaException() {
        super(" OPS! Nenhum resultado encontrado.");
    }
}
