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
    public void salvarNota(NotaFiscal nota){}

    public ArrayList<NotaFiscal> listarNotasFiscais(){
        String sql= "SELECT * FROM NOTAFISCAL";

        ResultSet result= null;
        try{
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
            }
        }catch (SQLException | NumberFormatException | NullPointerException e){

        }

    }
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

    public void deletarNotaFiscal(NotaFiscal nota){

    }

    public List<NotaFiscal> listarNotasFiscais(){
        ArrayList<NotaFiscal> listagem= new ArrayList<>();

        return listagem;
    }
}
