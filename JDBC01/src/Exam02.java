import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		//1.접속하기
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="keduu";
		String pw="keduu";
		Connection con=DriverManager.getConnection(url, id, pw);
		
		//2. sql문 작성하기
		Statement stat=con.createStatement();
		String sql="update cafe set price=3500 where name='Cafe Mocha'";
		int result=stat.executeUpdate(sql);
		if(result>0) {
			System.out.println(result+"입력 성공");
		}
		
		con.close();
	}

}
