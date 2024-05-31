package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MovieDTO;

public class MovieDAO {
	private MovieDAO() {}
	public static MovieDAO instance;

	public synchronized static MovieDAO getInstance() {
		if(instance==null) {
			instance=new MovieDAO();
		}
		return instance;
	}


	//JNDI
	private Connection getConnection() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	//insert
	public int insert(MovieDTO dto) throws Exception{

		String sql="insert into movies values(movies_seq.nextval, ?,?,?)";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getGenre());
			ps.setTimestamp(3, dto.getOpendate());
			return ps.executeUpdate();
		}
	}


	//select(ALL)
	public ArrayList<MovieDTO> selectAll() throws Exception{
		String sql="select * from movies order by 1";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();){
			ArrayList<MovieDTO> list=new ArrayList<MovieDTO>();
			while(rs.next()){
				int id=rs.getInt(1);
				String title=rs.getString(2);
				String genre=rs.getString(3);
				Timestamp opendate=rs.getTimestamp(4);

				list.add(new MovieDTO(id, title, genre, opendate));
				
			}
			return list;
		}
	}

	//search
	public ArrayList<MovieDTO> searchByTitle(String searchtitle) throws Exception{
		String sql="select * from movies where title = ?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, searchtitle);

			try(ResultSet rs=ps.executeQuery();){
				ArrayList<MovieDTO> list=new ArrayList<MovieDTO>();
				int id=rs.getInt(1);
				String title=rs.getString(2);
				String genre=rs.getString(3);
				Timestamp opendate=rs.getTimestamp(4);

				list.add(new MovieDTO(id, title, genre, opendate));
				return list;
			}
		}
	}


	//update
	public int updateById(int id, String wanttitle, String wantgenre, Timestamp wantdate ) throws Exception{
		String sql="update movies set title=?, genre=?, opendate=? where id=? ";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, wanttitle);
			ps.setString(2, wantgenre);
			ps.setTimestamp(3, wantdate);
			ps.setInt(4, id);
			return ps.executeUpdate();

		}
	}



	//delete
	public int deleteById(int targetid) throws Exception{
		String sql="delete from movies where id=?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1, targetid);
			return ps.executeUpdate();

		}
	}


}
