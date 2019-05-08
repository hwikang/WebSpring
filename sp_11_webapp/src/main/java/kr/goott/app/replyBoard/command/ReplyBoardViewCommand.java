package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;

public class ReplyBoardViewCommand {

	public ModelAndView execute(int regNum) {
		ReplyBoardDAO dao = new ReplyBoardDAO(); 
		
		dao.hitCount(regNum);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo",dao.replySelect(regNum));
		mav.setViewName("reply/view");
		
		
		return mav;
	}

}
