package proiect;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class proiectController implements Initializable {

    Proiect comp;
    Stage scena;
    String pas = "";

    @FXML
    private PasswordField parola;

    @FXML
    private TextField mesaj;

    @FXML
    private Button intra;

    @FXML
    void unu(ActionEvent event) {

        pas = pas.concat("1");
        parola.setText(pas);

    }

    @FXML
    void doi(ActionEvent event) {

        pas = pas.concat("2");
        parola.setText(pas);

    }

    @FXML
    void trei(ActionEvent event) {

        pas = pas.concat("3");
        parola.setText(pas);
    }

    @FXML
    void patru(ActionEvent event) {

        pas = pas.concat("4");
        parola.setText(pas);
    }

    @FXML
    void cinci(ActionEvent event) {

        pas = pas.concat("5");
    }

    @FXML
    void sase(ActionEvent event) {

        pas = pas.concat("6");
        parola.setText(pas);
    }

    @FXML
    void sapte(ActionEvent event) {

        pas = pas.concat("7");
        parola.setText(pas);
        
    }

    @FXML
    void opt(ActionEvent event) {
        pas = pas.concat("8");
        parola.setText(pas);
    }

    @FXML
    void noua(ActionEvent event) {

        pas = pas.concat("9");
    }

    @FXML
    void zero(ActionEvent event) {

        pas = pas.concat("0");
    }

    @FXML
    void intrare(ActionEvent event) {
        comp.incarcMese();

    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void verificaParola(ActionEvent event) {

        if (pas.length() == 4) {
            if (pas.equals("1111")||pas.equals("2222")) {
                /*parola.setText(pas);
                mesaj.setVisible(true);
                mesaj.setText("Parola corecta !");
                intra.setVisible(true);*/
                comp.incarcMese();

            } else {
                mesaj.setVisible(true);
                mesaj.setText("mai incearca");
                pas = "";
            }
        } else {
            mesaj.setVisible(true);
            mesaj.setText("cod numai din 4 cifre!");
            pas = "";
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //To change body of generated methods, choose Tools | Templates.
    }

}
