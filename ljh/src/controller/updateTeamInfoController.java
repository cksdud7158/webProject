package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.StadiumVO;
import model.TeamVO;

public class updateTeamInfoController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path= "teamSetting.jsp";
		HttpSession session = request.getSession();
		
		TeamVO tempTVO = (TeamVO) session.getAttribute("tVo");
		
		System.out.println("updateTeamInfoController 의 tmep::"+ tempTVO);
		HashMap<String, String> map = new fileuplaod().fileupload(request, response);		
		
		String emblem= "ours/img/"+map.get("emblem");
		String area1 = map.get("area1");
		String area2 = map.get("area2");
		String area3 = map.get("area3");
		int stadiumId = tempTVO.getStadiumId();
		String stadiumName = map.get("stadiumName");
		String stadiumAddr = map.get("stadiumAddr");
		System.out.println(stadiumAddr);
		System.out.println(map.get("stadiumCost"));
		int stadiumCost = Integer.parseInt(map.get("stadiumCost"));
		String stadiumType = map.get("stadiumType");
		int teamId = tempTVO.getTeamId();
		
		TeamVO tVo = new TeamVO();
		
		if(emblem!=null) {
			tVo.setEmblem(emblem);
		}else {
			tVo.setEmblem(tempTVO.getEmblem());
		}
		tVo.setTeamId(teamId);
		tVo.setArea1(area1);
		tVo.setArea2(area2);
		tVo.setArea3(area3);
		tVo.setStadiumId(stadiumId);
		tVo.setsVo(new StadiumVO(stadiumId, stadiumName, stadiumAddr, stadiumCost, stadiumType));
		
		TeamVO vo = FootBallDAOImpl.getInstance().updateTeam(tVo);
		
		System.out.println(vo);
		
		session.setAttribute("tVo", vo);
		
		return new ModelAndView(path);
	}

}
