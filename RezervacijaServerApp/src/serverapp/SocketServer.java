/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import niti.NitKlijent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class SocketServer extends Thread {

    private ServerSocket ss;
    private int brojPorta;
    public static List<NitKlijent> listaKlijenata = new ArrayList<>();
    public static boolean izvrsavaSe = true;

    public SocketServer(int brPorta) {
        brojPorta = brPorta;

        try {
            ss = new ServerSocket(brojPorta);
            System.out.println("Server soket je kreiran! Server je pokrenut!");
            
        } catch (Exception e) {
            System.out.println("Neuspesno kreiranje serveskog soketa");
            e.printStackTrace();
        }

    }

    
    @Override
    public void run() {

        while (izvrsavaSe) {
            try {
                Socket soket = ss.accept();
                
                System.out.println("Klijent se povezao!");
                NitKlijent nitKlijent = new NitKlijent(soket);
                nitKlijent.start();
                
//                int i = listaKlijenata.size() + 1;
                
//                listaKlijenata.add(nitKlijent);
//                System.out.println(listaKlijenata);

//                System.out.println("Klijent broj " +  " se povezao!");

            } catch (Exception e) {
                System.out.println("Nije moguce prihvatiti klijenta!");
            }
        }

    }
    
    public void zaustaviServer() {
        try {
            ss.close();
        } catch (Exception ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server nije pokrenut!");
    }
}
