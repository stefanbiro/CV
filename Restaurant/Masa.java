/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

/**
 *
 * @author stefan1
 */
public class Masa {
    private int nrMasa;
    private int stareMasa;
    private int nrOcupanti;

    public Masa(int nrMasa, int stareMasa, int nrOcupanti) {
        this.nrMasa = nrMasa;
        this.stareMasa = stareMasa;
        this.nrOcupanti = nrOcupanti;
    }

    public int getNrMasa() {
        return nrMasa;
    }

    public int getStareMasa() {
        return stareMasa;
    }

    public int getNrOcupanti() {
        return nrOcupanti;
    }
    
}
