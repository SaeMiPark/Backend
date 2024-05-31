package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import dto.MessageDTO;

public class MessageDAO {
	private MessageDAO() {}

	public static MessageDAO instance;

	public synchronized static MessageDAO getInstance() {
		if(instance == null) {
			instance=new MessageDAO();
		}
		return instance;
	}

	//JNDI 템플릿 메서드 익스프레션 패턴
	private Connection getConnection() throws Exception{
		Context ctx=new InitialContext(); //환경정보를 인스턴스로 만들었다. 톰캣!
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); //이거 찾아와
		return ds.getConnection();
	}

	//1. insert하기
	public int addMessage(MessageDTO dto) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval,?,?,?)";

		try (Connection con = this.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getMessage());
			ps.setTimestamp(3, dto.getWrite_date());
			int result= ps.executeUpdate();
			return result;
		} 
	}

	//2. 전체 select하기
	public ArrayList<MessageDTO> selectAll() throws Exception{
		String sql="select * from messages";

		try(Connection con=this.getConnection();
				PreparedStatement ptat=con.prepareStatement(sql);
				ResultSet rs=ptat.executeQuery();){	
			ArrayList<MessageDTO> list=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String writer=rs.getString("writer");
				String message=rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");
				list.add(new MessageDTO(id, writer,message,write_date));
			}
			return list;
		}
	}
	
	//update
		public int updateById(int id, String writer, String message, Timestamp write_date ) throws Exception{
			String sql="update messages set writer=?, message=?, write_date=? where id=? ";

			try(Connection con=this.getConnection();
					PreparedStatement ps=con.prepareStatement(sql);){
				ps.setString(1, writer);
				ps.setString(2, message);
				ps.setTimestamp(3, write_date);
				ps.setInt(4, id);
				return ps.executeUpdate();

			}
		}
		
	



		//delete
		public int deleteById(int targetid) throws Exception{
			String sql="delete from messages where id=?";

			try(Connection con=this.getConnection();
					PreparedStatement ps=con.prepareStatement(sql);){
				ps.setInt(1, targetid);
				return ps.executeUpdate();

			}
		}


}


