/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customer;

import PanelBottom.*;
import panel.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class HalamanUtama extends javax.swing.JFrame {
    private PanelRincian1 panelRincian1;  // Panel rincian pesanan
    public PanelPembayaran panelPembayaran;
    private PanelActivity panelActivity;
    private PanelPromo panelPromo;  // Panel untuk promo
    private PanelMakanan panelMakanan;
    private PanelMinuman panelMinuman;
    private PanelLainnya panelLainnya;    
    private DefaultTableModel tableModel;
    private static HalamanUtama instance; // Instance statis
    private Dimension navbarOriginalSize;
    private Dimension mainContentOriginalSize;
    private Dimension bottomOriginalSize;    
    
    public static HalamanUtama getInstance() {
        if (instance == null) {
            instance = new HalamanUtama();
        }
        return instance;
    }
    
    /**
     * Creates new form HalamanUtama
     */
     
    public HalamanUtama() {
        System.out.println("Memulai HalamanUtama...");
        initComponents();
        navbarOriginalSize = navbar.getSize();
        mainContentOriginalSize = mainContent.getSize();
        bottomOriginalSize = bottom.getSize();    

    panelRincian1 = PanelRincian1.getInstance(this);
    panelPromo = new PanelPromo(this, panelRincian1);
    panelPembayaran = PanelPembayaran.getInstance(this);
    panelActivity = PanelActivity.getInstance(this);

    mainContent.setLayout(new BorderLayout());
    mainContent.add(panelPromo, BorderLayout.CENTER);

    bottom.setLayout(new BorderLayout());
    bottom.add(panelRincian1, BorderLayout.CENTER);

    mainContent.revalidate();
    mainContent.repaint();
    bottom.revalidate();
    bottom.repaint();

    System.out.println("Halaman Utama selesai diinisialisasi.");
}

    public PanelRincian1 getPanelRincian1() {
        return panelRincian1;
    }    

    // Menambahkan metode untuk mendapatkan PanelActivity
    public PanelActivity getPanelActivity() {
        return panelActivity;  // Mengembalikan referensi ke PanelActivity
    }
    
    public PanelPembayaran getPanelPembayaran() {
        return panelPembayaran;
    }    
    
    public void showPanelPembayaran() {
    if (panelPembayaran == null) {
        panelPembayaran = PanelPembayaran.getInstance(this);
        System.out.println("Panel Pembayaran diinisialisasi.");
    }

    // Bersihkan panel sebelumnya
    pnlMain.removeAll();
    pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    // Tambahkan panel pembayaran
    pnlMain.add(panelPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, pnlMain.getWidth(), pnlMain.getHeight()));

    // Sembunyikan panel lain
    navbar.setVisible(false);
    mainContent.setVisible(false);
    bottom.setVisible(false);

    // Refresh tampilan
    pnlMain.revalidate();
    pnlMain.repaint();

    System.out.println("Panel Pembayaran ditampilkan.");
}

    public void showPanelRiwayat() {
        if (panelActivity == null) {
            panelActivity = PanelActivity.getInstance(this);
            System.out.println("Panel Riwayat diinisialisasi.");
        }

        SwingUtilities.invokeLater(() -> {
            pnlMain.removeAll();
            pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            pnlMain.add(panelActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, pnlMain.getWidth(), pnlMain.getHeight()));

            navbar.setVisible(false);
            mainContent.setVisible(false);
            bottom.setVisible(false);
            
            pnlMain.revalidate();
            pnlMain.repaint();

            System.out.println("Panel Riwayat ditampilkan.");
        });
    }

    public void showHalamanUtama() {
        // Bersihkan panel utama
        pnlMain.removeAll();

        // Tambahkan kembali semua komponen ke pnlMain
        pnlMain.setLayout(new javax.swing.GroupLayout(pnlMain));
        pnlMain.add(navbar);
        pnlMain.add(mainContent);
        pnlMain.add(bottom);

        // Reset ke ukuran semula
        resetLayout();

        System.out.println("Kembali ke main content dengan layout semula.");
    }
    
    private void resetLayout() {
        // Atur ulang ukuran dan tata letak
        navbar.setPreferredSize(navbarOriginalSize);
        navbar.setSize(navbarOriginalSize);

        mainContent.setPreferredSize(mainContentOriginalSize);
        mainContent.setSize(mainContentOriginalSize);

        bottom.setPreferredSize(bottomOriginalSize);
        bottom.setSize(bottomOriginalSize);
        
        // Tampilkan komponen
        navbar.setVisible(true);
        mainContent.setVisible(true);
        bottom.setVisible(true);

        // Atur ulang tata letak
        pnlMain.revalidate();
        pnlMain.repaint();

        System.out.println("Memanggil navbar, mainContent, dan bottom.");
    }
    
    public void resetAllPanels() {
        if (panelPromo != null) panelPromo.resetControls();
        if (panelMakanan != null) panelMakanan.resetControls();
        if (panelMinuman != null) panelMinuman.resetControls();
        if (panelLainnya != null) panelLainnya.resetControls();
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
        pnlMain = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        lbPromo = new javax.swing.JLabel();
        lbMakanan = new javax.swing.JLabel();
        lbMinuman = new javax.swing.JLabel();
        lbLainya = new javax.swing.JLabel();
        mainContent = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        judul = new javax.swing.JPanel();
        NamaRestaurant = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(430, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 932));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(420, 500));

        navbar.setBackground(new java.awt.Color(204, 0, 0));
        navbar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        navbar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                navbarMouseDragged(evt);
            }
        });
        navbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                navbarMousePressed(evt);
            }
        });

        lbPromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPromo.setForeground(new java.awt.Color(255, 255, 255));
        lbPromo.setText("Promo");
        lbPromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPromoMouseClicked(evt);
            }
        });

        lbMakanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMakanan.setForeground(new java.awt.Color(255, 255, 255));
        lbMakanan.setText("Makanan");
        lbMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMakananMouseClicked(evt);
            }
        });

        lbMinuman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMinuman.setForeground(new java.awt.Color(255, 255, 255));
        lbMinuman.setText("Minuman");
        lbMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinumanMouseClicked(evt);
            }
        });

        lbLainya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbLainya.setForeground(new java.awt.Color(255, 255, 255));
        lbLainya.setText("Lainnya");
        lbLainya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLainyaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbPromo)
                .addGap(57, 57, 57)
                .addComponent(lbMakanan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(lbMinuman)
                .addGap(51, 51, 51)
                .addComponent(lbLainya)
                .addGap(39, 39, 39))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMakanan)
                    .addComponent(lbPromo)
                    .addComponent(lbMinuman)
                    .addComponent(lbLainya))
                .addContainerGap())
        );

        mainContent.setBackground(new java.awt.Color(255, 255, 255));
        mainContent.setAlignmentX(5.0F);
        mainContent.setAlignmentY(5.0F);
        mainContent.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainContentMouseDragged(evt);
            }
        });
        mainContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainContentMousePressed(evt);
            }
        });
        mainContent.setLayout(new java.awt.BorderLayout());

        bottom.setBackground(new java.awt.Color(255, 255, 255));
        bottom.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainContent, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainContent, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        judul.setBackground(new java.awt.Color(250, 64, 50));

        NamaRestaurant.setBackground(new java.awt.Color(255, 255, 255));
        NamaRestaurant.setFont(new java.awt.Font("Speedee", 1, 26)); // NOI18N
        NamaRestaurant.setForeground(new java.awt.Color(255, 241, 10));
        NamaRestaurant.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NamaRestaurant.setText("Beans & Burger");
        NamaRestaurant.setToolTipText("");
        NamaRestaurant.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        NamaRestaurant.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout judulLayout = new javax.swing.GroupLayout(judul);
        judul.setLayout(judulLayout);
        judulLayout.setHorizontalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(NamaRestaurant)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        judulLayout.setVerticalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NamaRestaurant))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainContentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainContentMousePressed

    }//GEN-LAST:event_mainContentMousePressed

    private void mainContentMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainContentMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_mainContentMouseDragged

    private void navbarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_navbarMousePressed

    private void navbarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_navbarMouseDragged

    private void lbMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMakananMouseClicked
        mainContent.removeAll();
        PanelMakanan panelMakanan = new PanelMakanan(this, panelRincian1);
        mainContent.add(panelMakanan);
        mainContent.revalidate();
        mainContent.repaint();
    
    }//GEN-LAST:event_lbMakananMouseClicked

    private void lbPromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPromoMouseClicked
        mainContent.removeAll();
        mainContent.add(panelPromo);
        mainContent.revalidate();
        mainContent.repaint();
    }//GEN-LAST:event_lbPromoMouseClicked

    private void lbMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinumanMouseClicked
        mainContent.removeAll();
        PanelMinuman panelMinuman = new PanelMinuman(this, panelRincian1);
        mainContent.add(panelMinuman);
        mainContent.revalidate();
        mainContent.repaint();
    }//GEN-LAST:event_lbMinumanMouseClicked

    private void lbLainyaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLainyaMouseClicked
        mainContent.removeAll(); // Hapus semua komponen di mainContent
        PanelLainnya panelLainnya = new PanelLainnya(this, panelRincian1);
        mainContent.add(panelLainnya);
        mainContent.revalidate(); // Revalidasi layout setelah perubahan
        mainContent.repaint(); // Memperbarui tampilan
    }//GEN-LAST:event_lbLainyaMouseClicked

    
    // Tambahkan getter untuk mengakses model tabel dari PanelRincian1
    public DefaultTableModel getTableModel() {
        return panelRincian1.getTableModel(); // Ambil model tabel dari PanelRincian1
    }
    
 
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
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HalamanUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NamaRestaurant;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel judul;
    private javax.swing.JLabel lbLainya;
    private javax.swing.JLabel lbMakanan;
    private javax.swing.JLabel lbMinuman;
    private javax.swing.JLabel lbPromo;
    private javax.swing.JPanel mainContent;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
