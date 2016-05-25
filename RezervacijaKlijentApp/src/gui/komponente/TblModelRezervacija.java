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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Rezervacija r = listaRezervacija.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return r.getRezervacijaID();
            case 1: return r.getKorisnik().getIme() +" "+ r.getKorisnik().getPrezime();
            case 2: return r.getListaStavki().get(rowIndex).getProstorija().getNazivProstorije();
            case 3: return r.getDatumRezervacije();
            case 4: return r.getListaStavki().get(rowIndex).getVremeOd();
            case 5: return r.getListaStavki().get(rowIndex).getVremeDo();
            case 6: return r.getListaStavki().get(rowIndex).getIznos();
            default: return "n/a";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column) {
            case 0: return "Broj rezervacije";
            case 1: return "Korisnik";
            case 2: return "Prostorija";
            case 3: return "Datum rezervacije";
            case 4: return "Vreme od";
            case 5: return "Vreme do";
            case 6: return "Iznos";
            default: return "n/a";
        }
        
    }
    
    
    
}
