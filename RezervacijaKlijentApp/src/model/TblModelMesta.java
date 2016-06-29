/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Mesto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Aco Kandic
 */
public class TblModelMesta extends AbstractTableModel {

    List<Mesto> lm;

    public TblModelMesta(List<Mesto> lm) {
        this.lm = lm;
    }
    
    @Override
    public int getRowCount() {
        if (lm==null) {
            return 0;
        }
        return lm.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto m = lm.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return m.getPtt();
            case 1: return m.getNaziv();
            default: return "n/a";           
        }
    }
    
    @Override
    public String getColumnName(int column) {
        
        switch(column) {
            case 0: return "Postanski broj";
            case 1: return "Naziv mesta";
            default: return "n/a";
        }
    }
    
//    @Override
//    public boolean isCellEditable(int row, int col) {
//        return true;
//    }
//    
//    @Override
//    public void setValueAt(Object value, int row, int col) {
//        
//        Mesto m = lm.get(row);
//        
//        if (col == 0) {
//            m.setPtt(Integer.parseInt(value.toString()));
//        }
//        
//        if (col == 1) {
//            m.setNaziv(value.toString());
//        }
//        
//    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) return Integer.class;
        return String.class;
    }
    
    

//    public void dodajKorisnikaUTabelu(Korisnik k) throws Exception {
//        if (k==null) {
//            throw new Exception("Korisnik nije dodat u tabelu! Proverite da li ste popunili sva polja!");
//        }
//        lm.add(k);
//        fireTableDataChanged();
//    }
//
//    public List<Korisnik> vratiListuKorisnika() {
//        return lm;
//    }
  
}
