package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.MembersDTO;
import commons.Statics;

public class LoginManager {
	//Wrapper method
	private Connection getConnection() throws Exception {
		return Statics.bds.getConnection();
	}
	
	//회원가입 기능
	public int addmember(MembersDTO dto) throws Exception{
		String sql="insert into members values(?,?,?,?)";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);	){
			
			ps.setString(1,dto.getId());
			ps.setString(2,Statics.getSHA512(dto.getPw()));
			ps.setString(3,dto.getName());
			ps.setTimestamp(4, dto.getJoin_date());
			return ps.executeUpdate();
		}	
	}
	
	//로그인 기능
	public boolean loginmember(String id, String pw) throws Exception{
		String sql="select * from members where id=? and pw=?";
		try(Connection con=this.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);	){
			
			ps.setString(1,id);
			ps.setString(2,Statics.getSHA512(pw));
			
			try(ResultSet rs=ps.executeQuery();){
				return rs.next();	
			}
			
		}	
	}
	

}//class
