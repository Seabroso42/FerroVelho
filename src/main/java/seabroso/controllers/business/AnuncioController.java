package seabroso.controllers.business;

import seabroso.connection.database.AnuncioDAO;
import seabroso.connection.database.PecaDAO;
import seabroso.models.Peca;

public class AnuncioController {
    private static AnuncioController instance;
    private AnuncioDAO anuncioDatabase;
    private PecaDAO pecaDatabase;

    private AnuncioController(){
        this.anuncioDatabase= AnuncioDAO.getInstance();
        this.pecaDatabase= PecaDAO.getInstance();
    }
    public static AnuncioController getInstance(){
        if(instance == null){
            instance = new AnuncioController();
        }
        return instance;
    }

    //metodos dos anuncios
    public void ocultarAnuncio(){

    }
    public void addToCarrinho(){

    }
    public void denunciarAnuncio(){

    }
    //metodos das peças
    public void alterarNome(String nome, Peca peca){

    }
    public void alterarTipo(Peca item, String tipo){

    }
    public void atualizarEstoque(){

    }
    public void alterarEstado(){

    }
    public void alterarDescricao(){

    }
}
