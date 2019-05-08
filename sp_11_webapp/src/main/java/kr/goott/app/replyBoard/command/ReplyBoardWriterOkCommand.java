package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;
import kr.goott.app.replyBoard.model.ReplyBoardVO;

public class ReplyBoardWriterOkCommand {
	public ModelAndView execute(ReplyBoardVO vo) {
		ReplyBoardDAO dao = ReplyBoardDAO.getInstance();
		int cnt = dao.insertRecord(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cnt",cnt);
		mav.setViewName("reply/writeOk");
		return mav;
	}
}
