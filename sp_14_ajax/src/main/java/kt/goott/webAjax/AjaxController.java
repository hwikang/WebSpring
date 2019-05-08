package kt.goott.webAjax;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajax")
	public String ajaxHome() {
		return "ajax";
	}
	
	//문자열 처리
	@RequestMapping(value="/ajaxString" ,method=RequestMethod.GET)
	@ResponseBody
	public String ajaxString(String no , String name) {
		System.out.println(no+","+name);
		return "Ajax String Success";
	}
	
	//obj 처리
	@RequestMapping(value="/ajaxObject", method=RequestMethod.GET)
	@ResponseBody
	public TestVO ajaxObject(TestVO vo) {
		System.out.println(vo.toString());
		
		TestVO vo2 = new TestVO();
		vo2.setNo(999);
		vo2.setName("king 세종");		
		return vo2;		
	}
	
	@RequestMapping(value="/ajaxList", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<TestVO> ajaxList(TestVO vo){
		System.out.println(vo.toString());
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		TestVO vo1 = new TestVO(1,"hong");
		TestVO vo2 = new TestVO(2,"kong");
		TestVO vo3 = new TestVO(3,"jong");
		TestVO vo4 = new TestVO(4,"dong");
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		return list;
	}
	
	@RequestMapping(value="/ajaxMap",method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String ,TestVO> ajaxMap(TestVO vo){
		System.out.println(vo.toString());
					//키,밸류
		HashMap<String ,TestVO> map = new HashMap<String ,TestVO>();
		TestVO vo1 = new TestVO(11,"mofo");
		TestVO vo2 = new TestVO(22,"mofo2");
		TestVO vo3 = new TestVO(33,"mofo3");
		TestVO vo4 = new TestVO(44,"mofo4");
		
		map.put("A",vo1);
		map.put("B",vo2);
		map.put("C",vo3);
		map.put("D",vo4);
		return map;
	}
	
	@RequestMapping(value="/ajaxForm",method=RequestMethod.POST,produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxForm(TestVO vo){
		System.out.println(vo.toString());
		
		return "success";
	}
	
	
	
}
