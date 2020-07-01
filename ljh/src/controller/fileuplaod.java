package controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class fileuplaod {
	private static final String CHARSET = "utf-8";
	private static final String ATTACHES_DIR = "C:\\pcy\\webProject\\football10\\WebContent\\ours\\img";
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024;
	
	public HashMap<String, String> fileupload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		response.setContentType("text/html; charset=UTF-8");
	    request.setCharacterEncoding(CHARSET);
	    HashMap<String, String> map = new HashMap<>();
	     
	    File attachesDir = new File(ATTACHES_DIR);

	    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	    fileItemFactory.setRepository(attachesDir); //업로드된 파일을 저장할 위치를 file 객체로 지정
	    fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES); //저장소에 임시파일을 생성할 한계 크기를 byte 단위로 저장
	    ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

	    try {
	           List<FileItem> items = fileUpload.parseRequest(request);
	           for (FileItem item : items) {
	               if (item.isFormField()) {
	                   System.out.printf("파라미터 명1 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));
	                   map.put(item.getFieldName(), item.getString(CHARSET));
	               } else {
	                   System.out.printf("파라미터 명2 : %s, 파일 명 : %s,  파일 크기 : %s bytes \n", item.getFieldName(),
                            item.getName(), item.getSize());
	                    if (item.getSize() > 0) {
	                       String separator = File.separator;
	                       int index =  item.getName().lastIndexOf(separator);
	                       String fileName = item.getName().substring(index  + 1);
	                       File uploadFile = new File(ATTACHES_DIR +  separator + fileName);
	                       item.write(uploadFile);
	                       map.put(item.getFieldName(), item.getName());
	                   }
	               }
	           }
	 
	           
	         
	 
	 
	        } catch (Exception e) {
	            // 파일 업로드 처리 중 오류가 발생하는 경우
	            e.printStackTrace();
	            System.out.println("파일 업로드 중 오류가  발생하였습니다.");
	        }
		
		return map;
	}
}
