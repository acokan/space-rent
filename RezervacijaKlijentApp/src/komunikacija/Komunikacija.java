/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transferobjekti.KlijentTransferObjekat;
import transferobjekti.ServerTransferObjekat;

/**
 *
 * @author Aco Kandic
 */
public class Komunikacija {
    
    private static Komunikacija instanca;
    Socket soket;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    public static Komunikacija vratiInstancu() {
        if (instanca == null) {
            instanca = new Komunikacija(); 
        }
        return instanca;
    }

    public void setSoket(Socket soket) throws IOException {
        this.soket = soket;
        out = new ObjectOutputStream(this.soket.getOutputStream());
        in = new ObjectInputStream(this.soket.getInputStream());
    }
    
    public void posaljiZahtev(KlijentTransferObjekat kto) throws IOException {
        out.writeObject(kto);
    }
    
    public ServerTransferObjekat procitajOdgovor() throws IOException, ClassNotFoundException {
        return (ServerTransferObjekat) in.readObject();
    }
    
    
    
}
