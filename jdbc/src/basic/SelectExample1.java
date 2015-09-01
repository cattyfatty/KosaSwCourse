package basic;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*Statement stmt = null;*/
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
					"user0", "12345");
			
			String sql = "SELECT * FROM boards WHERE board_content like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%¿œ¬Ô%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				Date boardDate = rs.getDate("board_date");
				String boardWriter = rs.getString("board_writer");
				int boardHitcount = rs.getInt("board_hitcount");
				
				System.out.println(boardNo + "\t" + boardTitle + "\t" + boardContent);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {conn.close();} catch (Exception e) {}
		}
	}
}
