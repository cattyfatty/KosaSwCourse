package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;
import controller.MemberController;

public class DispatcherServlet extends HttpServlet {
	
	private MemberController memberController;
	private BoardController boardController;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		memberController = new MemberController();
		boardController = new BoardController();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//********************
		//    URL Mapping    *
		//********************
		String uri = req.getRequestURI();
		/*System.out.println(uri);
		System.out.println(req.getQueryString());
		System.out.println(req.getContextPath());
		System.out.println(req.getPathInfo());
		System.out.println(req.getPathTranslated());
		System.out.println(req.getServletPath());*/
		
		if(uri.contains("/mvc/member")) {
			memberController.handle(req, resp);
		} else if(uri.contains("/mvc/board")) {
			boardController.handle(req, resp);
		}
	}
}
