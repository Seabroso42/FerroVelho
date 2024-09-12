package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.NotaFiscal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaFiscalDAO {
    private static NotaFiscalDAO instance;
    public static NotaFiscalDAO getInstance() {
        if (instance == null){
            instance = new NotaFiscalDAO();
            return instance;
        }else {
            return instance;
        }
    }
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
