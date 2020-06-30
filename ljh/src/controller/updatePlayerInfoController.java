package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.PlayerInfoVO;
import model.UserVO;

public class updatePlayerInfoController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "profile.jsp";
		HttpSession session = request.getSession();
		UserVO uVo= (UserVO) session.getAttribute("uVo");
		System.out.println(uVo);
		PlayerInfoVO pVo = uVo.getpVo();
		//playerInfo
				String userId = uVo.getUserId();
				String position = request.getParameter("position");
				String mainFoot = request.getParameter("mainFoot");
				int height = Integer.parseInt(request.getParameter("height"));
				int weight = Integer.parseInt(request.getParameter("weight"));
				int injury = Integer.parseInt(request.getParameter("injury"));
				int mental = Integer.parseInt(request.getParameter("mental"));
				int speed = Integer.parseInt(request.getParameter("speed"));
				int physical = Integer.parseInt(request.getParameter("physical"));
				int dribble = Integer.parseInt(request.getParameter("dribble"));
				int pass = Integer.parseInt(request.getParameter("pass"));
				int defence = Integer.parseInt(request.getParameter("defence"));		
				pVo.setUserId(userId);
				pVo.setPosition(position);
				pVo.setMainFoot(mainFoot);
				pVo.setHeight(height);
				pVo.setWeight(weight);
				pVo.setInjury(injury);
				pVo.setMental(mental);
				pVo.setSpeed(speed);
				pVo.setPhysical(physical);
				pVo.setDribble(dribble);
				pVo.setPass(pass);
				pVo.setDefence(defence);
				
				uVo.setpVo(pVo);
				try {
					FootBallDAOImpl.getInstance().updateUser(uVo);
					session.setAttribute("uVo", uVo);
					path = "profile.jsp";
				} catch (SQLException e) {
					System.out.println(e);
				}
				return new ModelAndView(path);
			}
		
	}

