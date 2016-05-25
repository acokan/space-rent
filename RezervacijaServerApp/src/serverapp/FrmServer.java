/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import com.sun.xml.internal.fastinfoset.DecoderStateTables;
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco Kandic
 */
public class FrmServer extends javax.swing.JFrame {

    private boolean pokrenut = false;

    /**
     * Creates new form FrmServer
     */
    public FrmServer() {
        initComponents();
        srediStatusPanel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlblStatusServera = new javax.swing.JLabel();
        jbtnPokreniServer = new javax.swing.JButton();
        jpnlStatusnaBoja = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAdministratori = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmPodesavanja = new javax.swing.JMenu();
        jmiPodesavanjePorta = new javax.swing.JMenuItem();
        jmiParametriBaze = new javax.swing.JMenuItem();
        jmAdministracija = new javax.swing.JMenu();
        jmiUpravljanjeKorisnicima = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jlblStatusServera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblStatusServera.setText("Server nije pokrenut!");

        jbtnPokreniServer.setText("Pokreni");
        jbtnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPokreniServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlStatusnaBojaLayout = new javax.swing.GroupLayout(jpnlStatusnaBoja);
        jpnlStatusnaBoja.setLayout(jpnlStatusnaBojaLayout);
        jpnlStatusnaBojaLayout.setHorizontalGroup(
            jpnlStatusnaBojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jpnlStatusnaBojaLayout.setVerticalGroup(
            jpnlStatusnaBojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblStatusServera, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnPokreniServer)
                .addGap(26, 26, 26)
                .addComponent(jpnlStatusnaBoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnlStatusnaBoja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnPokreniServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jlblStatusServera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aktivni korisnici"));

        jtblAdministratori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ime", "Prezime", "Korisnicko ime"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblAdministratori);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        jmPodesavanja.setText("Podesavanja");

        jmiPodesavanjePorta.setText("Podesavanje porta");
        jmPodesavanja.add(jmiPodesavanjePorta);

        jmiParametriBaze.setText("Parametri baze");
        jmPodesavanja.add(jmiParametriBaze);

        jMenuBar1.add(jmPodesavanja);

        jmAdministracija.setText("Administracija");

        jmiUpravljanjeKorisnicima.setText("Upravljanje korisnicima");
        jmAdministracija.add(jmiUpravljanjeKorisnicima);

        jMenuBar1.add(jmAdministracija);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPokreniServerActionPerformed
        if (pokrenut == true) {
            try {
                zaustaviServer();
                jbtnPokreniServer.setText("Pokreni");
                jpnlStatusnaBoja.setBackground(Color.RED);
                jlblStatusServera.setText("Server nije pokrenut!");
                pokrenut = false;
            } catch (Exception ex) {
                Logger.getLogger(FrmServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                pokreniServer();
                jbtnPokreniServer.setText("Zaustavi");
                jbtnPokreniServer.setEnabled(false);
                jpnlStatusnaBoja.setBackground(Color.GREEN);
                jlblStatusServera.setText("Server je pokrenut!");
                pokrenut = true;
            } catch (IOException ex) {
                Logger.getLogger(FrmServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jbtnPokreniServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPokreniServer;
    private javax.swing.JLabel jlblStatusServera;
    private javax.swing.JMenu jmAdministracija;
    private javax.swing.JMenu jmPodesavanja;
    private javax.swing.JMenuItem jmiParametriBaze;
    private javax.swing.JMenuItem jmiPodesavanjePorta;
    private javax.swing.JMenuItem jmiUpravljanjeKorisnicima;
    private javax.swing.JPanel jpnlStatusnaBoja;
    private javax.swing.JTable jtblAdministratori;
    // End of variables declaration//GEN-END:variables

    private void srediStatusPanel() {
        jbtnPokreniServer.setText("Pokreni");
        jpnlStatusnaBoja.setBackground(Color.red);
        System.out.println("Server nije pokrenut!");
    }

    NitKlijent nitKlijent;
    List<NitKlijent> listaKlijenata;
    boolean izvrsavaSe = true;

    private void pokreniServer() throws IOException {

        SocketServer ss = new SocketServer(9010);
        ss.start();

    }

    private void zaustaviServer() throws IOException {
//        SocketServer.zaustaviServer();
//        System.out.println(SocketServer.izvrsavaSe);
    }
}
