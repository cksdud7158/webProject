package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import model.ScoreVO;

public class GetSphericalCoordinate {

	private GetSphericalCoordinate() {}
	private static class LazyHolder {
		private static final GetSphericalCoordinate singleton = new GetSphericalCoordinate();
	}
	public static GetSphericalCoordinate getInstance() {
		return LazyHolder.singleton;
	}
	
	public static double[][] getSphericalCoordinate(int teamId, ArrayList<ScoreVO> vo) throws UnsupportedEncodingException, ParseException {
		
		double[][] spherical_area = new double[3][2];
		JsonToJava json2java = JsonToJava.getInstance();
		
		for(int i = 0; i<vo.size(); i++) {
			if(teamId == vo.get(i).getTeamId()) {
				spherical_area[0] = json2java.JsonToJavaMethod(vo.get(i).getArea1());
				//System.out.println(spherical_area[0][0] + ", " + spherical_area[0][1]);
				
				if(vo.get(i).getArea2() != null) {
					spherical_area[1] = json2java.JsonToJavaMethod(vo.get(i).getArea2());
					//System.out.println(spherical_area[1][0] + ", " + spherical_area[1][1]);
				}
				
				if(vo.get(i).getArea3() != null) {
					spherical_area[2] = json2java.JsonToJavaMethod(vo.get(i).getArea3());
					//System.out.println(spherical_area[2][0] + ", " + spherical_area[2][1]);
				}
			}
		}
		
		return spherical_area;
	}
}
