package kr.goott.pro;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertiesMain {

	public PropertiesMain() {
		
	}
	
	public static void main(String[] args) {
		String location = "classpath:applicationCTX.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(location);
		
		//properties 객체
		PropertiesVO vo = context.getBean("properties",PropertiesVO.class);
		
		System.out.println("adminId="+vo.getAdminId());
		System.out.println("adminPwd="+vo.getAdminPwd());
		System.out.println("subadminId="+vo.getSubAdminId());
		System.out.println("subadminPwd="+vo.getSubAdminPwd());
		

	}

}
