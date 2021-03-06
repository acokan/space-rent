/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Administrator;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.SOAzurirajKorisnika;
import so.OpstaSO;
import so.SOAzurirajRezervaciju;
import so.SOIzlogujAdministratora;
import so.SOObrisiKorisnika;
import so.SOObrisiRezervaciju;
import so.SOZapamtiMesto;
import so.SOVratiSveAdministratore;
import so.SOUlogujAdministratora;
import so.SOZapamtiKorisnika;
import so.SOVratiSvaMesta;
import so.SOZapamtiRezervaciju;
import so.SOVratiSveRezervacije;
import so.SOVratiSveKorisnike;
import so.SOVratiSveProstorije;
import so.SOZapamtiSveKorisnike;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class Kontroler {

    private static Kontroler instanca;
//    private Map<String, Object> sesija;

    private Kontroler() {
    }

//    public Map<String, Object> getSesija() {
//        return sesija;
//    }
    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<OpstiDomenskiObjekat> vratiListuAdministratora() throws Exception {
        SOVratiSveAdministratore soua = new SOVratiSveAdministratore();
        soua.izvrsiOpstuSO();
        return soua.vratiSveAdmine();
    }

    public OpstiDomenskiObjekat ulogujAdministratora(OpstiDomenskiObjekat a) throws Exception {
        SOUlogujAdministratora soul = new SOUlogujAdministratora(a);
        soul.izvrsiOpstuSO();
        return soul.vratiAdmina();
    }

    public OpstiDomenskiObjekat izlogujAdministratora(OpstiDomenskiObjekat a) throws Exception {
        SOIzlogujAdministratora soia = new SOIzlogujAdministratora(a);
        soia.izvrsiOpstuSO();
        return soia.getAdmin();
    }

    public void zapamtiKorisnika(OpstiDomenskiObjekat k) throws Exception {
        SOZapamtiKorisnika oso = new SOZapamtiKorisnika(k);
        oso.izvrsiOpstuSO();
    }

    public List<OpstiDomenskiObjekat> vratiSvaMesta() throws Exception {
        SOVratiSvaMesta oso = new SOVratiSvaMesta();
        oso.izvrsiOpstuSO();
        return oso.getListaMesta();
    }

    public void azurirajKorisnika(OpstiDomenskiObjekat korisnik) throws Exception {
        SOAzurirajKorisnika soak = new SOAzurirajKorisnika(korisnik);
        soak.izvrsiOpstuSO();
    }

    public void sacuvajRezervaciju(OpstiDomenskiObjekat rezervacija) throws Exception {
        SOZapamtiRezervaciju soza = new SOZapamtiRezervaciju(rezervacija);
        soza.izvrsiOpstuSO();
    }

    public List<OpstiDomenskiObjekat> vratiSveRezervacije() throws Exception {
        SOVratiSveRezervacije soua = new SOVratiSveRezervacije();
        soua.izvrsiOpstuSO();
        return soua.vratiSveRezervacije();
    }

    public void azurirajRezervaciju(OpstiDomenskiObjekat rezervacija) throws Exception {
        SOAzurirajRezervaciju soar = new SOAzurirajRezervaciju(rezervacija);
        soar.izvrsiOpstuSO();
    }

    public List<OpstiDomenskiObjekat> vratiListuKorisnika() throws Exception {
        SOVratiSveKorisnike sovsk = new SOVratiSveKorisnike();
        sovsk.izvrsiOpstuSO();
        return sovsk.getListaKorisnika();
    }

    public void obrisiKorisnika(OpstiDomenskiObjekat korisnik) throws Exception {
        SOObrisiKorisnika sook = new SOObrisiKorisnika(korisnik);
        sook.izvrsiOpstuSO();
    }

    public void obrisiRezervaciju(OpstiDomenskiObjekat rezervacija) throws Exception {
        SOObrisiRezervaciju soor = new SOObrisiRezervaciju(rezervacija);
        soor.izvrsiOpstuSO();
    }

    public void zapamtiSveKorisnike(List<OpstiDomenskiObjekat> lk) throws Exception {
        SOZapamtiSveKorisnike sozvk = new SOZapamtiSveKorisnike(lk);
        sozvk.izvrsiOpstuSO();
    }

    public void sacuvajMesto(OpstiDomenskiObjekat m) throws Exception {
        SOZapamtiMesto sosm = new SOZapamtiMesto(m);
        sosm.izvrsiOpstuSO();
    }

    public List<OpstiDomenskiObjekat> vratiListuProstorija() throws Exception {
        SOVratiSveProstorije sovsp = new SOVratiSveProstorije();
        sovsp.izvrsiOpstuSO();
        return sovsp.getLista();
    }

}
