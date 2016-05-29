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
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aco Kandic
 */
public class SocketServer extends Thread {

    private ServerSocket ss;
    private int brojPorta;
    public static List<NitKlijent> listaKlijenata = new ArrayList<>();
    public static boolean izvrsavaSe = false;

    public SocketServer(int brPorta) {
        
        brojPorta = brPorta;

        try {
            ss = new ServerSocket(brojPorta);
            System.out.println("Server soket je kreiran na portu: "+brojPorta);

        } catch (Exception e) {
            System.out.println("Neuspesno kreiranje serveskog soketa");
            e.printStackTrace();
        }

    }
    
    public ServerSocket getServerSocket() {
        return ss;
    }

    public static boolean isIzvrsavaSe() {
        return izvrsavaSe;
    }

    public static void setIzvrsavaSe(boolean izvrsavaSe) {
        SocketServer.izvrsavaSe = izvrsavaSe;
    }
    

    @Override
    public void run() {

        try {
            upravljajKlijentima();
        } catch (SocketException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Server je zaustavljen!", "Soketi zatvoreni", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void zaustaviNiti() {
        try {
            ss.close();
            
            for (NitKlijent nitKlijent : listaKlijenata) {
                nitKlijent.getSoket().close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server nije pokrenut!");
    }

    private void upravljajKlijentima() throws SocketException {
        
        while (!isInterrupted()) {
            try {
                Socket soket = ss.accept();

                NitKlijent nitKlijent = new NitKlijent(soket, listaKlijenata);
                nitKlijent.start();
                
                listaKlijenata.add(nitKlijent);
                int i = listaKlijenata.size() + 1;
                System.out.println("Klijent broj " + i + " se povezao!");

                System.out.println("Lista niti " + listaKlijenata);

            } catch (SocketException e) {
                System.out.println("Server se gasi...");
                throw e;
            } catch (IOException ex) {
                System.out.println("Klijent ne moze da se poveze...");
            }
        }
        
       
    }
    
    
}
