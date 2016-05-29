/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class Administrator extends OpstiDomenskiObjekat implements Serializable {
    
    private int administratorID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private boolean ulogovan;

    public Administrator() {
    }

    public Administrator(int administratorID, String ime, String prezime, String korisnickoIme, String sifra, boolean ulogovan) {
        this.administratorID = administratorID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ulogovan = ulogovan;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(int administratorID) {
        this.administratorID = administratorID;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.ime);
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdminID: "+administratorID+", Korisnicko ime: "+korisnickoIme+", Sifra: "+sifra+", Status: "+ulogovan;
    }

    @Override
    public String vratiNazivTabele() {
        return "administrator";
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
        return "administratorID";
    }

    @Override
    public int vratiVrednostPK() {
        return administratorID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> listaAdmina = new ArrayList<>();
        
        try {
            while (rs.next()) {
                
                int adminID = rs.getInt("AdministratorID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String korisnickoIme = rs.getString("KorisnickoIme");
                String sifra = rs.getString("Sifra");
                boolean ulogovan = rs.getBoolean("Ulogovan");
                
                Administrator a = new Administrator(adminID, ime, prezime, korisnickoIme, sifra, ulogovan);
                
                listaAdmina.add(a);   
            }
        } catch (Exception ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAdmina;
    }
    
    
    
    
    
    
}
