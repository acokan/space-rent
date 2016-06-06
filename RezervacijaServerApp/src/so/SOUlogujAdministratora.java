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
    List<OpstiDomenskiObjekat> listaAdmina;

    public SOUlogujAdministratora() {
    }

    public SOUlogujAdministratora(OpstiDomenskiObjekat admin) {
        this.admin = admin;
        ulogovani = null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {

        listaAdmina = DBBroker.vratiInstancu().vratiSveObjekte(admin);

        Administrator unijeti = (Administrator) admin;

        for (OpstiDomenskiObjekat ad : listaAdmina) {

            Administrator a = (Administrator) ad;
            if (unijeti.getKorisnickoIme().equals(a.getKorisnickoIme()) && unijeti.getSifra().equals(a.getSifra())) {
                ulogovani = a;
                a.setUlogovan("Online");
                System.out.println("Prije update " + a);
                DBBroker.vratiInstancu().sacuvajIliAzurirajObjekat(a);
                return;
            }
        }
    }

    public OpstiDomenskiObjekat vratiAdmina() {
        return ulogovani;
    }

    public List<OpstiDomenskiObjekat> vratiSveAdmine() {
        System.out.println("lista " + listaAdmina);
        return listaAdmina;
    }

}
