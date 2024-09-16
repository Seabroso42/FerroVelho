package seabroso.controllers.data;

import seabroso.connection.database.NotaFiscalDAO;

public class NotaFiscalController {
    private static NotaFiscalController instance;
    private NotaFiscalDAO notaFiscalDatabase;

    private NotaFiscalController(){
        this.notaFiscalDatabase= NotaFiscalDAO.getInstance();
    }

    public static NotaFiscalController getInstance(){
        if(instance == null){
            instance = new NotaFiscalController();
        }
        return instance;
    }

    public void confirmarEnvio(){

    }

}
