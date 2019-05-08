package kr.goott.app.replyBoard.command;

import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.model.ReplyBoardDAO;

public class ReplyBoardEditCommand {


		public ModelAndView execute(int regNum) {
			ModelAndView mav =new ModelAndView();
			ReplyBoardDAO dao = new ReplyBoardDAO();
			
			mav.addObject("vo",dao.replySelect(regNum));
			mav.setViewName("reply/editForm");
			return mav;
		}


}
