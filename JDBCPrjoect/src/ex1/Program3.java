package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/JDBC";
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, FILES=? WHERE ID = ?";
		
		String title = "TE2";
		int ID = 2;
		String content = "papapa";
		String files = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, "root", "@Oleout[3892]");
		//Statement st = conn.createStatement();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, ID);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		conn.close();
	}

}
