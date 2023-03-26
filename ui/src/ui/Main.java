package ui;

import db.Datasource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.listArtist();

        stage.setTitle("Music Database");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!Datasource.getInstance().open()){
            System.out.println("FATAL ERROR: could not connect to db");
        };
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}
