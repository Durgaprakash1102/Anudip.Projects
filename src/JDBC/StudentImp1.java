//jdbc program to display records from student table
package JDBC;

//1.import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentImp1 {

	public static void main(String[] args) throws Exception {
		// 2.loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
		String user = "root";// add your username of mysql
		String pwd = "Durgaprakash@143";// add password of mysql

		// 3.establishing connection
		Connection con = DriverManager.getConnection(url, user, pwd);

		// 4.create statement
		Statement st = con.createStatement();

		// 5.Execute the statement
		ResultSet set = st.executeQuery("select * from Student");// create and add student1 table

		// 6.Print the o/p
		System.out.println("sid:" + "   " + "sname:");
		while (set.next())
			System.out.println(set.getInt("sid") + "      " + set.getString("sname"));

		// 7.close the connections
		con.close();
		st.close();
		set.close();

	}

}
