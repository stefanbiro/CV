/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author stefan1
 */
public class Comanda {

    ConsumatieController cctrl;

    private int masa;
     SimpleIntegerProperty scaun;
     SimpleStringProperty preparat;
    private String modificari;
    SimpleStringProperty stare;
    private int destinatie;
    SimpleDoubleProperty pret;

    /* public Comanda(int masa, int scaun, String preparat, String modificari, String stare, int destinatie) {
     this.masa = masa;
     this.scaun = new SimpleIntegerProperty(scaun);
     this.preparat = new SimpleStringProperty(preparat);
     this.modificari = modificari;
     this.stare = new SimpleStringProperty(stare);
     this.destinatie = destinatie;
     }
     */
    public Comanda(Integer scaun, String preparat, String stare,double pret) {
        this.scaun = new SimpleIntegerProperty(scaun);
        this.preparat = new SimpleStringProperty(preparat);
        this.stare = new SimpleStringProperty(stare);
        this.pret = new SimpleDoubleProperty(pret);
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

   // public int getScaun() {
     //   return (scaun);
    //}

    public SimpleStringProperty getPreparat() {
        return preparat;
    }

    public void setPreparat(SimpleStringProperty preparat) {
        this.preparat = preparat;
    }

    public String getModificari() {
        return modificari;
    }

    public void setModificari(String modificari) {
        this.modificari = modificari;
    }

    public SimpleStringProperty getStare() {
        return stare;
    }

    public void setStare(SimpleStringProperty stare) {
        this.stare = stare;
    }

    public int getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(int destinatie) {
        this.destinatie = destinatie;
    }

}
