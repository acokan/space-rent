/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author Aco Kandic
 */
public class StavkaRezervacije implements Serializable {
    
    private Rezervacija rezervacija;
    private int redniBrojStavke;
    private LocalTime vremeOd;
    private LocalTime vremeDo;
    private double iznos;
    private Prostorija prostorija; 

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(Rezervacija rezervacija, int redniBrojStavke, LocalTime vremeOd, LocalTime vremeDo, double iznos, Prostorija prostorija) {
        this.rezervacija = rezervacija;
        this.redniBrojStavke = redniBrojStavke;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.iznos = iznos;
        this.prostorija = prostorija;
    }
    
    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Prostorija getProstorija() {
        return prostorija;
    }

    public void setProstorija(Prostorija prostorija) {
        this.prostorija = prostorija;
    }

    public int getRedniBrojStavke() {
        return redniBrojStavke;
    }

    public void setRedniBrojStavke(int redniBrojStavke) {
        this.redniBrojStavke = redniBrojStavke;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return rezervacija.getRezervacijaID() + " - " + redniBrojStavke + ", " + vremeOd + " - " + vremeDo + ", " + prostorija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.redniBrojStavke;
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
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        if (this.redniBrojStavke != other.redniBrojStavke) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
