package kr.goott.master;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminLoginMain {

	public AdminLoginMain() {
		
	}

	public static void main(String[] args) {
		//javabean 객체
		
		//@configuration 이 붙은 클래스를 정보로 사용
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminVO vo = ctx.getBean("admin",AdminVO.class);
		
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		System.out.println(vo.getSub_id());
		System.out.println(vo.getSub_pwd());
		
		

	}

}
