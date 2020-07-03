package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonToJava {
	
	private JsonToJava() {}
	private static class LazyHolder {
		private static final JsonToJava singleton = new JsonToJava();
	}
	public static JsonToJava getInstance() {
		return LazyHolder.singleton;
	}
	
	// Test
	/*public static void main (String[] args) throws UnsupportedEncodingException, ParseException {
		String address = "서초구 효령로 331";
		JsonToJava(address);
	} // main*/
	
	public static double[] JsonToJavaMethod (String address) throws UnsupportedEncodingException, ParseException {
		
		if(address == null) {
			double arr[] = new double[2];
			return arr;
		}
		
		else {
		
			String addr = URLEncoder.encode(address,"utf-8"); // 주소는 예시로 넣음
			String api = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;
			StringBuffer sb = new StringBuffer();
			double arr[] = new double[2];
	
			try {
				 URL url = new URL(api);
				 HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
				 http.setRequestProperty("Content-Type", "application/json");
				 http.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "q1s46zd0tt"); // 발급받은 클라이언트 아이디 
				 http.setRequestProperty("X-NCP-APIGW-API-KEY", "p3ScXALzPROTvHLsa3YnOQ9vb8STLyVma77INR3o"); // 발급받은 클라이언트 키
				 http.setRequestMethod("GET");
				 http.connect();
				 
				 InputStreamReader in = new InputStreamReader(http.getInputStream(),"utf-8");
				 BufferedReader br = new BufferedReader(in);
			
				 String line;
				 while ((line = br.readLine()) != null) {
					 sb.append(line).append("\n");
				 } // while
		
				 JSONParser parser = new JSONParser();
				 JSONObject jsonObject;
				 JSONObject jsonObject2;
				 JSONArray jsonArray;
				 String x = "";
				 String y = "";
		
				 //트리형태로 온 JSON 파싱 
				 jsonObject = (JSONObject)parser.parse(sb.toString());
				 jsonArray = (JSONArray)jsonObject.get("addresses");
				 
				 for(int i=0;i<jsonArray.size();i++) {
					  jsonObject2 = (JSONObject) jsonArray.get(i);
					  if(null != jsonObject2.get("x")){
					   x = (String) jsonObject2.get("x").toString();
					  } // if
					  if(null != jsonObject2.get("y")){
					   y = (String) jsonObject2.get("y").toString();
					  } // if
				 } // for
			
				 br.close();
				 in.close();
				 http.disconnect();
			
				 //System.out.println("Latitude >> " + y + " " + "Longitude >> " + x);
				 arr[0] = Double.parseDouble(y);
				 arr[1] = Double.parseDouble(x);
			
			}// try 
			catch (IOException e) {} //catch 
			
			return arr;
		}
	} // JsonToJava class
}
