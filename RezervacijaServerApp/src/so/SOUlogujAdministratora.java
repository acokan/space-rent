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
public class SOUlogujAdministratora extends OpstaSO {

    OpstiDomenskiObjekat admin;
    OpstiDomenskiObjekat ulogovani;

    public SOUlogujAdministratora (OpstiDomenskiObjekat admin) {
        this.admin = admin;
        ulogovani = null;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        List<OpstiDomenskiObjekat> listaAdmina = DBBroker.vratiInstancu().vratiSveObjekte(odo);
        
        Administrator unijeti = (Administrator) admin;
        
        for (OpstiDomenskiObjekat ad : listaAdmina) {
            
            Administrator a = (Administrator) ad;
            if (unijeti.getKorisnickoIme().equals(a.getKorisnickoIme()) && unijeti.getSifra().equals(a.getSifra())) {
                ulogovani = a;
                return;
            }   
        }
    }
    
    public OpstiDomenskiObjekat vratiAdmina() {
        return ulogovani;
    }
    
}
