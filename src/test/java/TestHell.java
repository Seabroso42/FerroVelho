import seabroso.models.*;

public class TestHell {
    public static void main(String[] args) {
        //objetos mockados
        Peca produto = new Peca();
        CarteiraDigital carteiraTeste= new CarteiraDigital();
        UserVendedor sellerTest = new UserVendedor();
        UserCliente clienteTest= new UserCliente();
        UserAdmin adminTest= new UserAdmin();
        Anuncio anuncio = new Anuncio();
        NotaFiscal recibo = new NotaFiscal();
        Ocorrencia ocorrencia= new Ocorrencia();

        //testes com métodos dos models
        System.out.println("-----testes models-----");
        anuncio.ocultarAnuncio();
        anuncio.addCarrinho();
        carteiraTeste.depositar();
        carteiraTeste.sacar();
        carteiraTeste.addHistorico();
        recibo.marcarEnvio();
        recibo.formatDate();
        ocorrencia.updateImportancia();
        produto.updateConserva();
        produto.reporEstoque();
        produto.reduzirEstoque();
        produto.formatDate();
        adminTest.concluiOcorrencia();
        adminTest.AlteraRankVendedor();
        adminTest.penalizaVendedor();
        adminTest.multaUser();
        clienteTest.reclamar();
        sellerTest.criarAnuncio();
        sellerTest.solicitaRevisarOcorrencia();


        //testes com métodos dos DAOS
        System.out.println("-----testes DAOS-----");
        //DAOS mockados-
        
        System.out.println("-----CREATE-----");

        System.out.println("-----READ-----");

        System.out.println("-----UPDATE-----");

        System.out.println("-----DELETE-----");



        //testes com métodos dos Controllers
        System.out.println("-----testes controllers-----");

    }
}