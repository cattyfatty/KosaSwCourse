package basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2", 
					"team2", "123456");
			System.out.println("success");
		} catch (Exception e) {
			System.out.println("failed");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
	}
}
