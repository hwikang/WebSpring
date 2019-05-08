package kr.goott.home;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	public JdbcTemplate template;	
	String folder="";
	public JdbcTemplate getTemplate() {
		return template;
	}
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template =template;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
	}
	@RequestMapping(value="/fileupload1",method=RequestMethod.POST)
	public ModelAndView fileupload1(@RequestParam("userid") String userid,
			@RequestParam("title") String title,
			@RequestParam("filename1") MultipartFile filename1,
			@RequestParam("filename2") MultipartFile filename2,
			HttpServletRequest req
			) {
		
		
		ModelAndView mav = new ModelAndView();
		//업로드할경로
		folder= req.getSession().getServletContext().getRealPath("/upload");
		System.out.println(folder);
		//업로드
		//매개변수 구하기
		String fname = filename1.getName();
		String fname2 = filename2.getName();
		//파이렴ㅇ
		String f1 = filename1.getOriginalFilename();
		String f2 = filename2.getOriginalFilename();
		//업로드 하기
		try {
			if(f1!=null) {
				filename1.transferTo(new File(folder,f1));  //실제 업로드
			}
			if(f2!=null) {
				filename2.transferTo(new File(folder,f2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataVO vo = new dataVO();
		vo.setUserid(userid);
		vo.setTitle(title);
		vo.setFilename(f1);
		vo.setFilename2(f2);

/*		System.out.println(vo.getTitle());
		System.out.println(vo.getUserid());
		System.out.println(vo.getFilename());
		System.out.println(vo.getFilename2());
		*/
		dataDAO dao = new dataDAO();
		dao.insertRecord(vo);	
		
		mav.setViewName("redirect:list");
		
		return mav;
		
	}
	//upload2
	@RequestMapping(value="/fileupload2", method=RequestMethod.POST)
	public ModelAndView fileupload2(HttpServletRequest req) {
		//경로
		folder = req.getSession().getServletContext().getRealPath("/upload");
		dataVO vo = new dataVO();
		dataDAO dao = new dataDAO();
		vo.setUserid(req.getParameter("userid"));
		vo.setTitle(req.getParameter("title"));
		//MULTI PART HTTP SERVLET REQUEST
		//1.MultipartHttpServletRequest 객체구하기
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		
		//2.file 목록구하기
		List<MultipartFile> flist = mr.getFiles("filename");
		String newFilename[] = null;
		
		
		if(flist!=null) {
			newFilename= new String[flist.size()];
			for(int i=0; i<flist.size();i++) {
				MultipartFile mf= flist.get(i);
				//매개변수
				String f2 = mf.getName();
				//System.out.println(f2);
				//업로드할 원래 파일명
				String fileOriName = mf.getOriginalFilename();
				//
				if(fileOriName!=null &&!fileOriName.equals("")) {
					File file = new File(folder,fileOriName);
				
					if(file.exists()) {
						int cnt = 1;
						while(true) {
							int idx = fileOriName.lastIndexOf(".");
							//파일명
							String firstFile = fileOriName.substring(0, idx);
							String extFile = fileOriName.substring(idx+1);
							File newFile = new File(folder,firstFile+"_"+cnt+"."+extFile);
							if(!newFile.exists()) {
								newFilename[i] = newFile.getName();
								break;
							}
							cnt++;
						}//while
					}
					else {
						newFilename[i]= fileOriName;
					}
					try {
						mf.transferTo(new File(folder,newFilename[i]));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}//file 존재 for
		}//if
		System.out.println(newFilename[0]);
		System.out.println(newFilename[1]);
		vo.setNewFilename3(newFilename);
		
		int cnt = dao.insertRecord(vo);
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:list");
		
		return mav;
	}
	
	
	//리스트
	@RequestMapping(value="/list")
	public ModelAndView dataList() {
		dataDAO dao = new dataDAO();		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.addSellect());
		mav.setViewName("list");
		
		return mav;
	}
	
}
