/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Aco Kandic
 */
public class Prostorija implements Serializable {
    
    private int prostorijaID;
    private String nazivProstorije;
    private int kapacitet;
    private double cena;

    public Prostorija() {
    }

    public Prostorija(int prostorijaID, String nazivProstorije, int kapacitet, double cena) {
        this.prostorijaID = prostorijaID;
        this.nazivProstorije = nazivProstorije;
        this.kapacitet = kapacitet;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getProstorijaID() {
        return prostorijaID;
    }

    public void setProstorijaID(int prostorijaID) {
        this.prostorijaID = prostorijaID;
    }

    public String getNazivProstorije() {
        return nazivProstorije;
    }

    public void setNazivProstorije(String nazivProstorije) {
        this.nazivProstorije = nazivProstorije;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public String toString() {
        return nazivProstorije + " - " + cena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.prostorijaID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prostorija other = (Prostorija) obj;
        if (this.prostorijaID != other.prostorijaID) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
