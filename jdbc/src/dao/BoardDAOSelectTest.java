package dao;

import java.util.List;

public class BoardDAOSelectTest {

	public static void main(String[] args) throws Exception {
		BoardDAO boardDAO = new BoardDAO(ConnectionManager.getConnection());
		List<Board> list;
		
		/*Board board = boardDAO.selectByPK(21);
		if(board == null) {
			System.out.println(21 + "번 게시물이 없다");
		} else {
			System.out.println("번호: " + board.getNo());
			System.out.println("제목: " + board.getTitle());
			System.out.print("글쓴이: " + board.getWriter() + "\t|| ");
			System.out.println("조회수: " + board.getHitcount());
			System.out.println("날짜: " + board.getDate());
			System.out.println("내용: " + board.getContent());
		}*/
		
		System.out.println();
		
		/*for(Board b : list) {
			System.out.println("번호: " + b.getNo());
			System.out.println("제목: " + b.getTitle());
			System.out.print("글쓴이: " + b.getWriter() + "\t|| ");
			System.out.println("조회수: " + b.getHitcount());
			System.out.println("날짜: " + b.getDate());
			System.out.println("내용: " + b.getContent());
			System.out.println();
		}*/
		
		list = boardDAO.selectByPage(1, 10);
		for(Board b : list) {
			System.out.println("번호: " + b.getNo());
			System.out.println("제목: " + b.getTitle());
			System.out.print("글쓴이: " + b.getWriter() + "\t|| ");
			System.out.println("조회수: " + b.getHitcount());
			System.out.println("날짜: " + b.getDate());
			System.out.println("내용: " + b.getContent());
			System.out.println();
		}
	}
}
