package model;

public class DistanceCalculator {
	
	private DistanceCalculator() {}
	private static class LazyHolder {
		private static final DistanceCalculator singleton = new DistanceCalculator();
	}
	public static DistanceCalculator getInstance() {
		return LazyHolder.singleton;
	}
	
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else if (lat2 == 0 && lon2 == 0) {
			return 0;
		}
	
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(DegreeToRadian(lat1)) * Math.sin(DegreeToRadian(lat2)) + Math.cos(DegreeToRadian(lat1)) * Math.cos(DegreeToRadian(lat2)) * Math.cos(DegreeToRadian(theta));
			dist = Math.acos(dist);
			dist = RadianToDegree(dist);
			dist = dist * 60 * 1.1515;
			
			// 기본 단위 Mile
			// K = kilometer
			// M = Meter
			// N = Nautical Miles
			
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			} else if (unit.equals("M")) {
				 dist = dist * 1609.344;
			} else if (unit.equals("")) {
				;
			} else
				;
			
			return (dist);
		}
	} // distance
	
	private static double DegreeToRadian(double deg) {
		return ((deg * Math.PI) / 180.0);
	}
	
	private static double RadianToDegree(double rad) {
		return ((rad * 180) / Math.PI);
	}
}
