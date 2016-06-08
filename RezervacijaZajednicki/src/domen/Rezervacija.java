/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        return rezervacijaID + " - " + datumRezervacije + ", " + korisnik + " - " + listaStavki;
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
        return "rezervacija";
    }

    @Override
    public String vratiVrednostiZaInsert() {

        String datum = new SimpleDateFormat("yyyy-MM-dd").format(datumRezervacije);
        return "(" + "" + rezervacijaID + ", '" + datum + "', " + korisnik.getKorisnikID() + "" + ")";
        
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        
        String datum = new SimpleDateFormat("yyyy-MM-dd").format(datumRezervacije);
        return "RezervacijaID = " + rezervacijaID + ", DatumRezervacije = '" + datum + "', KorisnikID = " + korisnik.getKorisnikID() + "";
        
    }

    @Override
    public String vratiPK() {
        return "RezervacijaID";
    }

    @Override
    public int vratiVrednostPK() {
        return rezervacijaID;
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema slozen kljuc";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> listaRezervacija = new ArrayList<>();

        try {
            while (rs.next()) {

                int rezID = rs.getInt("RezervacijaID");
                Date datum = new Date(rs.getDate("DatumRezervacije").getTime());
                int korisnikID = rs.getInt("KorisnikID");
                
                Korisnik k = new Korisnik();
                k.setKorisnikID(korisnikID);
                
                Rezervacija r = new Rezervacija();
                r.setRezervacijaID(rezID);
                r.setDatumRezervacije(datum);
                r.setKorisnik(k);
                
                listaRezervacija.add(r);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRezervacija;
        
    }
    
    

}
