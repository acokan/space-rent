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
public class KlijentTransferObjekat implements Serializable {
    
    private int operacija;
    private Object parametar;

    public KlijentTransferObjekat() {
    }

    public KlijentTransferObjekat(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
}
