/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.FmGlavna;
import java.io.IOException;
import java.net.Socket;
import korisnici.kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class Start {
    
    public static void main(String[] args) throws IOException {
        
        Socket soket = new Socket("127.0.0.1", 9010);
        Kontroler.vratiInstancuKontrolera().getSesija().put(util.Util.MAP_KEY_SOKET, soket);
        FmGlavna fmg = new FmGlavna();
        fmg.setVisible(true);
        
    }
    
}
