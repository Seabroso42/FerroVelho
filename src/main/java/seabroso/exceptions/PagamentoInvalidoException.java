package seabroso.exceptions;

public class PagamentoInvalidoException extends Exception{
    public PagamentoInvalidoException(){
        super("Pagamento não concluído.");
    }
}
