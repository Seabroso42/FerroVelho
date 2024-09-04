package seabroso.models;

import lombok.Data;

@Data
public class ItemVenda {
    private Integer quantidade;
    private Peca produto;
    private Anuncio anuncio;

    public ItemVenda(Integer quantidade, Peca produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }


}
