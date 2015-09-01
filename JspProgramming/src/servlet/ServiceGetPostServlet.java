package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServiceGetPostServlet")
public class ServiceGetPostServlet extends HttpServlet {

	/*@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 요청 방식에 상관 없이 응답을 할 경우
	}*/ // 이걸 override하면 아래것들이 영원히 실행되지 않는다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get방식의 요청을 처리할 때 사용
		System.out.println("get-request");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post 방식의 요청을 처리할 때 사용
		System.out.println("post-request");
	}
}
