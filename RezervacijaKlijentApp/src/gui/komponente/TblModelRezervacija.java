/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aco Kandic
 */
public class TblModelRezervacija extends AbstractTableModel {
    
    List<Rezervacija> listaRezervacija;

    public TblModelRezervacija(List<Rezervacija> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }
    
    
    @Override
    public int getRowCount() {
        if (listaRezervacija == null) {
            return 0;
        }
        return listaRezervacija.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Rezervacija r = listaRezervacija.get(rowIndex);
        
        String[] listaDatum = r.getDatumRezervacije().toString().split(" ");
        String datum = listaDatum[2] + " " + listaDatum[1] + " " + listaDatum[5];
        
        switch(columnIndex) {
            case 0: return r.getRezervacijaID();
            case 1: return datum;
            case 2: return r.getKorisnik().getIme() +" "+ r.getKorisnik().getPrezime();
            case 3: return r.getKorisnik().getKontakt();
            case 4: return r.getKorisnik().getMail();
            default: return "n/a";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column) {
            case 0: return "Broj rezervacije";
            case 1: return "Datum rezervacije";
            case 2: return "Ime i prezime";
            case 3: return "Kontakt";
            case 4: return "Mail";
            default: return "n/a";
        }
        
    }
    
    
    
}
