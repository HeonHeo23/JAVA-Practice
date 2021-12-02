package com.newlecture.app.serivce;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	String url = "jdbc:mysql://localhost:3306/JDBC";
	String uid = "root";
	String pwd = "@Oleout[3892]";
	String driver = "com.mysql.cj.jdbc.Driver";
	

	public int getCount() throws SQLException, ClassNotFoundException {
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE"; 
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");
		
		rs.close();
		st.close();
		conn.close();
			
		return count;
	}
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10;
		int end = 10*page;
		
		String sql = "SELECT S.* FROM (SELECT @ROWNUM:=0 NUM) P, NOTICE_VIEW S WHERE "+field+" LIKE ? AND s.NUM BETWEEN ? AND ?";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerID = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hits = rs.getInt("hit");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(id, title, writerID, regDate, content, hits, files);
			list.add(notice);
		}
				
		st.close();
		conn.close();
		return list;
	}
	
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO notice (title, writer_id, content, files) VALUES(?, ?, ?, ?)";
		
		String title = notice.getTitle();
		String writerID = notice.getWriterID();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, pwd);
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
		return result;
	}
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, FILES=? WHERE ID = ?";
		
		String title = notice.getTitle();
		int ID = notice.getId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, pwd);
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
		
		return result;
	}
	public int delete(Notice notice) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		int ID = notice.getId();
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		//Statement st = conn.createStatement();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, ID);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		st.close();
		conn.close();
		return result;
	}

}
