/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korisnici.kontroler;

import domen.Administrator;
import domen.Korisnik;
import domen.Mesto;
import domen.Prostorija;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import komunikacija.Komunikacija;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class Kontroler {

    private static Kontroler instanca;
    private Map<String, Object> sesija;
    private int aktivanSK;

    public Map<String, Object> getSesija() {
        return sesija;
    }

    public int getAktivanSK() {
        return aktivanSK;
    }

    public void setAktivanSK(int aktivanSK) {
        this.aktivanSK = aktivanSK;
    }

    private Kontroler() {
        sesija = new HashMap<>();
    }

    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public boolean dodajKorisnika(Korisnik k) throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_KORISNIKA);
        kto.setParametar(k);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }
   
    }

    public void updateKorisnika(Korisnik k) throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_AZURIRAJ_KORISNIKA);
        kto.setParametar(k);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
        } else {
            throw new Exception(sto.getGreska());
        }
        
    }
    
    public boolean sacuvajListuKorisnika(List<Korisnik> lk) throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_SVE_KORISNIKE);
        kto.setParametar(lk);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }

    }

    public List<Korisnik> vratiListuKorisnika() throws IOException, ClassNotFoundException, Exception {

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_KORISNIKE);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Korisnik>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
    }


    public List<Mesto> vratiListuMesta() throws IOException, ClassNotFoundException, Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVA_MESTA);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Mesto>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }

    }

    public Mesto vratiMesto(int ptt) throws IOException, ClassNotFoundException, Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_MESTO_PO_PTT);
        kto.setParametar(ptt);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (Mesto) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
    }

    

    public boolean dodajMesto(Mesto m) throws Exception {

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_MESTO);
        kto.setParametar(m);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }

    }

    public List<Prostorija> vratiListuProstorija() throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_PROSTORIJE);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Prostorija>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
       
    }

    public boolean sacuvajRezervaciju(Rezervacija r) throws Exception {

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_REZERVACIJU);
        kto.setParametar(r);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }

    }

    public List<Rezervacija> vratiListuRezervacija() throws Exception {

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_REZERVACIJE);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Rezervacija>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
    }

    public Administrator ulogujAdministratora(Administrator a) throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_ULOGUJ_ADMINISTRATORA);
        kto.setParametar(a);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (Administrator) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
    }

    public boolean updateRezervacije(Rezervacija r) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_AZURIRAJ_REZERVACIJU);
        kto.setParametar(r);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return sto.isSacuvan();
        } else {
            throw new Exception(sto.getGreska());
        }
    }

    public boolean izbrisiKorisnika(Korisnik k) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_OBRISI_KORISNIKA);
        kto.setParametar(k);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return sto.isSacuvan();
        } else {
            throw new Exception(sto.getGreska());
        }
    }

    public boolean izbrisiRezervaciju(Rezervacija r) throws Exception {
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_OBRISI_REZERVACIJU);
        kto.setParametar(r);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return sto.isSacuvan();
        } else {
            throw new Exception(sto.getGreska());
        }
        
    }

    public boolean izlogujAdministratora(Administrator admin) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_IZLOGUJ_ADMINISTRATORA);
        kto.setParametar(admin);
        Komunikacija.vratiInstancu().posaljiZahtev(kto);
        
        ServerTransferObjekat sto = Komunikacija.vratiInstancu().procitajOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return sto.isSacuvan();
        } else {
            throw new Exception(sto.getGreska());
        }
    }
    

}
