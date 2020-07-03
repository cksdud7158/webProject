package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;

public class RejectToJoinController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sss = request.getSession();
		TeamVO tVo = (TeamVO)sss.getAttribute("tVo");
		
		// 가입신청한 회원의 팀멤버 아이디 가져오기
		int teamId = tVo.getTeamId();
		String userId = request.getParameter("userId");
		int teamMemberId = FootBallDAOImpl.getInstance().getTeamMemberId(userId, teamId);
		
		// 가입요청중인 해당 회원을 teammember 테이블에서 삭제하는 rejectToJoin 호출
		FootBallDAOImpl.getInstance().rejectToJoin(teamMemberId);
		
		// mv 리턴없이 바로 출력
		PrintWriter out = response.getWriter();
		out.print("해당 회원의 가입요청을 거절하였습니다.");
		
		return null;
	}

}
