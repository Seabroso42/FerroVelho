package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.enums.ImportanciaOcorrencia;
import seabroso.enums.TiposNot;
import seabroso.models.Ocorrencia;
import seabroso.models.Peca;
import seabroso.models.User;
import seabroso.models.UserVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.lang.String.valueOf;


public class OcorrenciaDAO{
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
        ResultSet busca= null;
        Set<Ocorrencia> listagem= new HashSet<>();
        try {
            PreparedStatement ps = DataCon.getConexao().prepareStatement(sql);
            busca = ps.executeQuery();
            while (busca.next()) {
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setCodigo(busca.getLong("codigo"));
                ocorrencia.setDescricao(busca.getString("descricao"));
                User destino = UserDAO.getInstance().buscaUsuario(busca.getLong("destino")).orElse(null);
                ocorrencia.setDestino(destino);
                User remetente = UserDAO.getInstance().buscaUsuario(busca.getLong("remetente")).orElse(null);
                ocorrencia.setRemetente(remetente);
                ocorrencia.setImportancia(ImportanciaOcorrencia.valueOf(busca.getString("importancia").toUpperCase()));
                ocorrencia.setTipo(TiposNot.valueOf(busca.getString("tipo").toUpperCase()));
                ocorrencia.setMomento(busca.getTimestamp("momento").toLocalDateTime());
                ocorrencia.setMensagem(busca.getString("mensagem"));
                listagem.add(ocorrencia);
            }
        }catch (SQLException e){
                System.out.println("falha na listagem." + e.getMessage());
                e.printStackTrace();
        }
        return listagem;
    }


    public TreeSet<Ocorrencia> filtrarOcorrencias(User user){
        Set<Ocorrencia> data = listarOcorrencias();
        TreeSet<Ocorrencia> result = new TreeSet<>();
        long id = user.getId();
        for (Ocorrencia ocorrencia : data){
            if (ocorrencia.getDestino().getId() == id || ocorrencia.getRemetente().getId() == id){
                result.add(ocorrencia);
            }
        }
        return result;
    }

    public Optional<Ocorrencia> buscarOcorrencia(long codigo){
        Set<Ocorrencia> data = listarOcorrencias();
        Optional<Ocorrencia> result = Optional.empty();
        for (Ocorrencia ocorrencia : data){
            if (ocorrencia.getCodigo() == codigo){
                result = Optional.of(ocorrencia);
            }
        }

        return result;
    }
    //UPDATE
    public void atualizarOcorrencia(Ocorrencia report){
        String sql= "UPDATE OCORRENCIAS SET descricao= ?, destino=?, remetente=?, importancia=?, rankVendedor=?, tipo=?, momento=?, mensagem=?" + "WHERE codigo = ? ";
        PreparedStatement ps= null;
        try {
            ps = DataCon.getConexao().prepareStatement(sql);
            ps.setString(1, report.getDescricao());
            ps.setLong(2, report.getDestino().getId());
            ps.setLong(3, report.getRemetente().getId());
            ps.setString(4, valueOf(report.getImportancia()));
            UserVendedor vendedor = (UserVendedor) report.getDestino();
            ps.setString(5, valueOf(vendedor.getRank()).toLowerCase());
            ps.setString(6, valueOf(report.getTipo()));
            ps.setString(7, report.formatDate());
            ps.setString(8, report.getMensagem());

            //ocorrencia a ser atualizada
            ps.setLong(9, report.getCodigo());
            ps.execute();
            System.out.println("Ocorrencia atualizada com sucesso!");
            ps.close();
        }catch (SQLException e) {
            System.out.println("falha na atualização." + e.getMessage());
            e.printStackTrace();
        }

    }
    //DELETE
    public void deletarOcorrencia(Ocorrencia report){
        String sql= "DELETE FROM OCORRENCIAS WHERE codigo = ?";
        try {
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, report.getCodigo());
            ps.execute();
            System.out.println("Ocorrencia deletada com sucesso!");
            ps.close();
        }catch (SQLException e){
            System.out.println("falha na exclusão." + e.getMessage());
            e.printStackTrace();
        }
    }
}
