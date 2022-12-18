package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserMsg;

public class UserMsgDao {
	private String url = "jdbc:mysql://localhost:3306/branch_local?allowPublicKeyRetrieval=true&useSSL=false";
	private String username = "admin";
	private String password = "asad";
	
	private static final String SELECT_SQL = "SELECT * FROM user_message";
	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<UserMsg> fetchMsg() throws SQLException {
		ArrayList<UserMsg> msgArr = new ArrayList<>();
		
		try(Connection con = getConnection();
				PreparedStatement prepStmt = con.prepareStatement(SELECT_SQL)) {
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String timestamp = rs.getString("timestamp");
				String msg = rs.getString("message_body");
				
				msgArr.add(new UserMsg(userId, timestamp, msg));
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return msgArr;
	}
}
