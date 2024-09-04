package seabroso.connection.database;

import seabroso.models.Ocorrencia;
import seabroso.models.Peca;
import seabroso.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class OcorrenciaDAO {
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
