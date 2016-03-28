/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author stefan1
 */
public class Proiect extends Application {

    proiectController ctrlP;// fereastra login
    SelectezController ctrlS; // fereastra selectare masa
    ConsumatieController ctrlC; // fereastra consumatie
    Stage scena;
    int nrMasa;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            scena = primaryStage;
            scena.setTitle("Proiect");
            incarcLogin();
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

// fereastra 1
    void incarcLogin() {
        ctrlP = (proiectController) inlocuiesteScena("login.fxml");
        ctrlP.comp = this;
// fereastra 2
    }

    void incarcMese() {
        ctrlS = (SelectezController) inlocuiesteScena("Selectez.fxml");
        ctrlS.comp = this;
    }

    void incarcMasa1() {
        ctrlC = (ConsumatieController) inlocuiesteScena("Consumatie1.fxml");
        ctrlC.comp = this;
        ctrlC.nrMasa.setText("1");

    }

    void incarcMasa2() {
        ctrlC = (ConsumatieController) inlocuiesteScena("Consumatie1.fxml");
        ctrlC.comp = this;
        ctrlC.nrMasa.setText("2");

    }

    void incarcMasa3() {
        ctrlC = (ConsumatieController) inlocuiesteScena("Consumatie1.fxml");
        ctrlC.comp = this;
        ctrlC.nrMasa.setText("3");

    }

    private Initializable inlocuiesteScena(String fxml) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxml));
        AnchorPane cont;
        try {
            cont = (AnchorPane) loader.load();
            Scene scene = new Scene(cont);
            scena.setScene(scene);
            scena.sizeToScene();
        } catch (IOException ex) {
            Logger.getLogger(proiectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
