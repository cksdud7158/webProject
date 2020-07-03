package model;

import java.util.ArrayList;

import model.TotalVO;

public class Max {
	
	private Max() {}
	private static class LazyHolder {
		private static final Max singleton = new Max(); 
	}
	public static Max getInstance() {
		return LazyHolder.singleton;
	}

	public static double getMax(ArrayList<TotalVO> vo, String Unit) {
		
		double max_distance = 0, max_manners_Score = 0, max_matchNum = 0, max_memberNum = 0, max_winningScore = 0;
		
		for(int i = 0; i<vo.size(); i++) {
			if(Unit.equals("distance_min")) {
				if(vo.get(i).getDistance_min() >= max_distance)
					max_distance = vo.get(i).getDistance_min();
			} else if(Unit.equals("manners_Score")) {
				if(vo.get(i).getMannersScore() >= max_manners_Score) 
					max_manners_Score = vo.get(i).getMannersScore();
			} else if(Unit.equals("matchNum")) {
				if(vo.get(i).getMatchNum() >= max_matchNum) 
					max_matchNum = vo.get(i).getMatchNum();					
			} else if(Unit.equals("memberNum")) {
				if(vo.get(i).getMemberNum() >= max_memberNum)
					max_memberNum = vo.get(i).getMemberNum();
			} else if(Unit.equals("winningScore")) {
				if(vo.get(i).getWinningScore() >= max_winningScore) 
					max_winningScore = vo.get(i).getWinningScore();
			} else
				;
		}
		
		if(Unit.equals("distance_min")) {
			return max_distance;
		} else if(Unit.equals("manners_Score")) {
			return max_manners_Score; 
		} else if(Unit.equals("matchNum")) {	
			return max_matchNum;
		} else if(Unit.equals("memberNum")) {
			return max_memberNum;
		} else if(Unit.equals("winningScore")) {
			return max_winningScore;
		} else
			return 0;
	}
}
