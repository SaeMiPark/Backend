package Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exam02 {

	public static void main(String[] args) throws Exception{
		//1.접속하기
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="keduu";
		String pw="keduu";
		
		String name="Cafe";
		int price=3000;
		
		//2.prepardstatement
		Connection con=DriverManager.getConnection(url, id, pw);
		String sql="insert into cafe values(cafe_seq.nextval,?,?)";
		PreparedStatement pstat=con.prepareStatement(sql);
		pstat.setString(1, name); //여기서 쿼테이션을 자동으로 넣어서 보내준다.
		pstat.setInt(2, price); // 1. 물음표에 인덱스 2. 넣을 변수 명
		int result=pstat.executeUpdate(); //★쿼리문이 안 들어 간다
		//미리 sql문을 컴파일 해놓고 컴파일 된 바이너리 파일을 가지고 있는다.
		//나중에 이 파일을 가지고 물음표 부분만 바꿔서 실행시키기 때문에 
		//컴파일을 반복적으로 하지 않아도 된다.


		if(result>0) {
			System.out.println(result+"입력 성공");
		}

		con.close();

		//보안성, 성능, 편의성 쿼테이션...
		//->PreparedStatement

	}

}
