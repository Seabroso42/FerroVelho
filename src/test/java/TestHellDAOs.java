import seabroso.connection.database.*;

public class TestHellDAOs {
    private AnuncioDAO anuncioDatabase;
    private NotaFiscalDAO notaFiscalDatabase;
    private OcorrenciaDAO ocorrenciaDatabase;
    private PecaDAO pecaDatabase;
    private UserDAO userDatabase;

    public TestHellDAOs(){
        this.anuncioDatabase= AnuncioDAO.getInstance();
        this.notaFiscalDatabase= NotaFiscalDAO.getInstance();
        this.ocorrenciaDatabase= OcorrenciaDAO.getInstance();
        this.pecaDatabase= PecaDAO.getInstance();
        this.userDatabase= UserDAO.getInstance();
    }
    public static void main(String[] args) {
        //testes com métodos dos DAOS
        System.out.println("-----testes DAOS-----");

        System.out.println("-----CREATE-----");

        System.out.println("-----READ-----");

        System.out.println("-----UPDATE-----");

        System.out.println("-----DELETE-----");
    }

}
