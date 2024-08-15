package seabroso.connection.DAO;

import seabroso.connection.DataCon;
import seabroso.enums.UserTypes;
import seabroso.models.Anuncio;
import seabroso.models.CarteiraDigital;
import seabroso.models.NotaFiscal;
import seabroso.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDAO {
    //CREATE
    public void salvarNota(NotaFiscal nota){}
    //READ
    public ArrayList<NotaFiscal> listarNotasFiscais(){
        String sql= "SELECT * FROM NOTAFISCAL";

        ResultSet result= null;
        try{
            ArrayList<NotaFiscal> historico= new ArrayList<>();
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            result= ps.executeQuery();

            while (result.next()){
                NotaFiscal nota= new NotaFiscal();
                nota.setIdNotaFiscal(result.getLong("idnotafiscal"));
                nota.setCliente(result.getLong("cliente"));
                nota.setVendedor(result.getLong("vendedor"));
                nota.setValorTotal(result.getDouble("valortotal"));
                nota.setMomento(result.getTimestamp("momento").toLocalDateTime());
                nota.setConteudo(result.getString("conteudo"));

                historico.add(nota);
            }
            return historico;
        }catch (SQLException | NumberFormatException | NullPointerException e){

        }

    }
    public NotaFiscal buscarNota(){

    }
    //UPDATE
    public void atualizarNota(){

    }
    //DELETE
    public void deletarNotaFiscal(NotaFiscal nota){

    }


}
