package kr.goott.home;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Download() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path =request.getSession().getServletContext().getRealPath("/upload");
		//파일명
		String filename = request.getParameter("filename");
		int recordNo = Integer.parseInt(request.getParameter("recordNo"));
		String filename_encode = new String(filename.getBytes(),"ISO-8859-1");
		
		//타입설정
		response.setContentType("application/unknown");
		// 인코딩한 파일명 header에 세팅
		response.setHeader("Content-Disposition", "attachment;filename="+filename_encode);
		
		//file download
		FileInputStream fis = new FileInputStream(path + "/" + filename);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		int readCount  =-1;
		byte data[] = new byte[1024];
		while((readCount = bis.read(data)) != -1) {
			bos.write(data,0,readCount);
			bos.flush();
			
		}
		
		dataDAO dao = new dataDAO();
		dao.downCount(recordNo);
		
		if(bis != null) bis.close();
		if(fis != null) fis.close();
		if(bos != null) bos.close();
		if(sos != null) sos.close();
		
		
	}

}
