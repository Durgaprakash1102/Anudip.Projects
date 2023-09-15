package JDBC;

//1.importing packages
import java.sql.*;

public class DemoPreparedStmt 
{

	public static void main(String[] args) throws Exception 
	{
		Connection con = null;
		PreparedStatement pst = null;
		// 2.loading the Driver class
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
			String user = "root";// add your username of mysql
			String pwd = "Durgaprakash@143";// add password of mysql

			// 3.establishing connection
			con = DriverManager.getConnection(url, user, pwd);

			pst = con.prepareStatement("insert into employee values(?,?,?)");
			pst.setInt(1, 55);
			pst.setString(2,"Raju");
			pst.setInt(3, 15000);
			int i = pst.executeUpdate();
			
			pst.setInt(1, 66);
			pst.setString(2,"Ravi");
			pst.setInt(3, 18000);
			i += pst.executeUpdate();
			 
			System.out.println("No of rows inserted: " + i);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally 
		{
			con.close();
			pst.close();
		}

	}

}
