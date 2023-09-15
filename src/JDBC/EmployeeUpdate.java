// jdbc program to update, delete a record in employee table.
package JDBC;

//importing the packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeUpdate {

	public static void main(String[] args) throws Exception {
		// loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
		String user = "root";// add your username of mysql
		String pwd = "Durgaprakash@143";// add password of mysql

		// establishing connection
		Connection con = DriverManager.getConnection(url, user, pwd);

		// creating a statement for updating employee details
		PreparedStatement pst = con.prepareStatement("update employee set ename=? where eid=?");
		pst.setString(1, "Ramesh");
		pst.setInt(2, 66);
		int i = pst.executeUpdate();
		System.out.println("No of rows updated:" + i);

		// deleting a record from the employee table using preparedstatement
		pst = con.prepareStatement("delete from employee where eid=55");
		i = pst.executeUpdate();
		System.out.println("No of records deleted:" + i);

		// selecting student table
		ResultSet rst = pst.executeQuery("select * from student");
		//printing the output
		while (rst.next()) {
			System.out.println(rst.getInt("sid") + "      " + rst.getString(2));
		}

		// closing statements and connections
		con.close();
		pst.close();
		rst.close();

	}

}
