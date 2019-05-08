package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;
import kr.goott.app.replyBoard.model.ReplyBoardVO;

public class ReplyBoardEditOkCommand {
	public ModelAndView execute(ReplyBoardVO vo) {
		ModelAndView mav = new ModelAndView();
		ReplyBoardDAO dao = ReplyBoardDAO.getInstance();	
		
		mav.addObject("cnt",dao.replyEdit(vo));
		mav.addObject("regNum",vo.getRegNum());
		
		mav.setViewName("reply/editOk");
		
		return mav;
	}
}
