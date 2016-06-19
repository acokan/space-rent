/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.rezervacija;

import domen.Korisnik;
import domen.Mesto;
import domen.Rezervacija;
import gui.komponente.TblModelKorisnik;
import gui.komponente.TblModelRezervacija;
import gui.komponente.TblModelStavkaRezervacije;
import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import korisnici.kontroler.Kontroler;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class FmPretragaRezervacija extends javax.swing.JDialog {

    /**
     * Creates new form FmPretragaKorisnika
     */
    public static List<Korisnik> listaKorisnikaFilter = new ArrayList<>();

    public FmPretragaRezervacija(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ButtonGroup bg = new ButtonGroup();
        bg.add(jradioBrojRezervacije);
        bg.add(jradioDatumRezervacije);
        bg.add(jradioTelefon);
        bg.add(jradioImePrezime);
        bg.add(jradioMail);
        jradioBrojRezervacije.setSelected(true);

        srediTabelu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtn_detalji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRezervacije = new javax.swing.JTable();
        jbtnResetujRezultate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jradioBrojRezervacije = new javax.swing.JRadioButton();
        jradioTelefon = new javax.swing.JRadioButton();
        jradioImePrezime = new javax.swing.JRadioButton();
        jradioMail = new javax.swing.JRadioButton();
        jbtnTrazi = new javax.swing.JButton();
        jtxtPretraga = new javax.swing.JTextField();
        jradioDatumRezervacije = new javax.swing.JRadioButton();
        btnOdustani = new javax.swing.JButton();
        btnObrisiRezervaciju = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jbtn_detalji.setText("Detalji");
        jbtn_detalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_detaljiActionPerformed(evt);
            }
        });

        jtblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Broj rezervacije", "Datum rezervacije", "Ime i prezime", "Kontakt", "Mail"
            }
        ));
        jScrollPane1.setViewportView(jtblRezervacije);

        jbtnResetujRezultate.setText("Resetuj rezultate");
        jbtnResetujRezultate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetujRezultateActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga rezervacija"));

        jradioBrojRezervacije.setText("Broj rezervacije");

        jradioTelefon.setText("Kontakt telefon");

        jradioImePrezime.setText("Ime i prezime");

        jradioMail.setText("Mail");

        jbtnTrazi.setText("Trazi");
        jbtnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTraziActionPerformed(evt);
            }
        });

        jradioDatumRezervacije.setText("Datum rezervacije");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtPretraga)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnTrazi)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jradioBrojRezervacije)
                        .addGap(18, 18, 18)
                        .addComponent(jradioDatumRezervacije)
                        .addGap(18, 18, 18)
                        .addComponent(jradioImePrezime)
                        .addGap(18, 18, 18)
                        .addComponent(jradioTelefon)
                        .addGap(18, 18, 18)
                        .addComponent(jradioMail)
                        .addGap(106, 106, 106))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradioBrojRezervacije)
                    .addComponent(jradioTelefon)
                    .addComponent(jradioImePrezime)
                    .addComponent(jradioMail)
                    .addComponent(jradioDatumRezervacije))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnTrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnObrisiRezervaciju.setText("Obrisi rezervaciju");
        btnObrisiRezervaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiRezervacijuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_detalji, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisiRezervaciju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnResetujRezultate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOdustani))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_detalji)
                    .addComponent(jbtnResetujRezultate)
                    .addComponent(btnOdustani)
                    .addComponent(btnObrisiRezervaciju))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnResetujRezultateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetujRezultateActionPerformed
        srediTabelu();
    }//GEN-LAST:event_jbtnResetujRezultateActionPerformed

    private void jbtn_detaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_detaljiActionPerformed
        Kontroler.vratiInstancuKontrolera().setAktivanSK(Util.SK_IZMENA_REZERVACIJE);
        int redRezervacije = jtblRezervacije.getSelectedRow();
        if (redRezervacije == -1) {
            JOptionPane.showMessageDialog(this, "Selektujte rezervaciju koju zelite izmeniti");
        } else {
            TblModelRezervacija tmr = (TblModelRezervacija) jtblRezervacije.getModel();
            Rezervacija r = tmr.vratiRezervaciju(redRezervacije);

            Kontroler.vratiInstancuKontrolera().getSesija().put("izabrana_rezervacija", r);

            FmUnosRezervacije fur = new FmUnosRezervacije(null, true);
            fur.setVisible(true);

            srediTabelu();
            
            Kontroler.vratiInstancuKontrolera().getSesija().remove("izabrana_rezervacija", r);
        }
    }//GEN-LAST:event_jbtn_detaljiActionPerformed

    private void jbtnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTraziActionPerformed

        try {
            
            List<Rezervacija> listaRezervacija = Kontroler.vratiInstancuKontrolera().vratiListuRezervacija();
            List<Rezervacija> listaRezultata = new ArrayList<>();
            
            if (jradioBrojRezervacije.isSelected()) {
                int trazenaRijec = Integer.parseInt(jtxtPretraga.getText().trim());
                for (Rezervacija rezervacija : listaRezervacija) {
                    if (rezervacija.getRezervacijaID() == trazenaRijec) {
                       listaRezultata.add(rezervacija);
                    }
                }
                jtblRezervacije.setModel(new TblModelRezervacija(listaRezultata));
                centrirajSadrzajTabele();
                return;
            }
            if (jradioTelefon.isSelected()) {
                String trazenaRijec = jtxtPretraga.getText().trim();
                for (Rezervacija rezervacija : listaRezervacija) {
                    if (rezervacija.getKorisnik().getKontakt().startsWith(trazenaRijec)) {
                       listaRezultata.add(rezervacija);
                    }
                }
                jtblRezervacije.setModel(new TblModelRezervacija(listaRezultata));
                centrirajSadrzajTabele();
                return;
            }
            if (jradioImePrezime.isSelected()) {
                String trazenaRijec = jtxtPretraga.getText().trim();
                for (Rezervacija rezervacija : listaRezervacija) {
                    String imePrezime = rezervacija.getKorisnik().getIme() + " " + rezervacija.getKorisnik().getPrezime();
                    if (imePrezime.startsWith(trazenaRijec)) {
                       listaRezultata.add(rezervacija);
                    }
                }
                jtblRezervacije.setModel(new TblModelRezervacija(listaRezultata));
                centrirajSadrzajTabele();
                return;
            }
            if (jradioMail.isSelected()) {
                String trazenaRijec = jtxtPretraga.getText().trim();
                for (Rezervacija rezervacija : listaRezervacija) {
                    if (rezervacija.getKorisnik().getMail().startsWith(trazenaRijec)) {
                       listaRezultata.add(rezervacija);
                    }
                }
                jtblRezervacije.setModel(new TblModelRezervacija(listaRezultata));
                centrirajSadrzajTabele();
                return;
            }
            if (jradioDatumRezervacije.isSelected()) {
                String trazenaRijec = jtxtPretraga.getText().trim();
                for (Rezervacija rezervacija : listaRezervacija) {
                    String[] listaDatum = rezervacija.getDatumRezervacije().toString().split(" ");
                    String datum = listaDatum[2] + " " + listaDatum[1] + " " + listaDatum[5];
                    if (datum.startsWith(trazenaRijec)) {
                       listaRezultata.add(rezervacija);
                    }
                }
                jtblRezervacije.setModel(new TblModelRezervacija(listaRezultata));
                centrirajSadrzajTabele();
                return;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FmPretragaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jbtnTraziActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnObrisiRezervacijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiRezervacijuActionPerformed
        
        int izabranaRez = jtblRezervacije.getSelectedRow();
        if (izabranaRez == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite rezervaciju koju zelite izbrisati!");
        } else {
            TblModelRezervacija tmr = (TblModelRezervacija) jtblRezervacije.getModel();
            Rezervacija r = tmr.vratiRezervaciju(izabranaRez);

            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this, "Da li zelite da izbrisete rezervaciju?", "Brisanje rezervacije", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, "Da");

            if (izbor == 0) {
                try {
                    boolean izbrisan = Kontroler.vratiInstancuKontrolera().izbrisiRezervaciju(r);
                    if (izbrisan) {
                        JOptionPane.showMessageDialog(this, "Rezervacije je izbrisana!");
                        srediTabelu();
                        return;
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Rezervacija nije izbrisana!"
                            + " Nije moguce izbrisati rezervaciju ukoliko postoje rezervacije na njegovo ime!");
                    return;
                }
            }
        }
        
    }//GEN-LAST:event_btnObrisiRezervacijuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisiRezervaciju;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnResetujRezultate;
    private javax.swing.JButton jbtnTrazi;
    private javax.swing.JButton jbtn_detalji;
    private javax.swing.JRadioButton jradioBrojRezervacije;
    private javax.swing.JRadioButton jradioDatumRezervacije;
    private javax.swing.JRadioButton jradioImePrezime;
    private javax.swing.JRadioButton jradioMail;
    private javax.swing.JRadioButton jradioTelefon;
    private javax.swing.JTable jtblRezervacije;
    private javax.swing.JTextField jtxtPretraga;
    // End of variables declaration//GEN-END:variables

    private void popuniComboKorisnici() {
//        jComboKorisnici.removeAllItems();
//        List<Korisnik> listaKorisnika = new ArrayList<>();
//        try {
//            listaKorisnika = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
//        } catch (SQLException ex) {
//            System.out.println("Korisnici nisu pronadjeni!");
//        }
//        for (Korisnik korisnik : listaKorisnika) {
//            jComboKorisnici.addItem(korisnik);
//        }
    }

    private void popuniTabeluKorisnici() {
        List<Korisnik> lk = new ArrayList<>();
        try {
            lk = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
        } catch (Exception ex) {
            System.out.println("Korisnici nisu pronadjeni!");
        }
        jtblRezervacije.setModel(new TblModelKorisnik(lk));

        ListSelectionModel lsm = jtblRezervacije.getSelectionModel();
        lsm.setSelectionInterval(0, 0);
    }

    private void dodajComboMestaUTabelu() {
        JComboBox jck = new JComboBox<Mesto>();
        try {
            jck.setModel(new DefaultComboBoxModel(Kontroler.vratiInstancuKontrolera().vratiListuMesta().toArray()));
        } catch (Exception ex) {
            System.out.println("Mesta nisu pronadjena!");
        }

        TableColumnModel tcm = jtblRezervacije.getColumnModel();
        TableColumn tm = tcm.getColumn(5);
        tm.setCellEditor(new DefaultCellEditor(jck));
    }

    private void srediTabelu() {
        List<Rezervacija> lr = new ArrayList<>();
        try {
            lr = Kontroler.vratiInstancuKontrolera().vratiListuRezervacija();
        } catch (Exception ex) {
            System.out.println("Korisnici nisu pronadjeni!");
        }
        jtblRezervacije.setModel(new TblModelRezervacija(lr));

        centrirajSadrzajTabele();
    }

    private void centrirajSadrzajTabele() {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < 5; i++) {
            jtblRezervacije.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

}
