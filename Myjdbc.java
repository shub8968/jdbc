package practiceapp;

import java.sql.*;



public class Myjdbc
{
public static void main(String [] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Successfully loaded");
	}
	catch(ClassNotFoundException ex) {
		System.out.println("cannot load the driver"+ ex.getMessage());
		System.exit(0);
	}
		Connection con = null;
		try {
	    con = DriverManager.getConnection("jdbc:oracle:thin:@bestfriend:1521:xe","system","shubham");
	    System.out.println("connected");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select model, company, price from XESPACE.car");
		while(rs.next()) {
			String s1  = rs.getString(1);
			String s2 = rs.getString(2);
			int price = rs.getInt(3);
			System.out.println(s1+" "+s2+" "+price);
		}
		}
catch(SQLException sq) {
System.out.println("SQL Error "+sq.getMessage());
}
		finally{
			if(con != null){
			try {
				con.close();
				System.out.println("Successfully disconnected from db");
			}
			catch(SQLException sq1){
				System.out.println("Error in closing the connection"+sq1.getMessage());
			}
}
}
}
}