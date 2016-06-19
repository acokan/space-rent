/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Aco Kandic
 */
public class FrmNoviAdministrator extends javax.swing.JDialog {

    /**
     * Creates new form FrmNoviAdministrator
     */
    public FrmNoviAdministrator(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKorIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        txtSifra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dodaj administratora"));

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Korisnicko ime:");

        jLabel4.setText("Sifra:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIme))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKorIme, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOdustani)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSacuvaj)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOdustani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        Administrator admin = new Administrator();

        String ime = txtIme.getText().trim();
        if (ime == null || ime.isEmpty()) {
            txtIme.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            JOptionPane.showMessageDialog(this, "Unesite ime administratora");
            return;
        }
        admin.setIme(ime);

        String prezime = txtPrezime.getText().trim();
        if (prezime == null || prezime.isEmpty()) {
            txtPrezime.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            JOptionPane.showMessageDialog(this, "Unesite prezime administratora");
            return;
        }
        admin.setPrezime(prezime);

        String korIme = txtKorIme.getText().trim();
        if (korIme == null || korIme.isEmpty()) {
            txtKorIme.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            JOptionPane.showMessageDialog(this, "Unesite korisnicko ime administratora");
            return;
        }
        admin.setKorisnickoIme(korIme);

        String sifra = txtSifra.getText().trim();
        if (sifra == null || sifra.isEmpty()) {
            txtSifra.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
            JOptionPane.showMessageDialog(this, "Unesite sifru administratora");
            return;
        }
        admin.setSifra(sifra);

        admin.setUlogovan("Offline");

        int maks = 0;
        try {
            List<OpstiDomenskiObjekat> l = DBBroker.vratiInstancu().vratiSveObjekte(new Administrator());

            Administrator a = (Administrator) l.get(0);
            maks = a.getAdministratorID();
            for (int j = 1; j < l.size(); j++) {
                Administrator ad = (Administrator) l.get(j);
                if (ad.getAdministratorID() > maks) {
                    maks = ad.getAdministratorID();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmNoviAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }

        admin.setAdministratorID(maks+1);

        OpstiDomenskiObjekat odo = admin;
        System.out.println(odo);
        try {
            DBBroker.vratiInstancu().sacuvaj(odo);
            JOptionPane.showMessageDialog(this, "Administrator je sacuvan");
            txtIme.setText("");
            txtPrezime.setText("");
            txtKorIme.setText("");
            txtSifra.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Administrator nije sacuvan");
            Logger.getLogger(FrmNoviAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOdustaniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSifra;
    // End of variables declaration//GEN-END:variables
}
