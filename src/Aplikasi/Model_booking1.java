/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP PC
 */
public class Model_booking1 {
  private DefaultTableModel tabel = new DefaultTableModel();
public Model_booking1(){

  getTabel().addColumn("Kode");
  getTabel().addColumn("Tanggal");
  getTabel().addColumn("Waktu");
  getTabel().addColumn("N0 HP");
  getTabel().addColumn("Nama Team");
  

}

/**
 *@return the tabel
 */
 public DefaultTableModel getTabel(){
   return tabel;
}
/**
*@param tabel the tabel to set
*/
public void setTabel(DefaultTableModel tabel){
 this.tabel=tabel;
}

}