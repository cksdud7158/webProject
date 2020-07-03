package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import model.ScoreVO;

public class NearestArea {
	
	private NearestArea() {}
	private static class LazyHolder {
		private static final NearestArea singleton = new NearestArea(); 
	}
	public static NearestArea getInstance() {
		return LazyHolder.singleton;
	}

	// test용 main
	public static void main(String[] args) {
	}
	
	public static double NearestAreaMethod(int teamId, ScoreVO vo, double[][] spherical_area) throws UnsupportedEncodingException, ParseException {
		
		double[][] temp = new double[3][2];
		double distance;
		double min = 666;
		JsonToJava json2java = JsonToJava.getInstance();
		DistanceCalculator disCalculator = DistanceCalculator.getInstance();
		
		temp[0] = json2java.JsonToJavaMethod(vo.getArea1());
				
		if(vo.getArea2() != null) {
			temp[1] = json2java.JsonToJavaMethod(vo.getArea2());
		}
				
		if(vo.getArea3() != null) {
			temp[2] = json2java.JsonToJavaMethod(vo.getArea3());
		}
				
		for(int j=0; j<3; j++) {
			if(spherical_area[j][0] == 0.0 && spherical_area[j][1] == 0.0) {
				continue;
			}
			else {
				for(int k=0; k<3; k++) {
					if(temp[k][0] == 0.0 && temp[k][1] == 0.0) {
						continue;
					}
					else {
						distance = disCalculator.distance(spherical_area[j][0], spherical_area[j][1], temp[k][0], temp[k][1], "K");
						if(min >= distance) {
							min = distance;
						}
					}
				}
						
			}
		}				
		
		return min;
	}

}
