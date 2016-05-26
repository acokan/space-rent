/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class VratiSvaMesta extends OpstaSO {

    List<OpstiDomenskiObjekat> listaMesta;

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {

        listaMesta = DBBroker.vratiInstancu().vratiSve(odo);
        
    }

}
