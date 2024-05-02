package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.BoardDTO;
import commons.Statics;

public class BoardManager {

	//Wrapper method
	private Connection getConnection() throws Exception {
		return Statics.bds.getConnection();
	}


	//1. 글 등록하기
	public int addBoard(int seq, String writer, String contents, Timestamp write_date) throws Exception {
		String sql="insert into board values(board_seq.nextval,?,?,?)";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1,writer);
			ps.setString(2,contents);
			ps.setTimestamp(3, write_date);
			return ps.executeUpdate();
		}
	}


	//전체 목록 출력-select
	public ArrayList<BoardDTO> selectAll() throws Exception {
	    String sql = "SELECT b.seq, m.name, b.contents, b.write_date "
	               + "FROM board b "
	               + "LEFT JOIN members m ON b.writer = m.id "
	               + "ORDER BY b.seq";

	    try (Connection con = this.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        ArrayList<BoardDTO> list = new ArrayList<>();
	        
	        while (rs.next()) {
	            int seq = rs.getInt("seq");
	            String name = rs.getString("name");
	            String contents = rs.getString("contents");
	            Timestamp write_date = rs.getTimestamp("write_date");
	            
	            list.add(new BoardDTO(seq, name, contents, write_date));
	        }
	        
	        return list;
	    }
	}


	//id로 항목 삭제-delete 
	public int deleteById(int deleteid) throws Exception{
		String sql="delete from board where seq =?";
		try(Connection con=this.getConnection(); 
				PreparedStatement ps=con.prepareStatement(sql);){ 
			ps.setInt(1,deleteid); 
			return ps.executeUpdate(); 
		} 
	}


	//id 중복 체크 기능 
	public boolean isIdExist(int id) throws Exception{ 
		String sql="select * from board where seq=?";
		try(Connection con=this.getConnection(); 
				PreparedStatement ps=con.prepareStatement(sql);){ 

			ps.setInt(1, id); 
			try(ResultSet rs=ps.executeQuery();){ 
				return rs.next(); 
			} 
		}

	}



	//id로 항목 수정-update 
	public int updateById(int modifyid, String writer, String contents, Timestamp write_date) throws Exception{
		String sql="update board set writer= ?, contents=?, write_date=? where seq =?";
		try(Connection con=this.getConnection(); 
				PreparedStatement ps=con.prepareStatement(sql);){ 
			ps.setString(1, writer);
			ps.setString(2, contents); 
			ps.setTimestamp(3, write_date); 
			ps.setInt(4, modifyid); 
			return ps.executeUpdate();
		} 
	}



	//id로 검색하기-select
	public ArrayList<BoardDTO> searchById(String searchid) throws Exception{ 
		String sql="SELECT b.seq, m.name, b.contents, b.write_date "
	               + "FROM board b "
	               + "LEFT JOIN members m ON b.writer = m.id "
	               + "WHERE m.name like ?"
	               + "ORDER BY b.seq";
		try(Connection con=this.getConnection(); 
			PreparedStatement ps=con.prepareStatement(sql);){ 

			ps.setString(1, "%"+searchid+"%");

			try(ResultSet rs=ps.executeQuery();) {
				ArrayList<BoardDTO> list=new ArrayList<BoardDTO>(); 
				while(rs.next()) { 
					int seq=rs.getInt("seq"); 
					String writer=rs.getString("name"); 
					String contents=rs.getString("contents"); 
					Timestamp write_date=rs.getTimestamp("write_date");

					list.add(new BoardDTO(seq,writer,contents,write_date)); 
				} 
				return list; 
			} 
		} 
	}




}
