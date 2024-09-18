package seabroso.controllers.data;

import seabroso.connection.database.NotaFiscalDAO;

public class CarrinhoController {
    private static CarrinhoController instance;
    private NotaFiscalDAO notaFiscalDatabase;
    private CarrinhoController(){
        this.notaFiscalDatabase= NotaFiscalDAO.getInstance();
    }

    public static CarrinhoController getInstance(){
        if(instance == null){
            instance = new CarrinhoController();
        }
        return instance;
    }
    public void finalizarCompra(){

    }
    public void removerItem(){

    }
    public void aplicarCupom(){

    }
    public void limparCarrinho(){

    }

}
