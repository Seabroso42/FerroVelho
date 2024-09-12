package seabroso.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;
import seabroso.exceptions.UserTambemAdminException;

import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdmin extends User{

    public UserAdmin(){
        super();
        this.setTipo(UserTypes.ADMIN);
        this.setCarteiraDigital(null);
    }
    public void concluiOcorrencia(Ocorrencia ocorrencia){
        ocorrencia.setIsResolvida(true);
        this.getNotiLista().remove(ocorrencia);
    }
    public void enviaNoti(User destino, Ocorrencia noti){
        LinkedList<Ocorrencia> mailBox= destino.getNotiLista();
        mailBox.add(noti);
    }
    public void AlteraRankVendedor(VendorRanks rank, UserVendedor vendedor){
        vendedor.setRank(rank);
    }
    public void penalizaVendedor(UserVendedor seller){
        VendorRanks[] rankeador= VendorRanks.values();
        int pos = seller.getRank().ordinal();
        seller.setRank(rankeador[pos-1]);

    }
    public void multaUser(User usuario, Double multa){
        UserTypes tipo= usuario.getTipo();
        if (tipo != UserTypes.ADMIN){
            CarteiraDigital bolso = usuario.getCarteiraDigital();
            bolso.setDebito(multa);
        }else{
            throw new UserTambemAdminException("esse usuário está no mesmo patamar que você.");
        }

    }

}
