package seabroso.models;

import lombok.Data;

@Data
public class ItemVenda implements Comparable<ItemVenda> {
    @Override
    public int compareTo(ItemVenda o) {
        if (this.getProduto().getValor() * this.getQuantidade() > o.getProduto().getValor() * o.getQuantidade()){
            return 1;
        }else if (this.getProduto().getValor() * this.getQuantidade() < o.getProduto().getValor() * o.getQuantidade()){
            return -1;
        }else{
            return 0;
        }
    }

    private Integer quantidade;
    private Peca produto;
    private Double valorConjunto;


    public ItemVenda(Integer quantidade, Peca produto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.valorConjunto = produto.getValor() * quantidade;
    }


}
