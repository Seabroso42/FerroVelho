package seabroso.models;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Peca getProduto() {
        return produto;
    }

    public void setProduto(Peca produto) {
        this.produto = produto;
    }

    public Double getValorConjunto() {
        return valorConjunto;
    }

    public void setValorConjunto(Double valorConjunto) {
        this.valorConjunto = valorConjunto;
    }

}
