package seabroso.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {
    private long contaDestino;
    private Double saldo;
    private User dono;
    private long carteiraId;
    private ArrayList<NotaFiscal> historico;

    public void depositar(Double valor){

    }
    public void sacar(Double valor){

    }
    public List<NotaFiscal> exibirHistorico(){
        return historico;
    }
}
