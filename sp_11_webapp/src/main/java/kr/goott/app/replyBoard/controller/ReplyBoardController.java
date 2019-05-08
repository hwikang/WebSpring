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
	
	//�۾�����
	@RequestMapping("/writerForm")
	public String writerForm() {
		return "reply/writerForm";
	}
	
	//�� ���
	@RequestMapping(value="/replyWriterOk",method=RequestMethod.POST)
	public ModelAndView writeOk(HttpServletRequest req,ReplyBoardVO vo) {  //session �� �ʿ��Ҷ��� req ��ü�� �Ű������� �־���Ѵ�
		System.out.println("writer"+vo.getWriter());
		ReplyBoardWriterOkCommand command = new ReplyBoardWriterOkCommand();
		
		return command.execute(vo);
	}
	
	
	//�ۼ���
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
	//��۾�����
	@RequestMapping(value="/replyForm")//regNum �޾Ƽ� int regNum ���־��
	public String replyForm(@RequestParam("regNum") int regNum,Model model) {
		model.addAttribute("regNum",regNum);
		
		return "reply/replyForm";
	}
	
	//��۾���
	@RequestMapping(value="/replyFormOk")
	public ModelAndView replyFormOk(ReplyBoardVO vo) {
		ReplyBoardReplyCommand command = new ReplyBoardReplyCommand();		
		return command.execute(vo);
	}
	//����
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam("regNum") int regNum) {
		ReplyBoardDeleteCommand command = new ReplyBoardDeleteCommand();
		return command.execute(regNum);
	}
	
}
