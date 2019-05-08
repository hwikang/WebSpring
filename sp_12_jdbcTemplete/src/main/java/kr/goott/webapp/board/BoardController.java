package kr.goott.webapp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.glassfish.gmbal.ParameterNames;
@Controller
public class BoardController {
	@RequestMapping("/boardList")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.getAllSelect();
		mav.setViewName("board/list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/view")
	public ModelAndView view(@RequestParam("recordNo") int recordNo) {
		ModelAndView mav = new ModelAndView();
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getSelect(recordNo);
		dao.hitCount(recordNo);
		mav.setViewName("board/view");
		mav.addObject("vo", vo);
		mav.addObject("replyVo", dao.getReplySelect(recordNo));
		return mav;
	}
	//글쓰기
	@RequestMapping("/writer")
	public String writerForm() {
		return "/board/writerForm";
	}
	@RequestMapping("/writerOk")
	public ModelAndView writerOk(HttpServletRequest req, BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		vo.setIp(req.getRemoteAddr()); //클라이언트의 ip
		BoardDAO dao = new BoardDAO();
		mav.addObject("cnt",dao.boardInsert(vo));
		mav.setViewName("board/writerOk");		
		return mav;
	}
	
	@RequestMapping("/editForm")
	public ModelAndView editForm(BoardVO vo) {
		BoardDAO dao = new BoardDAO();
		ModelAndView mav = new ModelAndView();
		//dao.updateRecord(vo);
		
		mav.setViewName("/board/editForm");
		
		mav.addObject("vo", dao.getSelect(vo.getRecordNo()));
		return mav;
	}
	@RequestMapping(value="/editOk",method=RequestMethod.POST)
	public ModelAndView editForm(BoardVO vo,HttpServletRequest req) {
		BoardDAO dao = new BoardDAO();
		ModelAndView mav = new ModelAndView();
		vo.setIp(req.getRemoteAddr());		
		mav.setViewName("/board/editOk");		
		mav.addObject("cnt", dao.updateRecord(vo));
		mav.addObject("recordNo", vo.getRecordNo());
		return mav;
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam int recordNo) {
		BoardDAO dao = new BoardDAO();
		ModelAndView mav = new ModelAndView();			
		mav.setViewName("/board/deleteOk");		
		mav.addObject("cnt", dao.deleteRecord(recordNo));		
		return mav;
	}
	@RequestMapping(value="/reply" , method=RequestMethod.POST)
	@ResponseBody
	public List<BoardReplyVO> reply(BoardReplyVO vo) {
		System.out.println(vo.getUserid());
		BoardDAO dao = new BoardDAO();
		List<BoardReplyVO> list = dao.replyInsert(vo);
		System.out.println(list.size());
		return list; 
	}
}
