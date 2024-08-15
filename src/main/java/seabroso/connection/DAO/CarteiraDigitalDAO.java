package seabroso.connection.DAO;

import seabroso.connection.DataCon;
import seabroso.enums.UserTypes;
import seabroso.models.CarteiraDigital;
import seabroso.models.NotaFiscal;
import seabroso.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarteiraDigitalDAO {
    public void atualizaHistorico(CarteiraDigital carteira){
        User dono= carteira.getDono();
        ResultSet result= null;
        try{
            ArrayList<NotaFiscal> historico= new ArrayList<>();
            if (dono.getTipo() == UserTypes.VENDEDOR){
                String sql= "SELECT * FROM NOTAFISCAL WHERE vendedor= ? ";
                PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
                ps.setLong(1, dono.getId());
                result= ps.executeQuery();

            }else{
                String sql= "SELECT * FROM NOTAFISCAL WHERE cliente= ? ";
                PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
                ps.setLong(1, dono.getId());
                result= ps.executeQuery();
            }
            while (result.next()){
                NotaFiscal nota= new NotaFiscal();
                nota.setIdNotaFiscal();
                nota.setCliente();
                nota.setVendedor();
                nota.setValorTotal();
                nota.setMomento();
                nota.setConteudo();
            }
            carteira.setHistorico(historico);

        }catch (SQLException e){

        }



    }
    public void salvaCarteira(){

    }
    public void atualizaSaldo(){

    }
    public void atualizaDebito(){

    }

}
