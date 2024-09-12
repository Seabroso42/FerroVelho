import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IronOldApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //processador da arquivo em uma tela utilizável
        FXMLLoader fxmlLoader = new FXMLLoader(IronOldApp.class.getResource("tela.fxml"));
        //cena a ser carregada no stage, podendo ter diversas.
        Scene scene = new Scene(fxmlLoader.load(), 360, 720);
        //nome da janela
        stage.setTitle("IronOld");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
