package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
// mysql usa o formato de data "YYYY-MM-DD"
public class PecaDAO {
    //CREATE
    public void cadastrarPeca(Peca produto){
        String sql= "INSERT INTO  () VALUES ()";
        PreparedStatement ps= null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setString();
            ps.setLong();

            ps.execute();
            System.out.println("sucesso!");
            ps.close();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }

    }

    //READ
    public Set<Peca> listarPecas(){
        String sql = "SELECT * FROM PEÇAS";
        ResultSet busca= null;
        Set<Peca> listagem= null;
        try {
            PreparedStatement ps = Objects.requireNonNull(DataCon.getConexao().prepareStatement(sql));
            busca = ps.executeQuery();
            while (busca.next()){

            }

        }catch (NullPointerException | SQLException | NumberFormatException e){
            System.out.println("erro na conversão de dados na listagem. -" + e.getMessage());
            e.printStackTrace();
        }
        return listagem;
    }
    public ArrayList<Peca> buscarPeca(String filtro){
        Set<Peca> data = listarPecas();
        ArrayList<Peca> result = null;

        return result;
    }
    //UPDATE
    public void atualizarPeca(Peca peca){
        String sql = "UPDATE PEÇAS SET nome= ?" + "WHERE idpeca = ? ";
        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            //dados
            ps.setString(1, String.valueOf());

            //usuario a ser atualizado
            ps.setLong(2, peca.getIdPeca());

            ps.execute();

        }catch(SQLException | NullPointerException | NumberFormatException e) {
            System.out.println("procedimento abortado." + e.getMessage());
            e.printStackTrace();
        }
    }

    //DELETE
    public void excluirPeca(Peca produto) {
        String sql = "DELETE FROM PEÇAS WHERE idpeca = ?";
        PreparedStatement ps = null;
        try {
            ps = DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, produto.getIdPeca());
            ps.execute();
            System.out.println("removido permanentemente.");

        } catch (SQLException | NullPointerException e) {
            System.out.println("não deletado.");
            e.printStackTrace();
        }
    }
}


