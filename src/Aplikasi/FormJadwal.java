/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Cab Priok
 */
public class FormJadwal extends javax.swing.JFrame {
private Connection con;
private Statement stat;
private ResultSet res;
    /**
     * Creates new form FormJadwal
     */
    public FormJadwal() {
        initComponents();
        koneksi();  
        tabel();
        
}   
    

    private void koneksi(){
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bookinglapfutsal", "root", "");
stat=con.createStatement();
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
    
private void tabel(){
DefaultTableModel tb= new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
tb.addColumn("ID");
tb.addColumn("Nama");
tb.addColumn("Lapangan");
tb.addColumn("Team");
tb.addColumn("Tanggal");
tb.addColumn("Jam");

tabell.setModel(tb);
try{
// Mengambil data dari database
res=stat.executeQuery("select * from data");

while (res.next())
{
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
tb.addRow(new Object[]{
res.getString("id"),
res.getDate("nama"),
res.getDate("lapangan"),
res.getDate("team"),
res.getDate("tanggal"),
res.getDate("jam"),        
});
}

}catch (Exception e){
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
        tabell = new javax.swing.JTable();
        tbcari2 = new javax.swing.JButton();
        tbback2 = new javax.swing.JButton();
        tbclose2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("JADWAL BOOKING LAPANGAN");

        tabell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabell);

        tbcari2.setText("CARI");
        tbcari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbcari2ActionPerformed(evt);
            }
        });

        tbback2.setText("KEMBALI KE MENU");
        tbback2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbback2ActionPerformed(evt);
            }
        });

        tbclose2.setText("LOG OUT");
        tbclose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbclose2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(tbcari2)
                        .addGap(46, 46, 46)
                        .addComponent(tbback2)
                        .addGap(48, 48, 48)
                        .addComponent(tbclose2)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbcari2)
                    .addComponent(tbback2)
                    .addComponent(tbclose2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbcari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbcari2ActionPerformed
        // TODO add your handling code here:
        
        koneksi();
        tabel();
    }//GEN-LAST:event_tbcari2ActionPerformed

    private void tbback2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbback2ActionPerformed
        // TODO add your handling code here:
        new FormMenuu().setVisible(true);
 dispose();
    }//GEN-LAST:event_tbback2ActionPerformed

    private void tbclose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbclose2ActionPerformed
        // TODO add your handling code here:
        new FormLogin().setVisible(true);
 dispose();
    }//GEN-LAST:event_tbclose2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabell;
    private javax.swing.JButton tbback2;
    private javax.swing.JButton tbcari2;
    private javax.swing.JButton tbclose2;
    // End of variables declaration//GEN-END:variables
}
