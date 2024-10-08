package seabroso.models;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
public class NotaFiscal {

    private long idNotaFiscal;
    private LocalDateTime momento;
    private String conteudo;
    private Double valorTotal;
    private User vendedor;
    private User cliente;
    private Boolean enviada;


    public NotaFiscal(){
        this.setEnviada(false);
        this.momento= LocalDateTime.now();
    }

    public void marcarEnvio(){
        this.setEnviada(true);
    }
    public String formatDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.getMomento().format(formatter);
    }

}
