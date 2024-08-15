package seabroso.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVendedor extends User{
    private VendorRanks rank;
    private ArrayList<Ocorrencia> problemas;

    public UserVendedor(){
        super();
        this.setTipo(UserTypes.VENDEDOR);
        this.setRank(VendorRanks.INCONCLUSIVO);
    }

    public void criarAnuncio(){

    }

    public void deletarAnuncio(){

    }

    public void atualizarEstoque(Peca produto, int valorNovo){

    }

    public void PedidoEntregue(){

    }
    public void SolicitaRevisarOcorrencia(Ocorrencia problema){

    }


}
