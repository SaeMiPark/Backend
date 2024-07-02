package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	//singletone
	private BoardDAO() {}
	public static BoardDAO instance;

	public synchronized static BoardDAO getInstance() {
		if(instance==null) {
			instance=new BoardDAO();
		}
		return instance;
	}

	//JNDI
	private Connection getConnection() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}


	//1. 글 추가하기 insert
	public int insert(BoardDTO dto) throws Exception{
		String sql="insert into board values(board_seq.nextval,?,?,?,sysdate,?)";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql, new String[] {"seq"});){
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, dto.getView_cout());
			ps.executeUpdate();

			try(ResultSet rs=ps.getGeneratedKeys();){
				rs.next();
				return rs.getInt(1);
			}
		}
	}

	//2. 페이지별로 select하기
	public ArrayList<BoardDTO> selectNtoM(int startnum, int endnum) throws Exception {
		String sql = "SELECT * " +
				"FROM ( " +
				"    SELECT board.*, " +
				"           row_number() OVER (ORDER BY seq DESC) AS rown " +
				"    FROM board " +
				") subquery " +
				"WHERE rown BETWEEN ? AND ?";

		try (Connection con = this.getConnection();
				PreparedStatement ptat = con.prepareStatement(sql)) {
			ptat.setInt(1, startnum);
			ptat.setInt(2, endnum);

			try (ResultSet rs = ptat.executeQuery()) {
				ArrayList<BoardDTO> list = new ArrayList<>();
				while (rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int view_cout = rs.getInt("view_cout");
					list.add(new BoardDTO(seq, writer, title, contents, write_date, view_cout));
				}
				return list;
			}
		}
	}

	//3. 내용출력하기
	public BoardDTO selectcontent(int searchseq) throws Exception{
		String sql="select * from board  where seq=?";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){	
			ps.setInt(1, searchseq);
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()) {
					int seq=rs.getInt("seq");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String contents=rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int view_cout=rs.getInt("view_cout");
					return new BoardDTO(seq, writer,title,contents,write_date,view_cout);
				}
				return null;
			}
		}
	}

	//4. delete
	public int deleteBySeq(int targetseq) throws Exception{
		String sql="delete from board where seq=?";
		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1, targetseq);
			return ps.executeUpdate();
		}
	}

	//5. update
	public int updateBySeq(int targetseq, String targettitle, String targetcontents) throws Exception{
		String sql="update board set title=?, contents=? where seq=? ";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, targettitle);
			ps.setString(2, targetcontents);
			ps.setInt(3, targetseq);
			return ps.executeUpdate();
		}
	}

	//5. update view
	public void updateviewcout(int seq) throws Exception{
		String sql="update board set view_cout=view_cout+1 where seq=? ";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1, seq);
			ps.executeUpdate();
		}
	}


	//6. getRecordCount()
	public int getRecordCount() throws Exception {
		String sql="select count(*) from board";
		int result=0;

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);){	
			try(ResultSet rs=ps.executeQuery();){
				rs.next();
				result= rs.getInt(1);
				return result;
			}	
		}
	}

	//7. search board seq
	/*	public void updateviewcout(int seq) throws Exception{
			String sql="update board set view_cout=view_cout+1 where seq=? ";

			try(Connection con=this.getConnection();
					PreparedStatement ps=con.prepareStatement(sql);){
				ps.setInt(1, seq);
				ps.executeUpdate();
			}
		}*/


	/*
	public static void main(String[] args) throws SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="servlet";
		String pw="servlet";

		String sql="insert into board values(board_seq.nextval,?,?,?,sysdate,0)";

		try(Connection con= DriverManager.getConnection(url, id, pw);
				PreparedStatement pstat=con.prepareStatement(sql);){
			for(int i=1; i<148; i++) {
				pstat.setString(1, "writer"+i);
				pstat.setString(2, "title"+i);
				pstat.setString(3, "contents"+i);
				pstat.addBatch();
			}
			pstat.executeBatch();
		}
	 */

}
