package exam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExam02 {
	public static void main(String[] args) throws Exception {
		//DB테이블의 날짜 타입 
		//(varchar면 변환 작업 필요 없음)->이 데이터를 날짜로서 써먹어야 할 때 못 써먹음
		//(Timestamp가 더 낫다)-> 전제로 한다.
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("yy/MM/dd");
	
	//String 사용자 날짜 입력 -> Timestamp or Date타입
	
		System.out.println("날짜 입력(년도/월/일): ");
		String inputData=sc.nextLine();
		java.util.Date pased=sdf.parse(inputData); //util-date를 적용해야 한다.
		
	//1.timestamp
		Timestamp ts=new Timestamp(pased.getTime()); //timestamp-sql
		//ts가 dbms에 넣을 수 있는 값이 된다.
		
	//2.date
		java.sql.Date reg_date=new java.sql.Date(pased.getTime());
		
//-------------------------------------------------------------------------------		
	
	//Timestamp or Date 타입 -> Format String변환
		//방법 똑같다.
		//ts와 reg_date는 여기서 DB에서 꺼낸 값일 것.
		String tsstr=sdf.format(ts);
		String reg_date_str=sdf.format(reg_date);	
	}

}
