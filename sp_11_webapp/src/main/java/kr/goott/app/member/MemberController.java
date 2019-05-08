package kr.goott.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@RequestMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//·Î±×ÀÎ
	@RequestMapping(value="/loginOk", method=RequestMethod.GET)
	public ModelAndView loginOk(HttpServletRequest req, MemberVO vo) {
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.loginCheck(vo);
		
		HttpSession session = req.getSession();
		ModelAndView mav = new ModelAndView();
		
		if(vo.getLogStatus().equals("Y")) {
			session.setAttribute("userid",vo.getUserid());
			session.setAttribute("username",vo.getUsername());
			session.setAttribute("logStatus","Y");
			
			
		}else {
			session.setAttribute("logStatus","N");
			
		}
		
		mav.setViewName("member/loginOk");
		
		return mav;
	}
	
}
