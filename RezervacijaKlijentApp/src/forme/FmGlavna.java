/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Administrator;
import forme.rezervacija.FmPretragaRezervacija;
import forme.rezervacija.FmUnosRezervacije;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import korisnici.kontroler.Kontroler;
import start.Start;
import util.Util;

/**
 *
 * @author Aco Kandic
 */
public class FmGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FmGlavna
     */
    public FmGlavna() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        new Start().start();

        Administrator admin = (Administrator) Kontroler.vratiInstancuKontrolera().getSesija().get("ulogovani_admin");
        if (admin != null) {
            jMenuBar1.setVisible(true);
        } else {
            jMenuBar1.setVisible(false);
        }

        //Option dialog za zatvaranje aplikacije
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                Object[] opcije = {"Da", "Ne"};
                int izbor = JOptionPane.showOptionDialog(null, "Da li ste sigurni zelite zatvoriti aplikaciju?", "Kraj", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opcije, "Da");
                if (izbor == 0) {
                    System.exit(0);
                }
            }
        });

        //Klikom na "Ne", program se ne minimizira
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlLogin = new javax.swing.JPanel();
        jlblStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtKorisnickoIme = new javax.swing.JTextField();
        jbtnPrijaviSe = new javax.swing.JButton();
        jtxtSifra = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmKorisnik = new javax.swing.JMenu();
        jmiUnosKorisnika = new javax.swing.JMenuItem();
        jmiPretragaKorisnika = new javax.swing.JMenuItem();
        jmRezervacija = new javax.swing.JMenu();
        jmiUnosRezervacije = new javax.swing.JMenuItem();
        jmiPretragaRezervacija = new javax.swing.JMenuItem();
        jmAdministrator = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rezervacija coworking prostora");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblStatus.setText("Prijavite se na sistem");

        jLabel2.setText("Korisničko ime:");

        jLabel3.setText("Šifra:");

        jbtnPrijaviSe.setText("Prijavi se");
        jbtnPrijaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrijaviSeActionPerformed(evt);
            }
        });

        jtxtSifra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSifraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlLoginLayout = new javax.swing.GroupLayout(jpnlLogin);
        jpnlLogin.setLayout(jpnlLoginLayout);
        jpnlLoginLayout.setHorizontalGroup(
            jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbtnPrijaviSe)
                        .addGroup(jpnlLoginLayout.createSequentialGroup()
                            .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(jtxtSifra))))
                    .addComponent(jlblStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlLoginLayout.setVerticalGroup(
            jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblStatus)
                .addGap(31, 31, 31)
                .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtxtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnPrijaviSe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        getContentPane().add(jpnlLogin, gridBagConstraints);

        jmKorisnik.setText("Korisnik");

        jmiUnosKorisnika.setText("Unos korisnika");
        jmiUnosKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosKorisnikaActionPerformed(evt);
            }
        });
        jmKorisnik.add(jmiUnosKorisnika);

        jmiPretragaKorisnika.setText("Pretraga korisnika");
        jmiPretragaKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaKorisnikaActionPerformed(evt);
            }
        });
        jmKorisnik.add(jmiPretragaKorisnika);

        jMenuBar1.add(jmKorisnik);

        jmRezervacija.setText("Rezervacija");

        jmiUnosRezervacije.setText("Unos rezervacije");
        jmiUnosRezervacije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosRezervacijeActionPerformed(evt);
            }
        });
        jmRezervacija.add(jmiUnosRezervacije);

        jmiPretragaRezervacija.setText("Pretraga rezervacija");
        jmiPretragaRezervacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaRezervacijaActionPerformed(evt);
            }
        });
        jmRezervacija.add(jmiPretragaRezervacija);

        jMenuBar1.add(jmRezervacija);

        jmAdministrator.setText("Administrator");

        jmiLogout.setText("Odjavi se");
        jmiLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogoutActionPerformed(evt);
            }
        });
        jmAdministrator.add(jmiLogout);

        jMenuBar1.add(jmAdministrator);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosKorisnikaActionPerformed
        Kontroler.vratiInstancuKontrolera().setAktivanSK(Util.SK_UNOS_KORISNIKA);
        FmKorisnik fmk = new FmKorisnik(this, true);
        fmk.setVisible(true);
    }//GEN-LAST:event_jmiUnosKorisnikaActionPerformed

    private void jmiPretragaKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaKorisnikaActionPerformed
        FmPretragaKorisnika korisnici = new FmPretragaKorisnika(this, true);
        korisnici.setVisible(true);
    }//GEN-LAST:event_jmiPretragaKorisnikaActionPerformed

    private void jbtnPrijaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrijaviSeActionPerformed
        String username = jtxtKorisnickoIme.getText().trim();
        String password = jtxtSifra.getText().trim();
        Administrator a = new Administrator(0, "", "", username, password, "");

        try {
            Administrator ulogovani = Kontroler.vratiInstancuKontrolera().ulogujAdministratora(a);
            System.out.println(ulogovani);
            if (ulogovani != null) {
                Kontroler.vratiInstancuKontrolera().getSesija().put("ulogovani_admin", a);
                jtxtKorisnickoIme.setText("");
                jtxtSifra.setText("");
                jtxtKorisnickoIme.setVisible(false);
                jtxtSifra.setVisible(false);
                jbtnPrijaviSe.setVisible(false);
                jlblStatus.setText("Dobrodosao/la " + username + ". Uspesno ste prijavljeni na sistem!");
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jbtnPrijaviSe.setVisible(false);
                jMenuBar1.setVisible(true);
            } else {
                jlblStatus.setText("Sistem ne moze da pronadje administratora!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtnPrijaviSeActionPerformed

    private void jmiLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogoutActionPerformed
        Kontroler.vratiInstancuKontrolera().getSesija().put("ulogovani_admin", null);
        Administrator a = (Administrator) Kontroler.vratiInstancuKontrolera().getSesija().get("ulogovani_admin");
        if (a == null) {
            jtxtKorisnickoIme.setVisible(true);
            jtxtSifra.setVisible(true);
            jbtnPrijaviSe.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jbtnPrijaviSe.setVisible(true);
            jMenuBar1.setVisible(false);
            jlblStatus.setText("Prijavite se na sistem");
        }
    }//GEN-LAST:event_jmiLogoutActionPerformed

    private void jtxtSifraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSifraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSifraActionPerformed

    private void jmiUnosRezervacijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosRezervacijeActionPerformed
        FmUnosRezervacije fur = new FmUnosRezervacije();
        fur.setVisible(true);
    }//GEN-LAST:event_jmiUnosRezervacijeActionPerformed

    private void jmiPretragaRezervacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaRezervacijaActionPerformed
        FmPretragaRezervacija fpr = new FmPretragaRezervacija(this, true);
        fpr.setVisible(true);
    }//GEN-LAST:event_jmiPretragaRezervacijaActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FmGlavna().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbtnPrijaviSe;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JMenu jmAdministrator;
    private javax.swing.JMenu jmKorisnik;
    private javax.swing.JMenu jmRezervacija;
    private javax.swing.JMenuItem jmiLogout;
    private javax.swing.JMenuItem jmiPretragaKorisnika;
    private javax.swing.JMenuItem jmiPretragaRezervacija;
    private javax.swing.JMenuItem jmiUnosKorisnika;
    private javax.swing.JMenuItem jmiUnosRezervacije;
    private javax.swing.JPanel jpnlLogin;
    private javax.swing.JTextField jtxtKorisnickoIme;
    private javax.swing.JPasswordField jtxtSifra;
    // End of variables declaration//GEN-END:variables
}
