package seabroso.exceptions;

public class PedidoJaEnviadoException extends RuntimeException {
    public PedidoJaEnviadoException() {
        super("esse pedido já foi enviado.");
    }
}
