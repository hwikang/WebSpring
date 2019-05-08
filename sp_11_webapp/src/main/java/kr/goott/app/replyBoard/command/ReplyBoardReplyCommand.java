package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;
import kr.goott.app.replyBoard.model.ReplyBoardVO;

public class ReplyBoardReplyCommand {
	public ModelAndView execute(ReplyBoardVO vo) {
		
		ModelAndView mav = new ModelAndView();
		ReplyBoardDAO dao = new ReplyBoardDAO();
		mav.addObject("cnt",dao.replyInsert(vo));
		mav.setViewName("reply/replyOk");
		
		return mav;
	}
}
