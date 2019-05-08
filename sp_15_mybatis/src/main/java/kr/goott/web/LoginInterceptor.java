package kr.goott.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	//controller 실행전실행	
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
		
		//false 면 원래 controller 호출
		return true;
	}
	
	// controller의 handler가 끝나면 처리됨	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
