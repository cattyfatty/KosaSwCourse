package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*Statement stmt = null;*/
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
					"user2", "12345");
			
			String sql = "INSERT INTO boards(board_title, board_content, board_writer) "
					+ "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "¾È³ç!");
			pstmt.setString(2, "¾È³ç! ¿À´Ãµµ!");
			pstmt.setString(3, "È«±æµ¿");
			int row = pstmt.executeUpdate();
			if(row < 1) {
				System.out.println("insert failed");
			} else System.out.println("1 row inserted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {conn.close();} catch (Exception e) {}
		}
	}
}
