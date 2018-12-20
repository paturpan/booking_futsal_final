package koneksi;

/*
*@ author resa cr
* This program can modify and share
*/
import java.sql.DriverManager;
import java.sql.Connection;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
import javax.swing.*;
        import java.sql.*;
        import javax.swing.table.*;
        import java.awt.Dimension;
        import java.awt.Toolkit;
public class Koneksi 
{
	private static Connection koneksi;
	
	public static Connection getKoneksi()
	{
		if(koneksi == null)
		{
			try
			{
				String url = "jdbc:mysql://localhost:3306/bookinglapfutsal";
				String user = "root";
				String password = "";
				
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				koneksi = DriverManager.getConnection(url,user,password);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		return koneksi;
	}
	
}
