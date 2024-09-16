package seabroso.exceptions;

public class OcorrenciaNegligenciadaException extends RuntimeException {
    public OcorrenciaNegligenciadaException() {
        super("Ocorrencia ignorada por tempo demais!");
    }
}
