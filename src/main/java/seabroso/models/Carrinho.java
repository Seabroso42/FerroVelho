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

    // o metodo de adicionar item novo ficou na classe de Cliente

    public void excluirItem(int pos){
        ArrayList<ItemVenda> compras = this.getCompras();
        compras.remove(pos);
    }
    public void limparSelecionados(){
        ArrayList<ItemVenda> compras = this.getCompras();
        if (!compras.isEmpty()){
            compras.clear();
        }
    }
    //usar stringbuilder pra construir a nota fiscal.
    public NotaFiscal finalizarCompra(){
        NotaFiscal comprovante= new NotaFiscal();
        Double custo= 0.00;
        StringBuilder builder= new StringBuilder();
        for (ItemVenda item : this.getCompras()){

            double gasto= item.getProduto().getValor() * item.getQuantidade();

            String labelProduto= String.valueOf((item.getQuantidade())) + item.getProduto().getNome().toUpperCase(Locale.ROOT);

            CarteiraDigital.transferir(gasto,this.cliente, item.getProduto().getDono());

            NotaFiscal notaVendedor= new NotaFiscal();
            notaVendedor.setConteudo(labelProduto);
            notaVendedor.setValorTotal(gasto);

            item.getProduto().getDono().getCarteiraDigital().addHistorico(notaVendedor);

            custo += gasto;

            builder.append("- " + labelProduto + " " + String.valueOf(item.getProduto().getValor()) + "/n");

        }
        String conteudo= builder.toString();
        comprovante.setValorTotal(custo);
        comprovante.setConteudo(conteudo);
        this.getCliente().getCarteiraDigital().addHistorico(comprovante);
        return comprovante;
    }

}
