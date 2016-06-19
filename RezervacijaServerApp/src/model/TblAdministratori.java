/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aco Kandic
 */
public class TblAdministratori extends AbstractTableModel {

    private List<OpstiDomenskiObjekat> listaAdministratora;

    public TblAdministratori(List<OpstiDomenskiObjekat> listaAdministratora) {
        this.listaAdministratora = listaAdministratora;
    }

    @Override
    public int getRowCount() {
        if (listaAdministratora == null) {
            return 0;
        }
        return listaAdministratora.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Administrator a = (Administrator) listaAdministratora.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return a.getIme();
            case 1:
                return a.getPrezime();
            case 2:
                return a.getKorisnickoIme();
            case 3:
                return a.getUlogovan();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "Prezime";
            case 2:
                return "Korisnicko ime";
            case 3:
                return "Status";

            default:
                return "n/a";
        }
    }

    public List<OpstiDomenskiObjekat> getListaAdministratora() {
        return listaAdministratora;
    }
    
    public OpstiDomenskiObjekat vratiAdmina(int selektovani) {
        OpstiDomenskiObjekat odo = null;
        for (int i = 0; i < listaAdministratora.size(); i++) {
            if (i == selektovani) {
                odo = listaAdministratora.get(i);
            }
        }
        return odo;
    }


    
}
