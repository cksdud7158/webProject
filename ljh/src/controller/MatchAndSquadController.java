package controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.VoteVO;

public class MatchAndSquadController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login.do";
		HttpSession session = request.getSession();
		TeamVO tVo= (TeamVO) session.getAttribute("tVo");
		VoteVO vVo = new VoteVO();
		int teamId = tVo.getTeamId();
		System.out.println("matchAndSquad의 팀 아이디입니다."+teamId);
		

		try {
			vVo = FootBallDAOImpl.getInstance().mostResentMatch(teamId);
			System.out.println(vVo+"매치엔스쿼드컨트롤러 안에서 보트객체입니다.");
			if(vVo.getTeamId()==teamId) {
				path = "matchAndSquadHome.jsp";
				int participationIndex = 10;
				int totalAbilityIndex = 0;
				if(!(request.getParameter("participationIndex")==null)&&!(request.getParameter("totalAbilityIndex")==null)) {
					participationIndex = Integer.parseInt(request.getParameter("participationIndex"));
					totalAbilityIndex = Integer.parseInt(request.getParameter("totalAbilityIndex"));
					
				}
				System.out.println("participationIndex"+participationIndex);
				System.out.println("totalAbilityIndex"+totalAbilityIndex);
				session.setAttribute("voteResultCount",FootBallDAOImpl.getInstance().voteResultCount(vVo.getVoteId()));
				
				session.setAttribute("auList",FootBallDAOImpl.getInstance().recommendSquad(participationIndex, totalAbilityIndex, teamId));
				System.out.println("vote아이디 입니다."+vVo.getVoteId());
				System.out.println(vVo+"total을 봅시다.");
				session.setAttribute("vVo", vVo);
				request.setAttribute("participationIndex", participationIndex);
				request.setAttribute("totalAbilityIndex", totalAbilityIndex);
			}else {
				path = "matchAndSquadAway.jsp";
			}
			session.setAttribute("aTVo",FootBallDAOImpl.getInstance().findTeamByTeamId(vVo.getmVo().getAwayId()));
			session.setAttribute("vVo", vVo);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(vVo.getDueDate()+"마감일입니다.");
		String[] dueDateList = vVo.getDueDate().split("-");
		int time = caldate(Integer.parseInt(dueDateList[0]),Integer.parseInt(dueDateList[1]), Integer.parseInt(dueDateList[2]));
		System.out.println(time+"타임입니다.");
		request.setAttribute("time", time);
		
		System.out.println(vVo.getmVo().getSchedule()+"경기일입니다.");
		String[] scheduleList = vVo.getmVo().getSchedule().split("-");
		int playTime = caldate(Integer.parseInt(scheduleList[0]),Integer.parseInt(scheduleList[1]), Integer.parseInt(scheduleList[2]));
		System.out.println(playTime+"플레이타임.");
		request.setAttribute("playTime", playTime);
		
		String stadiumType[] = tVo.getsVo().getStadiumType().split(":");
		int pPlayerNum = Integer.parseInt(stadiumType[0]);
		int pPlayerNumPlusOne = pPlayerNum+1;
		request.setAttribute("pPlayerNum", pPlayerNum);
		request.setAttribute("pPlayerNumPlusOne", pPlayerNumPlusOne);
		
		return new ModelAndView(path);
	}

	public static int caldate(int myear, int mmonth, int mday) { 
		try { 
			Calendar today = Calendar.getInstance(); //현재 오늘 날짜
			Calendar dday = Calendar.getInstance(); 
			dday.set(myear,mmonth-1,mday);// D-day의 날짜를 입력합니다. 
			long day = dday.getTimeInMillis()/ 1000 / 60 / 60 / 24; // 각각 날의 시간 값을 얻어온 다음 //( 1일의 값(86400000 = 24시간 * 60분 * 60초 * 1000(1초값) ) ) 
			System.out.println(day);
			long tday = today.getTimeInMillis()/ 1000 / 60 / 60 / 24; 
			System.out.println(tday);
			long count = tday - day; // 오늘 날짜에서 dday 날짜를 빼주게 됩니다. 
			return (int) count; // 날짜는 하루 + 시켜줘야합니다. 
			} catch (Exception e) { 
				e.printStackTrace();
				return -1; 
				} 
		}

}
