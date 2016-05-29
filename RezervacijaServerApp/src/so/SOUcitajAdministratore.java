/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class SOUcitajAdministratore extends OpstaSO {

    List<OpstiDomenskiObjekat> listaAdmina;
    
    public List<OpstiDomenskiObjekat> getListaAdmina() {
        return listaAdmina;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        listaAdmina = DBBroker.vratiInstancu().vratiSveObjekte(odo);
    }
    
    
    
}
