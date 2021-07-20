
package helloworldgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HelloWorldGUIController implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonClick(ActionEvent event) {
        label.setText("Hello World!");
    }
    
}
