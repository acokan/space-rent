/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Prostorija;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aco Kandic
 */
public class SOVratiSveRezervacije extends OpstaSO {

    List<OpstiDomenskiObjekat> listaRezervacija;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {

        listaRezervacija = DBBroker.vratiInstancu().vratiSveObjekte(new Rezervacija());
        srediKorisnike();
        srediListuStavki();

    }

    public List<OpstiDomenskiObjekat> vratiSveRezervacije() {
        System.out.println(listaRezervacija);
        return listaRezervacija;
    }

    private void srediKorisnike() throws SQLException {

        for (OpstiDomenskiObjekat odo : listaRezervacija) {
            Rezervacija r = (Rezervacija) odo;
            r.setKorisnik((Korisnik) DBBroker.vratiInstancu().vratiObjekatPoKljucu(new Korisnik(), r.getKorisnik().getKorisnikID()));
        }

    }

    private void srediListuStavki() throws SQLException {

        List<OpstiDomenskiObjekat> listaStavkiRezervacija = DBBroker.vratiInstancu().vratiSveObjekte(new StavkaRezervacije());
        
        for (OpstiDomenskiObjekat odo : listaRezervacija) {
            Rezervacija rez = (Rezervacija) odo;
            List<StavkaRezervacije> okStavke = new ArrayList<>();
            for (OpstiDomenskiObjekat odo1 : listaStavkiRezervacija) {
                StavkaRezervacije stavka = (StavkaRezervacije) odo1;
                if (stavka.getRezervacija().getRezervacijaID() == rez.getRezervacijaID()) {
                    okStavke.add(stavka);
                }
            }
            
            for (StavkaRezervacije okS : okStavke) {
                okS.setRezervacija(rez);
                okS.setProstorija((Prostorija) DBBroker.vratiInstancu().vratiObjekatPoKljucu(new Prostorija(), okS.getProstorija().getProstorijaID()));
                rez.getListaStavki().add(okS);
                listaStavkiRezervacija.remove(okS);
            }
        }

    }

}
