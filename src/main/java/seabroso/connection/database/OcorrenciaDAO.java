package seabroso.connection.database;

import seabroso.models.Ocorrencia;
import seabroso.models.Peca;
import seabroso.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class OcorrenciaDAO {
    private static OcorrenciaDAO instance;
    public static OcorrenciaDAO getInstance() {
        if (instance == null){
            instance = new OcorrenciaDAO();
            return instance;
        }else {
            return instance;
        }
    }
    //CREATE
    public void cadastrarOcorrencia(Ocorrencia problema){

    }
    //READ
    public Set<Ocorrencia> listarOcorrencias(){

    }
    public ArrayList<Ocorrencia> buscarOcorrencia(){
        Set<Ocorrencia> data = listarOcorrencias();
        ArrayList<Ocorrencia> result = null;

        return result;
    }
    //UPDATE
    public void atualizarOcorrencia(Ocorrencia report){

    }
    //DELETE
    public void deletarOcorrencia(Ocorrencia report){

    }
}
