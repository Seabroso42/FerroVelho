package seabroso.controllers.business;

public class CarrinhoController {
    private static CarrinhoController instance;

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
