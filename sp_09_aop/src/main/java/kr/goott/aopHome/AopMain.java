package kr.goott.aopHome;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public AopMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		SampleProcess sample = ctx.getBean("sampleProcess",SampleProcess.class);
		
		sample.sum(100000);
		sample.gugudan();
		sample.number();

	}

}
