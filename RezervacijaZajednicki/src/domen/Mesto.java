/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class Mesto extends OpstiDomenskiObjekat implements Serializable {
    
    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return ptt + ", " + naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.ptt;
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
        final Mesto other = (Mesto) obj;
        if (this.ptt != other.ptt) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> listaMesta = new ArrayList<>();
        
        try {
            while (rs.next()) {
                
                int ptt = rs.getInt("Ptt");
                String naziv = rs.getString("Naziv");
                
                Mesto m = new Mesto(ptt, naziv);
                listaMesta.add(m);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaMesta;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "ptt";
    }

    @Override
    public int vratiVrednostPK() {
        return ptt;
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema slozen PK";
    }
    
    
    
    
    
    
}
