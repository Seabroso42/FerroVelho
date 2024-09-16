package seabroso.exceptions;

public class OcorrenciaNotFoundException extends Exception{
    public OcorrenciaNotFoundException(){
        super("Ocorrencia não encontrada.");
    }
}
