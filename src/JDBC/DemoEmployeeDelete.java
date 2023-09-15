package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoEmployeeDelete {

	public static void main(String[] args) throws Exception{
		//2.loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/JDBC";//add your database name at myproject
		String user="root";//add your username of mysql
		String pwd="Durgaprakash@143";//add password of mysql
		
		//3.establishing connection
		Connection con=DriverManager.getConnection(url, user,pwd );
		
		PreparedStatement pst=con.prepareStatement("delete from employee where eid=55");
		int i=pst.executeUpdate();
		System.out.println("No of records deleted:"+i);
		con.close();
		pst.close();

	}

}
