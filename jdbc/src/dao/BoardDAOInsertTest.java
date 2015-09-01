package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDAOInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("������ DAO");
		board.setContent("���� ���� ����!");
		board.setWriter("ȫ�浿");
		
		Connection conn = ConnectionManager.getConnection();
		BoardDAO boardDAO = new BoardDAO(conn);
		Integer pk = boardDAO.insert(board);
		
		if(pk != null) {
			System.out.println(pk + "�� �Խù��� �����");
		} else {
			System.out.println("failed to insert");
		}
	}
}
