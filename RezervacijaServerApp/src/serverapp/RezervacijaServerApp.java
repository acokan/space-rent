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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class RezervacijaServerApp {


//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        RezervacijaServerApp rsa = new RezervacijaServerApp();
//        rsa.pokreniServer();
//
//    }
//
//    private void pokreniServer() throws IOException, ClassNotFoundException {
//
//        ServerSocket ss = new ServerSocket(9010);
//        System.out.println("Server je pokrenut!");
//
//        while (true) {
//            Socket soket = ss.accept();
//            System.out.println("Klijent se povezao!");
//            NitKlijent nitKlijent = new NitKlijent(soket);
//        }
//
//    }

}
