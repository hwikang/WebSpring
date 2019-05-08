package kr.goott.master;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@Configuration
public class ApplicationConfig {

	//properties 키 값 저장할 변수
	@Value("${id}") //d이렇게하면 값이 들어가짐 admin.properties에서 불러옴
	private String id;
	@Value("${pwd}")
	private String pwd;
	@Value("${sub_id}")
	private String sub_id;
	@Value("${sub_pwd}")
	private String sub_pwd; 
	
	//properties의 키와 value를 사용하기위햐
	//propertySourcesPlaceholderConfugurer 객체가 필요
	
		
	//객체생성되지않아도 사용가능 static
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		//configurer객체에 properties 파일명을 resource 객체새성해서 di한다
		
		Resource location[] = new Resource[2];
		location[0]= new ClassPathResource("admin.properties");
		location[1]= new ClassPathResource("subadmin.properties");
		
		configurer.setLocations(location);
		
		return configurer;
	}
	@Bean
	public AdminVO admin() {
		AdminVO vo = new AdminVO();		
		vo.setId(id);
		vo.setSub_id(sub_id);
		vo.setPwd(pwd);
		vo.setSub_pwd(sub_pwd);
				
		return vo;		
				
			
	}
	
}
