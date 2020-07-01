package controller;

import java.sql.SQLException;
import java.util.HashMap;

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
			
			HashMap<String, String> map = new fileuplaod().fileupload(request, response);
			
			//user 정보
			String userId = map.get("userId");
			String password = map.get("password");
			String name = map.get("name");
			String phoneNum = map.get("phoneNum");
			
			String photo = map.get("photo");
			if(photo==null) {
				photo = uVo.getPhoto();
			}
			String ssn = map.get("ssn");
			String nickName = map.get("nickName");
			char gender = map.get("gender").charAt(0);
			String email = map.get("email");
			String addr = map.get("addr");
			String favTeam1 = map.get("favTeam1");
			String favTeam2 = map.get("favTeam2");
			String country = map.get("country");
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

