package seabroso.controllers;

import seabroso.controllers.business.*;

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

}
