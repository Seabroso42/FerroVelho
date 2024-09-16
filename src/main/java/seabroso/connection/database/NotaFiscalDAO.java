package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.NotaFiscal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    public void salvarNota(NotaFiscal nota){
        String sql="INSERT INTO NOTAFISCAL (momento, conteudo, valortotal, vendedor, cliente, enviada) VALUES (?,?,?,?,?,?)";

    }
    //READ
    public Set<NotaFiscal> listarNotasFiscais(){
        String sql= "SELECT * FROM NOTAFISCAL";
        Set<NotaFiscal> database= new HashSet<>();
        ResultSet result= null;
        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            result= ps.executeQuery();

            while (result.next()){
                NotaFiscal nota= new NotaFiscal();
                nota.setIdNotaFiscal(result.getLong("idnotafiscal"));
               // nota.setCliente(result.getLong("cliente"));
               // nota.setVendedor(result.getLong("vendedor"));
                nota.setValorTotal(result.getDouble("valortotal"));
                nota.setMomento(result.getTimestamp("momento").toLocalDateTime());
                nota.setConteudo(result.getString("conteudo"));

                database.add(nota);
            }

        }catch (SQLException | NumberFormatException | NullPointerException e){
            e.printStackTrace();
        }
        return database;
    }
    public Optional<NotaFiscal> buscarNota(){


    }
    //UPDATE
    public void atualizarNota(NotaFiscal nota){
        String sql = "UPDATE NOTAFISCAL SET enviada= ?" + "WHERE idnotafiscal = ? ";

    }
    //DELETE
    public void deletarNotaFiscal(NotaFiscal nota){
        String sql= "DELETE FROM NOTAFISCAL WHERE idnotafiscal = ?";
    }


}
