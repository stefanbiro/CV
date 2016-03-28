package proiect;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConsumatieController implements Initializable {

    Proiect comp;
    String cale;
    Preparat pt;
    String categ;
    Comanda coma;
    ArrayList<Comanda> lCom;
    ArrayList<Preparat> listaP;
    int s;
    ModificareController ctrl;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    ComboBox<Integer> numarScaun;

    @FXML
    TextField nrMasa;

    @FXML
    private TableView<Comanda> lComanda;

    @FXML
    private TableColumn<Comanda, Integer> cscaun;

    @FXML
    private TableColumn<Comanda, String> cstare;

    @FXML
    private TableColumn<Comanda, String> cpreparat;

    @FXML
    private TableColumn<Comanda, Double> cpret;

    @FXML
    ListView<String> lPreparate;

    @FXML
    private ListView<String> lCategorii;

    @FXML
    TextArea textArie;

    @FXML
    void adauga(ActionEvent event) {
        adaugComanda();
    }

    @FXML
    void sterge(ActionEvent event) {

    }

    @FXML
    void trimitereComanda(ActionEvent event) {

    }

    @FXML
    void modifica(ActionEvent event) {

    }

    @FXML
    void plataNumerar(ActionEvent event) {

    }

    @FXML
    void plataCard(ActionEvent event) {

    }

    @FXML
    void delogare(ActionEvent event) {
        comp.incarcLogin();
    }

    @FXML
    void altaMasa(ActionEvent event) {
        comp.incarcMese();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // incarcam comboboxul cu nr meselor
        numarScaun.getItems().addAll(1, 2, 3, 4);
        numarScaun.getSelectionModel().selectFirst();
        nrMasa.setVisible(true);

        // incarcam lista de categorii
        lCategorii.getItems().add("Mic dejun");
        lCategorii.getItems().add("Gustare rece");
        lCategorii.getItems().add("Supe");
        lCategorii.getItems().add("Gratare");
        lCategorii.getItems().add("Garnituri");
        lCategorii.getItems().add("Salate");
        lCategorii.getItems().add("Bauturi");
        lCategorii.getItems().add("Cafea");

        // Supraveghere elemente din lista cu incarcarea in lista de preparate a fisierelor xml
        lCategorii.getSelectionModel().selectedItemProperty().addListener((ob, categVechi, categNou) -> {

            categNou = lCategorii.getSelectionModel().getSelectedItem();
            lPreparate.getItems().clear();
            incarc(categNou);

        });
        // La selectarea unui preparat din lista preparate acesta se va incarca in textfield

        lPreparate.getSelectionModel().selectedItemProperty().addListener((ob, categVechi, categNou) -> {

            categNou = lPreparate.getSelectionModel().getSelectedItem();
            textArie.setText(categNou);

        });
        // asociez coloanleor tabelului elemtentele corespunzatoare
        cscaun.setCellValueFactory(cellData -> cellData.getValue().scaun.asObject());
        cstare.setCellValueFactory(cellData -> cellData.getValue().stare);
        cpreparat.setCellValueFactory(cellData -> cellData.getValue().preparat);
        cpret.setCellValueFactory(cellData -> cellData.getValue().pret.asObject());

        lCom = new ArrayList();
        listaP = new ArrayList();

        //ctrl.cctrl=this;
    }

    void adaugComanda() {

        s = numarScaun.getSelectionModel().getSelectedIndex();
        s = s + 1;
      
        try {
            File fXml = new File("meniu.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXml);
            doc.getDocumentElement().normalize();

            Element radacina = doc.getDocumentElement();
            NodeList lista = doc.getElementsByTagName("preparat");

            for (int contor = 0; contor < lista.getLength(); contor++) {
                Element preparat = (Element) lista.item(contor);
                String pnume = preparat.getElementsByTagName("nume").item(0).getTextContent();
                String pgramaj = preparat.getElementsByTagName("gramaj").item(0).getTextContent();
                String ppret = preparat.getElementsByTagName("pret").item(0).getTextContent();
                String pdescriere = preparat.getElementsByTagName("descriere").item(0).getTextContent();
                double pppret = Double.valueOf(ppret);
                
                Preparat co = new Preparat(pnume, pgramaj, pppret, pdescriere);
                listaP.add(co);
                coma = new Comanda(s, textArie.getText(), "ocupat", co.pret);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lCom.add(coma);
        
        lComanda.getItems().add(coma);

    }

    void incarc(String categNou) {
        // calea , fisierul xml se pune tot timpul in proictl "mare " acolo se regaseste
        // si tot timpul se dau cai relative nu absolute
        try {
            File fXml = new File("meniu.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXml);
            doc.getDocumentElement().normalize();

            Element radacina = doc.getDocumentElement();
            NodeList lista = doc.getElementsByTagName("preparat");
            for (int contor = 0; contor < lista.getLength(); contor++) {
                Element preparat = (Element) lista.item(contor);
                if (preparat.getAttribute("categorie").equals(categNou)) {
                    String pnume = preparat.getElementsByTagName("nume").item(0).getTextContent();
                    String pgramaj = preparat.getElementsByTagName("gramaj").item(0).getTextContent();
                    String ppret = preparat.getElementsByTagName("pret").item(0).getTextContent();
                    String pdescriere = preparat.getElementsByTagName("descriere").item(0).getTextContent();
                    Double pppret = Double.valueOf(ppret);
                    // incarcam lPreparate
                    lPreparate.getItems().add(pnume + " " + pgramaj + " " + ppret + " " + pdescriere);

                    lPreparate.getItems().add("");
                   

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
