package seabroso.models;

import lombok.Data;

@Data
public class Anuncio {
    private long idAnuncio;
    private User dono;
    private Peca produto;
    private String titulo;
    private String descricao;
    private Boolean isAtivo;
    private String cidade;

    public Anuncio(long idAnuncio, User dono, Peca produto, String titulo, String descricao, Boolean isAtivo, String cidade) {
        this.idAnuncio = idAnuncio;
        this.dono = dono;
        this.produto = produto;
        this.titulo = titulo;
        this.descricao = descricao;
        this.isAtivo = isAtivo;
        this.cidade = cidade;
    }

    public static void main(String[] args) {

    }

    public void addCarrinho(){

    }

}
