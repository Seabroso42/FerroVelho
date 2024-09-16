package seabroso.Screen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;

@Data
public class ScreenManager {
    private static ScreenManager instance;
    private static Stage janela;

    private Scene mainScene;
    private Scene anuncioScene;
    private Scene cadastroAnuncioScene;
    private Scene cadastroUserScene;
    private Scene carrinhoScene;
    private Scene carteiraVendedorScene;
    private Scene homeScene;
    private Scene painelControleScene;
    private Scene customAlertScene;

    private MainScreenController mainScreenController;
    private AnuncioScreenController anuncioScreenController;
    private CadastroUserScreenController cadastroUserScreenController;
    private CadastroAnuncioScreenController cadastroAnuncioScreenController;
    private CarrinhoScreenController carrinhoScreenController;
    private CarteiraVendedorScreenController carteiraVendedorScreenController;
    private CustomAlertScreenController customAlertScreenController;
    private HomeScreenController homeScreenController;
    private PainelControleScreenController painelControleScreenController;

    public ScreenManager(){
        this.loadScreens();
    }

    private void loadScreens(){
        try{
            FXMLLoader mainPane = new FXMLLoader(getClass().getResource("main.fxml"));
            this.mainScene = new Scene(mainPane.load());
            this.mainScreenController = mainPane.getController();

            FXMLLoader anuncioPane = new FXMLLoader(getClass().getResource("anuncio.fxml"));
            this.anuncioScene = new Scene(anuncioPane.load());
            this.anuncioScreenController = anuncioPane.getController();

            FXMLLoader cadastroAnuncioPane = new FXMLLoader(getClass().getResource("CadastroAuncio.fxml"));
            this.cadastroAnuncioScene = new Scene(cadastroAnuncioPane.load());
            this.cadastroAnuncioScreenController = cadastroAnuncioPane.getController();

            FXMLLoader cadastroUserPane = new FXMLLoader(getClass().getResource("CadastroUser.fxml"));
            this.cadastroUserScene = new Scene(cadastroUserPane.load());
            this.cadastroUserScreenController = cadastroUserPane.getController();

            FXMLLoader carrinhoPane = new FXMLLoader(getClass().getResource("Carrinho.fxml"));
            this.carrinhoScene = new Scene(carrinhoPane.load());
            this.carrinhoScreenController = carrinhoPane.getController();

            FXMLLoader carteiraVendedorPane = new FXMLLoader(getClass().getResource("CarteiraVendedor.fxml"));
            this.carteiraVendedorScene = new Scene(carteiraVendedorPane.load());
            this.carteiraVendedorScreenController = carteiraVendedorPane.getController();

            FXMLLoader customAlertPane = new FXMLLoader(getClass().getResource("CustomAlert.fxml"));
            this.customAlertScene = new Scene(customAlertPane.load());
            this.customAlertScreenController = customAlertPane.getController();

            FXMLLoader homePane = new FXMLLoader(getClass().getResource("home.fxml"));
            this.homeScene = new Scene(homePane.load());
            this.homeScreenController = homePane.getController();

            FXMLLoader painelControlePane = new FXMLLoader(getClass().getResource("PainelControle.fxml"));
            this.painelControleScene = new Scene(mainPane.load());
            this.painelControleScreenController = painelControlePane.getController();


        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public void changeScene(String tela, String titulo){
        switch (tela){
            //case para cada fxml
            case "anuncio.fxml" -> janela.setScene(anuncioScene);
            case "CadastroAnuncio.fxml" -> janela.setScene(cadastroAnuncioScene);
            case "CadastroUser.fxml" -> janela.setScene(cadastroUserScene);
            case "Carrinho.fxml" -> janela.setScene(carrinhoScene);
            case "CarteiraVendedor.fxml" -> janela.setScene(carteiraVendedorScene);
            case "home.fxml" -> janela.setScene(homeScene);
            case "main.fxml" -> janela.setScene(mainScene);
            case "PainelControle.fxml" -> janela.setScene(painelControleScene);

        }
        janela.setTitle(titulo);
    }
}
