package kr.goott.web.board;

import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class BoardController {
		
		//servlet-contextdml sqlsession 가져옴
		@Autowired
		SqlSession sqlSession ;
		

		@RequestMapping("/list")
		public ModelAndView list() {
			//record선택  			daoInterface 클래스 
			BoardDAOInterface dao = sqlSession.getMapper(BoardDAOInterface.class);
			List<BoardVO> list = dao.selectAll();
			//MODELANDVIEW
			ModelAndView mav = new ModelAndView();
			mav.addObject("list",list);
			mav.setViewName("board/list");
			return mav;
				
		}

		@RequestMapping("/write")
		public String write() {
			return "board/writeForm";				
		}

		@RequestMapping("/writeOk")
		public ModelAndView writeOk(BoardVO vo, HttpServletRequest req) {
			vo.setIp(req.getRemoteAddr());
			BoardDAOInterface dao = sqlSession.getMapper(BoardDAOInterface.class);
			int cnt = dao.insertRecord(vo);
			ModelAndView mav = new ModelAndView();
			if(cnt==1) {
				mav.setViewName("redirect:list");
			}else {
				mav.setViewName("redirect:write");
			}
			return mav;				
		}
		
		@RequestMapping("/view")
		public ModelAndView view(BoardVO vo) {
			BoardDAOInterface dao = sqlSession.getMapper(BoardDAOInterface.class);
			System.out.println("recordno="+vo.getRecordNo());
			
			vo  = dao.selectOne(vo.getRecordNo());
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo",vo);
			mav.setViewName("board/view");
			
			return mav;				
		}

		@RequestMapping("/edit")
		public ModelAndView edit(@RequestParam("recordNo") int recordNo) {
			BoardDAOInterface dao = sqlSession.getMapper(BoardDAOInterface.class);
			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo",dao.selectOne(recordNo));
			mav.setViewName("board/edit");
			
			return mav;				
		}

		@RequestMapping("/editOk")
		public ModelAndView editOk(BoardVO vo, HttpServletRequest req) {
			BoardDAOInterface dao = sqlSession.getMapper(BoardDAOInterface.class);
			vo.setIp(req.getLocalAddr());
			int cnt = dao.updateRecord(vo);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("recordNo",vo.getRecordNo());
			if(cnt==1) {			
				mav.setViewName("redirect:view");
			}else {
				mav.setViewName("board/list");
			}
			return mav;				
		}

							
				
}
