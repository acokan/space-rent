/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import db.DBKonekcija;
import domen.Korisnik;
import domen.Mesto;
import domen.Prostorija;
import domen.Rezervacija;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class NitKlijent extends Thread {

    Socket soket;
//    List<NitKlijent> listaKlijenata;

    public NitKlijent(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {

        try {

            db.DBKonekcija dbKonekcija = new DBKonekcija();

            while (true) {

                ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
                KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();

                int operacija = kto.getOperacija();

                switch (operacija) {
                    case util.Util.OPERACIJA_SACUVAJ_KORISNIKA:
                        Korisnik k = (Korisnik) kto.getParametar();
                         {
                            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                            ServerTransferObjekat sto = new ServerTransferObjekat();
                            try {
                                dbKonekcija.sacuvajKorisnika(k);
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            } catch (Exception ex) {
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                                sto.setGreska(ex.getMessage());
                                Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out.writeObject(sto);
                        }
                        break;

                    case util.Util.OPERACIJA_AZURIRAJ_KORISNIKA:
                        Korisnik korisnik = (Korisnik) kto.getParametar();
                         {
                            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                            ServerTransferObjekat sto = new ServerTransferObjekat();
                            try {
                                dbKonekcija.updateKorisnika(korisnik);
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            } catch (Exception ex) {
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                                sto.setGreska(ex.getMessage());
                                Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out.writeObject(sto);
                        }
                        break;

                    case util.Util.OPERACIJA_SACUVAJ_SVE_KORISNIKE:
                        List<Korisnik> lk = (List<Korisnik>) kto.getParametar();
                         {
                            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                            ServerTransferObjekat sto = new ServerTransferObjekat();
                            try {
                                for (Korisnik kor : lk) {
                                    dbKonekcija.sacuvajKorisnika(kor);
                                }
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            } catch (Exception ex) {
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                                sto.setGreska(ex.getMessage());
                                Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out.writeObject(sto);
                        }
                        break;

                    case util.Util.OPERACIJA_VRATI_SVE_KORISNIKE: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            List<Korisnik> listaKorisnika = dbKonekcija.vratiListuKorisnika();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaKorisnika);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVE_KORISNIKE_PO_MESTU: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            List<Korisnik> listaKorisnika = dbKonekcija.vratiListuKorisnikaPoMestu((Mesto) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaKorisnika);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_SVA_MESTA: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            List<Mesto> listaMesta = dbKonekcija.vratiListuMesta();
                            System.out.println(listaMesta);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaMesta);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_VRATI_MESTO_PO_PTT: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Mesto mesto = dbKonekcija.vratiMesto((int) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(mesto);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_SACUVAJ_MESTO:
                        Mesto m = (Mesto) kto.getParametar();
                         {
                            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                            ServerTransferObjekat sto = new ServerTransferObjekat();
                            try {
                                dbKonekcija.dodajMesto(m);
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            } catch (Exception ex) {
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                                sto.setGreska(ex.getMessage());
                                Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out.writeObject(sto);
                        }
                        break;

                    case util.Util.OPERACIJA_VRATI_SVE_PROSTORIJE: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            List<Prostorija> listaProstorija = dbKonekcija.vratiListuProstorija();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaProstorija);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;
                    
                    case util.Util.OPERACIJA_VRATI_SVE_REZERVACIJE: {
                        ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            List<Rezervacija> listaRezervacija = dbKonekcija.vratiListuRezervacija();
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(listaRezervacija);
                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }
                    break;

                    case util.Util.OPERACIJA_SACUVAJ_REZERVACIJU:
                        Rezervacija r = (Rezervacija) kto.getParametar();
                         {
                            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
                            ServerTransferObjekat sto = new ServerTransferObjekat();
                            try {
                                dbKonekcija.sacuvajRezervaciju(r);
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            } catch (Exception ex) {
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                                sto.setGreska(ex.getMessage());
                                Logger.getLogger(RezervacijaServerApp.class.getName()).log(Level.SEVERE, null, ex);
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
