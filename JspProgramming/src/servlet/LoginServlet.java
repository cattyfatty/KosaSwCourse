package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos = resp.getOutputStream();
		String html = "<!DOCTYPE html>";
		html += "<html>";
		html += "	<head>";
		html += "		<meta charset='UTF-8'>";
		html += "	</head>";
		html += "	<body>";
		html += "		<form method='post' action='LoginServlet'>";
		html += "			아이디: <input type='text' name='mid'/><br/>";
		html += "			비번 : <input type='text' name='mpw'/><br/>";
		html += "			<input type='submit' value='login'/><br/>";
		html += "		</form>";
		html += "	</body>";
		html += "</html>";
		sos.write(html.getBytes("UTF-8"));
		sos.flush();*/
		RequestDispatcher rd = req.getRequestDispatcher("ch04/login_form.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get request parameter--------------------------------------------
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");
		
		// handling request-------------------------------------------------
		
		
		// send response----------------------------------------------------
		resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos = resp.getOutputStream();
		
		String html = "<!DOCTYPE html>";
		html += "<html>";
		html += "	<head>";
		html += "		<meta charset='UTF-8'>";
		html += "	</head>";
		html += "	<body>";
		html += "		<form method='post' action='LoginServlet'>";
		html += "			" + id + "님 로그인 성공";
		html += "		</form>";
		html += "	</body>";
		html += "</html>";
		sos.write(html.getBytes("UTF-8"));
		sos.flush();
	}
}
