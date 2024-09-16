package seabroso.controllers;

import seabroso.controllers.data.*;
import seabroso.models.User;

public class ServerManager {
    private static ServerManager instance;
    private AccessController accessController;
    private UserController userController;
    private CarrinhoController carrinhoController;
    private CarteiraController carteiraController;
    private NotaFiscalController notaFiscalController;

    private ServerManager() {
        accessController = AccessController.getInstance();
        userController = UserController.getInstance();
        carrinhoController = CarrinhoController.getInstance();
        carteiraController = CarteiraController.getInstance();
        notaFiscalController = NotaFiscalController.getInstance();
    }

    public static ServerManager getInstance() {
        if (instance == null) {
            instance = new ServerManager();
        }
        return instance;
    }

    public boolean autorizar(User usuario, String method){

    }


}
