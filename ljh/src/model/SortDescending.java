package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.TotalVO;

public class SortDescending {
	
	private SortDescending() {}
	private static class LazyHolder {
		private static final SortDescending singleton = new SortDescending(); 
	}
	public static SortDescending getInstance() {
		return LazyHolder.singleton;
	}
	
	public static ArrayList<TotalVO> sortDescending(ArrayList<TotalVO> tVo) {
		
		Collections.sort(tVo, new Comparator<TotalVO>(){

			@Override
			public int compare(TotalVO obj1, TotalVO obj2) {
				if(obj1.getTotal_score() < obj2.getTotal_score()) {
					return 1;
				}
				else if(obj1.getTotal_score() == obj2.getTotal_score()) {
					return obj1.getTeamName().compareTo(obj2.getTeamName());
				}
				else {
					return -1;
				}
			}
		});
		
		return tVo;
	}
}
