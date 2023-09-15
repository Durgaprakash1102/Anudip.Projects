package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BatchDemo {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String user="root";
		String pwd="Durgaprakash@143";
		Connection con=DriverManager.getConnection(url, user,pwd );
		PreparedStatement pst=con.prepareStatement("select * from employee");
		ResultSet rset=pst.executeQuery();
		while(rset.next()) {
			System.out.println(rset.getInt(1)+" "+rset.getString(2));
		}
		//inserting records into the employee table
		pst.addBatch("insert into employee values(55,'Rajesh',32200)");
		pst.addBatch("insert into employee values(77,'Ram',32500)");
		pst.addBatch("insert into employee values(88,'Sam',30000)");
		pst.addBatch("update employee set ename='Joe' where eid=22");
		pst.addBatch("insert into employee values(99,'Saara',30000)");
		
		
		int[] i=pst.executeBatch();
		System.out.println("No of records inserted :"+i.length);
		
	}

}
