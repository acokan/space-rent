/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.korisnik;

import domen.Korisnik;
import domen.Mesto;
import model.TblModelKorisnik;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Aco Kandic
 */
public class FmNaprednaPretraga extends javax.swing.JDialog {

    /**
     * Creates new form FmNaprednaPretraga
     */
    public FmNaprednaPretraga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popuniComboMesto();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtPretragaPrezime = new javax.swing.JTextField();
        jComboMesto = new javax.swing.JComboBox();
        jbtnPretraga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Napredna pretraga");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Napredna pretraga korisnika");

        jLabel2.setText("Pretrazi po prezimenu:");

        jLabel3.setText("Pretrazi po mestu stanovanja:");

        jtxtPretragaPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPretragaPrezimeActionPerformed(evt);
            }
        });

        jbtnPretraga.setText("Trazi");
        jbtnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretragaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtPretragaPrezime)
                            .addComponent(jComboMesto, 0, 293, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnPretraga)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtPretragaPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnPretraga)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtPretragaPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPretragaPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPretragaPrezimeActionPerformed

    private void jbtnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretragaActionPerformed
        if (jtxtPretragaPrezime.getText().trim().isEmpty()) {
            pretraziPoMestu();
        } else {
            pretraziPoPrezimenu();
        }
    }//GEN-LAST:event_jbtnPretragaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboMesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnPretraga;
    private javax.swing.JTextField jtxtPretragaPrezime;
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

    private void pretraziPoPrezimenu() {
        String prezime = jtxtPretragaPrezime.getText().trim();
        try {
            List<Korisnik> listaSvihKorisnika = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
            List<Korisnik> listaKorisnikaFinal = new ArrayList<>();
            for (Korisnik korisnik : listaSvihKorisnika) {
                if (korisnik.getPrezime().startsWith(prezime)) {
                    listaKorisnikaFinal.add(korisnik);
                }
            }
            FmPretragaKorisnika.listaKorisnikaFilter = listaKorisnikaFinal;
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
        setVisible(false);
    }

    private void pretraziPoMestu() {
        try {
            Mesto mesto = (Mesto) jComboMesto.getSelectedItem();
            List<Korisnik> listaK = Kontroler.vratiInstancuKontrolera().vratiListuKorisnika();
            List<Korisnik> lista = new ArrayList<>();

            for (Korisnik k : listaK) {
                if (mesto.equals(k.getMesto())) {
                    lista.add(k);
                }
            }
            FmPretragaKorisnika.listaKorisnikaFilter = lista;
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
        setVisible(false);
    }

}