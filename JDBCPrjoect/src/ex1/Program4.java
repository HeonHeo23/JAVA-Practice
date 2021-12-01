package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/JDBC";
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		int ID = 2;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, "root", "@Oleout[3892]");
		//Statement st = conn.createStatement();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, ID);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		conn.close();
	}

}
