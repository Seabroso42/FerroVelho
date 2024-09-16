package seabroso.connection.database;

import seabroso.models.CarteiraDigital;
import seabroso.models.User;

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
    public void salvarCarteira(){
        String sql= "INSERT INTO CARTEIRAS (iduser, saldo, debito) VALUES (?,?,?)";

    }
    //READ
    public static Set<CarteiraDigital> listarCarteiras(){
        String sql= "SELECT * FROM CARTEIRAS";
    }
    public Optional<CarteiraDigital> buscarCarteira(User usuario){

    }
    //UPDATE
    public void atualizaSaldo(){
        String sql="UPDATE CARTEIRAS SET saldo= ?, debito=?" + "WHERE iduser = ?";
    }

    //DELETE
    public void excluirCarteira(){
        String sql="DELETE FROM CARTEIRAS WHERE idcarteira = ?";
    }
}
