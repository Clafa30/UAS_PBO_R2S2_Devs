/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminPanel;

import Login.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InBoundPanel extends javax.swing.JPanel {
    private ActivityPanel activityPanel;

    public InBoundPanel() {
        initComponents();
        loadPesananData(); // Memuat data saat panel dibuat
        activityPanel = new ActivityPanel();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        SelesaiPesananBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetailPesananTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1387, 720));

        jPanel3.setBackground(new java.awt.Color(218, 41, 28));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        SelesaiPesananBtn.setText("Selesaikan Pesanan");
        SelesaiPesananBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelesaiPesananBtnActionPerformed(evt);
            }
        });

        DetailPesananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Riwayat Id", "Nama Pelanggan", "Status Pembayaran", "Status Pesanan", "Total Harga", "Order Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(DetailPesananTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(689, Short.MAX_VALUE)
                .addComponent(SelesaiPesananBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(490, 490, 490))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SelesaiPesananBtn)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SelesaiPesananBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelesaiPesananBtnActionPerformed
        // Ambil ID pesanan yang dipilih dari tabel, misalnya dari baris yang dipilih di tabel DetailPesananTable
        int selectedRow = DetailPesananTable.getSelectedRow();

        if (selectedRow != -1) {
            // Dapatkan pesanan_id dari kolom pertama pada baris yang dipilih
            int pesananId = (int) DetailPesananTable.getValueAt(selectedRow, 0);  // Asumsikan kolom pertama adalah Pesanan Id

            // Cek apakah status pesanan 'selesai'
            String statusPesanan = (String) DetailPesananTable.getValueAt(selectedRow, 3);  // Status Pesanan ada di kolom ke-4
            if ("selesai".equalsIgnoreCase(statusPesanan)) {
                JOptionPane.showMessageDialog(this, "Pesanan sudah selesai!");
                return;  
            }

            // Update status pesanan menjadi 'selesai' di database
            updateStatusPesanan(pesananId);

            // Pindahkan data dari DetailPesananTable ke ActivityTable
            moveToActivityTable(selectedRow);

            activityPanel.loadPesananData(); 

            // Hapus data dari DetailPesananTable
            DefaultTableModel modelDetailPesanan = (DefaultTableModel) DetailPesananTable.getModel();
            modelDetailPesanan.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih pesanan yang ingin dipindahkan.");
        }
    }//GEN-LAST:event_SelesaiPesananBtnActionPerformed

    private void loadPesananData() {
        String query = "SELECT r.riwayat_id, r.pelanggan_id, pl.nama_pelanggan, r.status_pembayaran, r.status_pesanan, r.total, r.tanggal_pemesanan " +
                       "FROM riwayat r " +
                       "JOIN pelanggan pl ON r.pelanggan_id = pl.pelanggan_id " + 
                       "WHERE r.status_pesanan != 'Selesai'";  // Menyaring hanya yang status pesanan bukan 'Selesai'

        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query); 
             ResultSet rs = stmt.executeQuery()) {

            // Ambil model tabel
            DefaultTableModel modelDetailPesanan = (DefaultTableModel) DetailPesananTable.getModel();

            // Hapus data lama dari tabel (jika perlu)
            modelDetailPesanan.setRowCount(0);

            // Isi tabel dengan data dari ResultSet
            while (rs.next()) {
                // Menambahkan data ke tabel DetailPesananTable
                modelDetailPesanan.addRow(new Object[] {
                    rs.getInt("riwayat_id"),  // Pesanan Id
                    rs.getString("pelanggan_id"),  // Pelanggan Id
                    rs.getString("nama_pelanggan"),  // Nama Pelanggan
                    rs.getString("status_pembayaran"),  // Status Pembayaran
                    rs.getString("status_pesanan"),  // Status Pesanan
                    rs.getDouble("total"),  // Total Harga
                    rs.getTimestamp("tanggal_pemesanan")  // Order Time
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Tangani kesalahan koneksi atau query
        }
    }

    private void updateStatusPesanan(int pesananId) {
        PreparedStatement stmt = null;

        try (Connection conn = DbConnection.getConnection()) {

            // Query untuk mengupdate status pesanan menjadi 'selesai'
            String query = "UPDATE riwayat SET status_pesanan = ? WHERE riwayat_id = ?";

            // Persiapkan statement SQL
            stmt = conn.prepareStatement(query);
            stmt.setString(1, "selesai");  // Set status menjadi 'selesai'
            stmt.setInt(2, pesananId);     // Set pesanan_id yang dipilih

            // Eksekusi update
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Tampilkan pesan sukses
                JOptionPane.showMessageDialog(this, "Pesanan telah diperbarui menjadi selesai.");
            } else {
                // Jika tidak ada yang terupdate
                JOptionPane.showMessageDialog(this, "Gagal memperbarui status pesanan.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Tangani error database
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui pesanan.");
        } 
    }    
    
    private void moveToActivityTable(int selectedRow) {
       // Ambil model tabel DetailPesananTable dan ActivityTable
        DefaultTableModel modelDetailPesanan = (DefaultTableModel) DetailPesananTable.getModel();
        DefaultTableModel modelActivity = (DefaultTableModel) activityPanel.getActivityTable().getModel();

        // Ambil data dari baris yang dipilih di DetailPesananTable
        int pesananId = (int) modelDetailPesanan.getValueAt(selectedRow, 0);  // Pesanan ID
        String namaPelanggan = (String) modelDetailPesanan.getValueAt(selectedRow, 1);  // Nama User
        String statusPembayaran = (String) modelDetailPesanan.getValueAt(selectedRow, 2);  // Status Pembayaran
        String statusPesanan = (String) modelDetailPesanan.getValueAt(selectedRow, 3);  // Status Pesanan
        String totalHarga = (String) modelDetailPesanan.getValueAt(selectedRow, 4);  // Total
        String waktuPesan = modelDetailPesanan.getValueAt(selectedRow, 5).toString();  // Waktu Pesan (formatkan jika perlu)

        // Tambahkan data ke ActivityTable
        modelActivity.addRow(new Object[] { 
            pesananId, 
            namaPelanggan, 
            statusPembayaran, 
            statusPesanan, 
            totalHarga, 
            waktuPesan
        });

        // Pastikan ActivityTable di-refresh setelah data dipindahkan
        activityPanel.getActivityTable().revalidate();
        activityPanel.getActivityTable().repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DetailPesananTable;
    private javax.swing.JButton SelesaiPesananBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
