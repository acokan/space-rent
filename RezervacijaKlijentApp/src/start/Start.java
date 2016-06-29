/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.korisnik.FmGlavna;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class Start extends Thread {

    @Override
    public void run() {
        try {
            Socket soket = new Socket("127.0.0.1", 9010);
            Komunikacija.vratiInstancu().setSoket(soket);
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        FmGlavna fmg = new FmGlavna();
        fmg.setVisible(true);
        
    }
    
}
