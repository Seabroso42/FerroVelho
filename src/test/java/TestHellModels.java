import seabroso.enums.EstadoConserva;
import seabroso.enums.UserTypes;
import seabroso.enums.VendorRanks;
import seabroso.models.*;

public class TestHellModels {
    public static void main(String[] args) {
        //testes com métodos dos models
        System.out.println("-----testes models-----");
        //objetos mockados
        UserCliente clienteTest = new UserCliente();
        CarteiraDigital carteiraCliente = clienteTest.getCarteiraDigital();
        carteiraCliente.setSaldo(2600.00);
        UserAdmin adminTest = new UserAdmin();
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

        System.out.println(parafuso);
    }
}