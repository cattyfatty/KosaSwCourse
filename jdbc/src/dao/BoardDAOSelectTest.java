package dao;

import java.util.List;

public class BoardDAOSelectTest {

	public static void main(String[] args) throws Exception {
		BoardDAO boardDAO = new BoardDAO(ConnectionManager.getConnection());
		List<Board> list;
		
		/*Board board = boardDAO.selectByPK(21);
		if(board == null) {
			System.out.println(21 + "�� �Խù��� ����");
		} else {
			System.out.println("��ȣ: " + board.getNo());
			System.out.println("����: " + board.getTitle());
			System.out.print("�۾���: " + board.getWriter() + "\t|| ");
			System.out.println("��ȸ��: " + board.getHitcount());
			System.out.println("��¥: " + board.getDate());
			System.out.println("����: " + board.getContent());
		}*/
		
		System.out.println();
		
		/*for(Board b : list) {
			System.out.println("��ȣ: " + b.getNo());
			System.out.println("����: " + b.getTitle());
			System.out.print("�۾���: " + b.getWriter() + "\t|| ");
			System.out.println("��ȸ��: " + b.getHitcount());
			System.out.println("��¥: " + b.getDate());
			System.out.println("����: " + b.getContent());
			System.out.println();
		}*/
		
		list = boardDAO.selectByPage(1, 10);
		for(Board b : list) {
			System.out.println("��ȣ: " + b.getNo());
			System.out.println("����: " + b.getTitle());
			System.out.print("�۾���: " + b.getWriter() + "\t|| ");
			System.out.println("��ȸ��: " + b.getHitcount());
			System.out.println("��¥: " + b.getDate());
			System.out.println("����: " + b.getContent());
			System.out.println();
		}
	}
}
