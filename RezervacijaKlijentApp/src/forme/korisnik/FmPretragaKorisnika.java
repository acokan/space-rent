/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.korisnik;

import domen.Korisnik;
import domen.Mesto;
import model.TblModelKorisnik;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import kontroler.Kontroler;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class FmPretragaKorisnika extends javax.swing.JDialog {

    /**
     * Creates new form FmPretragaKorisnika
     */
    public static List<Korisnik> listaKorisnikaFilter = new ArrayList<>();

    public FmPretragaKorisnika(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        popuniComboKorisnici();
        popuniTabeluKorisnici();
        dodajComboMestaUTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboKorisnici = new javax.swing.JComboBox();
        jbtn_detalji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKorisnici = new javax.swing.JTable();
        jbtnNaprednaPretraga = new javax.swing.JButton();
        jbtnResetujRezultate = new javax.swing.JButton();
        btnObrisiKorisnika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga korisnika");

        jLabel1.setText("Korisnici:");

        jComboKorisnici.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboKorisnici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboKorisniciActionPerformed(evt);
            }
        });

        jbtn_detalji.setText("Detalji");
        jbtn_detalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_detaljiActionPerformed(evt);
            }
        });

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
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
        jtblKorisnici.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtblKorisniciFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtblKorisniciFocusLost(evt);
            }
        });
        jtblKorisnici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblKorisniciMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblKorisnici);

        jbtnNaprednaPretraga.setText("Napredna pretraga");
        jbtnNaprednaPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNaprednaPretragaActionPerformed(evt);
            }
        });

        jbtnResetujRezultate.setText("Resetuj rezultate");
        jbtnResetujRezultate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetujRezultateActionPerformed(evt);
            }
        });

        btnObrisiKorisnika.setText("Obrisi korisnika");
        btnObrisiKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiKorisnikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboKorisnici, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_detalji, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisiKorisnika)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnNaprednaPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnResetujRezultate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboKorisnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_detalji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNaprednaPretraga)
                    .addComponent(jbtnResetujRezultate)
                    .addComponent(btnObrisiKorisnika))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboKorisniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboKorisniciActionPerformed
        int selectedUserCB = jComboKorisnici.getSelectedIndex();
        ListSelectionModel lsm = jtblKorisnici.getSelectionModel();
        lsm.setSelectionInterval(selectedUserCB, selectedUserCB);
    }//GEN-LAST:event_jComboKorisniciActionPerformed

    private void jbtn_detaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_detaljiActionPerformed
        Kontroler.vratiInstancuKontrolera().setAktivanSK(Util.SK_IZMENA_KORISNIKA);
        Korisnik k = (Korisnik) jComboKorisnici.getSelectedItem();
//        if(k != null) {
//            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje izabranog korisnika!", "Greska", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        Kontroler.vratiInstancuKontrolera().getSesija().put("izabrani_korisnik", k);
        FmKorisnik fmk = new FmKorisnik(null, true);
        fmk.setVisible(true);
        Kontroler.vratiInstancuKontrolera().getSesija().remove("izabrani_korisnik", k);
    }//GEN-LAST:event_jbtn_detaljiActionPerformed

    private void jtblKorisniciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblKorisniciMouseClicked
        int selectedUser = jtblKorisnici.getSelectedRow();
        jComboKorisnici.setSelectedIndex(selectedUser);
    }//GEN-LAST:event_jtblKorisniciMouseClicked

    private void jbtnNaprednaPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNaprednaPretragaActionPerformed
        FmNaprednaPretraga fmnp = new FmNaprednaPretraga(null, true);
        fmnp.setVisible(true);
        TblModelKorisnik tmk = new TblModelKorisnik(listaKorisnikaFilter);
        jtblKorisnici.setModel(tmk);
        jComboKorisnici.removeAllItems();
        for (Korisnik korisnik : listaKorisnikaFilter) {
            jComboKorisnici.addItem(korisnik);
        }
        if (listaKorisnikaFilter.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje korisnike po zadatim vrednostima!", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnNaprednaPretragaActionPerformed

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void jtblKorisniciFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtblKorisniciFocusGained

    }//GEN-LAST:event_jtblKorisniciFocusGained

    private void jtblKorisniciFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtblKorisniciFocusLost

    }//GEN-LAST:event_jtblKorisniciFocusLost

    private void jbtnResetujRezultateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetujRezultateActionPerformed
        popuniTabeluKorisnici();
        popuniComboKorisnici();
        dodajComboMestaUTabelu();
    }//GEN-LAST:event_jbtnResetujRezultateActionPerformed

    private void btnObrisiKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiKorisnikaActionPerformed
        int izKorisnik = jtblKorisnici.getSelectedRow();
        if (izKorisnik == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite korisnika kojeg zelite izbrisati!");
        } else {
            TblModelKorisnik tmk = (TblModelKorisnik) jtblKorisnici.getModel();
            Korisnik k = tmk.vratiKorisnika(izKorisnik);

            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this, "Da li zelite izbrisati korisnika " + k.getIme() + " " + k.getPrezime() + "?", "Brisanje korisnika", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, "Da");

            if (izbor == 0) {
                try {
                    boolean izbrisan = Kontroler.vratiInstancuKontrolera().izbrisiKorisnika(k);
                    if (izbrisan) {
                        JOptionPane.showMessageDialog(this, "Sistem je obrisao korisnika!", "Brisanje korisnika", JOptionPane.INFORMATION_MESSAGE);
                        popuniTabeluKorisnici();
                        popuniComboKorisnici();
                        dodajComboMestaUTabelu();
                        return;
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise korisnika!", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnObrisiKorisnikaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisiKorisnika;
    private javax.swing.JComboBox jComboKorisnici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnNaprednaPretraga;
    private javax.swing.JButton jbtnResetujRezultate;
    private javax.swing.JButton jbtn_detalji;
    private javax.swing.JTable jtblKorisnici;
    // End of variables declaration//GEN-END:variables

    private void popuniComboKorisnici() {
        jComboKorisnici.removeAllItems();
        List<Korisnik> listaKorisnika = new ArrayList<>();
        try {
            listaKorisnika = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
        } catch (Exception ex) {
            System.out.println("Korisnici nisu pronadjeni!");
        }
        for (Korisnik korisnik : listaKorisnika) {
            jComboKorisnici.addItem(korisnik);
        }
    }

    private void popuniTabeluKorisnici() {
        List<Korisnik> lk = new ArrayList<>();
        try {
            lk = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
        } catch (Exception ex) {
            System.out.println("Korisnici nisu pronadjeni!");
        }
        jtblKorisnici.setModel(new TblModelKorisnik(lk));

        ListSelectionModel lsm = jtblKorisnici.getSelectionModel();
        lsm.setSelectionInterval(0, 0);
    }

    private void dodajComboMestaUTabelu() {
        JComboBox jck = new JComboBox<Mesto>();
        try {
            jck.setModel(new DefaultComboBoxModel(Kontroler.vratiInstancuKontrolera().vratiListuMesta().toArray()));
        } catch (Exception ex) {
            System.out.println("Mesta nisu pronadjena!");
        }

        TableColumnModel tcm = jtblKorisnici.getColumnModel();
        TableColumn tm = tcm.getColumn(5);
        tm.setCellEditor(new DefaultCellEditor(jck));
    }

}
