package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;
import kr.goott.app.replyBoard.model.ReplyBoardVO;

public class ReplyBoardListCommand {
	public ModelAndView excute() {
		ModelAndView mav = new ModelAndView();

		ReplyBoardDAO dao = new ReplyBoardDAO();
		mav.addObject("list",dao.replySelectAll());
		mav.addObject("totalRecord",dao.totalRecord());
		mav.setViewName("reply/list");
		
		
		return mav;
	}
}
