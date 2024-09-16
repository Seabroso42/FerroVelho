package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.enums.EstadoConserva;
import seabroso.models.Anuncio;
import seabroso.models.Peca;
import seabroso.models.User;
import seabroso.models.UserVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AnuncioDAO {
    private static AnuncioDAO instance;

    public static AnuncioDAO getInstance() {
        if (instance == null){
            instance = new AnuncioDAO();
            return instance;
        }else {
            return instance;
        }
    }
    //CREATE
    public void cadastrarAnuncio(Anuncio anuncio){
        String sql= "INSERT INTO ANUNCIOS (donocod, idpeça, descriçao, cidade) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, anuncio.getDono().getId());
            ps.setLong(2, anuncio.getProduto().getIdPeca());
            ps.setString(3, anuncio.getDescricao());
            ps.setString(4, anuncio.getCidade());
            ps.execute();
            ps.close();
            System.out.println("Anuncio cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //READ
    public Set<Anuncio> listarAnuncios(){
        Set<Anuncio> listagem= new HashSet<>();
        ResultSet busca= null;
        String sql= "SELECT * FROM anuncio";
        try {
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            busca= ps.executeQuery();
            while (busca.next()){
                Anuncio anuncio= new Anuncio();
                anuncio.setIdAnuncio(busca.getLong("idanuncio"));
                User dono = UserDAO.getInstance().buscaUsuario(busca.getLong("donocod")).orElse(null);
                anuncio.setDono((UserVendedor) dono);
                Peca produto=PecaDAO.getInstance().buscarPeca(busca.getLong("idpeça")).orElse(null);
                anuncio.setProduto(produto);
                anuncio.setDescricao(busca.getString("descricao"));
                anuncio.setCidade(busca.getString("cidade"));
                listagem.add(anuncio);
            }
            ps.close();
            busca.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listagem;
    }
    //UPDATE
    public void editarAnuncio(Anuncio anuncio){
        String sql ="UPDATE ANUNCIOS SET descricao= ?, cidade=?, idpeça=?" + "WHERE idanuncio = ? ";


        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.setString(1, anuncio.getDescricao());
            ps.setString(2, anuncio.getCidade());
            ps.setLong(3, anuncio.getProduto().getIdPeca());
            //anuncio a ser editado
            ps.setLong(4, anuncio.getIdAnuncio());
            ps.execute();
            ps.close();
            System.out.println("Anuncio editado com sucesso!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    //DELETE
    public void deletarAnuncio(Anuncio anuncio){
        String sql ="DELETE FROM ANUNCIOS WHERE idanuncio = ?";
        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, anuncio.getIdAnuncio());

            ps.execute();
            ps.close();
            System.out.println("Anuncio deletado com sucesso!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public TreeSet<Anuncio> buscarAnuncioTitulo(String title){
        Set<Anuncio> pesquisa= listarAnuncios();
        TreeSet<Anuncio> resultado= new TreeSet<>();
        for(Anuncio anuncio: pesquisa){
            if(anuncio.getTitulo().contains(title)){
                resultado.add(anuncio);
            }
        }
        return resultado;

    }
    public TreeSet<Anuncio> buscarAnuncioTipo(String busca){
        Set<Anuncio> pesquisa= listarAnuncios();
        TreeSet<Anuncio> resultado= new TreeSet<>();
        for(Anuncio anuncio: pesquisa){
            if(anuncio.getProduto().getTipo().contains(busca) || anuncio.getProduto().getModelo().contains(busca)){
                resultado.add(anuncio);
            }
        }
        return resultado;

    }
    public TreeSet<Anuncio> buscarAnuncioConserva(EstadoConserva estado){
        Set<Anuncio> pesquisa= listarAnuncios();
        TreeSet<Anuncio> resultado= new TreeSet<>();
        for(Anuncio anuncio: pesquisa){
            if(anuncio.getProduto().getEstadoConserva().equals(estado)){
                resultado.add(anuncio);
            }
        }
        return resultado;

    }



}
