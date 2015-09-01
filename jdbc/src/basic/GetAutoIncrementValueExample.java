package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {
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
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
			pstmt.setString(1, "¾È³ç!");
			pstmt.setString(2, "¾È³ç! ¿À´Ãµµ!");
			pstmt.setString(3, "È«±æµ¿");
			int row = pstmt.executeUpdate();
			int boardNo = 0;
			if(row < 1) {
				System.out.println("insert failed");
			} else {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					boardNo = rs.getInt(1);
				}
				System.out.println(boardNo + " inserted");
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {conn.close();} catch (Exception e) {}
		}
	}
}
