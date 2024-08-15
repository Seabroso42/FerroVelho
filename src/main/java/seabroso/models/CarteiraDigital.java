package seabroso.models;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarteiraDigital {
    private Double saldo;
    private Double debito;
    private User dono;
    private long carteiraId;
    private ArrayList<NotaFiscal> historico;

    public CarteiraDigital(){
        this.saldo= 0.00;
        this.debito= 0.00;
        this.historico= new ArrayList<NotaFiscal>();
    }

    public void depositar(Double valor){

    }
    public void sacar(Double valor){

    }
    public List<NotaFiscal> exibirHistorico(){
        return historico;
    }
}
