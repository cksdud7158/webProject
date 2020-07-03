package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.UserVO;

public class RequestToJoinController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sss = request.getSession();
		UserVO uVo = (UserVO)sss.getAttribute("uVo");
		PrintWriter out = response.getWriter();
		
		String check = "false"; // true: 가입신청 완료 / false: 가입신청 실패 
		
		//팀 아이디, 유저아이디 받아오기
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		String userId = uVo.getUserId();
		
		// 팀멤버 중복 확인 후 requestToJoin 호출
		if(!FootBallDAOImpl.getInstance().isExistTeamMember(userId, teamId)) {
			FootBallDAOImpl.getInstance().requestToJoin(userId, teamId);
			System.out.println("가입신청됨");
			check = "true";
			out.print(check);
		}
		return null; // 이동하려는 페이지가 없으므로 null 처리함
	}

}
