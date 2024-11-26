/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

public class LoginSession {
    public static String pelangganId; // Variabel global untuk menyimpan ID pelanggan saat login
    private static String nomorMeja;// Variabel untuk nomor meja

    // Getter untuk nomor meja
    public static String getNomorMeja() {
        return nomorMeja;
    }

    public static void setNomorMeja(String nomorMeja) {
        LoginSession.nomorMeja = nomorMeja;
    }
}
