import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam03 {
	public static void main(String[] args) throws Exception {
		//1. 연결하기
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="keduu";
		String pw="keduu";
		Connection con=DriverManager.getConnection(url, id, pw);
		
		//2. 편집기
		Statement stat=con.createStatement();
		String sql="delete from cafe where id =1001";
		int result=stat.executeUpdate(sql);
		if(result>0) {
			System.out.println(result+"입력 성공");
		}
		con.close();
		
	}

}
