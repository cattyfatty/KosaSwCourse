package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {

	public void handle(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("memberController.handle()");
		String action = req.getParameter("action");

		/*
		 * if(action.equals("joinForm")) { joinForm(); } else
		 * if(action.equals("join")) { join(); } else
		 * if(action.equals("loginForm")) { loginForm(); } else
		 * if(action.equals("login")) { login(); }
		 */
		switch (action) {
		case "joinForm":
			joinForm(req, resp);
			break;
		case "join":
			join(req, resp);
			break;
		case "loginForm":
			loginForm(req, resp);
			break;
		case "login":
			login(req, resp);
			break;
		}
	}

	public void joinForm(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("joinForm");
	}

	public void join(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("join");

	}

	public void loginForm(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("loginForm");

	}

	public void login(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("login");

	}
}
