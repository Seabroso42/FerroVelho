package seabroso.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Locale;

@Data
public class Carrinho {
    private ArrayList<ItemVenda> compras;
    private User cliente;
    private Double valorTotal;

    public Double calculaTotal(){
       Double valorFinal = null;
        for (ItemVenda item : this.getCompras()) {
            double valor = item.getProduto().getValor();
            double valorConjunto= item.getQuantidade() * valor;
            valorFinal += valorConjunto;

        }
        return valorFinal;
    }

    // o metodo de adicionar item novo ficou na classe de anuncio
    public void excluirItem(){

    }
    public void limparSelecionados(){
        ArrayList<ItemVenda> compras = this.getCompras();
        compras.clear();

    }
    //usar stringbuilder pra construir a nota fiscal.
    public NotaFiscal finalizarCompra(){
        NotaFiscal comprovante= new NotaFiscal();
        Double custo= null;
        StringBuilder builder= new StringBuilder();
        for (ItemVenda item : this.getCompras()){
            double gasto= item.getProduto().getValor() * item.getQuantidade();
            custo += gasto;
            String labelProduto= String.valueOf((item.getQuantidade())) + item.getProduto().getNome().toUpperCase(Locale.ROOT);
            builder.append("-" + labelProduto + String.valueOf(item.getProduto().getValor()) + "/n");

        }
        String conteudo= builder.toString();
        comprovante.setValorTotal(custo);
        comprovante.setConteudo(conteudo);
        return comprovante;
    }

}
