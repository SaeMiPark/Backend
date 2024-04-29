import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		//DAO의 add기능의 내용이 DBMS로 데이터를 저장하는 코드로 변경되어야 함
		//DBMS에서 프로토콜을 신경쓰지 않고 제공하는 라이브러리가 있다.
		Scanner sc=new Scanner(System.in);
		System.out.print("메뉴 이름 : ");
		String name=sc.nextLine();
		
		System.out.print("메뉴 가격 : ");
		int price=Integer.parseInt(sc.nextLine());
		
		//순서외우기
		//1. DBMS접속하기
		String dbURL="jdbc:oracle:thin:@localhost:1521:xe"; 
		String dbID="keduu";
		String dbPW="keduu";		
		Connection con=DriverManager.getConnection(dbURL, dbID, dbPW);
		
		
		//2. 쿼리 쓸 수 있는 하얀 편집기 생성하기
		Statement stat=con.createStatement();
		
		String sql="insert into cafe values(cafe_seq.nextval,'"+name+"',"+price+")";
		
		int result=stat.executeUpdate(sql);
		
		if(result>0) {
			System.out.println(result+"입력 성공");
		}
		
		//★DBMS와 연결된 통로=con는 한정되어 있어서 항상 닫아야 한다.
		con.close();
		
		
	}
}
