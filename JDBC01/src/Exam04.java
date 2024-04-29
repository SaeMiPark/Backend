import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam04 {
	public static void main(String[] args) throws Exception {
		
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
		String dbid="keduu";
		String dbpw="keduu";
		
		Connection con=DriverManager.getConnection(dburl, dbid, dbpw);
		Statement stat=con.createStatement();
		
		String sql="select * from cafe";
		ResultSet rs=stat.executeQuery(sql); 
		//resultset 
		//포인터==가리키는자
		//즉, 결과의 주소를 알고 있는 객체
		//램에 로딩하는 과정도 있다.
		
		while(rs.next()) { //아래로 한 칸씩 내려주는 메서드
			//데이터가 없을 때 리턴값이 false로 변한다.
			int id=rs.getInt(1); //첫번째 열 같은 의미 rs.getInt("id");
			String name=rs.getString("name"); //두번째 열
			int price=rs.getInt("price");
			
			System.out.println("id : "+id+", name : "+name+", price : "+price);
		
		}
		
		con.close();
		//close 되는 순간 resultset은 더 이상 주소를 가지고 있지 않게 된다.
	}

}
