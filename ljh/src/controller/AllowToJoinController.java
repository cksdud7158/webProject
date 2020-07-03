package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;

public class AllowToJoinController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession sss = request.getSession();
		TeamVO tVo = (TeamVO)sss.getAttribute("tVo");
		
		//가입신청한 회원의 팀멤버 아이디 가져오기
		int teamId = tVo.getTeamId();
		String userId = request.getParameter("userId");
		int teamMemberId = FootBallDAOImpl.getInstance().getTeamMemberId(userId, teamId);
		
		// 해당 팀멤버의 status를 0(가입완료)로 수정하는 allowToJoin BL 호출
		FootBallDAOImpl.getInstance().allowToJoin(teamMemberId);
		
		// mv 리턴없이 바로 출력
		PrintWriter out = response.getWriter();
		out.print("해당 회원이 팀의 멤버가 되었습니다!");
		
		return null;
		
	}

}
