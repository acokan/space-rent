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

    public TblAdministratori(List<OpstiDomenskiObjekat> listaKorisnika) {
        this.listaAdministratora = listaKorisnika;
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Administrator a = (Administrator) listaAdministratora.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return a.getKorisnickoIme();
            case 1:
                return a.getSifra();
//            case 2:
//                return a.getStatus();
//            case 3:
//                return k.getPassword();
//            case 4:
//                return k.getStatusText();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Korisnicko ime";
            case 1:
                return "Sifra";
//            case 2:
//                return "Status";
//            case 3:
//                return "Password";
//            case 4:
//                return "Status";
            default:
                return "n/a";
        }
    }

    public List<OpstiDomenskiObjekat> getListaKorisnika() {
        return listaAdministratora;
    }

    
}
