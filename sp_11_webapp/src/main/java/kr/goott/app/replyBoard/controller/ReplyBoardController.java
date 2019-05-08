package kr.goott.app.replyBoard.controller;

import java.lang.reflect.Executable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.goott.app.replyBoard.command.ReplyBoardDeleteCommand;
import kr.goott.app.replyBoard.command.ReplyBoardEditCommand;
import kr.goott.app.replyBoard.command.ReplyBoardEditOkCommand;
import kr.goott.app.replyBoard.command.ReplyBoardListCommand;
import kr.goott.app.replyBoard.command.ReplyBoardReplyCommand;
import kr.goott.app.replyBoard.command.ReplyBoardViewCommand;
import kr.goott.app.replyBoard.command.ReplyBoardWriterOkCommand;
import kr.goott.app.replyBoard.model.ReplyBoardDAO;
import kr.goott.app.replyBoard.model.ReplyBoardVO;

@Controller
public class ReplyBoardController {
	@RequestMapping("/replyList")
	public ModelAndView list() {
		ReplyBoardListCommand command = new ReplyBoardListCommand();
		ModelAndView mav = command.excute();
		return mav;
	}
	
	//글쓰기폼
	@RequestMapping("/writerForm")
	public String writerForm() {
		return "reply/writerForm";
	}
	
	//글 등록
	@RequestMapping(value="/replyWriterOk",method=RequestMethod.POST)
	public ModelAndView writeOk(HttpServletRequest req,ReplyBoardVO vo) {  //session 이 필요할때는 req 객체를 매개변수로 넣어야한다
		System.out.println("writer"+vo.getWriter());
		ReplyBoardWriterOkCommand command = new ReplyBoardWriterOkCommand();
		
		return command.execute(vo);
	}
	
	
	//글선택
	@RequestMapping(value="/replyView")
	public ModelAndView view (@RequestParam("regNum") int regNum){
		ReplyBoardViewCommand command = new ReplyBoardViewCommand();
		return command.execute(regNum);
	}
	
	@RequestMapping(value="/replyEditForm")
	public ModelAndView edit(@RequestParam("regNum") int regNum) {
		ReplyBoardEditCommand command = new ReplyBoardEditCommand();
		return command.execute(regNum);
	}
	
	@RequestMapping(value="/replyEditOk")
	public ModelAndView editOk(ReplyBoardVO vo) {
		ReplyBoardEditOkCommand command = new ReplyBoardEditOkCommand();
		return command.execute(vo);
	}
	//답글쓰기폼
	@RequestMapping(value="/replyForm")//regNum 받아서 int regNum 에넣어라
	public String replyForm(@RequestParam("regNum") int regNum,Model model) {
		model.addAttribute("regNum",regNum);
		
		return "reply/replyForm";
	}
	
	//답글쓰기
	@RequestMapping(value="/replyFormOk")
	public ModelAndView replyFormOk(ReplyBoardVO vo) {
		ReplyBoardReplyCommand command = new ReplyBoardReplyCommand();		
		return command.execute(vo);
	}
	//삭제
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam("regNum") int regNum) {
		ReplyBoardDeleteCommand command = new ReplyBoardDeleteCommand();
		return command.execute(regNum);
	}
	
}
