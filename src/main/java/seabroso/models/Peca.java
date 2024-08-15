package seabroso.models;

import lombok.Data;

@Data
public class Peca {
    private long idPeca;
    private Double valor;
    private String nome;
    private String fabricante;
    //private tipo ENUM
    private String modelo;
    //private estado de conserva enum
    private int estoque;

    public Peca(long idPeca, String nome, String fabricante, String modelo, int estoque) {
        this.idPeca = idPeca;
        this.nome = nome;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.estoque = estoque;
    }


}
