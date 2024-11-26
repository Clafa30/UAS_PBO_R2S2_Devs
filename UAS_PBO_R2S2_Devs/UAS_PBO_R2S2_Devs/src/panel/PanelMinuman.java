/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import Customer.HalamanUtama;
import DataDAO.DataDAO;
import Login.DbConnection;
import PanelBottom.PanelRincian;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rolis
 */
public class PanelMinuman extends javax.swing.JPanel {
    private int lastMouseY;
    private HalamanUtama halamanUtama;
    private DefaultTableModel tableModel; // Model data untuk tabel
    private JTable jTable; // Variabel untuk tabel
    private PanelRincian panelRincian1;
    private DataDAO dataDAO;
    
    /**
     * Creates new form TesPanel
     */
    public PanelMinuman(HalamanUtama halamanUtama, PanelRincian panelRincian11) { 
        initComponents();  // Inisialisasi komponen GUI

        System.out.println("Membuat Panel Minuman...");
        this.halamanUtama = halamanUtama;
        panelRincian1 = PanelRincian.getInstance(halamanUtama);
        this.dataDAO = new DataDAO(halamanUtama); // Inisialisasi DataDAO        
        System.out.println("DataDAO di PanelMinuman: " + (this.dataDAO == null ? "null" : "initialized"));

        if (this.panelRincian1 != null) {
            System.out.println("PanelRincian1 diterima di PanelMinuman.");
            this.panelRincian1.refreshTable();  // Refresh table if panelRincian1 is not null
        } else {
            throw new IllegalStateException("PanelRincian1 null di PanelMinuman.");
        }

        menu.getVerticalScrollBar().setUnitIncrement(15); // Set scroll sensitivity
        jPanel1.setPreferredSize(new Dimension(menu.getWidth(), 800)); // Example height 800
        jPanel1.revalidate();

                // Tambahkan listener untuk Checkbox dan Spinner setelah initComponents()
        IceCapCbox.addActionListener(this::IceCapCboxActionPerformed);
        IceChocoCbox.addActionListener(this::IceChocoCboxActionPerformed);
        KelpCbox.addActionListener(this::KelpCboxActionPerformed);
        CocaColaCbox.addActionListener(this::CocaColaCboxActionPerformed);
        LeMineCbox.addActionListener(this::LeMineCboxActionPerformed);

        spinnerIceCap.addChangeListener(e -> {
            int value = (Integer) spinnerIceCap.getValue();
            if (value < 0) {
                spinnerIceCap.setValue(0);  // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MI001", spinnerIceChoco);
            updateCheckBoxFromSpinner(IceCapCbox, spinnerIceCap, "MI001");
        });

        // Menambahkan listener untuk spinnerDblBeef
        spinnerIceChoco.addChangeListener(e -> {
            int value = (Integer) spinnerIceChoco.getValue();
            if (value < 0) {
                spinnerIceChoco.setValue(0); // Pastikan nilai tidak negatif
            }
            updateTableFromSpinner("MI002", spinnerIceChoco);
            updateCheckBoxFromSpinner(IceChocoCbox, spinnerIceChoco, "MI002");  // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerDelxBurg
        spinnerKelp.addChangeListener(e -> {
            int value = (Integer) spinnerKelp.getValue();
            if (value < 0) {
                spinnerKelp.setValue(0);  // Atur nilai spinner kembali ke 0 jika nilai kurang dari 0
            }
            updateTableFromSpinner("P003", spinnerKelp);
            updateCheckBoxFromSpinner(KelpCbox, spinnerKelp, "MI003");  // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerChezzBurg
        spinnerCocaCola.addChangeListener(e -> {
            int value = (Integer) spinnerCocaCola.getValue();
            if (value < 0) {
                spinnerCocaCola.setValue(0);  // Atur nilai spinner kembali ke 0 jika nilai kurang dari 0
            }
            updateTableFromSpinner("P004", spinnerCocaCola);
            updateCheckBoxFromSpinner(CocaColaCbox, spinnerCocaCola, "MI004");  // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menambahkan listener untuk spinnerChikBurg
        spinnerLeMine.addChangeListener(e -> {
            int value = (Integer) spinnerLeMine.getValue();
            if (value < 0) {
                spinnerLeMine.setValue(0);  // Atur nilai spinner kembali ke 0 jika nilai kurang dari 0
            }
            updateTableFromSpinner("P005", spinnerLeMine);
            updateCheckBoxFromSpinner(LeMineCbox, spinnerLeMine, "M!005");  // Memperbarui checkbox sesuai dengan nilai spinner
        });

        // Menetapkan model spinner dengan validasi agar nilai tidak kurang dari 0
        spinnerIceCap.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerIceChoco.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerKelp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerCocaCola.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
        spinnerLeMine.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); 
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
        IceCapCbox = new javax.swing.JCheckBox();
        IceChocoCbox = new javax.swing.JCheckBox();
        KelpCbox = new javax.swing.JCheckBox();
        CocaColaCbox = new javax.swing.JCheckBox();
        LeMineCbox = new javax.swing.JCheckBox();
        spinnerLeMine = new javax.swing.JSpinner();
        spinnerCocaCola = new javax.swing.JSpinner();
        spinnerKelp = new javax.swing.JSpinner();
        spinnerIceChoco = new javax.swing.JSpinner();
        spinnerIceCap = new javax.swing.JSpinner();

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMinuman/capucino.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Rp 10.000");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ice Cappucino");

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
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMinuman/choco-removebg-preview.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Rp 10.000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Ice Chocolate");

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
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(4, 4, 4))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMinuman/kelpshake.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Rp 75.000");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Kelp Special Edition");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMinuman/cocacola.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Rp 8.000");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Coca Cola");

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
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addGap(4, 4, 4))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FootageMinuman/leminerale.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Rp 5.000");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Le Mineral");

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
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

        IceCapCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IceCapCboxActionPerformed(evt);
            }
        });

        IceChocoCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IceChocoCboxActionPerformed(evt);
            }
        });

        KelpCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KelpCboxActionPerformed(evt);
            }
        });

        CocaColaCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CocaColaCboxActionPerformed(evt);
            }
        });

        LeMineCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeMineCboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(IceCapCbox)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerIceCap)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(KelpCbox)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerKelp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CocaColaCbox)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerCocaCola))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(IceChocoCbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinnerIceChoco, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(LeMineCbox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spinnerLeMine))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(IceChocoCbox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IceCapCbox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerIceChoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerIceCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KelpCbox)
                    .addComponent(CocaColaCbox)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerCocaCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerKelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LeMineCbox)
                    .addComponent(spinnerLeMine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
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

    private void IceCapCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IceCapCboxActionPerformed
    if (IceCapCbox.isSelected()) {
        loadData("M007", spinnerIceCap);
    } else {
        removeData("M007");
    }
    }//GEN-LAST:event_IceCapCboxActionPerformed

    private void IceChocoCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IceChocoCboxActionPerformed
    if (IceChocoCbox.isSelected()) {
        loadData("M008", spinnerIceChoco);
    } else {
        removeData("M008");
    }
    }//GEN-LAST:event_IceChocoCboxActionPerformed

    private void KelpCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KelpCboxActionPerformed
    if (KelpCbox.isSelected()) {
        loadData("M009", spinnerKelp);
    } else {
        removeData("M009");
    }
    }//GEN-LAST:event_KelpCboxActionPerformed

    private void CocaColaCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CocaColaCboxActionPerformed
    if (CocaColaCbox.isSelected()) {
        loadData("M010", spinnerCocaCola);
    } else {
        removeData("M010");
    }
    }//GEN-LAST:event_CocaColaCboxActionPerformed

    private void LeMineCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeMineCboxActionPerformed
    if (LeMineCbox.isSelected()) {
        loadData("M011", spinnerLeMine);
    } else {
        removeData("M011");
    }
    }//GEN-LAST:event_LeMineCboxActionPerformed
    
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
    // Mendapatkan model tabel dari PanelRincian
    PanelRincian panelRincian1 = PanelRincian.getInstance(halamanUtama);
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
        removeData(menuId);           // Hapus data dari tabel PanelRincian
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
        spinnerCocaCola.setValue(0);
        spinnerIceCap.setValue(0);
        spinnerIceChoco.setValue(0);
        spinnerKelp.setValue(0);
        spinnerLeMine.setValue(0);

        // Reset checkbox ke tidak dicentang
        CocaColaCbox.setSelected(false);
        IceCapCbox.setSelected(false);
        IceChocoCbox.setSelected(false);
        KelpCbox.setSelected(false);
        LeMineCbox.setSelected(false);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CocaColaCbox;
    private javax.swing.JCheckBox IceCapCbox;
    private javax.swing.JCheckBox IceChocoCbox;
    private javax.swing.JCheckBox KelpCbox;
    private javax.swing.JCheckBox LeMineCbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane menu;
    private javax.swing.JSpinner spinnerCocaCola;
    private javax.swing.JSpinner spinnerIceCap;
    private javax.swing.JSpinner spinnerIceChoco;
    private javax.swing.JSpinner spinnerKelp;
    private javax.swing.JSpinner spinnerLeMine;
    // End of variables declaration//GEN-END:variables
}
