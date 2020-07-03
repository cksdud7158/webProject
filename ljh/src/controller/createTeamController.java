package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.StadiumVO;
import model.TeamVO;
import model.UserVO;

public class createTeamController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = "login.jsp";
		HashMap<String, String> map = new fileuplaod().fileupload(request, response);
		HttpSession session = request.getSession();
		
		UserVO vo = (UserVO) session.getAttribute("uVo");
		
		String teamName = map.get("teamName");
		String emblem = "ours/img/"+map.get("emblem");
		if(emblem==null) {
			emblem = "ours/img/emblem4.png";
		}
		String area1 = map.get("area1");
		String area2 = map.get("area2");
		String area3 = map.get("area3");
		String stadiumName = map.get("stadiumName");
		String stadiumAddr = map.get("stadiumAddr");
		int stadiumCost = Integer.parseInt(map.get("stadiumCost"));
		String stadiumType = map.get("stadiumType");
		
		TeamVO tVO =new TeamVO();
		StadiumVO sVO =  new StadiumVO();
		
		tVO.setTeamName(teamName);
		tVO.setEmblem(emblem);
		tVO.setArea1(area1);
		tVO.setArea2(area2);
		tVO.setArea3(area3);
		sVO.setStadiumName(stadiumName);
		sVO.setStadiumAddr(stadiumAddr);
		sVO.setStadiumCost(stadiumCost);
		sVO.setStadiumType(stadiumType);
		tVO.setsVo(sVO);
		
		FootBallDAOImpl.getInstance().makeTeam(tVO);
		FootBallDAOImpl.getInstance().iAmManager(vo.getUserId(), teamName);
		
		
		return new ModelAndView(path);
	}

}
