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
public class ZapamtiKorisnika extends OpstaSO {

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        DBBroker.vratiInstancu().sacuvaj(odo);
        
    }
    
    
    
}
