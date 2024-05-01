package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public boolean isIdExist(int id) throws Exception{
		String sql="select * from contact where id=?";

		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				){
			pstat.setInt(1, id);

			try(
					ResultSet rs=pstat.executeQuery();
					){
				return rs.next();
			}
		}

	}

	//신규 등록-insert
	public int addContact(ContactDTO dto) throws Exception  {
		String sql="insert into contact values(contact_seq.nextval,?,?,?)";
		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{
			pstat.setString(1,dto.getName());
			pstat.setString(2, dto.getPhone());
			pstat.setTimestamp(3, dto.getDate());
			return pstat.executeUpdate();
		}
	}

	//전체 목록 출력-select
	public ArrayList<ContactDTO> selectAll() throws Exception{
		String sql="select * from contact order by 1";
		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs=pstat.executeQuery();

				)
		{
			ArrayList<ContactDTO> list=new ArrayList<ContactDTO>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				Timestamp ts=rs.getTimestamp("reg_date");

				list.add(new ContactDTO(id,name,phone,ts));
			}
			return list;

		}
	}

	//id로 항목 삭제-delete
	public int deleteById(int deleteid) throws Exception{
		String sql="delete from contact where id =?";

		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				){

			pstat.setInt(1,deleteid);
			return pstat.executeUpdate();	 
		}	
	}

	//id로 항목 수정-update
	public int updateById(int deleteid, String name, String phone, Timestamp ts) throws Exception{
		String sql="update contact set name= ?,  phone=?, reg_date=? where id =?";

		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				){
			pstat.setString(1, name);
			pstat.setString(2, phone);
			pstat.setTimestamp(3, ts);
			pstat.setInt(4, deleteid);
			return pstat.executeUpdate();
		}	
	}

	//name으로 검색하기-select
	public ArrayList<ContactDTO> searchByName(String searchname) throws Exception{
		String sql="select * from contact where name like ?";
		try(
				Connection con=this.getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{
			pstat.setString(1, "%"+searchname+"%");

			try(
					ResultSet rs=pstat.executeQuery();
					){
				ArrayList<ContactDTO> list=new ArrayList<ContactDTO>();
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					Timestamp ts=rs.getTimestamp("reg_date");

					list.add(new ContactDTO(id,name,phone,ts));
				}
				return list;
			}

		}	
	}


}
