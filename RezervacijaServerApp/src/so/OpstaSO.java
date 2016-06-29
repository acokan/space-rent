/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
/**
 *
 * @author Aco Kandic
 */
public abstract class OpstaSO {
 
    public void izvrsiOpstuSO() throws Exception {
    
        try {
            proveriPreduslov();
            izvrsiKonkretnuOperaciju();
            potvrdi();
        } catch (Exception ex) {
            ponisti();
            throw new Exception("Greska kod izvrsenje sistemske operacije: "+ex.getMessage());
        }
        
    }

    protected void proveriPreduslov() throws Exception {};
    protected abstract void izvrsiKonkretnuOperaciju() throws Exception;
    
    private void potvrdi() throws Exception {
        DBBroker.vratiInstancu().potvrdiTransakciju();
    }
    private void ponisti() throws Exception {
        DBBroker.vratiInstancu().ponistiTransakciju();
    }
    
}
