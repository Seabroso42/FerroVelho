package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.NotaFiscal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
        PreparedStatement ps= null;
        try{
            ps= DataCon.getConexao().prepareStatement(sql);
            String envio= "pendente";
            if(nota.getEnviada()) {
                envio = "enviada";
            }
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(nota.getMomento()));
            ps.setString(2, nota.getConteudo());
            ps.setDouble(3, nota.getValorTotal());
            ps.setLong(4, nota.getVendedor().getId());
            ps.setLong(5, nota.getCliente().getId());

            ps.setString(6, envio);

            ps.execute();
            System.out.println("Nota fiscal cadastrada com sucesso!");
            ps.close();

        }catch (SQLException | NumberFormatException | NullPointerException e){
            e.printStackTrace();
        }

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

                nota.setCliente(UserDAO.getInstance().buscaUsuario(result.getLong("cliente")).orElse(null));
                nota.setVendedor(UserDAO.getInstance().buscaUsuario(result.getLong("vendedor")).orElse(null));
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
    public TreeSet<NotaFiscal> filtrarNotasFiscais(long busca){
        Set<NotaFiscal> data = listarNotasFiscais();
        TreeSet<NotaFiscal> result = new TreeSet<>();
        for (NotaFiscal nota : data){
            if (nota.getCliente().getId() == busca || nota.getVendedor().getId() == busca){
                result.add(nota);
            }
        }
        return result;
    }
    public Optional<NotaFiscal> buscarNota(long identificador){
        Set<NotaFiscal> notas= listarNotasFiscais();
        Optional<NotaFiscal> result= Optional.empty();
        for (NotaFiscal nota : notas){
            if (nota.getIdNotaFiscal() == identificador){
                result= Optional.of(nota);
            }
        }
        return result;
    }
    //UPDATE
    public void atualizarNota(NotaFiscal nota){
        String sql = "UPDATE NOTAFISCAL SET enviada= ?" + "WHERE idnotafiscal = ? ";
        PreparedStatement ps= null;
        try{
            ps= DataCon.getConexao().prepareStatement(sql);
            String envio= "pendente";
            if(nota.getEnviada()) {
                envio = "enviada";
            }
            ps.setString(1, envio);
            ps.setLong(2, nota.getIdNotaFiscal());
            ps.execute();
            System.out.println("Nota fiscal editada com sucesso!");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    //DELETE
    public void deletarNotaFiscal(NotaFiscal nota){
        String sql= "DELETE FROM NOTAFISCAL WHERE idnotafiscal = ?";
        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, nota.getIdNotaFiscal());
            ps.execute();
            System.out.println("Nota fiscal deletada com sucesso!");
            ps.close();
        }catch (SQLException e){
            System.out.println("falha na exclusão." + e.getMessage());
            e.printStackTrace();
        }
    }


}
