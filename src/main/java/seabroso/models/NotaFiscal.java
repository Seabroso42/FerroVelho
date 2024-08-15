package seabroso.models;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
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
        this.momento= LocalDateTime.now();
    }


}
