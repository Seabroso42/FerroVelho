package seabroso.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Anuncio {
    private long idAnuncio;
    private UserVendedor dono;
    private Peca produto;
    private String titulo;
    private String descricao;
    private Boolean isAtivo;
    private String cidade;

    public Anuncio(){
    }

    public Anuncio(UserVendedor dono, Peca produto) {
        this.dono = dono;
        this.produto = produto;
        this.isAtivo = true;
    }

    public void ocultarAnuncio(){
        this.setIsAtivo(false);
    }

    public void addCarrinho(UserCliente cliente, int quantidade){
        ArrayList<ItemVenda> cart = cliente.getPedido().getCompras();
        ItemVenda produto = new ItemVenda(quantidade, this.getProduto());
        cart.add(produto);
    }

}
