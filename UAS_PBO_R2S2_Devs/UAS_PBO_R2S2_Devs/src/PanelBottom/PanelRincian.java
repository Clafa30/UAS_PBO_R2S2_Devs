/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelBottom;

import Customer.HalamanUtama;
import DataDAO.DataDAO;
import Login.DbConnection;
import Login.LoginSession;
import Login.LoginDAO;
import panel.PanelActivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PanelRincian extends javax.swing.JPanel {
    private static PanelRincian instance;
    private DefaultTableModel tableModel;
    private DataDAO dataDAO;    
    private HalamanUtama halamanUtama;
    private PanelActivity panelActivity;
    
    public static synchronized PanelRincian getInstance(HalamanUtama halamanUtama) {
        if (instance == null) {
            instance = new PanelRincian(halamanUtama);
        }
        return instance;
    }

    public PanelRincian(HalamanUtama halamanUtama) {
        initComponents(); // Pastikan panel memiliki UI
        this.halamanUtama = halamanUtama;
        panelActivity = new PanelActivity(halamanUtama);
        
        JumlahBayarField.setText("Rp 0");
        TotalPsnanField.setText("0");
  
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Menu ID", "Nama Menu", "Harga", "Jumlah", "Total"});
        jTable1.setModel(tableModel);
    }
    
    public void setJumlahBayarField(String text) {
        JumlahBayarField.setText(text);  // Memperbarui JumlahBayarField
    }

    public void setTotalPsnanField(String text) {
        TotalPsnanField.setText(text);  // Memperbarui TotalPsnanField
    }
  
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public void setHalamanUtama(HalamanUtama halamanUtama) {
        if (halamanUtama == null) {
            System.out.println("HalamanUtama belum diteruskan.");
        } else {
            System.out.println("HalamanUtama berhasil diteruskan.");
            this.halamanUtama = halamanUtama;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        BayarBtn = new javax.swing.JButton();
        lbJumlahBayar = new javax.swing.JLabel();
        lbJumlahTotalPesanan = new javax.swing.JLabel();
        JumlahBayarField = new javax.swing.JLabel();
        TotalPsnanField = new javax.swing.JLabel();
        RiwayaPsnanBtn = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Menu Id", "Menu", "Harga", "Jumlah", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Rincian Pesanan");

        ExitBtn.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Batalkan");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        BayarBtn.setText("Bayar");
        BayarBtn.setEnabled(false);
        BayarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarBtnActionPerformed(evt);
            }
        });

        lbJumlahBayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbJumlahBayar.setText("Jumlah Bayar  :");

        lbJumlahTotalPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbJumlahTotalPesanan.setText("Total Pesanan :");

        JumlahBayarField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TotalPsnanField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RiwayaPsnanBtn.setBackground(new java.awt.Color(255, 255, 0));
        RiwayaPsnanBtn.setText("Riwayat Pesanan");
        RiwayaPsnanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiwayaPsnanBtnActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ExitBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RiwayaPsnanBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(CancelBtn)
                                .addGap(18, 18, 18)
                                .addComponent(BayarBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JumlahBayarField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lbJumlahTotalPesanan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalPsnanField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbJumlahBayar)
                                    .addComponent(JumlahBayarField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbJumlahTotalPesanan))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TotalPsnanField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitBtn)
                    .addComponent(CancelBtn)
                    .addComponent(BayarBtn)
                    .addComponent(RiwayaPsnanBtn))
                .addGap(17, 17, 17))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // Tanyakan konfirmasi kepada pengguna
        String pelangganId = LoginSession.pelangganId; // Ambil ID pelanggan dari sesi
        int option = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin keluar? Semua data di keranjang akan dibersihkan.", 
            "Konfirmasi Keluar", 
            JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            if (LoginDAO.hapusPelangganDanKeranjang(pelangganId)) {
                exit();
            } else {
                System.out.println("Gagal menghapus data pelanggan dan keranjang.");
            }

            System.exit(0); // Keluar dari aplikasi
        }
    }//GEN-LAST:event_ExitBtnActionPerformed
   
    public void setBayarButtonEnabled(boolean enabled) {
        BayarBtn.setEnabled(enabled);  // Meng-enable atau disable tombol Bayar
    }   

    private void BayarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarBtnActionPerformed
    // Pastikan halamanUtama diinisialisasi
        if (halamanUtama == null) {
            halamanUtama = new HalamanUtama();
            System.out.println("halamanUtama diinisialisasi.");
        }
        
        System.out.println("Memanggil metode showPanelPembayaran...");
        halamanUtama.getPanelPembayaran().LoadRincian();  // Memuat rincian setelah komponen siap
        halamanUtama.getPanelPembayaran().grandTotal();  // Memuat rincian setelah komponen siap
        this.halamanUtama.showPanelPembayaran(); // Memanggil metode showPanelPembayaran
    }//GEN-LAST:event_BayarBtnActionPerformed

    private void RiwayaPsnanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RiwayaPsnanBtnActionPerformed
    // Pastikan halamanUtama diinisialisasi
        if (halamanUtama == null) {
            halamanUtama = new HalamanUtama();
            System.out.println("halamanUtama diinisialisasi.");
        }
        
        // Memperbarui data di PanelActivity setelah pembayaran
        PanelActivity panelActivity = halamanUtama.getPanelActivity(); // Mengambil PanelActivity
        panelActivity.loadRiwayatData();  // Memperbarui riwayat setelah pembayaran
        
        System.out.println("Memanggil metode showPanelRiwayat...");
        this.halamanUtama.showPanelRiwayat(); // Memanggil metode showPanelPembayaran
    }//GEN-LAST:event_RiwayaPsnanBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus semua item di keranjang?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (this.dataDAO == null) {
                this.dataDAO = new DataDAO(halamanUtama); // Inisialisasi jika belum dilakukan
        }
            dataDAO.removeKeranjang();

            // Refresh tabel
            refreshTable();

            // Reset semua kontrol di setiap panel
            halamanUtama.resetAllPanels();
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    public DefaultTableModel getRincianTableModel() {
        // Akses panelRincian1 melalui HalamanUtama
        return halamanUtama.getPanelRincian1().getTableModel();
    }
    
    public void refreshTable() {
        DefaultTableModel tableModel = getTableModel();  // Dapatkan model tabel
        tableModel.fireTableDataChanged();  // Segera memperbarui tampilan tabel
        revalidate();  // Revalidate untuk memastikan tampilan diperbarui
        repaint();  // Repaint untuk memastikan perubahan terlihat
    }

    
// Fungsi untuk menghapus data keranjang dari database berdasarkan user_id
public void exit() {
    String pelangganId = LoginSession.pelangganId; // Ambil ID pelanggan dari sesi login
    if (pelangganId == null || pelangganId.isEmpty()) {
        System.out.println("Tidak ada pelanggan ID di sesi login. Tidak ada tindakan yang diambil.");
        return;
    }

    try (Connection conn = DbConnection.getConnection()) {
        // 1. Hapus data dari tabel keranjang
        String query1 = "DELETE FROM keranjang WHERE pelanggan_id = ?";
        try (PreparedStatement pstmt1 = conn.prepareStatement(query1)) {
            pstmt1.setString(1, pelangganId);
            int rowsAffected1 = pstmt1.executeUpdate();
            System.out.println("Data keranjang dihapus: " + rowsAffected1 + " baris.");
        }

        // 2. Hapus data dari tabel pelanggan
        String query2 = "DELETE FROM pelanggan WHERE pelanggan_id = ?";
        try (PreparedStatement pstmt2 = conn.prepareStatement(query2)) {
            pstmt2.setString(1, pelangganId);
            int rowsAffected2 = pstmt2.executeUpdate();
            System.out.println("Data pelanggan dihapus: " + rowsAffected2 + " baris.");
        }

        // 3. Reset status meja menjadi FALSE
        resetMeja(conn, pelangganId);

    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("Error saat logout: " + ex.getMessage());
    }
}   

private void resetMeja(Connection conn, String pelangganId) {
    String query = "UPDATE meja m " +
                   "JOIN pelanggan p ON m.no_meja = p.no_meja " +
                   "SET m.status = 0 " +
                   "WHERE p.pelanggan_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, pelangganId); // Set pelanggan_id
        int rowsUpdated = stmt.executeUpdate();
        System.out.println("Status meja direset: " + rowsUpdated + " baris diperbarui.");
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("Error saat mereset status meja: " + ex.getMessage());
    }
}


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BayarBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JLabel JumlahBayarField;
    private javax.swing.JButton RiwayaPsnanBtn;
    private javax.swing.JLabel TotalPsnanField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbJumlahBayar;
    private javax.swing.JLabel lbJumlahTotalPesanan;
    // End of variables declaration//GEN-END:variables
}
