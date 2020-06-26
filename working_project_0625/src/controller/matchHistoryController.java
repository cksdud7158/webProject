package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl2;
import model.MatchVO;

public class matchHistoryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "test.html";
		
		ArrayList<MatchVO> history = FootBallDAOImpl2.getInstance().matchHistory();
		if(!history.isEmpty()) {
			request.setAttribute("history", history);
			path = "matchHistory.jsp";
		}
		
		return new ModelAndView(path);
	}

}
