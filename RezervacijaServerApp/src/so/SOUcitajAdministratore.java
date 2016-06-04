/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class SOUcitajAdministratore extends OpstaSO {

    List<OpstiDomenskiObjekat> listaAdmina;

    public SOUcitajAdministratore() {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {

        listaAdmina = DBBroker.vratiInstancu().vratiSveObjekte(odo);
       
    }

    public List<OpstiDomenskiObjekat> vratiSveAdmine() {
        System.out.println("lista " + listaAdmina);
        return listaAdmina;
    }

}
