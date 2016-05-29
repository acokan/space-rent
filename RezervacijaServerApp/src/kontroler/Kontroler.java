/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.SOUcitajAdministratore;
import so.SOUlogujAdministratora;

/**
 *
 * @author Aco Kandic
 */
public class Kontroler {

    private static Kontroler instanca;
    private List<OpstiDomenskiObjekat> listaAktivnihAdmina;

    public List<OpstiDomenskiObjekat> getListaAktivnihAdmina() {
        return listaAktivnihAdmina;
    }

    public void setListaAktivnihAdmina(List<OpstiDomenskiObjekat> listaAktivnihAdmina) {
        this.listaAktivnihAdmina = listaAktivnihAdmina;
    }

    private Kontroler() {
         listaAktivnihAdmina = new ArrayList<>();
    }

    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<OpstiDomenskiObjekat> vratiListuAdministratora() throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        SOUcitajAdministratore soua = new SOUcitajAdministratore();
        soua.izvrsiOpstuSO(new Administrator());
        return soua.getListaAdmina();
    }

    public OpstiDomenskiObjekat ulogujAdministratora(Administrator a) throws Exception {
        SOUlogujAdministratora soul = new SOUlogujAdministratora(a);
        soul.izvrsiOpstuSO(a);
        listaAktivnihAdmina.add(a);
        return soul.vratiAdmina();
    }

}
