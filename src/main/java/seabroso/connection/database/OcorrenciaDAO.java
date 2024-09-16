package seabroso.connection.database;

import seabroso.models.Ocorrencia;
import seabroso.models.Peca;
import seabroso.models.User;

import java.util.*;


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
        String sql= "INSERT INTO OCORRENCIAS (descricao, destino, remetente, importancia, rankVendedor, tipo, momento, mensagem) VALUES (?,?,?,?,?,?,?,?,?)";

    }
    //READ
    public Set<Ocorrencia> listarOcorrencias(){
        String sql ="SELECT * FROM OCORRENCIAS";

    }
    public Optional<Ocorrencia> buscarOcorrencia(){
        Set<Ocorrencia> data = listarOcorrencias();
        Optional<Ocorrencia> result = Optional.empty();
        try{

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
    //UPDATE
    public void atualizarOcorrencia(Ocorrencia report){
        String sql= "UPDATE OCORRENCIAS SET descricao= ?, destino=?, remetente=?, importancia=?, rankVendedor=?, tipo=?, momento=?, mensagem=?" + "WHERE codigo = ? ";

    }
    //DELETE
    public void deletarOcorrencia(Ocorrencia report){
        String sql= "DELETE FROM OCORRENCIAS WHERE codigo = ?";

    }
}
