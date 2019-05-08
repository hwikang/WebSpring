package kr.goott.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	//controller ����������	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//login check
		try {
			HttpSession session = request.getSession();
			String logStat = (String)session.getAttribute("logStatus");
			boolean boo = true;
			if(logStat==null || logStat.equals("")) {
				response.sendRedirect("/web/login");
				return false;
			}
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("prehandle error");
		}
		
		//false �� ���� controller ȣ��
		return true;
	}
	
	// controller�� handler�� ������ ó����	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// view���� ó���� ���� �Ŀ� ó����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
