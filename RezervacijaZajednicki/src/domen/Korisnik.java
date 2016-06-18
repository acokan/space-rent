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
public class Korisnik extends OpstiDomenskiObjekat implements Serializable {

    private int korisnikID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String kontakt;
    private String mail;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, Date datumRodjenja, String kontakt, String mail, String ulica, String broj, Mesto mesto) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.kontakt = kontakt;
        this.mail = mail;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return korisnikID + " - " + ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.korisnikID;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumRodjenja);

        return "(" + "'" + korisnikID + "', '" + ime + "', '" + prezime + "', '" + datum + "', '" + kontakt + "', '" + mail + "', '" + ulica + "', '" + broj + "', " + mesto.getPtt() + ")";

    }

    @Override
    public String vratiVrednostiZaUpdate() {

        String datum = new SimpleDateFormat("yyyy-MM-dd").format(datumRodjenja);

        return "Ime = '" + ime + "', Prezime = '" + prezime + "', DatumRodjenja = '" + datum + "', Kontakt = '" + kontakt + "', Mail = '" + mail + "', "
                + "Ulica = '" + ulica + "', Broj = '" + broj + "', Ptt = " + mesto.getPtt() + " ";
    }

    @Override
    public String vratiPK() {
        return "KorisnikID";
    }

    @Override
    public int vratiVrednostPK() {
        return korisnikID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }
    
    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {

        List<OpstiDomenskiObjekat> listaKorisnika = new ArrayList<>();

        try {
            while (rs.next()) {

                int korisnikID = rs.getInt("KorisnikID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String datumRodjenja = rs.getString("DatumRodjenja");
                String kontakt = rs.getString("Kontakt");
                String mail = rs.getString("Mail");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                int ptt = rs.getInt("Ptt");
                Mesto m = new Mesto(ptt, "");
                
                String[] datumi = datumRodjenja.split("-");
                String datum = datumi[2] + "." + datumi[1] + "." + datumi[0] + ".";
                
                Korisnik k = null;
                try {
                    k = new Korisnik(korisnikID, ime, prezime, new SimpleDateFormat("dd.MM.yyyy.").parse(datum), kontakt, mail, ulica, broj, m);
                } catch (ParseException ex) {
                    Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                listaKorisnika.add(k);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKorisnika;

    }

}
