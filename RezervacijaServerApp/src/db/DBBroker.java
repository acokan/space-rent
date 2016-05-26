/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class DBBroker {
    
    private Connection connection;
    private static DBBroker instanca;
    
    public DBBroker() {
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
    
    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + odo.vratiVrednostiZaInsert();
        System.out.println(upit);
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        
    }
    
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException {
        
        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiListu(rs);
    }
    
    public void azuriraj(OpstiDomenskiObjekat odo) throws SQLException {
        
    }
    
    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        
    }
    
    public void vrati(OpstiDomenskiObjekat odo) throws SQLException {
        
    }
    
    public void vratiPoUslovu(OpstiDomenskiObjekat odo) throws SQLException {
        
    }
    
}
