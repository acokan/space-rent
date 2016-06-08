/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class StavkaRezervacije extends OpstiDomenskiObjekat implements Serializable {
    
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

    @Override
    public String vratiNazivTabele() {
        return "stavkarezervacije";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        
        return "(" + "" + rezervacija.getRezervacijaID() + ", " + redniBrojStavke + ", '" + vremeOd + "', '" + vremeDo + "', " 
                + iznos + ", " + prostorija.getProstorijaID() + "" + ")";
        
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        
        return "RezervacijaID = " + getRezervacija().getRezervacijaID() + ", RedniBrojStavke = " + getRedniBrojStavke() + ", VremeOd = '" + getVremeOd() + "', "
                + "VremeDo = '" + getVremeDo() + "', Iznos = " + getIznos() + ", " + "ProstorijaID = " + getProstorija().getProstorijaID() + "";
    
    }

    @Override
    public String vratiPK() {
        return null;
    }

    @Override
    public int vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE RezervacijaID=" + getRezervacija().getRezervacijaID() + " AND RedniBrojStavke=" + getRedniBrojStavke();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> listaStavkiRezervacije = new ArrayList<>();

        try {
            while (rs.next()) {

                int rezID = rs.getInt("RezervacijaID");                
                int rbrStavke = rs.getInt("RedniBrojStavke");
                String vrOd = rs.getString("VremeOd");
                String vrDo = rs.getString("VremeDo");
                double iz = rs.getDouble("Iznos");
                int prostorID = rs.getInt("ProstorijaID");
                
                Rezervacija rez = new Rezervacija();
                rez.setRezervacijaID(rezID);
                Prostorija p = new Prostorija();
                p.setProstorijaID(prostorID);
                
                String[] vreme1 = vrOd.split(":");
                String[] vreme2 = vrDo.split(":");
                LocalTime lt1 = LocalTime.of(Integer.parseInt(vreme1[0]), Integer.parseInt(vreme1[1]));
                LocalTime lt2 = LocalTime.of(Integer.parseInt(vreme2[0]), Integer.parseInt(vreme2[1]));
                System.out.println(lt1);
                System.out.println(lt2);
                
                StavkaRezervacije sr = new StavkaRezervacije();
                sr.setRezervacija(rez);
                sr.setRedniBrojStavke(rbrStavke);
                sr.setVremeOd(lt1);
                sr.setVremeDo(lt2);
                sr.setIznos(iz);
                sr.setProstorija(p);
                
                listaStavkiRezervacije.add(sr);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaStavkiRezervacije;
        
    }
    
    
    
    
    
    
}
