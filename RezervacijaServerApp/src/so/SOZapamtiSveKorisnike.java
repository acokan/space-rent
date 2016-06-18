/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class SOZapamtiSveKorisnike extends OpstaSO {

    List<OpstiDomenskiObjekat> lista;

    public SOZapamtiSveKorisnike(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        DBBroker.vratiInstancu().sacuvajObjekte(lista);
    }
    
    
    
}
