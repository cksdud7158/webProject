package controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.TotalVO;

public class FindMatchController implements Controller {

		@Override
		public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			String path = "findMatch.jsp";
			
			int distance;
			int mannersScore;
			int matchNum;
			int memberNum;
			int winningScore;
			
			distance = Integer.parseInt(request.getParameter("distance"));
			mannersScore = Integer.parseInt(request.getParameter("mannersScore"));
			matchNum = Integer.parseInt(request.getParameter("matchNum"));
			memberNum = Integer.parseInt(request.getParameter("memberNum"));
			winningScore = Integer.parseInt(request.getParameter("winningScore"));
			
			PrintWriter out = response.getWriter();
			try {
				
				HttpSession session = request.getSession();
				TeamVO vo = (TeamVO) session.getAttribute("tVo");
				int teamId = vo.getTeamId();
					
				ArrayList<TotalVO> totalVO = FootBallDAOImpl.getInstance().recommendMatch(teamId, distance, mannersScore, matchNum, memberNum, winningScore);
				if (totalVO != null) {
					session.setAttribute("totalVO", totalVO);
					path = "findMatch.jsp";
					out.print(path);
					
				/*	for(int i = 0; i<totalVO.size();i++) {
						System.out.println(totalVO.get(i).toString());
					}*/
					
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			return new ModelAndView(path);
		}
	}

