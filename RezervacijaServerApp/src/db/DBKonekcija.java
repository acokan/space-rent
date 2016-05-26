/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Korisnik;
import domen.Mesto;
import domen.Prostorija;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class DBKonekcija {

    Connection connection;

    public DBKonekcija() {
    }

    public void uspostaviKonekciju() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan!");
            String url = Util.url;
            String username = Util.username;
            String password = Util.password;
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            System.out.println("Konekcija je uspostavljena!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver ne postoji: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void raskiniKonekciju() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
        System.out.println("Konekcija je raskinuta!");
    }

    public void potvrdiTransakciju() throws SQLException {
        connection.commit();
    }

    public void ponistiTransakciju() throws SQLException {
        connection.rollback();
    }

    public void sacuvajKorisnika(Korisnik korisnik) throws SQLException {
        uspostaviKonekciju();
        String upit = "INSERT INTO korisnik (Ime, Prezime, DatumRodjenja, Kontakt, Mail, Ulica, Broj, Ptt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setString(1, korisnik.getIme());
        ps.setString(2, korisnik.getPrezime());
        ps.setDate(3, new Date(korisnik.getDatumRodjenja().getTime()));
        ps.setString(4, korisnik.getKontakt());
        ps.setString(5, korisnik.getMail());
        ps.setString(6, korisnik.getUlica());
        ps.setString(7, korisnik.getBroj());
        ps.setInt(8, korisnik.getMesto().getPtt());
        ps.executeUpdate();
        
        potvrdiTransakciju();
        System.out.println("Upit je izvrsen!");
        ps.close();
        raskiniKonekciju();
    }

    public void updateKorisnika(Korisnik korisnik) throws SQLException {
        uspostaviKonekciju();
        String upit = "UPDATE korisnik SET Ime=?, Prezime=?, DatumRodjenja=?, Kontakt=?, Mail=?, Ulica=?, Broj=?, Ptt=? WHERE Ime=? AND Prezime=?";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setString(1, korisnik.getIme());
        ps.setString(2, korisnik.getPrezime());
        ps.setDate(3, new Date(korisnik.getDatumRodjenja().getTime()));
        ps.setString(4, korisnik.getKontakt());
        ps.setString(5, korisnik.getMail());
        ps.setString(6, korisnik.getUlica());
        ps.setString(7, korisnik.getBroj());
        ps.setInt(8, korisnik.getMesto().getPtt());
        ps.setString(9, korisnik.getIme());
        ps.setString(10, korisnik.getPrezime());
        ps.executeUpdate();
        potvrdiTransakciju();
        System.out.println("Upit je izvrsen!");
        ps.close();
        raskiniKonekciju();
    }

    public List<Mesto> vratiListuMesta() throws Exception {
        uspostaviKonekciju();
        List<Mesto> listaMesta = new ArrayList<>();
        String upit = "SELECT * FROM mesto";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            int ptt = rs.getInt("Ptt");
            String naziv = rs.getString("naziv");
            Mesto m = new Mesto(ptt, naziv);
            listaMesta.add(m);
        }
        potvrdiTransakciju();
        s.close();
        raskiniKonekciju();
        return listaMesta;
    }

    public Mesto vratiMesto(int ptt) throws ClassNotFoundException, SQLException {
        
        uspostaviKonekciju();
        
        String upit = "SELECT * FROM mesto WHERE ptt=?";
        Mesto m = null;
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, ptt);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            m = new Mesto();
            m.setPtt(rs.getInt(1));
            m.setNaziv(rs.getString(2));
        }
        potvrdiTransakciju();
        ps.close();
        raskiniKonekciju();
        return m;
        
    }

    public List<Korisnik> vratiListuKorisnika() throws Exception {
        uspostaviKonekciju();
        
        List<Korisnik> listaKorisnika = new ArrayList<>();

        String upit = "SELECT * FROM korisnik JOIN mesto ON korisnik.ptt = mesto.ptt";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);

        while (rs.next()) {
            int korisnikID = rs.getInt("KorisnikID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            Date datumR = rs.getDate("DatumRodjenja");
            String kontakt = rs.getString("Kontakt");
            String mail = rs.getString("Mail");
            String ulica = rs.getString("Ulica");
            String broj = rs.getString("Broj");
            int ptt = rs.getInt("Ptt");
            String naziv = rs.getString("Naziv");

            Korisnik k = new Korisnik();
            k.setKorisnikID(korisnikID);
            k.setIme(ime);
            k.setPrezime(prezime);
            k.setDatumRodjenja(datumR);
            k.setKontakt(kontakt);
            k.setMail(mail);
            k.setUlica(ulica);
            k.setBroj(broj);

            Mesto m = new Mesto();
            m.setPtt(ptt);
            m.setNaziv(naziv);
            k.setMesto(m);

            listaKorisnika.add(k);
        }
        potvrdiTransakciju();
        s.close();
        raskiniKonekciju();
        return listaKorisnika;
    }


    public List<Korisnik> vratiListuKorisnikaPoMestu(Mesto mesto) throws SQLException {
        uspostaviKonekciju();
        
        List<Korisnik> listaKorisnika = new ArrayList<>();

        String upit = "SELECT * FROM korisnik JOIN mesto ON korisnik.ptt = mesto.ptt WHERE mesto.ptt=? AND mesto.naziv=?";
        PreparedStatement ps = connection.prepareStatement(upit);
        
        ps.setInt(1, mesto.getPtt());
        ps.setString(2, mesto.getNaziv());
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int korisnikID = rs.getInt("KorisnikID");
            String ime = rs.getString("Ime");
            String pr = rs.getString("Prezime");
            Date datumR = rs.getDate("DatumRodjenja");
            String kontakt = rs.getString("Kontakt");
            String mail = rs.getString("Mail");
            String ulica = rs.getString("Ulica");
            String broj = rs.getString("Broj");
            int ptt = rs.getInt("Ptt");
            String naziv = rs.getString("Naziv");

            Korisnik k = new Korisnik();
            k.setKorisnikID(korisnikID);
            k.setIme(ime);
            k.setPrezime(pr);
            k.setDatumRodjenja(datumR);
            k.setKontakt(kontakt);
            k.setMail(mail);
            k.setUlica(ulica);
            k.setBroj(broj);

            Mesto m = new Mesto();
            m.setPtt(ptt);
            m.setNaziv(naziv);
            k.setMesto(m);

            listaKorisnika.add(k);
        }
        potvrdiTransakciju();
        ps.close();
        raskiniKonekciju();
        return listaKorisnika;
    }

    public void dodajMesto(Mesto m) throws SQLException {
        uspostaviKonekciju();
        
        String upit = "INSERT INTO mesto(ptt, naziv) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, m.getPtt());
        ps.setString(2, m.getNaziv());
        ps.executeUpdate();
        potvrdiTransakciju();
        System.out.println("Upit je izvrsen!");
        ps.close();
        raskiniKonekciju();
    }

    public List<Prostorija> vratiListuProstorija() throws SQLException {
        uspostaviKonekciju();
        List<Prostorija> listaProstorija = new ArrayList<>();
        String upit = "SELECT * FROM prostorija";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while (rs.next()) {
            int prostorijaID = rs.getInt("ProstorijaID");
            String naziv = rs.getString("NazivProstorije");
            int kapacitet = rs.getInt("Kapacitet");
            double cena = rs.getDouble("Cena");
            Prostorija p = new Prostorija(prostorijaID, naziv, kapacitet, cena);
            listaProstorija.add(p);
        }
        potvrdiTransakciju();
        s.close();
        raskiniKonekciju();
        return listaProstorija;
    }

    public void sacuvajRezervaciju(Rezervacija r) throws SQLException {
        uspostaviKonekciju();
        String upit = "INSERT INTO rezervacija(RezervacijaID, DatumRezervacije, KorisnikID) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, r.getRezervacijaID());
        ps.setDate(2, new java.sql.Date(r.getDatumRezervacije().getTime()));
        ps.setInt(3, r.getKorisnik().getKorisnikID());
        ps.executeUpdate();
        potvrdiTransakciju();
        System.out.println("Upit je izvrsen!");
        ps.close();
        raskiniKonekciju();
    }

    public void sacuvajStavkeRezervacije(StavkaRezervacije sr) throws SQLException {
        uspostaviKonekciju();
        String upit = "INSERT INTO stavkarezervacije(RezervacijaID, RedniBrojStavke, VremeOd, VremeDo, Iznos, ProstorijaID) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, sr.getRezervacija().getRezervacijaID());
        ps.setInt(2, sr.getRedniBrojStavke());
        ps.setTime(3, new Time(sr.getVremeOd().toSecondOfDay()*1000-3600000));
        ps.setTime(4, new Time(sr.getVremeDo().toSecondOfDay()*1000-3600000));
        ps.setDouble(5, sr.getIznos());
        ps.setInt(6, sr.getProstorija().getProstorijaID());
        ps.executeUpdate();
        potvrdiTransakciju();
        System.out.println("Upit je izvrsen!");
        ps.close();
        raskiniKonekciju();
    }

    public List<Rezervacija> vratiListuRezervacija() throws SQLException {
        uspostaviKonekciju();
        
        List<Rezervacija> listaRezervacija = new ArrayList<>();
        String upit = "SELECT * FROM rezervacija";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);    
        while (rs.next()) {
            int rezervacijaID = rs.getInt("RezervacijaID");
            Date datumR = rs.getDate("DatumRezervacije");
            int korisnikID = rs.getInt("KorisnikID");
            Rezervacija r = new Rezervacija(rezervacijaID, datumR, new Korisnik(0, "", "", null, "", "", "", "", null), new ArrayList<>());
            listaRezervacija.add(r);
        }
        potvrdiTransakciju();
        s.close();
        raskiniKonekciju();
        return listaRezervacija;
    }

}
