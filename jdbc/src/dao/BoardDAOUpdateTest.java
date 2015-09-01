package dao;

import java.sql.SQLException;

public class BoardDAOUpdateTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setNo(21);
		board.setTitle("������ DAO�� ����");
		board.setContent("www���� ���� ����!www");
		board.setHitcount(2);;
		
		BoardDAO boardDAO = new BoardDAO(ConnectionManager.getConnection());
		/*int rows = boardDAO.update(board);
		
		if(rows >= 1) {
			System.out.println(board.getNo() + "�� �Խù��� �����");
		} else {
			System.out.println(board.getNo() + "�� �Խù��� ����");
		}
		*/
		int rows = boardDAO.delete(22);
		if(rows >= 1) {
			System.out.println(22 + "�� �Խù��� ������");
		} else {
			System.out.println(22 + "�� �Խù��� ����");
		}
	}
}
