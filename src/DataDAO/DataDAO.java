/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataDAO;

import Customer.HalamanUtama;
import Login.DbConnection;
import PanelBottom.PanelRincian1;
import Login.LoginSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author rafai
 */
public class DataDAO {
    private String pelangganId;
    private PanelRincian1 panelRincian1;
    private HalamanUtama halamanUtama;

        public DataDAO(HalamanUtama halamanUtama) {    
            this.halamanUtama = halamanUtama;
            this.pelangganId = pelangganId;
            this.panelRincian1 = halamanUtama.getPanelRincian1(); 

            // Atau pastikan PanelRincian1 terinisialisasi dengan benar
            if (this.panelRincian1 == null) {
                this.panelRincian1 = halamanUtama.getPanelRincian1();         
        }
    }
        
public void addToKeranjang(String menuId, int jumlah, double harga) {
    try (Connection conn = DbConnection.getConnection()) {
        String pelangganId = LoginSession.pelangganId; // Mengambil ID pelanggan yang sedang login

        // Pastikan tidak menambah item yang sudah ada
        String checkExistQuery = "SELECT COUNT(*) FROM keranjang WHERE menu_id = ? AND pelanggan_id = ? AND is_deleted = FALSE";
        PreparedStatement checkStmt = conn.prepareStatement(checkExistQuery);
        checkStmt.setString(1, menuId);
        checkStmt.setString(2, pelangganId);
        ResultSet rs = checkStmt.executeQuery();
        
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Item sudah ada di keranjang, memperbarui jumlah.");
            updateKeranjang(menuId, jumlah); // Memperbarui jumlah jika item sudah ada
            return;
        }

        String query = "INSERT INTO keranjang (menu_id, nama_menu, harga, jumlah, total, pelanggan_id) "
                     + "SELECT menu_id, nama_menu, harga, ?, ?, ? FROM menu WHERE menu_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, jumlah);
        pstmt.setDouble(2, harga * jumlah);  // total dihitung berdasarkan harga * jumlah
        pstmt.setString(3, pelangganId);     // Menyisipkan pelanggan_id
        pstmt.setString(4, menuId);
        pstmt.executeUpdate();
  System.out.println("Item berhasil ditambahkan ke keranjang!");

        // Segera refresh data setelah menambah item ke keranjang
        loadDataFromKeranjang();  // Memuat ulang data dari keranjang ke PanelRincian1
    } catch (SQLException e) {
        e.printStackTrace();
    }     
}

public void loadDataFromKeranjang() {
    try (Connection conn = DbConnection.getConnection()) {
        String query = "SELECT * FROM keranjang WHERE pelanggan_id = ? AND is_deleted = FALSE"; // Menambahkan filter is_deleted
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, LoginSession.pelangganId);  // Menggunakan pelanggan_id yang login
        ResultSet rs = pstmt.executeQuery();

        DefaultTableModel tableModel = halamanUtama.getPanelRincian1().getTableModel();
        tableModel.setRowCount(0);  // Kosongkan tabel sebelum menambah data baru

        boolean adaItem = false;  // Variabel untuk mengecek apakah ada item di keranjang

        // Memasukkan data ke dalam tabel
        while (rs.next()) {
            adaItem = true;  // Menandakan ada item
            String menuId = rs.getString("menu_id");
            String namaMenu = rs.getString("nama_menu");
            double harga = rs.getDouble("harga");
            int jumlah = rs.getInt("jumlah");
            double total = rs.getDouble("total");

            // Menambah baris ke tabel
            tableModel.addRow(new Object[]{menuId, namaMenu, harga, jumlah, total});
        }

        // Memperbarui total dan jumlah bayar
        loadTotalFromKeranjang(halamanUtama.getPanelRincian1());  // Memperbarui jumlah bayar dan total barang
        tableModel.fireTableDataChanged();  // Menyegarkan tampilan tabel

        // Meng-enable tombol Bayar jika ada item di keranjang
        halamanUtama.getPanelRincian1().setBayarButtonEnabled(adaItem); // Memanggil metode untuk enable tombol

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public boolean updateKeranjang(String menuId, int jumlah) {
    try (Connection conn = DbConnection.getConnection()) {
        String pelangganId = LoginSession.pelangganId; // Mengambil ID pelanggan yang sedang login
        String query = "UPDATE keranjang SET jumlah = ?, total = harga * ? WHERE menu_id = ? AND pelanggan_id = ? AND is_deleted = FALSE";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, jumlah);
        pstmt.setInt(2, jumlah); // Menghitung total berdasarkan jumlah baru
        pstmt.setString(3, menuId);
        pstmt.setString(4, pelangganId);  // Menyaring berdasarkan pelanggan_id
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


public boolean removeFromKeranjang(String menuId) {
    // Pastikan menuId tidak null atau kosong sebelum melanjutkan
    if (menuId == null || menuId.isEmpty()) {
        System.err.println("Error: menuId tidak boleh null atau kosong.");
        return false;
    }

    String pelangganId = LoginSession.pelangganId; // Mengambil ID pelanggan yang sedang login
    String query = "UPDATE keranjang SET is_deleted = TRUE WHERE menu_id = ? AND pelanggan_id = ? AND is_deleted = FALSE";
    try (Connection conn = DbConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        // Set nilai parameter
        pstmt.setString(1, menuId);
        pstmt.setString(2, pelangganId);  // Menyaring berdasarkan pelanggan_id

        // Eksekusi perintah soft delete
        int rowsAffected = pstmt.executeUpdate();

        // Berhasil jika ada baris yang terhapus
        if (rowsAffected > 0) {
            System.out.println("Menu dengan ID " + menuId + " berhasil dihapus dari keranjang.");

            // Panggil metode refreshTable untuk memperbarui UI
            loadDataFromKeranjang();  // Memperbarui tampilan keranjang

            return true;
        } else {
            System.out.println("Menu dengan ID " + menuId + " tidak ditemukan di keranjang.");
            return false;
        }
    } catch (SQLException e) {
        // Tangkap error SQL dan tampilkan stack trace
        System.err.println("Error saat menghapus item dari keranjang: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


public void loadTotalFromKeranjang(PanelRincian1 panelRincian1) {
    String pelangganId = LoginSession.pelangganId; // Ambil pelanggan_id yang sudah login
    try (Connection conn = DbConnection.getConnection()) {
        String query = "SELECT SUM(jumlah) AS totalJumlah, SUM(total) AS totalBayar "
                     + "FROM keranjang WHERE pelanggan_id = ? AND is_deleted = FALSE"; // Menambahkan filter is_deleted
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, pelangganId);  // Menggunakan pelanggan_id sebagai filter
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int totalJumlah = rs.getInt("totalJumlah");
            double totalBayar = rs.getDouble("totalBayar");

            // Menampilkan hasil pada label di PanelRincian1
            panelRincian1.setJumlahBayarField(String.format("Rp %.2f", totalBayar)); // Update label Jumlah Bayar
            panelRincian1.setTotalPsnanField(String.valueOf(totalJumlah)); // Update label Total Pesanan (Jumlah Barang)
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void removeKeranjang() {
        try (Connection conn = DbConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Koneksi database gagal.");
                return;
            }

            // Query untuk menghapus data keranjang
            String deleteQuery = "DELETE FROM keranjang";  // Sesuaikan dengan struktur tabel Anda
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Keranjang berhasil dihapus.");
                loadDataFromKeranjang();  // Memastikan data di-refresh
                panelRincian1.refreshTable();     // Segarkan tabel
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void refreshTable() {
        loadDataFromKeranjang();
        System.out.println("Tabel di PanelRincian1 diperbarui!");
    }
    
    public void MoveRiwayat() {
    String pelangganId = LoginSession.pelangganId;
    String insertQuery = "INSERT INTO riwayat (pelanggan_id, menu_id, nama_menu, harga, jumlah, total) "
                       + "SELECT ?, menu_id, nama_menu, harga, jumlah, total FROM keranjang";

    try (Connection conn = DbConnection.getConnection();
         PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
        
        // Set parameter pelanggan_id
        insertStmt.setString(1, pelangganId);  // Menggunakan pelanggan_id yang login

        // Mulai transaksi
        conn.setAutoCommit(false);
        
        // Pindahkan data ke tabel riwayatpemesanan
        insertStmt.executeUpdate();
              
        // Commit transaksi
        conn.commit();
        System.out.println("Data berhasil disimpan ke riwayat pesanan.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}   
}
