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

        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);
        
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_KORISNIKA);
        kto.setParametar(k);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }
   
    }

    public void updateKorisnika(Korisnik k) throws Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);
        
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_AZURIRAJ_KORISNIKA);
        kto.setParametar(k);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            dbk.updateKorisnika(k);
//            dbk.potvrdiTransakciju();
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            System.out.println("Greska prilikom azuriranja novog korisnika: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
    }
    
    public boolean sacuvajListuKorisnika(List<Korisnik> lk) throws Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);
        
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_SVE_KORISNIKE);
        kto.setParametar(lk);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        boolean sacuvana = false;
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//        try {
//            for (Korisnik korisnik : lk) {
//                dbk.sacuvajKorisnika(korisnik);
//            }
//            dbk.potvrdiTransakciju();
//            sacuvana = true;
//        } catch (SQLException e) {
//            dbk.ponistiTransakciju();
//            sacuvana = false;
//            System.out.println("Greska prilikom cuvanja liste korisnika: " + e.getMessage());
//        }
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//
//        }
//        return sacuvana;
    }

    public List<Korisnik> vratiListuKorisnika() throws IOException, ClassNotFoundException, Exception {

        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_KORISNIKE);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Korisnik>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        List<Korisnik> listaKorisnika = new ArrayList<>();
//
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            listaKorisnika = dbk.vratiListuKorisnika();
//            dbk.potvrdiTransakciju();
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            System.out.println("Greska prilikom pretrage korisnika: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
//
//        return listaKorisnika;
    }

    
    public List<Korisnik> vratiListuKorisnikaPoMestu(Mesto mesto) throws IOException, ClassNotFoundException, Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_KORISNIKE_PO_MESTU);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Korisnik>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        List<Korisnik> listaKorisnika = new ArrayList<>();
//
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            listaKorisnika = dbk.vratiListuKorisnikaPoMestu(mesto);
//            dbk.potvrdiTransakciju();
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            System.out.println("Greska prilikom pretrage korisnika: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
//
//        return listaKorisnika;
    }

    public List<Mesto> vratiListuMesta() throws IOException, ClassNotFoundException, Exception {

        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVA_MESTA);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Mesto>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }

    }

    public Mesto vratiMesto(int ptt) throws IOException, ClassNotFoundException, Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_MESTO_PO_PTT);
        kto.setParametar(ptt);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (Mesto) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        Mesto m = null;
//
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            m = dbk.vratiMesto(ptt);
//            dbk.potvrdiTransakciju();
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            System.out.println("Greska prilikom pretrage mesta: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
//
//        return m;
    }

    

    public boolean dodajMesto(Mesto m) throws Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);
        
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_MESTO);
        kto.setParametar(m);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        boolean dodat = false;
//
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            dbk.dodajMesto(m);
//            dbk.potvrdiTransakciju();
//            dodat = true;
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            dodat = false;
//            System.out.println("Greska prilikom cuvanja novog korisnika: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
//
//        return dodat;
    }

    public List<Prostorija> vratiListuProstorija() throws Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_PROSTORIJE);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Prostorija>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
//        List<Prostorija> listaProstorija = new ArrayList<>();
//
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//
//        try {
//            listaProstorija = dbk.vratiListuProstorija();
//            dbk.potvrdiTransakciju();
//        } catch (Exception e) {
//            dbk.ponistiTransakciju();
//            System.out.println("Greska prilikom pretrage mesta: " + e.getMessage());
//        }
//
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//        }
//
//        return listaProstorija;
    }

    public boolean sacuvajRezervaciju(Rezervacija r) throws Exception {

        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);
        
        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_REZERVACIJU);
        kto.setParametar(r);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return true;
        } else {
            throw new Exception(sto.getGreska());
        }

//        boolean sacuvana = false;
//        try {
//            dbk.uspostaviKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom konekcije na bazu: " + e.getMessage());
//        }
//        try {
//            dbk.sacuvajRezervaciju(r);
//            for (StavkaRezervacije sr : r.getListaStavki()) {
//                dbk.sacuvajStavkeRezervacije(sr);
//            }
//            dbk.potvrdiTransakciju();
//            sacuvana = true;
//        } catch (SQLException e) {
//            dbk.ponistiTransakciju();
//            sacuvana = false;
//            System.out.println("Greska prilikom cuvanja rezervacije: " + e.getMessage());
//        }
//        try {
//            dbk.raskiniKonekciju();
//        } catch (Exception e) {
//            System.out.println("Greska prilikom raskidanja konekcije sa bazom: " + e.getMessage());
//
//        }
//        return sacuvana;
    }

    public List<Rezervacija> vratiListuRezervacija() throws Exception {
        
        Socket soket = (Socket) getSesija().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
        
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVE_REZERVACIJE);
        out.writeObject(kto);
        
        ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<Rezervacija>) sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
    }
    

}
