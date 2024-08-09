package seabroso.models;

import java.util.ArrayList;

public class UserVendedor extends User{
    private long sellerId;
    private CarteiraDigital carteira;
    private ArrayList<Ocorrencia> problemas;

    public void criarAnuncio(){

    }

    public void deletarAnuncio(){

    }

    public void atualizarEstoque(Peca produto, int valorNovo){

    }

    public void PedidoEntregue(){

    }
    public void SolicitaRevisarOcorrencia(Ocorrencia problema){

    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public CarteiraDigital getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraDigital carteira) {
        this.carteira = carteira;
    }
}
