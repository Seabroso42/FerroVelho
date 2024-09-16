package seabroso.connection.database;

import seabroso.connection.DataCon;
import seabroso.models.CarteiraDigital;
import seabroso.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CarteiraDigitalDAO {
    private static CarteiraDigitalDAO instance;
    public static CarteiraDigitalDAO getInstance() {
        if (instance == null){
            instance = new CarteiraDigitalDAO();
            return instance;
        }else {
            return instance;
        }
    }
    //CREATE
    public void salvarCarteira(CarteiraDigital carteiraDigital){
        String sql= "INSERT INTO CARTEIRAS (iduser, saldo, debito) VALUES (?,?,?)";
        PreparedStatement ps= null;
        try {
            ps= DataCon.getConexao().prepareStatement(sql);
            ps.setLong(1, carteiraDigital.getDono().getId());
            ps.setDouble(2, carteiraDigital.getSaldo());
            ps.setDouble(3, carteiraDigital.getDebito());
            ps.execute();
            System.out.println("Carteira cadastrada com sucesso!");
            ps.close();

        }catch(SQLException e) {
            System.out.println("falha no cadastro." + e.getMessage());
            e.printStackTrace();
        }
    }
    //READ
    public static Set<CarteiraDigital> listarCarteiras(){
        String sql= "SELECT * FROM CARTEIRAS";
        ResultSet busca= null;
        Set<CarteiraDigital> listagem= new HashSet<>();
        try {
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            busca= ps.executeQuery();
            while (busca.next()){
                CarteiraDigital carteira= new CarteiraDigital();
                carteira.setCarteiraId(busca.getLong("idcarteira"));
                User dono= UserDAO.getInstance().buscaUsuario(busca.getLong("iduser")).orElse(null);
                carteira.setDono(dono);
                carteira.setSaldo(busca.getDouble("saldo"));
                carteira.setDebito(busca.getDouble("debito"));
                listagem.add(carteira);
            }
            ps.close();
        }catch(SQLException e) {
            System.out.println("falha na busca." + e.getMessage());
            e.printStackTrace();
        }
            return listagem;
    }
    public Optional<CarteiraDigital> buscarCarteira(User usuario){
        Set<CarteiraDigital> listagem= listarCarteiras();
        Optional<CarteiraDigital> result= Optional.empty();
        for (CarteiraDigital carteira: listagem){
            if (carteira.getDono().equals(usuario)){
                result= Optional.of(carteira);
            }
        }
        return result;

    }
    //UPDATE
    public void atualizaSaldo(CarteiraDigital carteira){
        String sql="UPDATE CARTEIRAS SET saldo= ?, debito=?" + "WHERE iduser = ?";
        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.setDouble(1, carteira.getSaldo());
            ps.setDouble(2, carteira.getDebito());
            ps.setLong(3, carteira.getDono().getId());
            ps.execute();
            System.out.println("Atualização realizada com sucesso!");
            ps.close();

        }catch (SQLException e){
            System.out.println("falha na atualização." + e.getMessage());
            e.printStackTrace();
        }
    }

    //DELETE
    public void excluirCarteira(){
        String sql="DELETE FROM CARTEIRAS WHERE idcarteira = ?";
        try{
            PreparedStatement ps= DataCon.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Carteira excluida com sucesso!");
            ps.close();
        }catch (SQLException e){
            System.out.println("falha na exclusão." + e.getMessage());
            e.printStackTrace();
        }
    }
}
