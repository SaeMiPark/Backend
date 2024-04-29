package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.ContactDTO;

public class ContactDAO {
	String dburl="jdbc:oracle:thin:@localhost:1521:xe";
	String dbid="keduu";
	String dbpq="keduu";

	//Wrapper Method
	private Connection getConnection() throws Exception {
		return DriverManager.getConnection(dburl, dbpq, dbid);
	}

	//id 중복 체크 기능
	public boolean isContactExist(int id) throws Exception{
		String sql="select * from contact where id="+id;
		
		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				){
			
			return rs.next();
		}
		
	}

	//신규 등록-insert
	public int addContact(ContactDTO dto) throws Exception  {
		String sql="insert into contact values(contact_seq.nextval"+
				", '"+dto.getName()+"', '"+dto.getPhone()+"', '"+dto.getDate()+"')";
		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				)
		{
			int result=stat.executeUpdate(sql);
			return result;

		}
	}

	//전체 목록 출력-select
	public ArrayList<ContactDTO> selectAll() throws Exception{
		String sql="select * from contact";
		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);

				)
		{
			ArrayList<ContactDTO> list=new ArrayList<ContactDTO>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				Timestamp timestampdate=rs.getTimestamp("reg_date");

				list.add(new ContactDTO(id,name,phone,timestampdate));
			}
			return list;

		}
	}

	//id로 항목 삭제-delete
	public int deleteById(int deleteid) throws Exception{
		String sql="delete from contact where id ="+deleteid;

		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				){

			int result=stat.executeUpdate(sql);
			return result;

		}	
	}

	//id로 항목 수정-update
	public int updateById(int deleteid, String name, String phone, Timestamp ts) throws Exception{
		String sql="update contact set name= '"+name+"',  phone='"+phone+"' where id ="+deleteid;

		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				){

			int result=stat.executeUpdate(sql);
			return result;

		}	
	}

	//name으로 검색하기-select
	public ArrayList<ContactDTO> searchByName(String searchname) throws Exception{
		String sql="select * from contact where name = '"+searchname+"'";
		try(
				Connection con=this.getConnection();
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);

				)
		{
			ArrayList<ContactDTO> list=new ArrayList<ContactDTO>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				Timestamp timestampdate=rs.getTimestamp("reg_date");

				list.add(new ContactDTO(id,name,phone,timestampdate));
			}
			return list;

		}	
	}


}
