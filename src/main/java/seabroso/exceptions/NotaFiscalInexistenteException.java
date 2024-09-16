package seabroso.exceptions;

public class NotaFiscalInexistenteException extends Exception{
    public NotaFiscalInexistenteException(){
        super("Nota Fiscal não encontrada.");
    }
}
