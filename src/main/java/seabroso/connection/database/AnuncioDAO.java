package seabroso.connection.database;

import seabroso.models.Anuncio;

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

    }
    //READ
    public Set<Anuncio> listarAnuncios(){
        Set<Anuncio> listagem= new HashSet<>();

        return listagem;
    }
    //UPDATE
    public void editarAnuncio(Anuncio anuncio){

    }
    //DELETE
    public void deletarAnuncio(Anuncio anuncio){

    }

    public Optional<Anuncio> buscarAnuncio(){

    }



}
