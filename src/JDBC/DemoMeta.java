//program to get the table details from the database
package JDBC;

//importing packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoMeta {

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

		// executing the statement
		ResultSet rst = st.executeQuery("select * from employee");
		
		// creating statement for getting metadata of the table
		java.sql.ResultSetMetaData rsmd = rst.getMetaData();

		// printing the metadata of the table /table details
		System.out.println("Table name:" + rsmd.getTableName(1));
		System.out.println("No of coloumns:" + rsmd.getColumnCount());
		System.out.println("Coloumn Type:" + rsmd.getColumnType(1));
		System.out.println("Coloumn Type:" + rsmd.getColumnTypeName(1));
		System.out.println("Coloumn class name:" + rsmd.getColumnClassName(1));
		System.out.println("Coloumn name:" + rsmd.getColumnName(1));

		// closing statements and connections
		con.close();
		st.close();
		rst.close();

	}
}
