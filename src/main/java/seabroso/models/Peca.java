package seabroso.models;

import lombok.Data;
import seabroso.enums.EstadoConserva;
import seabroso.enums.TiposPeca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
public class Peca {
    private long idPeca;
    private Double valor;
    private String nome;
    private String fabricante;
    private String modelo;
    private LocalDate dataFabricacao;
    private EstadoConserva estadoConserva;
    private TiposPeca tipo;
    private int estoque;

    public Peca(){}

    public Peca(long idPeca, String nome, String fabricante, String modelo, int estoque) {
        this.idPeca = idPeca;
        this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.estoque = estoque;
    }

    public void updateConserva(){
        LocalDate dataAtual= LocalDate.now();
        EstadoConserva[] estados= EstadoConserva.values();
        int result = dataAtual.getYear() - this.getDataFabricacao().getYear();
        if (result != 0 && result <= 7){
            EstadoConserva atualizado = estados[7 - result];
            this.setEstadoConserva(atualizado);
        }
    }

    public void reduzirEstoque(int quantidade){
        int update = this.getEstoque() - quantidade;
        this.setEstoque(update);
    }
    public void reporEstoque(int quantidade){
        int update = this.getEstoque() + quantidade;
        this.setEstoque(update);
    }

    public String formatDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.getDataFabricacao().format(formatter);
    }

}


