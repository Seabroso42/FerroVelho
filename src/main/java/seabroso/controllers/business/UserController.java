package seabroso.controllers.business;

import seabroso.models.Peca;
import seabroso.models.User;

public class UserController {
    private static UserController instance;
    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }

    //métodos clientes
    public void Reclamar(){

    }
    public void comprar(){

    }
    public void cancelarCompra(){

    }
    public void buscarProduto(){

    }
    //metodos de vendedores
    public void notificarEnvio(){

    }
    public void criarAnuncio(){

    }
    public void cadastraPeca(Peca produto, Integer estoque){

    }
    public void editarAnuncio(){

    }
    public void deletarAnuncio(){

    }

    public void reinvidicarOcorrencia(){

    }
    //métodos de administradores
    public void removerUsuario() {
    }

    public void enviarNotif(User destino, String conteudo) {

    }

    public void limparOcorrencia() {

    }

    public void penalizarUsuario() {

    }


    public void bonificarUsuario() {

    }

    public void atualizarCadastro() {

    }
}
