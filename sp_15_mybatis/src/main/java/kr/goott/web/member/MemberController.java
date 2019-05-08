package kr.goott.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	SqlSession sqlSession ;
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
		
	}
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest req,MemberVO vo) {
		MemberDAOInterface dao = sqlSession.getMapper(MemberDAOInterface.class);
		MemberVO memberVo = dao.logCheck(vo);
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		if(memberVo !=null) {			
			session.setAttribute("vo", memberVo);
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/");
		}else {
			session.setAttribute("logStatus", "N");
			mav.setViewName("redirect:/login");
		}
		
		return mav;
	}
}
