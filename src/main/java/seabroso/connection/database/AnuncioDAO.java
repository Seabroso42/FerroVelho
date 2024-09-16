package seabroso.connection.database;

import seabroso.models.Anuncio;

import java.sql.ResultSet;
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

    }
    //READ
    public Set<Anuncio> listarAnuncios(){
        Set<Anuncio> listagem= new HashSet<>();
        ResultSet busca= null;
        String sql= "SELECT * FROM anuncio";

        return listagem;
    }
    //UPDATE
    public void editarAnuncio(Anuncio anuncio){
        String sql ="UPDATE ANUNCIOS SET descricao= ?, cidade=?, idpeça=?" + "WHERE idanuncio = ? ";

    }
    //DELETE
    public void deletarAnuncio(Anuncio anuncio){
        String sql ="DELETE FROM ANUNCIOS WHERE idanuncio = ?";

    }

    public Optional<Anuncio> buscarAnuncio(){


    }



}
