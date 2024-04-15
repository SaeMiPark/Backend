package main;

public class Exam01 {
	public static void main(String[] args) {
		//Timestamp: 1970년 1월 1일을 기준으로 현재까지 흐른 시간에 대한 초값
		long starttime=System.currentTimeMillis();
		//System.out.println(ctime);
		
		int count=0;
		for(int i=0; i<1000000; i++) {
			count++;
		}
		long endtime=System.currentTimeMillis();
		
		System.out.println(endtime-starttime);
		//3 *1000분의 1=0.003초 걸린 것==for문 돌린 시간
		
	}

}
