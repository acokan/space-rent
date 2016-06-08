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
public class SOZapamtiRezervaciju extends OpstaSO {

    OpstiDomenskiObjekat r;

    public SOZapamtiRezervaciju(OpstiDomenskiObjekat r) {
        this.r = r;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        
        DBBroker.vratiInstancu().sacuvaj(r);
        sacuvajStavke();
        
    }

    private void sacuvajStavke() throws SQLException {
        Rezervacija rez = (Rezervacija) r;
        for (StavkaRezervacije stavka : rez.getListaStavki()) {
            stavka.setRezervacija(rez);
            DBBroker.vratiInstancu().sacuvaj(stavka);
        }
    }
    
}
