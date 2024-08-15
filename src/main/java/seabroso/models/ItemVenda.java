package seabroso.models;

import lombok.Data;

@Data
public class ItemVenda {
    private Integer quantidade;
    private Peca produto;
    private Double valorConjunto;
    private Anuncio anuncio;

    public ItemVenda(Integer quantidade, Peca produto) {
        this.quantidade = quantidade;
        this.produto = produto;
        custoConjunto();
    }
    public void custoConjunto(){
        Double custoProduto= this.produto.getValor();
        Integer multiplicador= this.quantidade;
        Double total= custoProduto * multiplicador;
        setValorConjunto(total);
    }

}
