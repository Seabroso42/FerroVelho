package seabroso.connection.database;

import seabroso.models.CarteiraDigital;

import java.util.Optional;

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

    }
    //READ
    public Optional<CarteiraDigital> buscarCarteira(){

    }
    //UPDATE
    public void atualizaSaldo(){

    }
    public void atualizaDebito(){

    }
    //DELETE
    public void excluirCarteira(){

    }
}
