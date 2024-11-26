/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminPanel;

import Login.DbConnection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityPanel extends javax.swing.JPanel {
    public ActivityPanel() {
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{
            "Riwayat Id", "Nama Pelanggan", "Status Pembayaran", "Status Pesanan", "Total", "tanggal pemesanan"
        });
        ActivityTable.setModel(model);
        
        loadPesananData();
    }

    // Getter untuk ActivityTable
    public JTable getActivityTable() {
        return ActivityTable;
    }

    public void loadPesananData() {
       DefaultTableModel modelActivity = (DefaultTableModel) ActivityTable.getModel();
       modelActivity.setRowCount(0);  // Clear data yang ada di tabel sebelum memuat ulang

    // Query untuk mengambil data pesanan yang statusnya 'Selesai'
    String query = "SELECT " +
                   "r.riwayat_id, " +
                   "pl.nama_pelanggan, " +
                   "r.status_pembayaran, " +
                   "r.status_pesanan, " +
                   "r.total, " +
                   "r.tanggal_pemesanan " +
                   "FROM riwayat r " +
                   "JOIN pelanggan pl ON r.pelanggan_id = pl.pelanggan_id " +
                   "WHERE r.status_pesanan = 'Selesai'";  

       try (Connection conn = DbConnection.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(query); 
            ResultSet rs = stmt.executeQuery()) {

           // Mengambil data dari ResultSet dan memasukkan ke dalam model tabel
           while (rs.next()) {
            int riwayatId = rs.getInt("riwayat_id");
            String namaPelanggan = rs.getString("nama_pelanggan");
            String statusPembayaran = rs.getString("status_pembayaran");
            String statusPesanan = rs.getString("status_pesanan");
            double total = rs.getDouble("total");
            String tanggalPemesanan = rs.getString("tanggal_pemesanan");  

                // Menambahkan data ke ActivityTable
                modelActivity.addRow(new Object[]{
                    riwayatId, namaPelanggan, statusPembayaran, statusPesanan, total, tanggalPemesanan
               });
            }
           
            System.out.println("Memulai pengambilan data...");
            while (rs.next()) {
                System.out.println("Riwayat ID: " + rs.getInt("riwayat_id"));
                System.out.println("Nama Pelanggan: " + rs.getString("nama_pelanggan"));
                // Debugging data lainnya
            }

        // Perbarui tampilan tabe          
        ActivityTable.revalidate();
        ActivityTable.repaint();
       } catch (SQLException ex) {
           ex.printStackTrace(); 
       }
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ActivityTable = new javax.swing.JTable();

        jPanel3.setBackground(new java.awt.Color(218, 41, 28));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        ActivityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pesanan Id", "Nama User", "Status Pembayaran", "Status Pesanan", "Total Harga", "Waktu Pesan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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
        jScrollPane2.setViewportView(ActivityTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActivityTable;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
