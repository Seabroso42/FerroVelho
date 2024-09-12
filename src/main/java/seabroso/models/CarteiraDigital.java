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

    public static void transferir(Double valor, User remetente, User destino){
        remetente.getCarteiraDigital().sacar(valor);
        destino.getCarteiraDigital().depositar(valor);
    }

    public CarteiraDigital(){
        this.saldo= 0.00;
        this.debito= 0.00;
        this.historico= new ArrayList<NotaFiscal>();
    }

    public void depositar(Double valor){
        Double saldoNovo= this.getSaldo() + valor;
        this.setSaldo(saldoNovo);
    }
    public void sacar(Double valor){
        Double saldoNovo= this.getSaldo() - valor;
        this.setSaldo(saldoNovo);
    }
    public void addHistorico(NotaFiscal recibo){
        ArrayList<NotaFiscal> hist= this.getHistorico();
        hist.add(recibo);
    }

}
