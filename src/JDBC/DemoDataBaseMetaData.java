//program to get the database and driver details from the database
package JDBC;

//importing the packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DemoDataBaseMetaData {

	public static void main(String[] args) throws Exception {
		// loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
		String user = "root";// add your username of mysql
		String pwd = "Durgaprakash@143";// add password of mysql

		// establishing connection
		Connection con = DriverManager.getConnection(url, user, pwd);

		// creating a statement
		Statement st = con.createStatement();

		// creating a statement for getting the database details
		java.sql.DatabaseMetaData dbmd = con.getMetaData();

		// printing the details of the driver and database
		System.out.println("Driver Name: " + dbmd.getDriverName());
		System.out.println("Driver Version: " + dbmd.getDriverVersion());
		System.out.println("Database product Name: " + dbmd.getDatabaseProductName());
		System.out.println("Database product Version: " + dbmd.getDatabaseProductVersion());
		System.out.println("Database user Name: " + dbmd.getUserName());
		System.out.println("URL : " + dbmd.getURL());
		System.out.println("Maximum coloumns : " + dbmd.getMaxColumnsInTable());
		System.out.println(dbmd.getTimeDateFunctions());
		System.out.println(dbmd.getMaxTableNameLength());

		// closing statements and connections
		con.close();
		st.close();

	}

}
