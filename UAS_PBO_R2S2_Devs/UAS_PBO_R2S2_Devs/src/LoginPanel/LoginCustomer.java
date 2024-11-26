/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LoginPanel;

import Customer.HalamanUtama;
import Login.DbConnection;
import Login.LoginDAO;
import Login.HalamanLogin;
import static Login.LoginDAO.generatePelangganId;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import Login.LoginSession;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginCustomer extends javax.swing.JPanel {
    private HalamanLogin parentFrame; // Menyimpan referensi ke HalamanLogin

    public LoginCustomer(HalamanLogin parentFrame) {
        this.parentFrame = parentFrame; // Simpan referensi ke HalamanLogin
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        NamaUserField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NomorMejaField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 7));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setText("Nomor Meja");

        btnMasuk.setBackground(new java.awt.Color(153, 0, 0));
        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setText("Pesan Sekarang");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setText("Selamat Datang Di Aplikasi");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText(" Beans & Burger's");

        jLabel2.setText("Masukan nama dan nomor meja Anda");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NamaUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(NomorMejaField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnMasuk))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(BackBtn)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NamaUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NomorMejaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(btnMasuk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(BackBtn)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 560));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        String pelangganId = generatePelangganId(); // Buat ID pelanggan baru
        String username = NamaUserField.getText();
        String noMeja = NomorMejaField.getText();

        // Validasi input kosong
        if (!validasiInput(username, noMeja)) return;

        // Simpan data pelanggan dan validasi meja
        int nomorMeja = Integer.parseInt(noMeja);
        if (isMejaTersedia(nomorMeja) && LoginDAO.tambahPelanggan(pelangganId, username, nomorMeja)) {
            // Ubah status meja menjadi TRUE (terpakai)
            if (!updateStatusMeja(nomorMeja, true)) {
                JOptionPane.showMessageDialog(this, "Gagal mengubah status meja menjadi terpakai.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LoginSession.pelangganId = pelangganId; // Simpan ke sesi login
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil terdaftar.", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Pindah ke halaman utama
            bukaHalamanUtama();
        } else {
            JOptionPane.showMessageDialog(this, "Meja tidak tersedia atau gagal menyimpan data pelanggan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode validasi input
    private boolean validasiInput(String username, String noMeja) {
        if (username.isEmpty() || noMeja.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan Nomor Meja tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!username.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Nama hanya boleh huruf dan spasi.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(noMeja); // Validasi apakah nomor meja angka
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nomor meja harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Metode untuk memvalidasi meja tersedia
    private boolean isMejaTersedia(int noMeja) {
        try (Connection conn = DbConnection.getConnection()) {
            String query = "SELECT * FROM meja WHERE no_meja = ? AND status = FALSE";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, noMeja);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // TRUE jika ada hasil, berarti meja tersedia
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memvalidasi meja.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Metode untuk mengubah status meja
    private boolean updateStatusMeja(int noMeja, boolean status) {
        try (Connection conn = DbConnection.getConnection()) {
            String query = "UPDATE meja SET status = ? WHERE no_meja = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setBoolean(1, status); // TRUE untuk terpakai, FALSE untuk tidak terpakai
            stmt.setInt(2, noMeja);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah status meja.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Metode untuk membuka halaman utama
    private void bukaHalamanUtama() {
        HalamanUtama halamanUtama = new HalamanUtama();
        halamanUtama.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose(); // Tutup form login
    }//GEN-LAST:event_btnMasukActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        parentFrame.switchPanel(new Login(parentFrame));
    }//GEN-LAST:event_BackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTextField NamaUserField;
    private javax.swing.JTextField NomorMejaField;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
