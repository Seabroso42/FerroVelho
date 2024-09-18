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
        TestHellDAOs inferno = new TestHellDAOs();
        //testes com métodos dos DAOS
        /*
        System.out.println("-----testes DAOS-----");
        System.out.println("-----CREATE-----");
        inferno.anuncioDatabase.cadastrarAnuncio();
        inferno.notaFiscalDatabase.salvarNota();
        inferno.ocorrenciaDatabase.cadastrarOcorrencia();
        inferno.pecaDatabase.cadastrarPeca();
        inferno.userDatabase.cadastroUserCliente();
        inferno.userDatabase.cadastroUserVendedor();
        inferno.userDatabase.cadastroUserAdmin();

        System.out.println("-----READ-----");
        inferno.anuncioDatabase.listarAnuncios();
        inferno.notaFiscalDatabase.listarNotasFiscais();
        inferno.ocorrenciaDatabase.listarOcorrencias();
        inferno.pecaDatabase.listarPecas();
        inferno.userDatabase.listaUser();
        System.out.println("-----UPDATE-----");
        inferno.anuncioDatabase.editarAnuncio();
        inferno.notaFiscalDatabase.atualizarNota();
        inferno.ocorrenciaDatabase.atualizarOcorrencia();
        inferno.pecaDatabase.atualizarPeca();
        inferno.userDatabase.atualizaUser();
        System.out.println("-----DELETE-----");
        inferno.anuncioDatabase.deletarAnuncio();
        inferno.notaFiscalDatabase.deletarNotaFiscal();
        inferno.ocorrenciaDatabase.deletarOcorrencia();
        inferno.pecaDatabase.excluirPeca();
        inferno.userDatabase.deletaUser();

         */
    }

}
