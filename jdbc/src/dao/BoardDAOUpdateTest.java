package dao;

import java.sql.SQLException;

public class BoardDAOUpdateTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setNo(21);
		board.setTitle("오늘은 DAO를 배운다");
		board.setContent("www연습 많이 하자!www");
		board.setHitcount(2);;
		
		BoardDAO boardDAO = new BoardDAO(ConnectionManager.getConnection());
		/*int rows = boardDAO.update(board);
		
		if(rows >= 1) {
			System.out.println(board.getNo() + "번 게시물이 변경됨");
		} else {
			System.out.println(board.getNo() + "번 게시물이 없다");
		}
		*/
		int rows = boardDAO.delete(22);
		if(rows >= 1) {
			System.out.println(22 + "번 게시물이 삭제됨");
		} else {
			System.out.println(22 + "번 게시물이 없다");
		}
	}
}
