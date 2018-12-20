/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;
import entity.Entitas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Cab Priok
 */
public class Control {
 Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;

    public Control(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/transaksi","root","");
            st=con.createStatement();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
    }

    public List tampil(){
        List logBarang = new ArrayList();       
        sql="select no_transaksi from tb_transaksi order by id asc";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                Entitas eb=new Entitas();
                eb.setNoTransaksi(rs.getString("no_transaksi"));               
                logBarang.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logBarang;
    }   
}
