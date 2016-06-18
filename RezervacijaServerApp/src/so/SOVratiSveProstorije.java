/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Prostorija;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class SOVratiSveProstorije extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        lista = DBBroker.vratiInstancu().vratiSveObjekte(new Prostorija());
    }
    
    
    
}
