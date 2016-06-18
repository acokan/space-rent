/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Korisnik;
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
public class TblModelKorisnik extends AbstractTableModel {

    List<Korisnik> lk;

    public TblModelKorisnik(List<Korisnik> lk) {
        this.lk = lk;
    }
    
    @Override
    public int getRowCount() {
        if (lk==null) {
            return 0;
        }
        return lk.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = lk.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return k.getIme()+" "+k.getPrezime();
            case 1: SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 
                    return sdf.format(k.getDatumRodjenja());
            case 2: return k.getKontakt();
            case 3: return k.getMail();
            case 4: return k.getUlica()+" "+k.getBroj();
            case 5: return k.getMesto();
            default: return "n/a";           
        }
    }
    
    @Override
    public String getColumnName(int column) {
        
        switch(column) {
            case 0: return "Ime i prezime";
            case 1: return "Datum rodjenja";
            case 2: return "Kontakt";
            case 3: return "Mail";
            case 4: return "Adresa";
            case 5: return "Mesto";
            default: return "n/a";
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        
        Korisnik k = lk.get(row);
        
        if (col == 0) {
            String[] imePrezime = value.toString().split(" ");
            k.setIme(imePrezime[0]);
            k.setPrezime(imePrezime[1]);
        }
        
        if (col == 1) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            try {
                k.setDatumRodjenja(sdf.parse(value.toString()));
            } catch (ParseException ex) {
                Logger.getLogger(TblModelKorisnik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (col == 2) {
            k.setKontakt(value.toString());
        }
        
        if (col == 3) {
            k.setMail(value.toString());
        }
        
        if (col == 4) {
            String[] adresa = value.toString().split(" ");
            k.setUlica(adresa[0]);
            k.setBroj(adresa[1]);
        }
        
        if (col == 5) {
            Mesto m = (Mesto) value;
            k.setMesto(m);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 6) return Mesto.class;
        return String.class;
    }
    
    

    public void dodajKorisnikaUTabelu(Korisnik k) throws Exception {
        if (k==null) {
            throw new Exception("Korisnik nije dodat u tabelu! Proverite da li ste popunili sva polja!");
        }
        lk.add(k);
        fireTableDataChanged();
    }

    public List<Korisnik> vratiListuKorisnika() {
        return lk;
    }

    public Korisnik vratiKorisnika(int izKorisnik) {
        Korisnik k = null;
        for (int i = 0; i < lk.size(); i++) {
            if (i == izKorisnik) {
                k = lk.get(i);
            }
        }
        return k;
    }
  
}
