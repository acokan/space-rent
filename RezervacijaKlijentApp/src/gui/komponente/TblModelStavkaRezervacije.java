/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

//import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;
import domen.Korisnik;
import domen.Mesto;
import domen.Prostorija;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import korisnici.kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class TblModelStavkaRezervacije extends AbstractTableModel {

    Rezervacija rezervacija;

    public TblModelStavkaRezervacije(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    String[] naziviKolona = {"Redni broj", "Vreme od", "Vreme do", "Prostorija", "Iznos"};

    @Override
    public int getRowCount() {
        if (rezervacija.getListaStavki().isEmpty()) {
            return 0;
        }
        return rezervacija.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        StavkaRezervacije stavke = rezervacija.getListaStavki().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return stavke.getRedniBrojStavke();
            case 1:
                return stavke.getVremeOd();
            case 2:
                return stavke.getVremeDo();
            case 3:
                return stavke.getProstorija();
            case 4:
                return stavke.getIznos();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 4) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        StavkaRezervacije stavke = rezervacija.getListaStavki().get(row);

        if (col == 0) {
            stavke.setRedniBrojStavke(Integer.parseInt(value.toString()));
        }

        if (col == 1) {
            try {
                stavke.setVremeOd(LocalTime.parse(value.toString()));
                if (stavke.getVremeOd().isAfter(stavke.getVremeDo())) {
                    throw new Exception();
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Unesite vreme u formatu 'HH:mm'", "Greska!", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "'Vreme od' mora biti manje od 'Vreme do'", "Greska!", JOptionPane.ERROR_MESSAGE);
            }

            double brojSati = (stavke.getVremeDo().toSecondOfDay() - stavke.getVremeOd().toSecondOfDay());
            stavke.setIznos(stavke.getProstorija().getCena() * brojSati / 3600);
            fireTableCellUpdated(row, 3);
            fireTableCellUpdated(row, 4);
        }

        if (col == 2) {
            try {
                stavke.setVremeDo(LocalTime.parse(value.toString()));
                if (stavke.getVremeDo().isBefore(stavke.getVremeOd())) {
                    throw new Exception();
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Unesite vreme u formatu 'HH:mm'", "Greska!", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "'Vreme do' mora biti vece od 'Vreme od'", "Greska!", JOptionPane.ERROR_MESSAGE);
            }

            double brojSati = (stavke.getVremeDo().toSecondOfDay() - stavke.getVremeOd().toSecondOfDay());
            stavke.setIznos(stavke.getProstorija().getCena() * brojSati / 3600);
            fireTableCellUpdated(row, 3);
            fireTableCellUpdated(row, 4);
        }

        if (col == 3) {
            Prostorija p = (Prostorija) value;
            stavke.setProstorija(p);
            double brojSati = (stavke.getVremeDo().toSecondOfDay() - stavke.getVremeOd().toSecondOfDay());
            stavke.setIznos(stavke.getProstorija().getCena() * brojSati / 3600);
            fireTableCellUpdated(row, 3);
            fireTableCellUpdated(row, 4);
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }
//        if (columnIndex == 1 || columnIndex == 2) {
//            return String.class;
//        }
        if (columnIndex == 3) {
            return Prostorija.class;
        }
        if (columnIndex == 4) {
            return Double.class;
        }
        return String.class;
    }

    public void dodajStavkuRezervacije() {

        StavkaRezervacije stavka = new StavkaRezervacije();

        stavka.setRezervacija(rezervacija);
        stavka.setRedniBrojStavke(rezervacija.getListaStavki().size() + 1);

        stavka.setVremeOd(LocalTime.of(LocalTime.MIDNIGHT.getHour(), LocalTime.MIDNIGHT.getMinute()));
        stavka.setVremeDo(LocalTime.of(LocalTime.MIDNIGHT.getHour(), LocalTime.MIDNIGHT.getMinute()));

        try {
            stavka.setProstorija(Kontroler.vratiInstancuKontrolera().vratiListuProstorija().get(0));
        } catch (Exception ex) {
            System.out.println("Prostorije nisu pronadjene!");
        }
        stavka.setIznos(0);

        rezervacija.getListaStavki().add(stavka);
        fireTableDataChanged();

    }

    public void obrisiStavkuRezervacije(int selektovaniRed) {
        rezervacija.getListaStavki().remove(selektovaniRed);
        fireTableDataChanged();
    }
    
    public Rezervacija vratiRezervaciju() {
        return rezervacija;
    }

}
