package seabroso.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Locale;

@Data
public class Carrinho {
    private ArrayList<ItemVenda> compras;
    private User cliente;
    private Double valorTotal;

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
    //TODO ajeitar esse metodo
    //usar stringbuilder pra construir a nota fiscal.
    // chamar o method limparlista no final

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
