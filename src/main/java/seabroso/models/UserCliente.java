package seabroso.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.UserTypes;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCliente extends User{
    private String endereco;
    private Carrinho pedido;

    public UserCliente(){
        super();
        this.setTipo(UserTypes.CLIENTE);
    }
    public Ocorrencia reclamar(UserVendedor culpado, String descricao){
        Ocorrencia reclamacao= new Ocorrencia();
        reclamacao.setDestino(culpado);
        return reclamacao;
    }

}
