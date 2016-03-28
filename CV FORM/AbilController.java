package cv;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AbilController {

    cvController ctrl4;
    Abilitati a;

    @FXML
    private RadioButton bine4;

    @FXML
    private RadioButton bine2;

    @FXML
    private RadioButton mediu4;

    @FXML
    private RadioButton bine3;

    @FXML
    private RadioButton mediu2;

    @FXML
    private RadioButton bine1;

    @FXML
    private RadioButton mediu3;

    @FXML
    private RadioButton mediu1;

    @FXML
    private RadioButton avansat4;

    @FXML
    private RadioButton avansat3;

    @FXML
    private RadioButton avansat2;

    @FXML
    private RadioButton avansat1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> limba3;

    @FXML
    private ComboBox<String> pc;

    @FXML
    private ComboBox<String> limba1;

    @FXML
    private ComboBox<String> limba2;

    @FXML
    private ToggleGroup gr2;

    @FXML
    private ToggleGroup gr1;

    @FXML
    private ToggleGroup gr4;

    @FXML
    private ToggleGroup gr3;

    @FXML
    private CheckBox sofer;

    @FXML
    private TextField cat;

    @FXML
    void salveazaAbil(ActionEvent event) {
        String n1 = " ", n2 = " ", n3 = " ", n4 = " ";
        if (mediu1.isSelected()) {
            n1 = "  Nivel satisfacator";
        } else if (bine1.isSelected()) {
            n1 = "  Nivel mediu ";
        } else if (avansat1.isSelected()) {
            n1 = "  Nivel avansat ";
        }

        if (mediu2.isSelected()) {
            n2 = "  Nivel satisfacator";
        } else if (bine2.isSelected()) {
            n2 = "  Nivel mediu ";
        } else if (avansat2.isSelected()) {
            n2 = "  Nivel avansat ";
        }

        if (mediu3.isSelected()) {
            n3 = "  Nivel satisfacator";
        } else if (bine3.isSelected()) {
            n3 = "  Nivel mediu ";
        } else if (avansat3.isSelected()) {
            n3 = "  Nivel avansat ";
        }
        if (mediu4.isSelected()) {
            n4 = "  Nivel satisfacator";
        } else if (bine4.isSelected()) {
            n4 = "  Nivel mediu ";
        } else if (avansat4.isSelected()) {
            n4 = "  Nivel avansat ";
        }

        // creeam obiecte din clasa Abilitati cu datele alese de user
        a = new Abilitati(limba1.getSelectionModel().getSelectedItem(), limba2.getSelectionModel().getSelectedItem(), limba3.getSelectionModel().getSelectedItem(), pc.getSelectionModel().getSelectedItem());
        // introducem obiectele intr-o lista de abilitati
        ctrl4.lAbil.add(a);
        // introducem datele specifice in cvlist
        ctrl4.cvlist.getItems().add("Abilitati personale");
        ctrl4.cvlist.getItems().add(" ");
        ctrl4.cvlist.getItems().add("Limba 1 : " + a.limba1 + n1);
        ctrl4.cvlist.getItems().add("Limba 2 : " + a.limba2 + n2);
        ctrl4.cvlist.getItems().add("Limba 3 : " + a.limba3 + n3);
        ctrl4.cvlist.getItems().add("Limba 4 : " + a.pc + n4);
        ctrl4.cvlist.getItems().add("Carnet de sofer :" + cat.getText());

        // stergem cotroalele
        limba1.getItems().clear();
        limba2.getItems().clear();
        limba3.getItems().clear();
        pc.getItems().clear();
        // ascundem fereastra
        Stage stage = (Stage) pc.getScene().getWindow();
        stage.hide();

    }

    @FXML
    void abandon(ActionEvent event) {
        Stage stage = (Stage) pc.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void initialize() {
        limba1.getItems().addAll("Engleza", "Franceza", "Germana", "Italiana");
        limba2.getItems().addAll("Engleza", "Franceza", "Germana", "Italiana");
        limba3.getItems().addAll("Engleza", "Franceza", "Germana", "Italiana");
        pc.getItems().addAll("Ms Office");

        sofer.setSelected(false);
        sofer.selectedProperty().addListener((ov, veche, noua) -> {
            if (noua) {
                cat.setVisible(true);
            }
        });

    }
}
