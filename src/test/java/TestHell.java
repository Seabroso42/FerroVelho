import seabroso.models.*;

public class TestHell {
    public static void main(String[] args) {
        //objetos mockados
        Peca produto = new Peca();
        UserVendedor sellerTest = new UserVendedor();
        UserCliente clienteTest= new UserCliente();
        UserAdmin adminTest= new UserAdmin();
        Anuncio anuncio = new Anuncio();

        //testes com métodos dos models
        System.out.println("-----testes models-----");
         

        //testes com métodos dos DAOS
        System.out.println("-----testes DAOS-----");

        //testes com métodos dos Controllers
        System.out.println("-----testes controllers-----");

    }
}