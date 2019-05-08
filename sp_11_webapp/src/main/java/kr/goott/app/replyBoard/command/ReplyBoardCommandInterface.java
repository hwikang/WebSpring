package kr.goott.app.replyBoard.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ReplyBoardCommandInterface {
	public ModelAndView excute(HttpServletRequest request);
}
