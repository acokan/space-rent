/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class Rezervacija extends OpstiDomenskiObjekat implements Serializable {
    
    private int rezervacijaID;
    private Date datumRezervacije;
    private Korisnik korisnik;
    private List<StavkaRezervacije> listaStavki;

    public Rezervacija() {
        listaStavki = new ArrayList<>();
    }

    public Rezervacija(int rezervacijaID, Date datumRezervacije, Korisnik korisnik, List<StavkaRezervacije> listaStavki) {
        this.rezervacijaID = rezervacijaID;
        this.datumRezervacije = datumRezervacije;
        this.korisnik = korisnik;
        this.listaStavki = listaStavki;
    }

    public List<StavkaRezervacije> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacije> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return rezervacijaID + " - " +datumRezervacije + ", " + korisnik + " - " + listaStavki;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.rezervacijaID;
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.rezervacijaID != other.rezervacijaID) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
