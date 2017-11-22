
package paz1c.projekt.turistickaDatabaza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TuristickaDatabazaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       LoginSceneController controller = new LoginSceneController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
        loader.setController(controller);
        
        Parent parentPane = loader.load();
        Scene scene = new Scene(parentPane);
        
        stage.setScene(scene);
        stage.setTitle("Turistická databáza");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
