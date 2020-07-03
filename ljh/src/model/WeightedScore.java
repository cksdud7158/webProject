package model;

import model.TotalVO;

public class WeightedScore {
	
	private WeightedScore() {}
	private static class LazyHolder {
		private static final WeightedScore singleton = new WeightedScore(); 
	}
	public static WeightedScore getInstance() {
		return LazyHolder.singleton;
	}

	public static double weightedScore(TotalVO vo, int x, int y, int z, int n, int m) {
		double total = 0;
		
		if(((x + y + z + n + m)) != 10 && (x >= 0) && (y >= 0) && (z >= 0) && (n >= 0) && (m >= 0))
			return 0;
		
		else {
		
			total = (vo.getDistance_min_normalised() * x) +
					(vo.getMannersScore_normalised() * y) + 
					(vo.getMatchNum_normalised() * z) +
					(vo.getMemberNum_noramlised() * n) +
					(vo.getWinningScore_normalised() * m);
			
			return total;
		}
	}
}
