package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.PlayerInfoVO;
import model.UserVO;

public class UpdateUserController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String path = "profile.jsp";
			HttpSession session = request.getSession();
			UserVO uVo= (UserVO) session.getAttribute("uVo");
			System.out.println(uVo);
			
			//user 정보
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phoneNum = request.getParameter("phoneNum");
			
			String photo = request.getParameter("photo");
			if(photo==null) {
				photo = uVo.getPhoto();
			}
			String ssn = request.getParameter("ssn");
			String nickName = request.getParameter("nickName");
			char gender = request.getParameter("gender").charAt(0);
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String favTeam1 = request.getParameter("favTeam1");
			String favTeam2 = request.getParameter("favTeam2");
			String country = request.getParameter("country");
			uVo.setUserId(userId);
			uVo.setPass(password);
			uVo.setName(name);
			uVo.setPhoneNum(phoneNum);
			uVo.setPhoto(photo);
			uVo.setSsn(ssn);
			uVo.setNickName(nickName);
			uVo.setGender(gender);
			uVo.setEmail(email);
			uVo.setAddr(addr);
			uVo.setFavTeam1(favTeam1);
			uVo.setFavTeam2(favTeam2);
			uVo.setCountry(country);
			
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

