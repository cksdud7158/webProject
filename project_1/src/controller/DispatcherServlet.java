package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// extracting command
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println(command);
		
		// creating controller
		Controller controller = HandlerMapping.getInstance().createController(command);
		String path = "index.jsp"; // default path
		ModelAndView mv = null; 

		try {
			mv = controller.handle(request, response);
			System.out.println("컨트롤러 실행");
			path = mv.getPath();
			System.out.println(path+"입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);
		}
	}
}