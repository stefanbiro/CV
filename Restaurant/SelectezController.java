package proiect;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SelectezController implements Initializable {

    Proiect comp;
    int masa;

    ConsumatieController cc;

    @FXML
    Button m1;

    @FXML
    Button m2;

    @FXML
    Button m3;

    @FXML
    void masa1(ActionEvent event) {

        comp.incarcMasa1();
        comp.nrMasa=1;

    }

    @FXML
    void masa2(ActionEvent event) {

        comp.incarcMasa2();
        comp.nrMasa=2;
    }

    @FXML
    void masa3(ActionEvent event) {

        comp.incarcMasa3();
        comp.nrMasa=3;
    }

    @FXML
    void iesire(ActionEvent event) {
        comp.incarcLogin();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }

}
