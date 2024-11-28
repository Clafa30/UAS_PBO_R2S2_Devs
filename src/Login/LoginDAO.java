/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author rafai
 */
public class LoginDAO {
    // Method untuk memvalidasi login admin
    public static boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Return true jika ada hasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false jika terjadi error
        }
    }
    
        // Metode untuk menyimpan username dan nomor meja ke database
    
        // Metode untuk menambahkan pelanggan
    public static boolean tambahPelanggan(String pelangganId, String username, int noMeja) {
        String checkQuery = "SELECT COUNT(*) FROM pelanggan WHERE pelanggan_id = ?";
        String insertQuery = "INSERT INTO pelanggan (pelanggan_id, nama_pelanggan, no_meja) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {

            // Periksa apakah ID sudah ada
            checkStmt.setString(1, pelangganId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("ID pelanggan sudah ada: " + pelangganId);
                return false; // Gagal karena ID sudah ada
            }

            // Jika ID tidak ada, tambahkan data baru
            insertStmt.setString(1, pelangganId);
            insertStmt.setString(2, username);
            insertStmt.setInt(3, noMeja);

            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Jika terjadi kesalahan
    }
    
    public static boolean hapusPelangganDanKeranjang(String pelangganId) {
        String deleteKeranjangQuery = "DELETE FROM keranjang WHERE pelanggan_id = ?";
        String deletePelangganQuery = "DELETE FROM pelanggan WHERE pelanggan_id = ?";

        try (Connection conn = DbConnection.getConnection()) {
            // Mulai transaksi
            conn.setAutoCommit(false);

            // Hapus data keranjang
            try (PreparedStatement keranjangStmt = conn.prepareStatement(deleteKeranjangQuery)) {
                keranjangStmt.setString(1, pelangganId);
                keranjangStmt.executeUpdate();
            }

            // Hapus data pelanggan
            try (PreparedStatement pelangganStmt = conn.prepareStatement(deletePelangganQuery)) {
                pelangganStmt.setString(1, pelangganId);
                pelangganStmt.executeUpdate();
            }

            // Commit transaksi
            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
    }

    return false; // Jika terjadi kesalahan
}
    
    
    // Metode untuk memeriksa ketersediaan meja
    public static boolean isMejaTersedia(int noMeja) {
        String query = "SELECT status FROM meja WHERE no_meja = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, noMeja);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int status = rs.getInt("status");
                    return status == 0; // Meja tersedia jika status = 0
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Jika terjadi kesalahan atau meja tidak ditemukan
    }
    
    public static String generatePelangganId() {
        String query = "SELECT IFNULL(MAX(CAST(SUBSTRING(pelanggan_id, 3) AS UNSIGNED)), 0) + 1 AS next_id FROM pelanggan";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                int nextId = rs.getInt("next_id"); // Ambil ID berikutnya
                return String.format("PE%03d", nextId); // Format ke PE001, PE002, dst.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null jika terjadi kesalahan
    }
    
}
