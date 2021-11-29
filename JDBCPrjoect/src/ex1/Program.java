package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/JDBC";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, "root", "@Oleout[3892]");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerID = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hits = rs.getInt("hit");
			System.out.printf("id: %d, ntitle: %s, writerID: %s, regDate: %s, content: %s, hit: %d\n",id, title, writerID, regDate, content, hits);
		}
		rs.close();
		st.close();
		conn.close();
	}

}
