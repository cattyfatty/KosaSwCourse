package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/HelloWorldServlet1")*/
public class HelloWorldServlet3 extends HttpServlet {

    public HelloWorldServlet3() {
    	System.out.println("HelloWorldServlet3()");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorldServlet3-service()");
	}

}
