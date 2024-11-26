/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminPanel;

import Login.DbConnection;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ManageTablePanel extends javax.swing.JPanel {

    public ManageTablePanel() {
        initComponents();
        
        // Panggil loadDataToTable agar data langsung dimuat saat form pertama kali ditampilkan
        loadDataToTable(); // Atau bisa disesuaikan dengan ID meja default
        setPreferredSize(new Dimension(800, 1000)); 

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Table1 = new javax.swing.JButton();
        Table2 = new javax.swing.JButton();
        Table3 = new javax.swing.JButton();
        Table4 = new javax.swing.JButton();
        Tabe5 = new javax.swing.JButton();
        Table6 = new javax.swing.JButton();
        Table7 = new javax.swing.JButton();
        Table8 = new javax.swing.JButton();
        Table9 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        UsedToggleBtn = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1498, 838));

        jPanel4.setBackground(new java.awt.Color(218, 41, 28));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        Table1.setText("Tabel 1");
        Table1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table1ActionPerformed(evt);
            }
        });

        Table2.setText("Tabel 2");
        Table2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table2ActionPerformed(evt);
            }
        });

        Table3.setText("Tabel 3");
        Table3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table3ActionPerformed(evt);
            }
        });

        Table4.setText("Tabel 4");
        Table4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table4ActionPerformed(evt);
            }
        });

        Tabe5.setText("Tabel 5");
        Tabe5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabe5ActionPerformed(evt);
            }
        });

        Table6.setText("Tabel 6");
        Table6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table6ActionPerformed(evt);
            }
        });

        Table7.setText("Tabel 7");
        Table7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table7ActionPerformed(evt);
            }
        });

        Table8.setText("Tabel 8");
        Table8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table8ActionPerformed(evt);
            }
        });

        Table9.setText("Tabel 9");
        Table9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Table9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Table9)
                    .addComponent(Table8)
                    .addComponent(Table7)
                    .addComponent(Table6)
                    .addComponent(Tabe5)
                    .addComponent(Table4)
                    .addComponent(Table3)
                    .addComponent(Table2)
                    .addComponent(Table1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Table1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabe5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Table9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        UsedToggleBtn.setText("Not Available");
        UsedToggleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsedToggleBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Meja", "No Meja", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1215, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UsedToggleBtn)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UsedToggleBtn)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Table1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table1ActionPerformed
        String mejaId = "M1"; // ID meja untuk Table1
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table1ActionPerformed

    private void Table2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table2ActionPerformed
        String mejaId = "M2"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table2ActionPerformed

    private void Table3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table3ActionPerformed
        String mejaId = "M3"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table3ActionPerformed

    private void Table4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table4ActionPerformed
        String mejaId = "M4"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table4ActionPerformed

    private void UsedToggleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsedToggleBtnActionPerformed
        String mejaId = (String) UsedToggleBtn.getClientProperty("mejaId");

        if (mejaId == null || mejaId.isEmpty()) {
            System.out.println("Meja ID is not set for this button.");
            return;
        }

        if (UsedToggleBtn.isSelected()) {
            updateStatusInDatabase(true, mejaId);  // Mengupdate status ke 'Used'
        } else {
            updateStatusInDatabase(false, mejaId);  // Mengupdate status ke 'Available'
        }

        loadDataToTable();  // Memuat data tabel setelah update
        updateToggleButtonStatus(mejaId);  // Memperbarui status toggle button
    }//GEN-LAST:event_UsedToggleBtnActionPerformed

    private void Tabe5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tabe5ActionPerformed
        String mejaId = "M5"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Tabe5ActionPerformed

    private void Table6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table6ActionPerformed
        String mejaId = "M6"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table6ActionPerformed

    private void Table7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table7ActionPerformed
        String mejaId = "M7"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table7ActionPerformed

    private void Table8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table8ActionPerformed
        String mejaId = "M8"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table8ActionPerformed

    private void Table9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Table9ActionPerformed
        String mejaId = "M9"; // ID meja untuk Table2
        assignMejaIdToToggleButtons(mejaId);
        updateToggleButtonStatus(mejaId);
    }//GEN-LAST:event_Table9ActionPerformed

    private void assignMejaIdToToggleButtons(String mejaId) {
        UsedToggleBtn.putClientProperty("mejaId", mejaId);
    }

    private void loadDataToTable() {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT Meja_Id, No_Meja, Status FROM meja";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Hapus semua data dari tabel

            while (rs.next()) {
                String idMeja = rs.getString("Meja_Id");
                int noMeja = rs.getInt("No_Meja");
                boolean status = rs.getBoolean("Status");

                model.addRow(new Object[]{idMeja, noMeja, status});
            }

            // Memanggil method customizeTable setelah data dimuat ke dalam tabel
            customizeTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStatusInDatabase(boolean isUsed, String mejaId) {
        int status = isUsed ? 1 : 0; // Menggunakan 1 untuk 'TRUE' dan 0 untuk 'FALSE'

        String sql = "UPDATE meja SET status = ? WHERE meja_id = ?"; 

        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, status);  // Set status 1 atau 0
            stmt.setString(2, mejaId);  // Set id meja yang dipilih

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateToggleButtonStatus(String mejaId) {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT Status FROM meja WHERE Meja_Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mejaId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                boolean status = rs.getBoolean("Status");

                // Menyesuaikan status tombol toggle
                UsedToggleBtn.setSelected(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void customizeTable() {
        // Mengonversi kolom status yang berisi Boolean menjadi Tersedia/Tidak Tersedia
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof Boolean) {
                    boolean status = (Boolean) value;
                    setText(status ? "Tidak Tersedia" : "Tersedia");  // Menampilkan Tersedia / Tidak Tersedia
                } else {
                    super.setValue(value);
                }
            }
        });

        jTable1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.LEFT);  // Mengatur alignment ke kiri
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Tabe5;
    private javax.swing.JButton Table1;
    private javax.swing.JButton Table2;
    private javax.swing.JButton Table3;
    private javax.swing.JButton Table4;
    private javax.swing.JButton Table6;
    private javax.swing.JButton Table7;
    private javax.swing.JButton Table8;
    private javax.swing.JButton Table9;
    private javax.swing.JToggleButton UsedToggleBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
