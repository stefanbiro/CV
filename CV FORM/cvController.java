package cv;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

// fereastra principala
public class cvController {
    Image imagine;
    ArrayList<Personal> lpersonal;
    ArrayList<Studii> lstudii;
    ArrayList<Experienta> lExp;
    ArrayList<Abilitati> lAbil;

    // fereastra de date
    Stage adaugDate;
    PersController ctrlDate;

    // fereastra de studii
    Stage adaugStudii;
    StrudiiController ctrlStudii;

    // fereastra de experienta
    Stage adaugExp;
    ExpController ctrlExp;

    //fereastra  de abilitati
    Stage adaugAbil;
    AbilController ctrlAbil;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    ListView<String> cvlist;

    @FXML
    private ImageView poza;

    @FXML
    void complDate(ActionEvent event) {
        adaugDate.showAndWait();
    }

    @FXML
    void complStudii(ActionEvent event) {
        adaugStudii.showAndWait();
    }

    @FXML
    void complExp(ActionEvent event) {
        adaugExp.showAndWait();
    }

    @FXML
    void complAbilitati(ActionEvent event) {
        adaugAbil.showAndWait();
    }

    @FXML
    void adaugPoza(ActionEvent event) {
     imagine = new Image("cv/came.jpg");
     poza.setImage(imagine);
    }

    @FXML
    void stergPoza(ActionEvent event) {
     poza.setImage(null);
    }

    @FXML
    void iesireProgram(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void info(ActionEvent event) {

    }

    @FXML
    void salveazaCV(ActionEvent event) {

    }

    @FXML
    void initialize() {
        lpersonal = new ArrayList();
        cvlist.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        adaugDate = new Stage();

        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Pers.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller

            ctrlDate = loader.getController();
            adaugDate.setTitle("Date personale");
            adaugDate.initModality(Modality.APPLICATION_MODAL);
            Scene scena = new Scene(container);
            adaugDate.setScene(scena);
            ctrlDate.ctrl = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        lstudii = new ArrayList();
        adaugStudii = new Stage();
        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("strudii.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller

            ctrlStudii = loader.getController();
            adaugStudii.setTitle("Pregatire profesionala");
            adaugStudii.initModality(Modality.APPLICATION_MODAL);
            Scene scena = new Scene(container);
            adaugStudii.setScene(scena);
            ctrlStudii.ctrl2 = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        lExp = new ArrayList();
        adaugExp = new Stage();
        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Exp.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller

            ctrlExp = loader.getController();
            adaugExp.setTitle("Pregatire profesionala");
            adaugExp.initModality(Modality.APPLICATION_MODAL);
            Scene scena = new Scene(container);
            adaugExp.setScene(scena);
            ctrlExp.ctrl3 = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        lAbil = new ArrayList();
        adaugAbil = new Stage();
        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Abil.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller

            ctrlAbil = loader.getController();
            adaugAbil.setTitle("Abilitati personale");
            adaugAbil.initModality(Modality.APPLICATION_MODAL);
            Scene scena = new Scene(container);
            adaugAbil.setScene(scena);
            ctrlAbil.ctrl4 = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

    }
}
