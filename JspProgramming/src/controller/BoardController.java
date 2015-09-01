package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;

public class BoardController {
	
	private ServletContext application;
	private BoardService boardService;

	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(boardService == null) {
			application = req.getServletContext();
			boardService = (BoardService)application.getAttribute("boardService");
			if(boardService == null) {
				boardService = new BoardService();
				application.setAttribute("boardService", boardService);
			}
		}
		
		String action = req.getParameter("action");
		
		switch(action) {
		case "list":		list(req, resp); break;
		case "writeForm":	writeForm(req,resp); break;
		case "write":		write(req,resp); break;
		}
	}

	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/exam_mvc/write.jsp");
		rd.forward(req, resp);
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/exam_mvc/write_form.jsp");
		rd.forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Board> list = boardService.getPage(1, 10);
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/exam_mvc/list.jsp");
		rd.forward(req, resp);
	}
	
}
