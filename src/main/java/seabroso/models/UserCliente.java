package seabroso.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.UserTypes;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCliente extends User{
    private String endereco;
    private Carrinho pedido;

    public UserCliente(){
        super();
        this.setTipo(UserTypes.CLIENTE);
        this.pedido= new Carrinho();
    }
    public void addCarrinho(Anuncio anuncio, int quantidade){
        ArrayList<ItemVenda> cart = this.getPedido().getCompras();
        ItemVenda produto = new ItemVenda(quantidade, anuncio.getProduto());
        cart.add(produto);
    }
    public void reclamar(UserVendedor culpado, String descricao){
        Ocorrencia reclamacao= new Ocorrencia();
        reclamacao.setDescricao(descricao);
        culpado.getProblemas().add(reclamacao);
    }

}
