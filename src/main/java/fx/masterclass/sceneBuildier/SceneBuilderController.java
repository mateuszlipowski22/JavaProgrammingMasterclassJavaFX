package fx.masterclass.sceneBuildier;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SceneBuilderController {

    @FXML
    private Label label;

    @FXML
    private void handleAction(){
        label.setText("OK button pressed");
    }
}
