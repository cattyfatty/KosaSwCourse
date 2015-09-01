package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDAOInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("오늘은 DAO");
		board.setContent("연습 많이 하자!");
		board.setWriter("홍길동");
		
		Connection conn = ConnectionManager.getConnection();
		BoardDAO boardDAO = new BoardDAO(conn);
		Integer pk = boardDAO.insert(board);
		
		if(pk != null) {
			System.out.println(pk + "번 게시물이 저장됨");
		} else {
			System.out.println("failed to insert");
		}
	}
}
