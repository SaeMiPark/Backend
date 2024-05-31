package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MembersDTO;

public class MembersDAO {
	//singletone
	private MembersDAO() {}
	public static MembersDAO instance;

	public synchronized static MembersDAO getInstance() {
		if(instance==null) {
			instance=new MembersDAO();
		}
		return instance;
	}

	//JNDI
	private Connection getConnection() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}


	//id중복체크
	public boolean isIdExist(String id) throws Exception{
		String sql="select * from members where id = ?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, id); 
			try(ResultSet rs=ps.executeQuery()){
				return rs.next(); 
			}
		}

	}

	//login체크 기능
	public boolean isLoginExist(String id, String pw) throws Exception{
		String sql="select * from members where id = ? and pw =?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, id); 
			ps.setString(2, pw);
			try(ResultSet rs=ps.executeQuery()){
				return rs.next(); 
			}
		}
	}

	//insert
	public int insert(MembersDTO dto) throws Exception{

		String sql="insert into members values(?,?,?,?,?,?,?,?,sysdate)";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getZipcode());
			ps.setString(7, dto.getAddress1());
			ps.setString(8, dto.getAddress2());
			return ps.executeUpdate();
		}
	}

	//delete
	public int deleteById(String targetid) throws Exception{
		String sql="delete from members where id=?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, targetid);
			return ps.executeUpdate();

		}
	}

	//search
	public MembersDTO searchById(String loginid) throws Exception{
		String sql="select * from members where id = ?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, loginid);

			try(ResultSet rs=ps.executeQuery();){
				MembersDTO dto=null;
				while(rs.next()) {
					String id=rs.getString(1);
					String pw=rs.getString(2);
					String name=rs.getString(3);
					String phone=rs.getString(4);
					String email=rs.getString(5);
					String zipcode=rs.getString(6);
					String address1=rs.getString(7);
					String address2=rs.getString(8);
					Timestamp join_date=rs.getTimestamp(9);
					dto=new MembersDTO(id, pw, name, phone, email, zipcode, address1, address2, join_date);
				}

				return dto;

			}
		}
	}

	//update
	public int updateById(String id, String name, String phone, String email, String zipcode, String address1, String address2) throws Exception{
		String sql="update members set name=?, phone=?, email=?, zipcode=?, address1=?, address2=? where id=? ";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, zipcode);
			ps.setString(5, address1);
			ps.setString(6, address2);
			ps.setString(7, id);
			return ps.executeUpdate();
		}
	}

}
