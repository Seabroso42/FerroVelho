package seabroso.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.ImportanciaOcorrencia;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVendedor extends User{
    private VendorRanks rank;
    private LinkedList<Ocorrencia> problemas;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<Peca> deposito;

    public UserVendedor(){
        super();
        this.setTipo(UserTypes.VENDEDOR);
        this.setRank(VendorRanks.INCONCLUSIVO);
        this.anuncios= new ArrayList<>();
        this.deposito= new ArrayList<>();
        this.problemas= new LinkedList<>();
    }

    public Anuncio criarAnuncio(Peca produto,String titulo){
        Anuncio venda= new Anuncio(this, produto);
        venda.setTitulo(titulo);
        this.anuncios.add(venda);
        return venda;
    }

    public Peca criarPeca(String nome, int estoque){
        Peca produto= new Peca();
        produto.setDono(this);
        produto.setNome(nome);
        produto.setEstoque(estoque);
        this.deposito.add(produto);

        return produto;
    }


    public void solicitaRevisarOcorrencia(Ocorrencia problema, UserAdmin admin , String message){
        StringBuilder builder= new StringBuilder();
        builder.append(message + "/n");
        builder.append("requisição referente à ocorrência: " +  String.valueOf(problema.getCodigo()));
        String request= builder.toString();
        Ocorrencia pedido= new Ocorrencia();
        pedido.setRemetente(this);
        pedido.setDestino(admin);
        pedido.setImportancia(ImportanciaOcorrencia.IMPORTANTE);
        pedido.setDescricao(request);
        pedido.setMensagem("Revisão requisitada por: "+ this.getUsername());

        admin.getNotiLista().add(pedido);
    }


}
