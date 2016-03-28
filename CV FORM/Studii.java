/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv;

/**
 *
 * @author stefan1
 */
public class Studii {
    String univ;
    String fac;
    String spec;
    int durata;

    public Studii(String univ, String fac, String spec, int durata) {
        this.univ = univ;
        this.fac = fac;
        this.spec = spec;
        this.durata = durata;
    }

    public Studii() {
    }
   

    public String getUniv() {
        return univ;
    }

    public String getFac() {
        return fac;
    }

    public String getSpec() {
        return spec;
    }

    public int getDurata() {
        return durata;
    }

  
}
