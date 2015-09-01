package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*Statement stmt = null;*/
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
					"user0", "12345");
			
			String sql = "UPDATE boards SET board_title=?, board_content=?, board_writer=? "
					+ "WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "JDBC 공부");
			pstmt.setString(2, "JDBC 배우자");
			pstmt.setString(3, "학");
			pstmt.setInt(4, 2);
			int row = pstmt.executeUpdate();
			if(row < 1) {
				System.out.println("insert failed");
			} else System.out.println(row + "row updated");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {conn.close();} catch (Exception e) {}
		}
	}
}
