package com.kedu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	/*값을 두개 넘길 수 없다. 두 개를 전달하고 싶다면 dto형태로 넘겨야 한다.
	 * 그러면 dto 항상 만들어야 해? 그건 상황에 따라 다르다
	 * dto말고도 map을 사용할 수 있다.
	 * */
	
	@Autowired
	private SqlSession mybatis;
	
	public List<MessagesDTO> selectByCon(String column, String keyword){
		Map<String,String> params=new HashMap<>();
		params.put("column", column);
		params.put("keyword", keyword);
		List<MessagesDTO> list= mybatis.selectList("Messages.selectByCon",params);
		for(MessagesDTO dto:list) {
			System.out.println(dto.getSeq()+dto.getWriter()+dto.getMessage());
		}
		return list;
	}
	
	public List<MessagesDTO> selectByMultiCon(String writer, String message){
		Map<String,String> params=new HashMap<>();
		params.put("writer", writer);
		params.put("message", message);
		List<MessagesDTO> list= mybatis.selectList("Messages.selectByMultiCon",params);
		for(MessagesDTO dto:list) {
			System.out.println(dto.getSeq()+dto.getWriter()+dto.getMessage());
		}
		return list;
	}
	
	
	
	
	public int insert(MessagesDTO dto) {
		/* 왼쪽은 맵퍼의 아이디 */
		mybatis.insert("Messages.insert", dto);
		int seq= dto.getSeq();
		System.out.println(seq);
		return seq;
	}
	
	public List<Map<String,Object>> selectAll() {
		List<Map<String,Object>> list = mybatis.selectList("Messages.selectAll");
		for(Map<String,Object> item:list) {
			System.out.println(item);
		}
		return list;
	}
	
	public int delete(int seq) {
		/*
		 * Map<String, Object> params=new HashMap<>(); 
		 * params.put("seq1", seq);
		 * params.put("seq2", seq); 
		 * return mybatis.delete("Messages.delete", params);
		 */
		Map<String, Object> params=new HashMap<>(); 
		params.put("seq", seq);
		return mybatis.delete("Messages.delete", params);
	}
	
	public int update(MessagesDTO dto) throws Exception{  
		return mybatis.update("Messages.update", dto);
	}
	
	
	
	
	
	/*
	 * @Autowired private JdbcTemplate jdbc;
	 * 
	 * public int insert(MessagesDTO dto) throws Exception{ String
	 * sql="insert into messages values(messages_seq.nextval,?,?)"; return
	 * jdbc.update(sql, dto.getWriter(), dto.getMessage()); }
	 * 
	 * public List<MessagesDTO> selectAll() throws Exception{ String
	 * sql="select * from messages"; return jdbc.query(sql, new
	 * BeanPropertyRowMapper<>(MessagesDTO.class)); }
	 * 
	 * public int update(MessagesDTO dto) throws Exception{ String
	 * sql="update messages set writer=?, message=? where seq=?"; return
	 * jdbc.update(sql, dto.getWriter(), dto.getMessage(), dto.getSeq()); }
	 * 
	 * public int delete(int seq) throws Exception{ String
	 * sql="delete from messages where seq=?"; return jdbc.update(sql, seq); }
	 * 
	 * //예시를 보여주기 위한 코드 public MessagesDTO selectBySeq(int seq) { String
	 * sql="select * from messages where seq = ?"; return jdbc.queryForObject(sql,
	 * new BeanPropertyRowMapper<>(MessagesDTO.class), seq); }
	 * 
	 * //예시를 위한 코드/* public int selectCount() { String
	 * sql="select count(*) from messages"; return jdbc.queryForObject(sql,
	 * Integer.class); }
	 * 
	 * 
	 * 
	 */
	
	/*@Autowired
	private BasicDataSource bds;
	
	//insert
	public int insert(MessagesDTO dto) throws Exception{
		String sql="insert into messages values(messages_seq.nextval,?,?)";
		
		try(Connection con=bds.getConnection();
				PreparedStatement ps= con.prepareStatement(sql);){
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getMessage());
			return ps.executeUpdate();
		}
	}
	
	//selectAll
	public ArrayList<MessagesDTO> selectAll() throws Exception{
		String sql="select * from messages";
		
		try(Connection con=bds.getConnection();
				PreparedStatement ps= con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery()){
			
			ArrayList<MessagesDTO> list=new ArrayList<>();
			while(rs.next()) {
				int seq=rs.getInt(1);
				String writer=rs.getString(2);
				String message=rs.getString(3);
				list.add(new MessagesDTO(seq,writer, message));
			}
			return list;
		}
	}
	
	//delete
		public int delete(int seq) throws Exception{
			String sql="delete from messages where seq=?";
			
			try(Connection con=bds.getConnection();
					PreparedStatement ps= con.prepareStatement(sql);){
				ps.setInt(1, seq);
				return ps.executeUpdate();
			}
		}
		
		//update
		public int update(MessagesDTO dto) throws Exception{
			String sql="update messages set writer=?, message=? where seq=?";
			try(Connection con=bds.getConnection();
					PreparedStatement ps= con.prepareStatement(sql);){
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getMessage());
				ps.setInt(3, dto.getSeq());
				return ps.executeUpdate();
			}
		}*/

}
