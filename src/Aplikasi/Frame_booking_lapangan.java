/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;
import autoincrement.Validasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author HP PC
 */
public class Frame_booking_lapangan extends javax.swing.JFrame {
    
 
    
    double nama,harga,jmlhjual,total;
    Model_booking1 penjualan = new Model_booking1();
DefaultTableModel tabmode;
Validasi valid=new Validasi();
    private Object frame_booking_lapangan;
    /**
     * Creates new form Frame_booking_lapangan
     */
    
    public Frame_booking_lapangan() {
        initComponents();
tblPesanan.setModel(penjualan.getTabel());
lapangan.addItem("MINI SAN SIRO");
lapangan.addItem("MINI SANTIAGO BERNABEU");
lapangan.addItem("MINI OLD TRAFFORD");

for (int a=1; a<=31;a++){
Tgl.addItem(a);
}
Bln.addItem("January");
Bln.addItem("February");
Bln.addItem("Maret");
Bln.addItem("April");
Bln.addItem("Mei");
Bln.addItem("Juny");
Bln.addItem("July");
Bln.addItem("Agustus");
Bln.addItem("September");
Bln.addItem("Oktober");
Bln.addItem("November");
Bln.addItem("Desember");

for (int b=2018; b<=2020; b++){
Thn.addItem(b);
}
Jam1.addItem("08:00");
Jam1.addItem("09:00");
Jam1.addItem("10:00");
Jam1.addItem("11:00");
Jam1.addItem("12:00");
Jam1.addItem("13:00");
Jam1.addItem("14:00");
Jam1.addItem("15:00");
Jam1.addItem("16:00");
Jam1.addItem("17:00");
Jam1.addItem("18:00");
Jam1.addItem("19:00");
Jam1.addItem("20:00");
Jam1.addItem("21:00");
Jam1.addItem("22:00");
Jam1.addItem("23:00");
Jam1.addItem("24:00");

jam2.addItem("08:00");
jam2.addItem("09:00");
jam2.addItem("10:00");
jam2.addItem("11:00");
jam2.addItem("12:00");
jam2.addItem("13:00");
jam2.addItem("14:00");
jam2.addItem("15:00");
jam2.addItem("16:00");
jam2.addItem("17:00");
jam2.addItem("18:00");
jam2.addItem("19:00");
jam2.addItem("20:00");
jam2.addItem("21:00");
jam2.addItem("22:00");
jam2.addItem("23:00");
jam2.addItem("24:00");

    }

        Connection koneksi;
    
    public void konekdatabase(){
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookinglapfutsal","root","");
}
catch (Exception e)
{
System.err.println("Exception: "+e.getMessage());
}
}
    
    public void orderin() 
			{
				try
				{
					Connection koneksi = Koneksi.getKoneksi();
					String string = "INSERT INTO data VALUES(?,?,?,?,?,?)";
					PreparedStatement prepare = koneksi.prepareStatement(string);
					
					prepare.setInt(1,Integer.parseInt(txtId.getText()));
					prepare.setString(2, txtNama.getText());
					prepare.setString(3, (String) lapangan.getSelectedItem());
                                        prepare.setString(4, txtTeam.getText());
                                        prepare.setString(5, ""+Tgl.getSelectedItem()+"-"+Bln.getSelectedItem()+"-"+Thn.getSelectedItem());
					prepare.setString(6, ""+Jam1.getSelectedItem()+"-"+jam2.getSelectedItem());
                                        prepare.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					prepare.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Data gagal disimpan","Pesan",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}
				finally
				{
					autonumber(); //Menampilkan autonumber setelah data disimpan
				}
			}

    
    public void autonumber()
	{
		try
		{
			Connection koneksi = Koneksi.getKoneksi();
			Statement state = koneksi.createStatement();
			String query = "SELECT MAX(id) FROM data"; //Mendapatkan nilai id terakhir
			
			ResultSet rs = state.executeQuery(query);
			if(rs.next())
			{
				int a = rs.getInt(1);
				txtId.setText(Integer.toString(a+1)); //Nilai input yang terakhir ditambahkan 1
			}
			rs.close();
			state.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			txtNama.setText("");
			txtTeam.setText("");
			txtNama.requestFocus();
		}
	}
 

    
    private Frame_booking_lapangan(Frame_booking_lapangan aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Frame_booking_lapangan(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jLabel2 = new javax.swing.JLabel();
        lapangan = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        Tgl = new javax.swing.JComboBox();
        Bln = new javax.swing.JComboBox();
        Thn = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        Jam1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jam2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTeam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        btnPesan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        tbback = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Program Booking Lapangan Futsal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("LAPANGAN");

        lapangan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lapangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapanganActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tanggal Pemesanan");

        Tgl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Bln.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Thn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Waktu Pemesanan");

        Jam1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sampai");

        jam2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nama Pemesan");

        txtNama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nama Team");

        txtTeam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("No Handphone");

        txtNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnPesan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPesan.setText("PESAN");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblPesanan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblPesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPesanan);

        tbback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbback.setText("BACK");
        tbback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbbackActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("NO FAKTUR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jam1, 0, 76, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jam2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Bln, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Thn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnPesan, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnHapus)
                                    .addGap(18, 18, 18)
                                    .addComponent(tbback))
                                .addComponent(txtNo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTeam, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lapangan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Jam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesan)
                    .addComponent(tbback)
                    .addComponent(btnHapus))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lapanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapanganActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_lapanganActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        // TODO add your handling code here:
  
        String[] data = new String[6];
  data[0] = (""+lapangan.getSelectedItem());
  data[1] = (""+Tgl.getSelectedItem()+"-"+Bln.getSelectedItem()+"-"+Thn.getSelectedItem());
  data[2] = (""+Jam1.getSelectedItem()+"-"+jam2.getSelectedItem());
  data[3] = txtNama.getText();
  data[4] = txtTeam.getText();
  data[3] = txtNo.getText();

penjualan.getTabel().addRow(data);

orderin();
konekdatabase();
    }//GEN-LAST:event_btnPesanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        penjualan.getTabel().removeRow(tblPesanan.getSelectedRow());
        
        orderin();
konekdatabase();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tbbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbbackActionPerformed
        // TODO add your handling code here:
        new FormMenuu().setVisible(true);
 dispose();
    }//GEN-LAST:event_tbbackActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    Frame_booking_lapangan fbl= new Frame_booking_lapangan(this, false);
     fbl.setVisible(true);
     fbl.emptTeks();
    }//GEN-LAST:event_txtIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_booking_lapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_booking_lapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_booking_lapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_booking_lapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Frame_booking_lapangan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Bln;
    private javax.swing.JComboBox Jam1;
    private javax.swing.JComboBox Tgl;
    private javax.swing.JComboBox Thn;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jam2;
    private javax.swing.JComboBox lapangan;
    private javax.swing.JButton tbback;
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtTeam;
    // End of variables declaration//GEN-END:variables
public void emptTeks() {
        txtId.setText("");
        txtNama.setText("");
        txtNo.setText("");
        txtTeam.setText("");
        txtId.requestFocus();
        valid.autoNomer(tabmode,"T",4,txtId);
    
}



    
}