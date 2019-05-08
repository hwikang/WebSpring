package kr.goott.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping(value="/aLink")
	//@RequestMapping(value="/aLink",method=RequestMethod.GET)
	public String aLink(HttpServletRequest req, Model model) {
		//HttpServletRequest: Ŭ���̾�Ʈ�� ����������
		String username=req.getParameter("username");
		String num = req.getParameter("num");
		System.out.println(username+","+num);
		
		//Model : �������� Ŭ���̾�Ʈ�� ������ �����°�ü
		model.addAttribute("name",username);
		model.addAttribute("no",num);
		return "aLinkView";
	}
	
	//�������� ȣ��
	@RequestMapping(value="/formData")
	public ModelAndView getForm(HttpServletRequest req) {
		String id=req.getParameter("id");
		String pwd = req.getParameter("pwd");
		ModelAndView mav = new ModelAndView();
		//��, ���ѹ���
		mav.addObject("userid", id);
		mav.addObject("userpwd", pwd);
		mav.setViewName("getForm");
		return mav;
	}
	@RequestMapping(value="/formData2",method=RequestMethod.POST)
	public String getFormData(@RequestParam("id") String id,@RequestParam("pwd") String pwd,@RequestParam("num") int num,Model model) {  //req.getParameter()���� ����, �޾ƿͼ� String id�� �־���
		model.addAttribute("userid",id);
		model.addAttribute("userpwd",pwd);
		model.addAttribute("num",num+100);
		
		
		return "viewResult";				
	}

}
