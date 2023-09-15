package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
			String user = "root";// add your username of mysql
			String pwd = "Durgaprakash@143";// add password of mysql

			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			rset = stmt.executeQuery("select eid,ename from Employee");
			 System.out.println("eid:"+"   "+"ename:");
			while (rset.next())
				System.out.println(rset.getInt("eid") + "     " + rset.getString("ename"));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
			stmt.close();
			rset.close();

		}
	}

}
