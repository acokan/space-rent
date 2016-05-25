/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Korisnik;
import domen.Mesto;
import gui.komponente.TblModelKorisnik;
import java.awt.Color;
import java.awt.Dimension;
import java.security.interfaces.ECKey;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import javafx.stage.Stage;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;
import korisnici.kontroler.Kontroler;
import util.Util;
import static util.Util.VALID_EMAIL_ADDRESS_REGEX;

/**
 *
 * @author Aco Kandic
 */
public class FmKorisnik extends javax.swing.JDialog {

    /**
     * Creates new form FmKorisnik
     */
    public FmKorisnik(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnl_mesto = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboMesto = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jtxt_ulica = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxt_broj = new javax.swing.JTextField();
        jbtn_izberiMesto = new javax.swing.JButton();
        jbtn_dodajMesto = new javax.swing.JButton();
        jbtn_sacuvajKorisnika = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKorisnici = new javax.swing.JTable();
        jbtn_dodajKorisnika = new javax.swing.JButton();
        jbtn_sacuvajSve = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxt_ime = new javax.swing.JTextField();
        jtxt_prezime = new javax.swing.JTextField();
        jtxt_datumRodjenja = new javax.swing.JTextField();
        jtxt_kontakt = new javax.swing.JTextField();
        jtxt_mail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbtnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos korisnika");
        setResizable(false);

        jpnl_mesto.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesto"));

        jLabel7.setText("Mesto:");

        jComboMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Ulica:");

        jLabel9.setText("Broj:");

        jbtn_izberiMesto.setText("Izaberi");
        jbtn_izberiMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_izberiMestoActionPerformed(evt);
            }
        });

        jbtn_dodajMesto.setText("+");
        jbtn_dodajMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_dodajMestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnl_mestoLayout = new javax.swing.GroupLayout(jpnl_mesto);
        jpnl_mesto.setLayout(jpnl_mestoLayout);
        jpnl_mestoLayout.setHorizontalGroup(
            jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_mestoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_ulica, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnl_mestoLayout.createSequentialGroup()
                        .addComponent(jComboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_izberiMesto)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_dodajMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxt_broj))
                .addContainerGap())
        );
        jpnl_mestoLayout.setVerticalGroup(
            jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_mestoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_izberiMesto)
                    .addComponent(jbtn_dodajMesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxt_ulica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl_mestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxt_broj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtn_sacuvajKorisnika.setText("Sacuvaj");
        jbtn_sacuvajKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_sacuvajKorisnikaActionPerformed(evt);
            }
        });

        jtblKorisnici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblKorisnici);

        jbtn_dodajKorisnika.setText("Dodaj");
        jbtn_dodajKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_dodajKorisnikaActionPerformed(evt);
            }
        });

        jbtn_sacuvajSve.setText("Sacuvaj sve");
        jbtn_sacuvajSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_sacuvajSveActionPerformed(evt);
            }
        });

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        jLabel4.setText("Datum rodjenja:");

        jLabel5.setText("Kontakt telefon:");

        jLabel6.setText("Mail:");

        jtxt_prezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_prezimeActionPerformed(evt);
            }
        });

        jtxt_datumRodjenja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_datumRodjenjaActionPerformed(evt);
            }
        });

        jtxt_kontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_kontaktActionPerformed(evt);
            }
        });

        jtxt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_mailActionPerformed(evt);
            }
        });

        jLabel10.setText("dd.MM.yyyy.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_kontakt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxt_prezime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxt_ime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt_datumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxt_mail))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_prezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel4))
                    .addComponent(jtxt_datumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_kontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnObrisi.setText("Obrisi");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtn_sacuvajSve))
                    .addComponent(jScrollPane1)
                    .addComponent(jpnl_mesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtn_dodajKorisnika)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_sacuvajKorisnika, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnl_mesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_dodajKorisnika)
                    .addComponent(jbtn_sacuvajKorisnika)
                    .addComponent(jbtnObrisi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_sacuvajSve)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnl_mesto.getAccessibleContext().setAccessibleName("Mesto prebivalista");
        jpnl_mesto.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_kontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_kontaktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_kontaktActionPerformed

    private void jtxt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_mailActionPerformed

    private void jtxt_prezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_prezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_prezimeActionPerformed

    private void jbtn_izberiMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_izberiMestoActionPerformed
        FmPretragaMesta fmp = new FmPretragaMesta(null, true);
        fmp.setVisible(true);
        Mesto m = fmp.izaberiMesto();
        jComboMesto.setSelectedItem(m);
    }//GEN-LAST:event_jbtn_izberiMestoActionPerformed

    private void jbtn_dodajMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_dodajMestoActionPerformed
        FmDodajMesto fdm = new FmDodajMesto(null, true);
        fdm.setVisible(true);
        popuniComboMesto();
    }//GEN-LAST:event_jbtn_dodajMestoActionPerformed

    private void jbtn_sacuvajKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_sacuvajKorisnikaActionPerformed

        int rezim = Kontroler.vratiInstancuKontrolera().getAktivanSK();
        if (rezim == Util.SK_UNOS_KORISNIKA) {
            try {
                Object[] opcije = {"Da", "Ne"};
                int izbor = JOptionPane.showOptionDialog(this, "Da li zelite sacuvati korisnika?", "Cuvanje korisnika", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, "Da");
                if (izbor == 0) {
                    Korisnik korisnik = kreirajKorisnikaSaForme();
                    boolean sacuvan = Kontroler.vratiInstancuKontrolera().dodajKorisnika(korisnik);
                    if (sacuvan == true) {
                        JOptionPane.showMessageDialog(this, "Korisnik je sacuvan!");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Korisnik nije sacuvan!");
                    vratiDefaultBorder();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (rezim == Util.SK_IZMENA_KORISNIKA) {
            try {
                Object[] opcije = {"Da", "Ne"};
                int izbor = JOptionPane.showOptionDialog(this, "Da li zelite izmeniti korisnika?", "Izmena korisnika", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, "Da");
                if (izbor == 0) {
                    Korisnik korisnik = kreirajKorisnikaSaForme();
                    Kontroler.vratiInstancuKontrolera().updateKorisnika(korisnik);
                    JOptionPane.showMessageDialog(this, "Korisnik je azuriran!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }


    }//GEN-LAST:event_jbtn_sacuvajKorisnikaActionPerformed

    private void jbtn_dodajKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_dodajKorisnikaActionPerformed
        try {
            Korisnik k = kreirajKorisnikaSaForme();

            TblModelKorisnik tmk = (TblModelKorisnik) jtblKorisnici.getModel();
            tmk.dodajKorisnikaUTabelu(k);

            if (jtblKorisnici.getRowCount() > 0) {
                jbtn_sacuvajKorisnika.setEnabled(false);
            }

            JOptionPane.showMessageDialog(this, "Korisnik je dodat u tabelu!");
            jbtn_sacuvajSve.setEnabled(true);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
            vratiDefaultBorder();
        }
    }//GEN-LAST:event_jbtn_dodajKorisnikaActionPerformed

    private void jbtn_sacuvajSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_sacuvajSveActionPerformed
        TblModelKorisnik tmk = (TblModelKorisnik) jtblKorisnici.getModel();
        List<Korisnik> listaKorisnika = tmk.vratiListuKorisnika();
        try {
            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this, "Da li zelite sacuvati korisnike?", "Cuvanje korisnika", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, "Da");
            if (izbor == 0) {
                boolean sacuvani = Kontroler.vratiInstancuKontrolera().sacuvajListuKorisnika(listaKorisnika);
                if (sacuvani) {
                    JOptionPane.showMessageDialog(this, "Lista korisnika je sacuvana!");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Lista korisnika nije sacuvana!");
                srediFormu();
            }
        } catch (Exception e) {
            System.out.println("Lista korisnika nije sacuvana: " + e.getMessage());
        }
    }//GEN-LAST:event_jbtn_sacuvajSveActionPerformed

    private void jtxt_datumRodjenjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_datumRodjenjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_datumRodjenjaActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        TblModelKorisnik tmk = (TblModelKorisnik) jtblKorisnici.getModel();
        List<Korisnik> lk = tmk.vratiListuKorisnika();
        int selectedRow = jtblKorisnici.getSelectedRow();
        lk.remove(selectedRow);
        jtblKorisnici.setModel(new TblModelKorisnik(lk));
        JOptionPane.showMessageDialog(this, "Korisnik je uklonjen iz tabele!");
        if (lk.isEmpty()) {
            jbtn_sacuvajSve.setEnabled(false);
            jbtn_sacuvajKorisnika.setEnabled(true);
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboMesto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtn_dodajKorisnika;
    private javax.swing.JButton jbtn_dodajMesto;
    private javax.swing.JButton jbtn_izberiMesto;
    private javax.swing.JButton jbtn_sacuvajKorisnika;
    private javax.swing.JButton jbtn_sacuvajSve;
    private javax.swing.JPanel jpnl_mesto;
    private javax.swing.JTable jtblKorisnici;
    private javax.swing.JTextField jtxt_broj;
    private javax.swing.JTextField jtxt_datumRodjenja;
    private javax.swing.JTextField jtxt_ime;
    private javax.swing.JTextField jtxt_kontakt;
    private javax.swing.JTextField jtxt_mail;
    private javax.swing.JTextField jtxt_prezime;
    private javax.swing.JTextField jtxt_ulica;
    // End of variables declaration//GEN-END:variables

    private void popuniComboMesto() {
        jComboMesto.removeAllItems();
        List<Mesto> listaMesta = new ArrayList<>();
        try {
            listaMesta = Kontroler.vratiInstancuKontrolera().vratiListuMesta(); //Util.vratiListuMesta();
        } catch (Exception ex) {
            System.out.println("Mesta nisu pronadjena!");
        }
        for (Mesto m : listaMesta) {
            jComboMesto.addItem(m);
        }
    }

    private void popuniComboMestoZaTrenutnogKorisnika(Korisnik k) {
        jComboMesto.removeAllItems();
        int index = 0;
        Mesto mesto = new Mesto();
        List<Mesto> listaMesta = new ArrayList<>();
        try {
            mesto = Kontroler.vratiInstancuKontrolera().vratiMesto(k.getMesto().getPtt());
            listaMesta = Kontroler.vratiInstancuKontrolera().vratiListuMesta();
        } catch (Exception ex) {
            System.out.println("Mesta nisu pronadjena!");
        }

        for (int i = 0; i < listaMesta.size(); i++) {
            jComboMesto.addItem(listaMesta.get(i));
            if (listaMesta.get(i).getPtt() == mesto.getPtt()) {
                index = i;
            }
        }
        jComboMesto.setSelectedIndex(index);
    }

    private void prikaziKorisnika(Korisnik k) {
        jtxt_ime.setText(k.getIme());
        jtxt_prezime.setText(k.getPrezime());
        jtxt_datumRodjenja.setText(new SimpleDateFormat("dd.MM.yyyy.").format(k.getDatumRodjenja()));
        jtxt_kontakt.setText(k.getKontakt());
        jtxt_mail.setText(k.getMail());
        jtxt_ulica.setText(k.getUlica());
        jtxt_broj.setText(k.getBroj());
        jComboMesto.setSelectedItem(k.getMesto());
    }

    private void srediFormu() {
        int rezim = Kontroler.vratiInstancuKontrolera().getAktivanSK();
        if (rezim == Util.SK_UNOS_KORISNIKA) {
            popuniComboMesto();
            postaviModelTabele();
            ocistiFormu();
            jbtn_sacuvajSve.setEnabled(false);
        }
        if (rezim == Util.SK_IZMENA_KORISNIKA) {
            srediFormuURezimuIzmena();
            Korisnik k = (Korisnik) Kontroler.vratiInstancuKontrolera().getSesija().get("izabrani_korisnik");
            popuniComboMestoZaTrenutnogKorisnika(k);
            prikaziKorisnika(k);
        }
    }

    private void srediFormuURezimuIzmena() {
        jbtn_dodajKorisnika.setVisible(false);
        jbtn_sacuvajSve.setVisible(false);
        jbtnObrisi.setVisible(false);
        jScrollPane1.setVisible(false);
        jtblKorisnici.setVisible(false);
        setPreferredSize(new Dimension(783, 400));
        pack();
    }

    private void postaviModelTabele() {
        List<Korisnik> lk = new ArrayList<>();
        TblModelKorisnik tmk = new TblModelKorisnik(lk);
        jtblKorisnici.setModel(tmk);

        JComboBox jcb = null;
        try {
            jcb = new JComboBox(Kontroler.vratiInstancuKontrolera().vratiListuMesta().toArray());
        } catch (Exception ex) {
            System.out.println("Mesta nisu pronadjena!");
        }
        TableColumn tc = jtblKorisnici.getColumnModel().getColumn(5);
        tc.setCellEditor(new DefaultCellEditor(jcb));
    }

    private Korisnik kreirajKorisnikaSaForme() throws Exception {
        Korisnik korisnik = null;
        try {
            String ime = jtxt_ime.getText().trim();
            String prezime = jtxt_prezime.getText().trim();
            String datumRodjenja = jtxt_datumRodjenja.getText().trim();
            String kontakt = jtxt_kontakt.getText().trim();
            String mail = jtxt_mail.getText().trim();
            String ulica = jtxt_ulica.getText().trim();
            String broj = jtxt_broj.getText().trim();
            Mesto mesto = (Mesto) jComboMesto.getSelectedItem();

            korisnik = kreirajObjekatKorisnik(ime, prezime, datumRodjenja, kontakt, mail, ulica, broj, mesto);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return korisnik;
    }

    private Korisnik kreirajObjekatKorisnik(String ime, String prezime, String datumR, String kontakt, String mail, String ulica, String broj, Mesto mesto) throws Exception {

        Korisnik k = new Korisnik();

        if (ime == null || ime.isEmpty()) {
            jtxt_ime.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite ime korisnika!");
        }
        k.setIme(ime);

        if (prezime == null || prezime.isEmpty()) {
            jtxt_prezime.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite prezime korisnika!");
        }
        k.setPrezime(prezime);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            Date datumRodjenja = sdf.parse(datumR);
            k.setDatumRodjenja(datumRodjenja);
        } catch (ParseException parseException) {
            JOptionPane.showMessageDialog(this, "Unesite datum u odgovarajucem formatu!");
        }

        if (kontakt == null || kontakt.isEmpty()) {
            jtxt_kontakt.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite kontakt telefon korisnika!");
        }
        k.setKontakt(kontakt);

        if (validateEmail(mail) == false) {
            jtxt_mail.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite mail korisnika!");
        }
        k.setMail(mail);

        if (ulica == null || ulica.isEmpty()) {
            jtxt_ulica.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite ulicu stanovanja korisnika!");
        }
        k.setUlica(ulica);

        if (broj == null || broj.isEmpty()) {
            jtxt_broj.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            throw new Exception("Unesite broj ulice stanovanja korisnika!");
        }
        k.setBroj(broj);

        k.setMesto(mesto);

        return k;
    }

    private void vratiDefaultBorder() {
        Border border = jtxt_datumRodjenja.getBorder();
        jtxt_ime.setBorder(border);
        jtxt_prezime.setBorder(border);
        jtxt_ulica.setBorder(border);
        jtxt_broj.setBorder(border);
        jtxt_kontakt.setBorder(border);
        jtxt_mail.setBorder(border);
    }

    private void ocistiFormu() {
        jtxt_ime.setText("");
        jtxt_prezime.setText("");
        jtxt_datumRodjenja.setText("");
        jtxt_kontakt.setText("");
        jtxt_mail.setText("");
        jtxt_ulica.setText("");
        jtxt_broj.setText("");
        jbtn_sacuvajKorisnika.setEnabled(true);
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}
