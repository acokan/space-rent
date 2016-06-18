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
import so.SOUcitajAdministratore;
import so.SOUlogujAdministratora;
import so.SOZapamtiKorisnika;
import so.SOVratiSvaMesta;
import so.SOZapamtiRezervaciju;
import so.SOUcitajRezervacije;
import so.SOVratiSveKorisnike;
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
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        SOUcitajAdministratore soua = new SOUcitajAdministratore();
        soua.izvrsiOpstuSO();
        return soua.vratiSveAdmine();
    }

    public OpstiDomenskiObjekat ulogujAdministratora(OpstiDomenskiObjekat a) throws Exception {
        SOUlogujAdministratora soul = new SOUlogujAdministratora(a);
        soul.izvrsiOpstuSO();
        return soul.vratiAdmina();
    }

    public void izlogujAdministratora(Administrator admin) throws Exception {
        SOIzlogujAdministratora soia = new SOIzlogujAdministratora(admin);
        soia.izvrsiOpstuSO();
    }

    public void ugasiKorisnike() {

//        try {
//            
//            Socket soket = (Socket) getSesija().get("soket");
//
//            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
//            
//            ServerTransferObjekat sto = new ServerTransferObjekat();
//            sto.setRezultat("Otkacen");
//            out.writeObject(sto);
//            System.out.println("Objekat je poslat: "+sto.getRezultat());
//                
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
      SOUcitajRezervacije soua = new SOUcitajRezervacije();
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

}
