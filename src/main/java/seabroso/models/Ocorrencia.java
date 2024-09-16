package seabroso.models;

import lombok.Data;
import seabroso.enums.EstadoConserva;
import seabroso.enums.ImportanciaOcorrencia;
import seabroso.enums.TiposNot;
import seabroso.exceptions.OcorrenciaNegligenciadaException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Ocorrencia implements Comparable<Ocorrencia> {
    @Override
    public int compareTo(Ocorrencia o) {
        int pos= this.getImportancia().ordinal();
        int nextpos= o.getImportancia().ordinal();
        if (pos > nextpos){
           return 1;
        } else if (pos < nextpos){
            return -1;
        }else {
            return 0;
        }
    }

    private long codigo;
    private User remetente;
    private String mensagem;
    private TiposNot tipo;
    private ImportanciaOcorrencia importancia;
    private String descricao;
    private User destino;
    private Boolean isResolvida;
    private LocalDateTime momento;


    public Ocorrencia(){
        this.isResolvida= false;
        this.importancia= ImportanciaOcorrencia.NORMAL;
        this.momento= LocalDateTime.now();
    }

    public void updateImportancia(){
        LocalDate dataAtual= LocalDate.now();
        ImportanciaOcorrencia[] importancias= ImportanciaOcorrencia.values();
        int result = dataAtual.getMonthValue() - this.getMomento().getMonthValue();
        int posicaoImp = this.getImportancia().ordinal();
        if (result != 0 && this.getImportancia()!= ImportanciaOcorrencia.PRIORIDADEMAX){
            ImportanciaOcorrencia atualizado = importancias[posicaoImp + 1];
            this.setImportancia(atualizado);
        }else {
            if (result!= 0){
                throw new OcorrenciaNegligenciadaException();
            }
        }
    }
    public String formatDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.getMomento().format(formatter);
    }

}
