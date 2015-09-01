package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/HelloWorldServlet1")*/
public class HelloWorldServlet4 extends HttpServlet {

	private String greeting;
	
	public HelloWorldServlet4() {
		System.out.println("HelloWorldServlet4()");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		greeting = config.getInitParameter("greeting");
		System.out.println("greeting: " + greeting);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorldServlet4-service()"+ greeting);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() - servlet destroyed");
	}
}
