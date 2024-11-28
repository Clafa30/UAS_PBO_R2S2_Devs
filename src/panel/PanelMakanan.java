/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import DataDAO.DataDAO;
import Customer.HalamanUtama;
import Login.DbConnection;
import PanelBottom.PanelRincian1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rolis
 */

public class PanelMakanan extends javax.swing.JPanel {
    private int lastMouseY;
    private HalamanUtama halamanUtama;
    private DefaultTableModel tableModel; // Model data untuk tabel
    private JTable jTable; // Variabel untuk tabel
    private PanelRincian1 panelRincian1;
    private DataDAO dataDAO;
    
    /**
     * Creates new form TesPanel
     */
    public PanelMakanan(HalamanUtama halamanUtama, PanelRincian1 panelRincian11) { 
        initComponents();  // Inisialisasi komponen GUI

        System.out.println("Membuat PanelPromo...");
        this.halamanUtama = halamanUtama;
        panelRincian1 = PanelRincian1.getInstance(halamanUtama);
        this.dataDAO = new DataDAO(halamanUtama); // Inisialisasi DataDAO        
        System.out.println("DataDAO di PanelPromo: " + (this.dataDAO == null ? "null" : "initialized"));

        if (this.panelRincian1 != null) {
            System.out.println("PanelRincian1 diterima di PanelPromo.");
                this.panelRincian1.refreshTable();
            } else {
                throw new IllegalStateException("PanelRincian1 null di PanelPromo.");
        }

        menu.getVerticalScrollBar().setUnitIncrement(15); // Atur sensitivitas vertikal
        jPanel1.setPreferredSize(new Dimension(menu.getWidth(), 800)); // Contoh tinggi 2000
        jPanel1.revalidate();

        // Menambahkan listener untuk Checkbox dan Spinner setelah initComponents()
        BeefBurgCbox.addActionListener(this::BeefBurgCboxActionPerformed);
        ChezzBurgCbox.addActionListener(this::ChezzBurgCboxActionPerformed);
        DblBeefBurgerCbox.addActionListener(this::DblBeefBurgerCboxActionPerformed);
        DelxBurgCbox.addActionListener(this::DelxBurgCboxActionPerformed);
        HotDogCbox.addActionListener(this::HotDogCboxActionPerformed);
        NasiCbox.addActionListener(this::NasiCboxActionPerformed); // Gantilah sesuai dengan aksi untuk Nasi

        // Menambahkan listener untuk spinnerBeefBurg
        spinnerBeefBurg.addChangeListener(e -> {
            int value = (Integer) spinnerBeefBurg.getValue();
            if (value < 0) {
                spinnerBeefBurg.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA001", spinnerBeefBurg);            
            updateCheckBoxFromSpinner(BeefBurgCbox, spinnerBeefBurg, "MA001"); // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerChezzBurg
        spinnerChezzBurg.addChangeListener(e -> {
            int value = (Integer) spinnerChezzBurg.getValue();
            if (value < 0) {
                spinnerChezzBurg.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA002", spinnerChezzBurg);
            updateCheckBoxFromSpinner(ChezzBurgCbox, spinnerChezzBurg, "MA002"); // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerDblBeef
        spinnerDblBeef.addChangeListener(e -> {
            int value = (Integer) spinnerDblBeef.getValue();
            if (value < 0) {
                spinnerDblBeef.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA003", spinnerDblBeef);
            updateCheckBoxFromSpinner(DblBeefBurgerCbox, spinnerDblBeef, "MA003"); // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerDelxBurg
        spinnerDelxBurg.addChangeListener(e -> {
            int value = (Integer) spinnerDelxBurg.getValue();
            if (value < 0) {
                spinnerDelxBurg.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA004", spinnerDelxBurg);
            updateCheckBoxFromSpinner(DelxBurgCbox, spinnerDelxBurg, "MA004"); // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerHotDog
        spinnerHotDog.addChangeListener(e -> {
            int value = (Integer) spinnerHotDog.getValue();
            if (value < 0) {
                spinnerHotDog.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA005", spinnerHotDog);
            updateCheckBoxFromSpinner(HotDogCbox, spinnerHotDog, "MA005"); // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerNasi
        spinnerNasi.addChangeListener(e -> {
            int value = (Integer) spinnerNasi.getValue();
            if (value < 0) {
                spinnerNasi.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MA006", spinnerNasi);
            updateCheckBoxFromSpinner(NasiCbox, spinnerNasi, "MA006"); // Memperbarui checkbox sesuai dengan nilai spinner
        });


        // Menetapkan model spinner dengan validasi agar nilai tidak kurang dari 0
        spinnerBeefBurg.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerChezzBurg.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerDblBeef.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerDelxBurg.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerHotDog.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerNasi.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        BeefBurgCbox = new javax.swing.JCheckBox();
        DblBeefBurgerCbox = new javax.swing.JCheckBox();
        DelxBurgCbox = new javax.swing.JCheckBox();
        ChezzBurgCbox = new javax.swing.JCheckBox();
        ChikBurgCbox = new javax.swing.JCheckBox();
        AyamNasiCbox = new javax.swing.JCheckBox();
        spinnerAyamNasi = new javax.swing.JSpinner();
        spinnerChikBurg = new javax.swing.JSpinner();
        spinnerChezzBurg = new javax.swing.JSpinner();
        spinnerDelxBurg = new javax.swing.JSpinner();
        spinnerDblBeef = new javax.swing.JSpinner();
        spinnerBeefBurg = new javax.swing.JSpinner();
        ChickBuckCbox1 = new javax.swing.JCheckBox();
        spinnerChickBuck = new javax.swing.JSpinner();
        HotDogCbox = new javax.swing.JCheckBox();
        spinnerHotDog = new javax.swing.JSpinner();
        spinnerNasi = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        NasiCbox = new javax.swing.JCheckBox();

        menu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        menu.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/burger.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Rp 20.000");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Beef Burger");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/deluxe.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Rp 40.000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Double Beef Burger");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(15, 15, 15))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(4, 4, 4))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/doublecheese burger.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Rp 32.000");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Deluxe Burger");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(32, 32, 32))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(4, 4, 4))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/chesse.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Rp 25.000");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Chezzzz Burger");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(4, 4, 4))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/chicken.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Rp 30.000");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Chicken Burger");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(4, 4, 4))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/nasiayam.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Rp 15.000");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Ayam+Nasi");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel20))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel19)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(4, 4, 4))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/chickenbucket.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Rp 95.000");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Chicken Bucket");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(3, 3, 3)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(4, 4, 4))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/hotdog.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("Rp 17.000");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("HotDog");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(3, 3, 3)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(4, 4, 4))
        );

        BeefBurgCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeefBurgCboxActionPerformed(evt);
            }
        });

        DblBeefBurgerCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DblBeefBurgerCboxActionPerformed(evt);
            }
        });

        DelxBurgCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelxBurgCboxActionPerformed(evt);
            }
        });

        ChezzBurgCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChezzBurgCboxActionPerformed(evt);
            }
        });

        ChikBurgCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChikBurgCboxActionPerformed(evt);
            }
        });

        AyamNasiCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyamNasiCboxActionPerformed(evt);
            }
        });

        ChickBuckCbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChickBuckCbox1ActionPerformed(evt);
            }
        });

        HotDogCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDogCboxActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMakanan/rice.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setText("Rp 6.000");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Rice");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(3, 3, 3)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(4, 4, 4))
        );

        NasiCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NasiCboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(NasiCbox)
                            .addGap(18, 18, 18)
                            .addComponent(spinnerNasi))
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ChickBuckCbox1)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerChickBuck))
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(HotDogCbox)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerHotDog))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BeefBurgCbox)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinnerBeefBurg)))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(DelxBurgCbox)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinnerDelxBurg, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ChezzBurgCbox)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinnerChezzBurg))
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ChikBurgCbox)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(spinnerChikBurg)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(AyamNasiCbox)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinnerAyamNasi))
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(DblBeefBurgerCbox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerDblBeef, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DblBeefBurgerCbox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BeefBurgCbox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerDblBeef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerBeefBurg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DelxBurgCbox)
                    .addComponent(ChezzBurgCbox)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerChezzBurg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerDelxBurg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ChikBurgCbox)
                        .addComponent(spinnerChikBurg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AyamNasiCbox)
                        .addComponent(spinnerAyamNasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChickBuckCbox1)
                            .addComponent(spinnerChickBuck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HotDogCbox)
                            .addComponent(spinnerHotDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NasiCbox)
                    .addComponent(spinnerNasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menu.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        lastMouseY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
         int deltaY = lastMouseY - evt.getY();
        lastMouseY = evt.getY(); // Perbarui posisi terakhir mouse

        // Dapatkan viewport dari JScrollPane
        JViewport viewport = menu.getViewport();
        Point viewPosition = viewport.getViewPosition();

        // Geser viewport berdasarkan perubahan vertikal (deltaY)
        viewPosition.translate(0, deltaY); // Geser vertikal, tidak horizontal
        menu.getViewport().setViewPosition(viewPosition);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void BeefBurgCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeefBurgCboxActionPerformed
        if (BeefBurgCbox.isSelected()) {
            loadData("MA001", spinnerBeefBurg);
        } else {
            removeData("MA001");
        }
    }//GEN-LAST:event_BeefBurgCboxActionPerformed

    private void DblBeefBurgerCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DblBeefBurgerCboxActionPerformed
        if (DblBeefBurgerCbox.isSelected()) {
            loadData("MA002", spinnerDblBeef);
        } else {
            removeData("MA002");
        }
    }//GEN-LAST:event_DblBeefBurgerCboxActionPerformed

    private void DelxBurgCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelxBurgCboxActionPerformed
        if (DelxBurgCbox.isSelected()) {
            loadData("MA003", spinnerDelxBurg);
        } else {
            removeData("MA003");
        }
    }//GEN-LAST:event_DelxBurgCboxActionPerformed

    private void ChezzBurgCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChezzBurgCboxActionPerformed
        if (ChezzBurgCbox.isSelected()) {
            loadData("MA004", spinnerChezzBurg);
        } else {
            removeData("MA004");
        }
    }//GEN-LAST:event_ChezzBurgCboxActionPerformed

    private void ChikBurgCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChikBurgCboxActionPerformed
        if (ChikBurgCbox.isSelected()) {
            loadData("MA005", spinnerChikBurg);
        } else {
            removeData("MA005");
        }
    }//GEN-LAST:event_ChikBurgCboxActionPerformed

    private void AyamNasiCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyamNasiCboxActionPerformed
    if (AyamNasiCbox.isSelected()) {
            loadData("MA006", spinnerAyamNasi);
        } else {
            removeData("MA006");
        }
    }//GEN-LAST:event_AyamNasiCboxActionPerformed

    private void ChickBuckCbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChickBuckCbox1ActionPerformed
        if (ChickBuckCbox1.isSelected()) {
            loadData("MA007", spinnerChikBurg);
        } else {
            removeData("MA007");
        }
    }//GEN-LAST:event_ChickBuckCbox1ActionPerformed

    private void HotDogCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDogCboxActionPerformed
        if (HotDogCbox.isSelected()) {
            loadData("MA008", spinnerHotDog);
        } else {
            removeData("MA008");
        }
    }//GEN-LAST:event_HotDogCboxActionPerformed

    private void NasiCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NasiCboxActionPerformed
        if (NasiCbox.isSelected()) {
            loadData("MA009", spinnerNasi);
        } else {
            removeData("MA009");
        }
    }//GEN-LAST:event_NasiCboxActionPerformed

private void customizeScrollPanel() {
        menu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        menu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        menu.getHorizontalScrollBar().setUI(null); // Hapus UI scrollbar horizontal
        menu.getVerticalScrollBar().setUI(null);   // Hapus UI scrollbar vertikal

        // Tambahkan MouseListener ke jPanel1
        jPanel1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel1.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });      
    }
    
private void loadData(String menuId, javax.swing.JSpinner spinner) {
    try (Connection conn = DbConnection.getConnection()) {
        if (conn == null) {
            System.out.println("Koneksi database gagal.");
            return;
        }

        String query = "SELECT * FROM menu WHERE menu_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, menuId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String namaMenu = rs.getString("nama_menu");
            double harga = rs.getDouble("harga");
            int jumlah = (Integer) spinner.getValue();

            // Pastikan method addToKeranjang berhasil dipanggil
            System.out.println("Menambahkan ke keranjang: " + namaMenu + ", Jumlah: " + jumlah + ", Harga: " + harga);
            dataDAO.addToKeranjang(menuId, jumlah, harga);
            dataDAO.loadDataFromKeranjang();  // Memastikan data di-refresh
            panelRincian1.refreshTable();     // Segarkan tabel
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void removeFromDatabase(String menuId) {
    // Menggunakan try-with-resources untuk memastikan koneksi dan statement ditutup secara otomatis
    try (Connection conn = DbConnection.getConnection()) {
        
        // Query SQL untuk menghapus data berdasarkan menuId
        String query = "DELETE FROM keranjang WHERE menu_id = ?";
        
        // Membuat prepared statement
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Menetapkan parameter query
            pstmt.setString(1, menuId);
            
            // Eksekusi update query (karena ini adalah perintah DELETE)
            int rowsAffected = pstmt.executeUpdate();
            
            // Cek apakah ada baris yang terpengaruh
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus untuk Menu ID: " + menuId);
            } else {
                System.out.println("Tidak ada data yang ditemukan untuk Menu ID: " + menuId);
            }
        }
    } catch (SQLException e) {
        // Menangani kesalahan SQL jika terjadi
        System.out.println("Error saat menghapus data dari database: " + e.getMessage());
    }
}
    
private void removeData(String menuId) {
    // Mendapatkan model tabel dari PanelRincian1
    PanelRincian1 panelRincian1 = PanelRincian1.getInstance(halamanUtama);
    DefaultTableModel tableModel = panelRincian1.getTableModel();

    // Loop untuk menemukan baris yang sesuai dengan menuId
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 0).equals(menuId)) { // Cek jika menuId pada kolom pertama
            tableModel.removeRow(i);  // Hapus baris yang sesuai
            break; // Hentikan loop setelah menghapus
        }
    }

    // Segarkan data tabel
    tableModel.fireTableDataChanged();
    System.out.println("Baris dengan menuId: " + menuId + " dihapus dari tabel.");
}

public void updateCheckBoxFromSpinner(JCheckBox checkBox, JSpinner spinner, String menuId) {
    int value = (Integer) spinner.getValue();  // Mengambil nilai dari spinner
    
    System.out.println("Spinner Value: " + value);  // Debugging

    // Jika nilai spinner >= 1, centang checkbox
    if (value >= 1) {
        checkBox.setSelected(true);  // Centang checkbox jika jumlah > 0
        loadData(menuId, spinner);   // Memuat data ke dalam keranjang jika jumlah > 0
    } else if (value == 0) {
        checkBox.setSelected(false);  // Uncheck checkbox jika jumlah = 0
        removeFromDatabase(menuId);   // Hapus data dari database
        removeData(menuId);           // Hapus data dari tabel PanelRincian1
    }
}

public void updateTableFromSpinner(String menuId, JSpinner spinner) {
    int value = (Integer) spinner.getValue();
    if (value >= 1) {
        // Memperbarui jumlah di keranjang jika jumlah >= 1
        dataDAO.updateKeranjang(menuId, value);
        System.out.println("Jumlah di keranjang diperbarui untuk menu ID: " + menuId);
    } else {
        // Hapus data dari database dan tabel jika jumlah = 0
        dataDAO.removeFromKeranjang(menuId);
        removeData(menuId);  // Hapus baris yang terkait dengan menuId dari tabel
        System.out.println("Item dihapus dari keranjang untuk menu ID: " + menuId);
    }

    // Memuat ulang keranjang dari database ke tabel
    dataDAO.loadDataFromKeranjang(); // Memastikan data dimuat ulang ke tabel
}

public void resetControls() {
    // Reset spinner ke nilai awal (misalnya 0)
    spinnerAyamNasi.setValue(0);
    spinnerBeefBurg.setValue(0);
    spinnerChezzBurg.setValue(0);
    spinnerChickBuck.setValue(0);
    spinnerChikBurg.setValue(0);
    spinnerDblBeef.setValue(0);
    spinnerDelxBurg.setValue(0);
    spinnerHotDog.setValue(0);
    spinnerNasi.setValue(0);

    // Reset checkbox ke tidak dicentang
    AyamNasiCbox.setSelected(false);
    BeefBurgCbox.setSelected(false);
    ChezzBurgCbox.setSelected(false);
    ChickBuckCbox1.setSelected(false);
    ChikBurgCbox.setSelected(false);
    DblBeefBurgerCbox.setSelected(false);
    DelxBurgCbox.setSelected(false);
    HotDogCbox.setSelected(false);
    NasiCbox.setSelected(false);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AyamNasiCbox;
    private javax.swing.JCheckBox BeefBurgCbox;
    private javax.swing.JCheckBox ChezzBurgCbox;
    private javax.swing.JCheckBox ChickBuckCbox1;
    private javax.swing.JCheckBox ChikBurgCbox;
    private javax.swing.JCheckBox DblBeefBurgerCbox;
    private javax.swing.JCheckBox DelxBurgCbox;
    private javax.swing.JCheckBox HotDogCbox;
    private javax.swing.JCheckBox NasiCbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane menu;
    private javax.swing.JSpinner spinnerAyamNasi;
    private javax.swing.JSpinner spinnerBeefBurg;
    private javax.swing.JSpinner spinnerChezzBurg;
    private javax.swing.JSpinner spinnerChickBuck;
    private javax.swing.JSpinner spinnerChikBurg;
    private javax.swing.JSpinner spinnerDblBeef;
    private javax.swing.JSpinner spinnerDelxBurg;
    private javax.swing.JSpinner spinnerHotDog;
    private javax.swing.JSpinner spinnerNasi;
    // End of variables declaration//GEN-END:variables
}
