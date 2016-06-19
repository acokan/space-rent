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
public class SOIzlogujAdministratora extends OpstaSO {

    OpstiDomenskiObjekat admin;
    OpstiDomenskiObjekat logOut;
    List<OpstiDomenskiObjekat> listaAdmina;

    public SOIzlogujAdministratora(OpstiDomenskiObjekat admin) {
        this.admin = admin;
    }

    public OpstiDomenskiObjekat getAdmin() {
        return logOut;
    }
    
     
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        
        listaAdmina = DBBroker.vratiInstancu().vratiSveObjekte(admin);

        Administrator unijeti = (Administrator) admin;

        for (OpstiDomenskiObjekat ad : listaAdmina) {

            Administrator a = (Administrator) ad;
            if (unijeti.getKorisnickoIme().equals(a.getKorisnickoIme()) && unijeti.getSifra().equals(a.getSifra())) {
                logOut = a;
                a.setUlogovan("Offline");
                System.out.println("Prije update " + a);
                DBBroker.vratiInstancu().sacuvajIliAzurirajObjekat(a);
                return;
            }
        }
        
    }
    
    
    
}
