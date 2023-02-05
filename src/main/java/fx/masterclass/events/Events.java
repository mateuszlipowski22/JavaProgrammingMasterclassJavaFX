package fx.masterclass.events;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Events extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(fx.masterclass.events.Events.class.getResource("events-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);
        stage.setTitle("Events!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
