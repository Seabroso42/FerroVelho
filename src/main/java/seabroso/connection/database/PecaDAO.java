package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.lang.String.valueOf;

// mysql usa o formato de data "YYYY-MM-DD"
public class PecaDAO {
    private static PecaDAO instance;
    public static PecaDAO getInstance() {
        if (instance == null){
            instance = new PecaDAO();
            return instance;
        }else {
            return instance;
        }
    }
    //CREATE
    public void cadastrarPeca(Peca produto){
        String sql= "INSERT INTO PEÇAS (dono, nome, valor, estado_conserva, tipo, modelo, descriçao, estoque, datafabrica, imageurl) VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps= null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, produto.getDono().getId());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getValor());
            ps.setString(4, valueOf(produto.getEstadoConserva()).toLowerCase());
            ps.setString(5, produto.getTipo());
            ps.setString(6, produto.getModelo());
            ps.setString(7, produto.getModelo() + " " + produto.getFabricante());
            ps.setInt(8, produto.getEstoque());
            ps.setString(9, produto.formatDate());
            ps.setString(10, produto.getImageURL());

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
    public TreeSet<Peca> filtrarPecas(String busca){
        Set<Peca> data = listarPecas();
        TreeSet<Peca> result = new TreeSet<>();
        for (Peca peca : data){
            if (peca.getNome().contains(busca) || peca.getTipo().contains(busca) || peca.getModelo().contains(busca)){
                result.add(peca);
            }
        }
        return result;
    }
    public Optional<Peca> buscarPeca(long id){
        Set<Peca> data = listarPecas();
        Optional<Peca> result = Optional.empty();
        for (Peca peca : data){
            if (peca.getIdPeca() == id){
                result = Optional.of(peca);
            }
        }

        return result;
    }
    //UPDATE
    public void atualizarPeca(Peca peca){
        String sql = "UPDATE PEÇAS SET nome=?, valor=?, estado_conserva=?, tipo=?, modelo=?, descriçao=?, estoque=?, imageurl=?" + "WHERE idpeça = ? ";

        PreparedStatement ps = null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            //dados
            ps.setString(1, peca.getNome());
            ps.setDouble(2, peca.getValor());
            ps.setString(3, valueOf(peca.getEstadoConserva()).toLowerCase());
            ps.setString(4, peca.getTipo());
            ps.setString(5, peca.getModelo());
            ps.setString(6, peca.getModelo() + " " + peca.getFabricante());
            ps.setInt(7, peca.getEstoque());
            ps.setString(8, peca.getImageURL());
            //peça a ser atualizada
            ps.setLong(9, peca.getIdPeca());

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


