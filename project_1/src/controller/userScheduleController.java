package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.FootBallDAOImpl;
import model.MatchVO;
import model.UserVO;

public class userScheduleController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "userSchedule.jsp";
		HttpSession s = request.getSession(false);
		
		UserVO vo= (UserVO)s.getAttribute("uVo");
		String userId =vo.getUserId(); 
		System.out.println("userSchedule Controller userId::"+userId);
		
		System.out.println("여기까지 실행");
		try {
			ArrayList<MatchVO> list = FootBallDAOImpl.getInstance().userSchedule(userId);
			
			if(list!=null) {
				request.setAttribute("list", list);	
			JSONObject jsonObject = new JSONObject();
			
	        JSONObject data = new JSONObject();
	        data.put("title", "이건 테스트입니다.");
	        data.put("start", "2020-06-10");
	        
	        JSONArray req_array = new JSONArray();
	        req_array.add(data);
	        
	        jsonObject.put("REQ_DATA", req_array);
	        
	        request.setAttribute("json", jsonObject);
			}
			
			

		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);

	}

}
