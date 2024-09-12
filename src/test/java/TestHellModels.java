import seabroso.enums.EstadoConserva;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;
import seabroso.models.*;

public class TestHellModels {
    public static void main(String[] args) {
        //testes com métodos dos models
        System.out.println("-----testes models-----");
        //objetos mockados
        UserCliente clienteTest= new UserCliente();
        CarteiraDigital carteiraCliente = clienteTest.getCarteiraDigital();
        carteiraCliente.setSaldo(2600.00);
        UserAdmin adminTest= new UserAdmin();
        adminTest.setNome("Jerry");
        UserVendedor sellerTest = new UserVendedor();
        sellerTest.setNome("Oswaldo");
        UserVendedor outerSeller = new UserVendedor();
        outerSeller.setNome("Kaik");

        Peca parafuso = sellerTest.criarPeca("parafuso cromado", 400);
        parafuso.setFabricante("tramontina");
        parafuso.setValor(1.50);
        parafuso.setModelo("estrelado");
        parafuso.setEstadoConserva(EstadoConserva.FABRICA);
        parafuso.setTipo("ferragem");

        System.out.println(parafuso.toString());

        Peca porca = outerSeller.criarPeca("porca enferrujada", 5000);
        porca.setFabricante("josué do morro");
        porca.setValor(0.25);
        porca.setModelo("3mm");
        porca.setEstadoConserva(EstadoConserva.MAUESTADO);
        porca.setTipo("ferragem");

        System.out.println(porca.toString());

        Anuncio porcaAnuncio= outerSeller.criarAnuncio(porca, "porcas baratas!");

        Anuncio anuncio= sellerTest.criarAnuncio(parafuso, "Parafuso Tramontina");

        clienteTest.addCarrinho(anuncio, 100);
        System.out.println("O estado do anúncio é:" + anuncio.getIsAtivo());
        anuncio.ocultarAnuncio();
        System.out.println("O estado do anúncio é:" + anuncio.getIsAtivo());

        System.out.println("o pior anúncio apareceu: " + porcaAnuncio.getIsAtivo());
        clienteTest.addCarrinho(porcaAnuncio, 200);

        NotaFiscal recibo = clienteTest.getPedido().finalizarCompra();
        System.out.println(recibo.toString());
        System.out.println(recibo.formatDate());

        clienteTest.reclamar(outerSeller, "as porcas estavam horríveis.");

        Ocorrencia problema= outerSeller.getProblemas().getFirst();

        outerSeller.solicitaRevisarOcorrencia(problema, adminTest, "reclamação indevida pois o cliente foi avisado com antecedência.");

        System.out.println("o problema foi resolvido: " + problema.getIsResolvida());

        System.out.println(outerSeller.getRank());
        adminTest.AlteraRankVendedor(VendorRanks.BOM, outerSeller);
        System.out.println(outerSeller.getRank());

        System.out.println(sellerTest.getRank());
        adminTest.penalizaVendedor(sellerTest);
        System.out.println(sellerTest.getRank());

        adminTest.multaUser(clienteTest, 300.00);

        adminTest.concluiOcorrencia(problema);
        System.out.println("o problema foi resolvido: " + problema.getIsResolvida());
    }
}