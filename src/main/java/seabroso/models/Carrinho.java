package seabroso.models;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ItemVenda> compras;
    private User cliente;
    private Double valorTotal;

    public Double calculaTotal(Carrinho cart){
        Double conta= null;
        for (ItemVenda item : compras) {


        }
        return conta;
    }

    // o metodo de adicionar item novo ficou na classe de anuncio
    public void excluirItem(){

    }
    public void limparSelecionados(){

    }
    public static NotaFiscal finalizarCompra(){
        NotaFiscal comprovante= null;
        try{

        }catch (){

        }
        return comprovante;
    }

}
