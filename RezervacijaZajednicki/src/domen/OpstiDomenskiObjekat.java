/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public abstract class OpstiDomenskiObjekat {
    
    public abstract String vratiNazivTabele();    

    public abstract String vratiVrednostiZaInsert();

    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        return null;
    }
    
}
