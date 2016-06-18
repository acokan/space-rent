/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Aco Kandic
 */
public class SOObrisiRezervaciju extends OpstaSO {
    
    OpstiDomenskiObjekat r;

    public SOObrisiRezervaciju(OpstiDomenskiObjekat r) {
        this.r = r;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        
        DBBroker.vratiInstancu().obrisi(r);
        
    }
    
}
