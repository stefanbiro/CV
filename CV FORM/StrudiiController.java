package cv;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StrudiiController {
// o sa avem o lista a aceleiasi clase pt populare cb si o alta lista pt

    ArrayList<Studii> lstudii; // pt preluare date din combobox

    cvController ctrl2;
    Studii s;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> univ;

    @FXML
    private ComboBox<Integer> dur;

    @FXML
    private TextField studiiPost;

    @FXML
    private CheckBox post;

    @FXML
    private ComboBox<String> fac;

    @FXML
    private ComboBox<String> spec;

    @FXML
    void univ(ActionEvent event) {

    }

    @FXML
    void fac(ActionEvent event) {

    }

    @FXML
    void spec(ActionEvent event) {

    }

    @FXML
    void dur(ActionEvent event) {

    }

    @FXML
    void salveazaStudii(ActionEvent event) {

        lstudii = new ArrayList();
        int d = dur.getSelectionModel().getSelectedItem();

        Studii s = new Studii(univ.getSelectionModel().getSelectedItem(),
                fac.getSelectionModel().getSelectedItem(), spec.getSelectionModel().getSelectedItem(), d);
        ctrl2.lstudii.add(s);
        ctrl2.cvlist.getItems().add("PREGATIREA PROFESIONALA");
        ctrl2.cvlist.getItems().add(" ");
        ctrl2.cvlist.getItems().add("UNIVERSITATEA: " + s.univ);
        ctrl2.cvlist.getItems().add("FACULTATEA: " + s.fac);
        ctrl2.cvlist.getItems().add("SPECIALIZAREA: " + s.spec);
        ctrl2.cvlist.getItems().add("DURATA : " + s.durata);
        ctrl2.cvlist.getItems().add("Studii postuniversitare :" + studiiPost.getText());
        ctrl2.cvlist.getItems().add(" ");
        // stergem cotroalele
        univ.getItems().clear();
        fac.getItems().clear();
        spec.getItems().clear();
        dur.getItems().clear();
        // ascundem fereastra
        Stage stage = (Stage) univ.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void abandon(ActionEvent event) {
        Stage stage = (Stage) univ.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void initialize() {
        univ.getItems().addAll("UBB", "UMF", "UTCN", "USAMV");

        fac.getItems().addAll("Chimie", "Fizica", "Matematica", "Litere", "Drept", "Pshihologie",
                "Ed Fizica si sport", "Economie", "Business", "Robotica", "Automatizari", "Mecanica", "Informatica", "Electronica", "Ingineria mediului",
                "Contructii de masini", "Instalatii", "Medicina generala", " altceva", "stomatologie", "pediatire");
        spec.getItems().addAll("Anorganica", "Organica", "Biochimie", "Materiale oxidice", "Fizica nucleara", "Fizica medicala", "Fizica generala", "Matematica", "Informatica", "Analiza");
        dur.getItems().addAll(3, 4, 5, 6);

        post.setSelected(false);
        post.selectedProperty().addListener((ov, vechi, nou) -> {
            if ((boolean) nou) {
                studiiPost.setVisible(true);

            }

        });

    }
}
