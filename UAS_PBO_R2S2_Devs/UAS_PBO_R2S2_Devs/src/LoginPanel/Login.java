/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LoginPanel;

import Login.HalamanLogin;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 *
 * @author rafai
 */
public class Login extends javax.swing.JPanel {
    private HalamanLogin parentFrame; // Simpan referensi ke HalamanLogin
    /**
     * Creates new form Login
     */
    public Login(HalamanLogin parentFrame) {
        initComponents();
        this.parentFrame = parentFrame; // Simpan referensi HalamanLogin        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LoginCustBtn = new javax.swing.JButton();
        LoginAdmBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 3));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Hallo Sobat Bean's !");

        jLabel14.setText("Masuk dan coba makanan dari B&B Food's");

        LoginCustBtn.setBackground(new java.awt.Color(153, 0, 0));
        LoginCustBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginCustBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginCustBtn.setText("Login Customer");
        LoginCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginCustBtnActionPerformed(evt);
            }
        });

        LoginAdmBtn.setForeground(new java.awt.Color(0, 0, 204));
        LoginAdmBtn.setText("Admin");
        LoginAdmBtn.setBorder(null);
        LoginAdmBtn.setBorderPainted(false);
        LoginAdmBtn.setContentAreaFilled(false);
        LoginAdmBtn.setFocusPainted(false);
        LoginAdmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginAdmBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("coba sensasi makanan yang bisa membuatmu ketagihan !");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\ResoPbo\\burger-removebg-preview.png")); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(77, 77, 77))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel13))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(LoginCustBtn)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(LoginAdmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(32, 32, 32)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(71, 71, 71)
                .addComponent(LoginCustBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(LoginAdmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginCustBtnActionPerformed
        // Akses panel Main dari parentFrame
        JPanel mainPanel = parentFrame.getMain(); // Ambil referensi Main
        mainPanel.removeAll();

        // Tambahkan panel LoginCustomer ke Main
        parentFrame.switchPanel(new LoginCustomer(parentFrame));

        // Validasi ulang dan perbarui tampilan
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_LoginCustBtnActionPerformed

    private void LoginAdmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginAdmBtnActionPerformed
        // Akses panel Main dari parentFrame
        JPanel mainPanel = parentFrame.getMain(); // Ambil referensi Main
        mainPanel.removeAll();

        // Tambahkan AdminPage ke Main
        parentFrame.switchPanel(new LoginAdmin(parentFrame));

        // Validasi ulang dan perbarui tampilan
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_LoginAdmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginAdmBtn;
    private javax.swing.JButton LoginCustBtn;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
