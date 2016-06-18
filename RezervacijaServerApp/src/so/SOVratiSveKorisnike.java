/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class SOVratiSveKorisnike extends OpstaSO {

    List<OpstiDomenskiObjekat> listaKorisnika;

    public List<OpstiDomenskiObjekat> getListaKorisnika() {
        return listaKorisnika;
    }
    
    @Override 
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        
        listaKorisnika = DBBroker.vratiInstancu().vratiSveObjekte(new Korisnik());
        srediKorisnike();
        
    }

    private void srediKorisnike() throws SQLException {
        for (OpstiDomenskiObjekat odo : listaKorisnika) {
            Korisnik k = (Korisnik) odo;
            k.setMesto((Mesto) DBBroker.vratiInstancu().vratiObjekatPoKljucu(new Mesto(), k.getMesto().getPtt()));
        }
    }
    
    
}
