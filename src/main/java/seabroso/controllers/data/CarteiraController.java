package seabroso.controllers.data;

import seabroso.connection.DataCon;
import seabroso.connection.database.CarteiraDigitalDAO;
import seabroso.connection.database.NotaFiscalDAO;
import seabroso.enums.UserTypes;
import seabroso.models.CarteiraDigital;
import seabroso.models.NotaFiscal;
import seabroso.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarteiraController {
    private static CarteiraController instance;
    private CarteiraDigitalDAO carteiraDatabase;
    private NotaFiscalDAO notaFiscalDatabase;

    private CarteiraController(){
        this.notaFiscalDatabase= NotaFiscalDAO.getInstance();
        this.carteiraDatabase= CarteiraDigitalDAO.getInstance();
    }

    public static CarteiraController getInstance() {
        if (instance == null) {
            instance = new CarteiraController();
        }
        return instance;
    }

    public void sacarComissao(){

    }
    public void quitarDebito(){

    }
    public void confirmarEnvioProduto(){

    }

}
