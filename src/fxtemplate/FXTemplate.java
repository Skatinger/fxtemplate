package fxtemplate;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */
public class FXTemplate extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> System.exit(0));

        //some bloated stuff to make a nice exit dialog
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setResizable(true);
                alert.getDialogPane().setPrefSize(450, 220);

                alert.setTitle("Confirm closing");
                alert.setHeaderText("Exit Application");
                alert.setContentText("Do you really want to quit?");

                ButtonType bt1 = new ButtonType(
                        "OK",
                        ButtonBar.ButtonData.OK_DONE
                );
                ButtonType bt2 = new ButtonType(
                        "Cancel",
                        ButtonBar.ButtonData.CANCEL_CLOSE
                );
                alert.getButtonTypes().setAll(bt1, bt2);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == bt1) {
                    System.exit(0);
                } else {
                    alert.close();
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

}
