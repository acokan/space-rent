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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class Prostorija extends OpstiDomenskiObjekat implements Serializable {
    
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

    @Override
    public String vratiNazivTabele() {
        return "prostorija";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("+ "'"+prostorijaID+"', '"+nazivProstorije+"', '"+kapacitet+"', '"+cena+"'" +")"; 
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ProstorijaID = "+prostorijaID+", NazivProstorije= '"+nazivProstorije+"', Kapacitet = "+kapacitet+", Cena = "+cena+"";
    }

    @Override
    public String vratiPK() {
        return "ProstorijaID";
    }

    @Override
    public int vratiVrednostPK() {
        return prostorijaID;
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema slozen kljuc";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> listaProstorija = new ArrayList<>();

        try {
            while (rs.next()) {

                int proID = rs.getInt("ProstorijaID");
                String naziv = rs.getString("NazivProstorije");
                int kap = rs.getInt("Kapacitet");
                double c =  rs.getDouble("Cena");
                
                Prostorija p = new Prostorija(proID, naziv, kap, c);
                
                listaProstorija.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProstorija;
        
    }
    
    
    
    
    
}
