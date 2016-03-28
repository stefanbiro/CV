package cv;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExpController {

    cvController ctrl3;
    ArrayList<Experienta> lExp;
    Experienta e;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField perioada;

    @FXML
    private TextField functia;

    @FXML
    private TextField firma;

    @FXML
    private ListView<String> disponibile;

    @FXML
    private ListView<String> selectate;

    @FXML
    void transfer(ActionEvent event) {
        selectate.getItems().clear();
        ObservableList<Integer> dispo
                = disponibile.getSelectionModel().getSelectedIndices();
        for (int poz : dispo) {
            String ecurent = disponibile.getItems().get(poz);
            selectate.getItems().add(ecurent);
        }
    }

    @FXML
    void salvezExp(ActionEvent event) {

        lExp = new ArrayList();
        int t = Integer.valueOf(perioada.getText());
        e = new Experienta(firma.getText(), t, functia.getText());
        ctrl3.lExp.add(e);
        ctrl3.cvlist.getItems().add("EXPERIENTA PROFESIONALA");
        ctrl3.cvlist.getItems().add(" ");
        ctrl3.cvlist.getItems().add("FIRMA : " + e.firma);
        ctrl3.cvlist.getItems().add("PERIOADA: " + e.perioada);
        ctrl3.cvlist.getItems().add("FUNCTIA: " + e.functia);
        ctrl3.cvlist.getItems().add("ATRIBUTIUNI PRINCIPALE " + selectate.getItems()); 
         ctrl3.cvlist.getItems().add(" ");
                

        // stergem cotroalele
        firma.clear();
        perioada.clear();
        functia.clear();

        // ascundem fereastra
        Stage stage = (Stage) firma.getScene().getWindow();
        stage.hide();

    }

    @FXML
    void abandon(ActionEvent event) {
        Stage stage = (Stage) firma.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void Goleste(ActionEvent event) {
        selectate.getItems().clear();
    }

    @FXML
    void initialize() {
        disponibile.getItems().addAll("Top managment", "Midle-managment", "Responsabil productie",
                "Responsabil calitate","Coordonator echipa","Responsabil mediu-protectia muncii");
        disponibile.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
