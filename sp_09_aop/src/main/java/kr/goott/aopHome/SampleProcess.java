package kr.goott.aopHome;

public class SampleProcess {

	public void sum(int max) {
		int total=0;
		for(int i =1;i<=max; i++) {
			total += i;
			
		}
		System.out.println("1~"+max+"="+total);
	}
	
	public void gugudan() {
		for(int i =1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			
			System.out.println();
		}
	}
	public void number() {
		for(int i =0; i<=100;i++) {
			System.out.printf("%4d",i);
		}
		System.out.println();
	}
	
}
