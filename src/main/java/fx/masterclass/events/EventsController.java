package fx.masterclass.events;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EventsController {

    @FXML
    private TextField nameField;

    @FXML
    public void onButtonClicked(){
        System.out.println("Hello " + nameField.getText());
    }

}
