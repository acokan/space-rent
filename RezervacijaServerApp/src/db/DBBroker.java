/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class DBBroker {

    private Connection connection;
    private static DBBroker instanca;

    public DBBroker() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            System.out.println(System.getProperty("user.home"));
            String prop = System.getProperty("user.home") + "\\props.properties";
            
            input = new FileInputStream(prop);
            props.load(input);
            
            String prefix = props.getProperty("prefix");
            System.out.println("Prefiks: "+prefix);
            Class.forName(props.getProperty(prefix+"_driver"));
            System.out.println("Driver je ucitan");
            String url = props.getProperty(prefix+"_url");
            String korisnickoIme = props.getProperty(prefix+"_korisnickoIme");
            String sifra = props.getProperty(prefix+"_sifra");
            connection = DriverManager.getConnection(url, korisnickoIme, sifra);
            connection.setAutoCommit(false);
            System.out.println("Konekcija je uspostavljena");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public static DBBroker vratiInstancu() {
        if (instanca == null) {
            instanca = new DBBroker();
        }
        return instanca;
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

    public OpstiDomenskiObjekat sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {

        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + odo.vratiVrednostiZaInsert();
        System.out.println(upit);
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        st.close();
        return odo;

    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws SQLException {

        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            String upit = "SELECT * FROM " + odo.vratiNazivTabele();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            lista = odo.vratiListu(rs);
            st.close();
            System.out.println("Vrati sve upit izvrsen! " + upit);
            return lista;
        } catch (SQLException ex) {
            System.out.println("Vrati sve upit nije izvrsen!");
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public OpstiDomenskiObjekat vratiObjekatPoKljucu(OpstiDomenskiObjekat odo, int id) throws SQLException {

        String upit = "";

        if (odo.vratiPK() != null) {
            upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiPK() + " = " + id;
            System.out.println(upit);
        } else {
            upit = "SELECT * FROM " + odo.vratiNazivTabele() + odo.vratiSlozenPK();
        }

        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = odo.vratiListu(rs);
        st.close();
        System.out.println("Vrati objekat po kljucu upit izvrsen!");
        return lista.get(0);

    }

    public OpstiDomenskiObjekat sacuvajIliAzurirajObjekat(OpstiDomenskiObjekat odo) throws SQLException {

        String upit = "";
        List<OpstiDomenskiObjekat> listaObjekata = vratiSveObjekte(odo);
        System.out.println("Lista obj " + listaObjekata);

        if (!listaObjekata.contains(odo)) {
            upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + odo.vratiVrednostiZaInsert();
            System.out.println("Insert upit je izvrsen: " + upit);
        } else if (odo.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            upit = "DELETE FROM " + odo.vratiNazivTabele() + odo.vratiSlozenPK();
            System.out.println("Delete upit: " + upit);
        } else if (odo.vratiPK() != null) {
            upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiPK() + " = " + odo.vratiVrednostPK();
            System.out.println("Update upit sa primarnim kljucem: " + upit);
        } else {
            upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + odo.vratiSlozenPK();
            System.out.println("Update upit sa slozenim primarnim kljucem: " + upit);
        }

        Statement s = connection.createStatement();
        s.executeUpdate(upit);
        s.close();
        return odo;
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {

        String upit = "";

        if (odo.vratiPK() != null) {
            upit = "DELETE FROM " + odo.vratiNazivTabele()+ " WHERE " + odo.vratiPK()+ "=" + odo.vratiVrednostPK();
        } else {
            upit = "DELETE FROM " + odo.vratiNazivTabele() + odo.vratiSlozenPK();
        }

        Statement s = (Statement) connection.createStatement();
        s.executeUpdate(upit);
        potvrdiTransakciju();
        s.close();
        
    }

    public void sacuvajObjekte(List<OpstiDomenskiObjekat> lista) throws SQLException {
        for (OpstiDomenskiObjekat odo : lista) {
            sacuvajIliAzurirajObjekat(odo);
        }
    }

}
