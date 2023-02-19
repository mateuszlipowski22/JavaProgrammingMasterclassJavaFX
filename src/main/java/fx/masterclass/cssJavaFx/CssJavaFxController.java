package fx.masterclass.cssJavaFx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class CssJavaFxController {

    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    public void initialize(){
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleY(2.0);
        label.setScaleX(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleY(1.0);
        label.setScaleX(1.0);
    }

    @FXML
    public void handleClick(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save application file");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.jpeg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All files", "*.*")
                );
//        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());
        if(file!=null){
            System.out.println(file.getPath());
        }else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClick(){
        System.out.println("The link as clicked");
        try{
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        }catch(IOException e) {
            e.printStackTrace();
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
