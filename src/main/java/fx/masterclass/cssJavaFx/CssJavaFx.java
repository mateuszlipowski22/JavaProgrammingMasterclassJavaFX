package fx.masterclass.cssJavaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CssJavaFx extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(fx.masterclass.cssJavaFx.CssJavaFx.class.getResource("cssJavaFx-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 275);
//        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
