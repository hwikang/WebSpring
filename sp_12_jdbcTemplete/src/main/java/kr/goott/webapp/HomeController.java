package kr.goott.webapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//jdbc template ��ü�� di �� ����
	
	public JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	@Autowired //servlet-context.xml ��ü�� �ڵ����� template ������
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constants.template=template;
	}
	




	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		
		return "home";
	}
	
}