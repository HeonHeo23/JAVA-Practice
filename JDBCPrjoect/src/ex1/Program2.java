package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/JDBC";
		String sql = "INSERT INTO notice (title, writer_id, content, files) VALUES(?, ?, ?, ?)";
		
		String title = "TEST2";
		String writerID = "newlec";
		String content = "hahaha";
		String files = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, "root", "@Oleout[3892]");
		//Statement st = conn.createStatement();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerID);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		conn.close();
	}

}
