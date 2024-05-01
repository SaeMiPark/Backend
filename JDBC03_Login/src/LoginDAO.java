import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class LoginDAO {
	String dburl="jdbc:oracle:thin:@localhost:1521:xe";
	String dbid="keduu";
	String dbpw="keduu";

	//id, pw 찾기
	public boolean login(String sid, String spw) throws Exception{
		String sql="select * from members where id = ? and pw= ?";
		try(
				Connection con=DriverManager.getConnection(dburl, dbid, dbpw);
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{
			pstat.setString(1, sid);
			pstat.setString(2, spw);
			
			try(
					ResultSet rs=pstat.executeQuery();
					)
			{

				return rs.next();
			}

		}
	}

	//insert 기능 구현
	public int insert(String id, String pw, String name) throws Exception  {
		String sql="insert into members values(?, ?, ?)";
		try(
				Connection con=DriverManager.getConnection(dburl, dbid, dbpw);
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{
			pstat.setString(1, id);
			pstat.setString(2, pw);
			pstat.setString(3, name);
			return pstat.executeUpdate();

		}
	}
}
