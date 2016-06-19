/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Administrator;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Prostorija;
import domen.Rezervacija;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import kontroler.Kontroler;
import model.TblAdministratori;
import so.SOAzurirajKorisnika;
import so.SOZapamtiSveKorisnike;
import so.OpstaSO;
import so.SOUlogujAdministratora;
import so.SOVratiSvaMesta;
import so.SOZapamtiKorisnika;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class NitKlijent extends Thread {

    Socket soket;
    List<NitKlijent> listaKlijenata;
    List<OpstiDomenskiObjekat> listaAktivnihAdministratora;
    JTable jtblAdministratori;
    ObjectInputStream in;
    ObjectOutputStream out;

    public NitKlijent(Socket soket, List<NitKlijent> listaKlijenata, List<OpstiDomenskiObjekat> listaAktivnihAdministratora, JTable jtblAdministratori) {
        this.soket = soket;
        this.listaKlijenata = listaKlijenata;
        this.listaAktivnihAdministratora = listaAktivnihAdministratora;
        this.jtblAdministratori = jtblAdministratori;
    }

    public Socket getSoket() {
        return soket;
    }

    public List<NitKlijent> getListaKlijenata() {
        return listaKlijenata;
    }

    @Override
    public void run() {
        System.out.println("Kijent thread pokrenut!");

        try {

            in = new ObjectInputStream(soket.getInputStream());
            out = new ObjectOutputStream(soket.getOutputStream());

            while (true) {

                ServerTransferObjekat sto = new ServerTransferObjekat();
                KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();
                int operacija = kto.getOperacija();

                switch (operacija) {

                    case util.Util.OPERACIJA_SACUVAJ_KORISNIKA: {
                        try {
                            OpstiDomenskiObjekat k = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().zapamtiKorisnika(k);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_AZURIRAJ_KORISNIKA: {
                        try {
                            OpstiDomenskiObjekat korisnik = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().azurirajKorisnika(korisnik);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_OBRISI_KORISNIKA: {
                        try {
                            OpstiDomenskiObjekat korisnik = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().obrisiKorisnika(korisnik);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setSacuvan(true);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            sto.setSacuvan(false);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_SACUVAJ_SVE_KORISNIKE: {
                        List<OpstiDomenskiObjekat> lk = (List<OpstiDomenskiObjekat>) kto.getParametar();
                        try {
                            Kontroler.vratiInstancuKontrolera().zapamtiSveKorisnike(lk);
                            sto.setSacuvan(true);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            sto.setSacuvan(false);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVE_KORISNIKE: {
                        try {
                            List<OpstiDomenskiObjekat> listaKorisnika = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaKorisnika);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_SACUVAJ_MESTO: {
                        try {
                            OpstiDomenskiObjekat m = (Mesto) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().sacuvajMesto(m);
                            sto.setSacuvan(true);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setSacuvan(false);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVA_MESTA: {
                        try {
                            List<OpstiDomenskiObjekat> listaMesta = Kontroler.vratiInstancuKontrolera().vratiSvaMesta();
                            sto.setRezultat(listaMesta);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVE_PROSTORIJE: {
                        try {
                            List<OpstiDomenskiObjekat> listaProstorija = Kontroler.vratiInstancuKontrolera().vratiListuProstorija();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaProstorija);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_SACUVAJ_REZERVACIJU: {

                        try {
                            OpstiDomenskiObjekat rezervacija = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().sacuvajRezervaciju(rezervacija);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_OBRISI_REZERVACIJU: {
                        try {
                            OpstiDomenskiObjekat rezervacija = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().obrisiRezervaciju(rezervacija);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setSacuvan(true);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            sto.setSacuvan(false);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_AZURIRAJ_REZERVACIJU: {

                        try {
                            OpstiDomenskiObjekat rezervacija = (OpstiDomenskiObjekat) kto.getParametar();
                            Kontroler.vratiInstancuKontrolera().azurirajRezervaciju(rezervacija);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setSacuvan(true);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            sto.setSacuvan(false);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVE_REZERVACIJE: {

                        try {
                            List<OpstiDomenskiObjekat> listaRezervacija = Kontroler.vratiInstancuKontrolera().vratiSveRezervacije();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaRezervacija);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_ULOGUJ_ADMINISTRATORA: {

                        try {
                            OpstiDomenskiObjekat admin = Kontroler.vratiInstancuKontrolera().ulogujAdministratora((OpstiDomenskiObjekat) kto.getParametar());

                            listaAktivnihAdministratora.add(admin);
                            jtblAdministratori.setModel(new TblAdministratori(listaAktivnihAdministratora));

                            sto.setRezultat((Administrator) admin);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        System.out.println(sto.getRezultat());
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_IZLOGUJ_ADMINISTRATORA: {

                        try {
                            OpstiDomenskiObjekat a = Kontroler.vratiInstancuKontrolera().izlogujAdministratora((OpstiDomenskiObjekat) kto.getParametar());
                            System.out.println("Nit klijent izloguj: "+a);
                            listaAktivnihAdministratora.remove(a);
                            jtblAdministratori.setModel(new TblAdministratori(listaAktivnihAdministratora));
                            sto.setSacuvan(true);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            sto.setSacuvan(false);
                        }
                        out.writeObject(sto);
                    }
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
