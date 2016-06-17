/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjekti;

import java.io.Serializable;

/**
 *
 * @author Aco Kandic
 */
public class ServerTransferObjekat implements Serializable {
    
    private int status;
    private Object rezultat;
    private String greska;
    private boolean sacuvan;

    public ServerTransferObjekat(int status, Object rezultat, String greska, boolean sacuvan) {
        this.status = status;
        this.rezultat = rezultat;
        this.greska = greska;
        this.sacuvan = sacuvan;
    }
    
    public ServerTransferObjekat() {
    }


    public String getGreska() {
        return greska;
    }

    public void setGreska(String greska) {
        this.greska = greska;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public boolean isSacuvan() {
        return sacuvan;
    }

    public void setSacuvan(boolean sacuvan) {
        this.sacuvan = sacuvan;
    }
    
}
