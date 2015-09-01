package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	/*	// singleton으로 사용
	private static BoardDAO singleton = new BoardDAO();
	private BoardDAO(){}
	public static BoardDAO getInstance() {
		return singleton;
	}
	 */
	private Connection conn;
	//	private PreparedStatement pstmt;

	public BoardDAO(Connection conn) {
		this.conn = conn;
	}

	/*	//close
	public void close() {
		try{ pstmt.close(); } catch(Exception e){}
		try{ conn.close(); } catch(Exception e){}
//		System.out.println("closed");
	}*/

	//DMM
	public Integer insert(Board board) throws SQLException {
		Integer pk = null;
		String sql = "INSERT INTO boards(board_title, board_content, board_writer)"
				+ " VALUES(?,?,?)";
		ResultSet rs = null;

		PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());

		int row = pstmt.executeUpdate();
		if(row < 1) {
			System.out.println("failed");
		} else {
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		}

		pstmt.close();
		return pk;
	}

	public int update(Board board) throws SQLException {
		int rows = 0;
		String sql = "UPDATE boards SET board_title=?, board_content=?, "
				+ "board_hitcount=? WHERE board_no=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());

		rows = pstmt.executeUpdate();

		pstmt.close();
		return rows;
	}

	public int delete(int boardNo) throws SQLException {
		int rows = 0;
		String sql = "DELETE FROM boards WHERE board_no=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);

		rows = pstmt.executeUpdate();

		pstmt.close();
		return rows;
	}

	public Board selectByPK(int boardNo) throws SQLException {
		Board board = null;
		String sql = "SELECT * FROM boards WHERE board_no=?";
		ResultSet rs = null;

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);

		rs = pstmt.executeQuery();
		if(rs.next()){
			board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));
		}
		rs.close();

		pstmt.close();

		return board;
	}
	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException {
		List<Board> list = new ArrayList<Board>();
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM rn, board_no, board_title, board_content, "
				+ "board_date, board_writer, board_hitcount FROM ("
				+ "SELECT * "
				+ "FROM boards ORDER BY board_no DESC) WHERE ROWNUM <=?) "
				+ "WHERE rn>=?";
		ResultSet rs = null;

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageNo * rowsPerPage);
		pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);

		rs = pstmt.executeQuery();
		while(rs.next()){
			Board b = new Board();
			b.setNo(rs.getInt("board_no"));
			b.setTitle(rs.getString("board_title"));
			b.setContent(rs.getString("board_content"));
			b.setDate(rs.getDate("board_date"));
			b.setWriter(rs.getString("board_writer"));
			b.setHitcount(rs.getInt("board_hitcount"));
			list.add(b);
		}
		rs.close();
		pstmt.close();
		
		return list;
	}
	/*
	public List<Board> selectAll() throws SQLException {
		List<Board> board = null;
		String sql = "SELECT * FROM boards";
		ResultSet rs = null;

		PreparedStatement pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		board = new ArrayList<Board>();
		while(rs.next()){
			Board b = new Board();
			b.setNo(rs.getInt("board_no"));
			b.setTitle(rs.getString("board_title"));
			b.setContent(rs.getString("board_content"));
			b.setDate(rs.getDate("board_date"));
			b.setWriter(rs.getString("board_writer"));
			b.setHitcount(rs.getInt("board_hitcount"));
			board.add(b);
		}
		rs.close();

		pstmt.close();
		return board;
	}
	 */
}
