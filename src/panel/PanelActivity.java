/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import Customer.HalamanUtama;
import Login.DbConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author rolis
 */
public class PanelActivity extends javax.swing.JPanel {
    private static PanelActivity instance;
    private HalamanUtama halamanUtama;
    private DefaultTableModel tableModel; // Model data untuk tabel
    private int lastMouseY;
    
    /**
     * Creates new form PanelActivity
     */
    public PanelActivity(HalamanUtama halamanUtama) {
        System.out.println("Membuat panel activity..");
        this.halamanUtama = halamanUtama;
        
        initComponents(); // Inisialisasi komponen GUI      
        loadRiwayatData(); 
        setupTableButton(); // Set up kolom tombol untuk rincian
                   
    }
    
    public static synchronized PanelActivity getInstance(HalamanUtama halamanUtama) {
        if (instance == null) {
            instance = new PanelActivity(halamanUtama); // Membuat instance baru jika belum ada
        }
        return instance;
    }
    
    public void setHalamanUtama(HalamanUtama halamanUtama) {
        if (halamanUtama == null) {
            System.out.println("HalamanUtama belum diteruskan.");
        } else {
            System.out.println("HalamanUtama berhasil diteruskan.");
            this.halamanUtama = halamanUtama;
        }
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public void refreshTable() {
        DefaultTableModel tableModel = getTableModel();  // Dapatkan model tabel
        tableModel.fireTableDataChanged();  // Segera memperbarui tampilan tabel
        revalidate();  // Revalidate untuk memastikan tampilan diperbarui
        repaint();  // Repaint untuk memastikan perubahan terlihat
    } 
    
    public void loadRiwayatData() {
    // Cek apakah ActivityTable sudah terinisialisasi
    if (ActivityTable == null) {
        System.out.println("ActivityTable belum terinisialisasi.");
        return;  // Jangan lanjutkan jika tabel belum ada
    }

    DefaultTableModel modelActivity = (DefaultTableModel) ActivityTable.getModel();
    modelActivity.setRowCount(0);     
    
    // Query untuk mengambil data pesanan yang statusnya 'Selesai'
    String query = "SELECT r.riwayat_id, pl.nama_pelanggan, r.status_pembayaran, r.status_pesanan, r.total, r.tanggal_pemesanan " +
                   "FROM riwayat r " +
                   "JOIN pelanggan pl ON r.pelanggan_id = pl.pelanggan_id ";  

    System.out.println("Query yang dieksekusi: " + query);  // Cek query yang akan dieksekusi

    try (Connection conn = DbConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query); 
         ResultSet rs = stmt.executeQuery()) {

        // Inisialisasi DecimalFormat untuk menambahkan pemisah ribuan
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        // Periksa apakah ResultSet memiliki data
        if (!rs.next()) {
            System.out.println("Tidak ada data yang ditemukan.");
            return;  // Jika tidak ada data, keluar dari metode
        }

        // Mengambil data dari ResultSet dan memasukkan ke dalam model tabel
        do {
            int riwayatId = rs.getInt("riwayat_id");
            String namaPelanggan = rs.getString("nama_pelanggan");
//            String statusPembayaran = rs.getString("status_pembayaran");
//            String statusPesanan = rs.getString("status_pesanan");
//            double total = rs.getDouble("total");
//            String tanggalPemesanan = rs.getString("tanggal_pemesanan");  // Menggunakan Timestamp untuk tanggal

            // Menambahkan data ke ActivityTable dengan format total yang baru
            modelActivity.addRow(new Object[]{
                riwayatId, namaPelanggan,
            });

        } while (rs.next());  // Lanjutkan membaca data di ResultSet

        // Perbarui tampilan tabel
        modelActivity.fireTableDataChanged();
        ActivityTable.revalidate();
        ActivityTable.repaint();
    } catch (SQLException ex) {
        System.out.println("Error saat mengambil data: " + ex.getMessage());
        ex.printStackTrace();  // Tangani kesalahan koneksi atau query
    }
}

    private void setupTableButton() {
    // Atur kolom terakhir (Rincian) menjadi tombol
    ActivityTable.getColumn("Rincian").setCellRenderer(new ButtonRenderer());
    ActivityTable.getColumn("Rincian").setCellEditor(new ButtonEditor(new JCheckBox()));
}

   // Render tombol pada kolom "Rincian"
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);  // Membuat tombol lebih terlihat jelas
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Rincian" : value.toString()); // Set teks tombol
            return this;
        }
    }

    // Editor untuk tombol di kolom "Rincian"
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);

            button.addActionListener(e -> showDetailPopup()); // Ketika tombol diklik
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Rincian" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            clicked = false;
            return label;
        }

private void showDetailPopup() {
    int selectedRow = ActivityTable.getSelectedRow(); // Ambil baris yang dipilih

    if (selectedRow != -1) {
        // Ambil ID riwayat dari baris yang dipilih
        int riwayatId = (int) ActivityTable.getValueAt(selectedRow, 0);  // Mengambil ID riwayat

        StringBuilder detailMessage = new StringBuilder();
        try (Connection conn = DbConnection.getConnection()) {
            // Query untuk mengambil detail pesanan dari tabel riwayat
            String query = "SELECT nama_menu, harga, jumlah, total, status_pembayaran, status_pesanan FROM riwayat WHERE riwayat_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, riwayatId);  // Menyertakan ID riwayat
                try (ResultSet rs = stmt.executeQuery()) {
                    // Cek jika ada data
                    if (rs.next()) {
                        // Menambahkan status pembayaran dan status pesanan terlebih dahulu
                        String statusPembayaran = rs.getString("status_pembayaran");
                        String statusPesanan = rs.getString("status_pesanan");
                        detailMessage.append("Status Pembayaran: ").append(statusPembayaran)
                                     .append("\nStatus Pesanan: ").append(statusPesanan)
                                     .append("\n\nDetail Pesanan:\n");

                        // Menambahkan informasi pesanan yang diambil
                        do {
                            detailMessage.append("- ")
                                .append(rs.getString("nama_menu"))
                                .append(", Harga: ")
                                .append(rs.getDouble("harga"))
                                .append(", Jumlah: ")
                                .append(rs.getInt("jumlah"))
                                .append(", Total: ")
                                .append(rs.getDouble("total"))
                                .append("\n");
                        } while (rs.next()); // Mengambil semua baris yang ada untuk menu yang dipesan
                    } else {
                        detailMessage.append("Detail pesanan tidak ditemukan.");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            detailMessage.append("Gagal memuat detail pesanan.");
        }

        // Menampilkan pop-up dengan detail pesanan
        JOptionPane.showMessageDialog(null, detailMessage.toString(), "Rincian Pesanan", JOptionPane.INFORMATION_MESSAGE);
    }
}

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
        jScrollPane1 = new javax.swing.JScrollPane();
        ActivityTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("                               Riwayat Pesanan");

        ActivityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Total", "Rincian"
            }
        ));
        ActivityTable.setShowGrid(false);
        jScrollPane1.setViewportView(ActivityTable);

        BackBtn.setBackground(new java.awt.Color(255, 0, 0));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setText("Kembali");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BackBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(BackBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        System.out.println("Memanggil metode showHalamanUtama...");
        this.halamanUtama.showHalamanUtama();
    }//GEN-LAST:event_BackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ActivityTable;
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
