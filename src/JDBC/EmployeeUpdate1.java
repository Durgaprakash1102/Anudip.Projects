//program using jdbc to insert records into the employee asking the user for employee information and yes/no to continue inserting.
package JDBC;

//importing packages
import java.sql.*;
import java.util.Scanner;

public class EmployeeUpdate1 {

	public static void main(String[] args) throws Exception {
		try {
			// loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/JDBC";// add your database name at myproject
			String user = "root";// add your username of mysql
			String pwd = "Durgaprakash@143";// add password of mysql

			// establishing connection
			Connection con = DriverManager.getConnection(url, user, pwd);

			// creating a prepared statement
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");

			System.out.println("Enter Yes to Insert record of employee, No to exit : ");
			Scanner sc = new Scanner(System.in);
			String s = sc.next();

			if (s.equals("Yes")) {
				System.out.println("Enter the eid of employee to be inserted : ");
				int eid = sc.nextInt();
				pstmt.setInt(1, eid);

				System.out.println("Enter the ename of employee to be inserted: ");
				String ename = sc.next();
				pstmt.setString(2, ename);

				System.out.println("Enter the salary of employee to be inserted : ");
				int salary = sc.nextInt();
				pstmt.setInt(3, salary);

				// executing the statement
				int i = pstmt.executeUpdate();
				System.out.println("No of rows inserted : " + i);

			}

			else if (s.equals("No")) {
				System.out.println("Program exited");
			}

			// closing connections
			con.close();
			sc.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}