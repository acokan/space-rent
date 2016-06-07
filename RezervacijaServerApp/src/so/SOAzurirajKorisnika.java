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
public class SOAzurirajKorisnika extends OpstaSO {

    OpstiDomenskiObjekat k;

    public SOAzurirajKorisnika(OpstiDomenskiObjekat k) {
        this.k = k;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        System.out.println("Korisnik: "+k);
        DBBroker.vratiInstancu().sacuvajIliAzurirajObjekat(k);
        
    }
    
}
