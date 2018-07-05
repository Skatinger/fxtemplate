package fxtemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author alex
 */
public class FXMLDocumentController implements Initializable {

    //stuff belonging to the controller initialization
    @FXML
    TextField input_field;
    @FXML
    ListView output_field;
    @FXML
    ListView listing;
    @FXML
    CheckBox checkbox_1;
    @FXML
    MenuItem panic_btn;
    @FXML
    Slider slider;
    @FXML
    Label slider_label;
    @FXML
    ToggleButton enable_btn;

    //other stuff, does not belong to FXML
    ArrayList items;

    //constructor not always necessary, most things are done in initialize()
    public FXMLDocumentController() {
    }

    /**
     * used to prepare the whole visual stuff
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = new ArrayList<String>();
        items.add("First List Element");
        output_field.getItems().add(items.get(0));

        //better to have a listener for a slider than a actionMethod
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            slider_label.setText(Double.toString((int) slider.getValue()));
        });
    }

    @FXML
    private void submit_btn_ActionEvent(ActionEvent event) {
        items.add(input_field.getText());
        input_field.setText("");
        refreshLists();
    }

    @FXML
    private void checkbox_1_ActionEvent(ActionEvent event) {
        listing.getItems().clear();
        if (checkbox_1.isSelected()) {
            for (Object item : items) {
                listing.getItems().add(item);
            }
        }
    }
    
    @FXML
    private void panic_btn_ActionEvent(ActionEvent event) {
        showMessageDialog(null, "Please dont panic...");
    }

    @FXML
    private void enable_btn_ActionEvent(ActionEvent event) {
        slider.setDisable(!enable_btn.isSelected());
        enable_btn.setText(enable_btn.isSelected() ? "disable slider" : "enable slider");
    }

    /**
     * sample method to show what can be done without FXML annotation just write
     * methods however you like
     */
    private void refreshLists() {
        listing.getItems().clear();
        output_field.getItems().clear();
        for (Object item : items) {
            output_field.getItems().add(item);
            if (checkbox_1.isSelected()) {
                listing.getItems().add(item);
            }
        }
    }
}
