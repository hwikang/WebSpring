package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;

public class ReplyBoardDeleteCommand {
	public ModelAndView execute(int regNum) {
		ModelAndView mav = new ModelAndView();
		ReplyBoardDAO dao = new ReplyBoardDAO();
		dao.replyDelete(regNum);
		mav.setViewName("reply/deleteOk");
		return mav;
	}
}
