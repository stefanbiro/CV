package cv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersController {

    cvController ctrl;
    Personal p;

    @FXML
    private TextField varsta;

    @FXML
    private TextField orasul;

    @FXML
    private TextField prenume;

    @FXML
    private TextField sexul;

    @FXML
    private TextField nume;

    @FXML
    private TextField email;

    @FXML
    void salveazaDate(ActionEvent event) {
        int v = Integer.valueOf(varsta.getText());
        Personal p = new Personal(nume.getText(), prenume.getText(), v, sexul.getText(), orasul.getText(), email.getText());
        ctrl.lpersonal.add(p);
        ctrl.cvlist.getItems().add("DATE PERSONALE");
        ctrl.cvlist.getItems().add(" ");
        ctrl.cvlist.getItems().add("NUMELE:  " + p.nume);

        ctrl.cvlist.getItems().add("PRENUMELE :  " + p.prenume);

        ctrl.cvlist.getItems().add("VARSTA:  " + p.varsta);

        ctrl.cvlist.getItems().add("SEXUL:  " + p.sexul);

        ctrl.cvlist.getItems().add("ORASUL DE DOMICILIU:  " + p.domiciliul);

        ctrl.cvlist.getItems().add("CONTACT : " + p.email);
        ctrl.cvlist.getItems().add(" ");
        // golim controalele
        nume.clear();
        prenume.clear();
        varsta.clear();
        sexul.clear();
        orasul.clear();
        email.clear();
        // ascundem fereastra de date
        Stage stage = (Stage) nume.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void abandon(ActionEvent event) {
        Stage stage = (Stage) nume.getScene().getWindow();
        stage.hide();
    }

}
