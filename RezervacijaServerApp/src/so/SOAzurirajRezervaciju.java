/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.sql.SQLException;

/**
 *
 * @author Aco Kandic
 */
public class SOAzurirajRezervaciju extends OpstaSO {

    OpstiDomenskiObjekat odo;

    public SOAzurirajRezervaciju(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        
        System.out.println("Rezervacija: "+odo);
        DBBroker.vratiInstancu().sacuvajIliAzurirajObjekat(odo);
        sacuvajStavke();
            
        
    }

    private void sacuvajStavke() throws Exception {
        
        Rezervacija rez = (Rezervacija) odo;
        for (StavkaRezervacije stavka : rez.getListaStavki()) {
            stavka.setRezervacija(rez);
            DBBroker.vratiInstancu().sacuvajIliAzurirajObjekat(stavka);
        }
        
    }
    
    
    
}
