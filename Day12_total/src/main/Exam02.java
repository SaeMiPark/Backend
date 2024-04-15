package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam02 {
	public static void main(String[] args) throws ParseException {
		//Timestamp -> String(형식을 갖춘)   MM는 대문자 dd, year는 소문자 
		long ctime=System.currentTimeMillis(); //현재 시간 추출
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY.MM.dd(E) hh:mm:ss"); //어떤 형식으로 보여줄지 결정
		String result=sdf.format(ctime); //형식에 맞게 반환
		System.out.println("결과:"+result);
		
		//String -> Timestamp
		String ctime2="2014-04-15";
		
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdff.parse(ctime2); 
		System.out.println("결과:"+date);
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy년 MM월 dd일");
		String mydate=sdf2.format(date);
		System.out.println("한번 더 변환:"+mydate);
	}

}
