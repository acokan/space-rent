/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kontroler.Kontroler;
import model.TblAdministratori;
import niti.NitKlijent;
import serverapp.SocketServer;

/**
 *
 * @author Aco Kandic
 */
public class FrmUpravljanjeAdministratorima extends javax.swing.JFrame {

    SocketServer ss;
    List<OpstiDomenskiObjekat> onlineKorisnici;

    /**
     * Creates new form FrmUpravljanjeAdminima
     */
    public FrmUpravljanjeAdministratorima() {
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSviAdmini = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Upravljanje administratorima");

        jtblSviAdmini.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblSviAdmini);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnIzbrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzbrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOdustani))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        FrmNoviAdministrator fna = new FrmNoviAdministrator(this, true);
        fna.setVisible(true);
        srediTabelu();

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        try {
            int selektovaniAdmin = jtblSviAdmini.getSelectedRow();
            if (selektovaniAdmin == -1) {
                JOptionPane.showMessageDialog(this, "Selektujte administratora");
            } else {
                TblAdministratori ta = (TblAdministratori) jtblSviAdmini.getModel();
                OpstiDomenskiObjekat a = ta.vratiAdmina(selektovaniAdmin);
                DBBroker.vratiInstancu().obrisi(a);
                JOptionPane.showMessageDialog(this, "Administrator je obrisan");
                srediTabelu();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmUpravljanjeAdministratorima.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOdustaniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblSviAdmini;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {

        try {
            jtblSviAdmini.setModel(new TblAdministratori(Kontroler.vratiInstancuKontrolera().vratiListuAdministratora()));
            System.out.println("tab popunjena");
        } catch (Exception ex) {
            Logger.getLogger(FrmUpravljanjeAdministratorima.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
