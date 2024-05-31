package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContents());
			ps.setInt(4, dto.getView_cout());
			return ps.executeUpdate();
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
	private int getRecordCount() throws Exception {
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


	public String getPageNavi(int currentPage) throws Exception {
		//페이지 기법
		//1. 전체 글의 갯수
		int recordTotalCount=this.getRecordCount(); //향후 데이터베이스에서 알아와야 하는 값

		//2. 한 페에지에 몇개의 게시글을 보여줄 것인지 결정
		int recordCountPerPage=15;

		//3.Page Navigater 페이지 번호 자체를 몇 개씩 보여줄건지 결정
		int naviCountPerPage=10; //전역변수로 관리할수도

		//4. 1번/2번 필요한 페이지 숫자
		int pageTotalCount= 0;
		if(recordTotalCount%recordCountPerPage>0) {
			pageTotalCount=recordTotalCount/recordCountPerPage+1;
		}else {
			pageTotalCount=recordTotalCount/recordCountPerPage;
		}

		//현재 나의 페이지 위치도 알아야한다. 내가 11페이지면 11~20까지 나와야 할 것
		//int currentPage=11; //향후 클라이언트가 페이지번호를 누르면 인자 값으로 받아야 할 것

		//알고리즘. 내가 볼 범위의 번호를 구해야 한다. 1~10
		//start
		int startNavi=(currentPage-1)/naviCountPerPage*naviCountPerPage+1;
		//end
		int endNavi=startNavi+naviCountPerPage-1;
		if(endNavi>pageTotalCount) {endNavi=pageTotalCount;}

		//화살표 붙이기
		boolean needNext=true;
		boolean needPrev=true;
		//각 화살표 필요없는 경우
		if(startNavi==1) {needPrev=false;}
		if(endNavi==pageTotalCount) {needNext=false;}

		StringBuilder sb=new StringBuilder(); //문자합쳐주는함수

		//출력
		if(needPrev==true) {sb.append("<a href='/list.boards?cpage="+(startNavi-1)+"'> < </a>&nbsp");}

		for(int i=startNavi; i<=endNavi; i++) {
			sb.append("<a href='/list.boards?cpage="+i+"'>"+i+"</a>&nbsp");
		}

		if(needNext==true) {sb.append("<a href='/list.boards?cpage="+(endNavi+1)+"'> > </a>&nbsp");}

		return sb.toString();


	}



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

		//페이지 기법
		//1. 전체 글의 갯수
		int recordTotalCount=310; //향후 데이터베이스에서 알아와야 하는 값

		//2. 한 페에지에 몇개의 게시글을 보여줄 것인지 결정
		int recordCountPerPage=30;

		//3.Page Navigater 페이지 번호 자체를 몇 개씩 보여줄건지 결정
		int naviCountPerPage=10;

		//4. 1번/2번 필요한 페이지 숫자
		int pageTotalCount= 0;
		if(recordTotalCount%recordCountPerPage>0) {
			pageTotalCount=recordTotalCount/recordCountPerPage+1;
		}else {
			pageTotalCount=recordTotalCount/recordCountPerPage;
		}

		//현재 나의 페이지 위치도 알아야한다. 내가 11페이지면 11~20까지 나와야 할 것
		int currentPage=11; //향후 클라이언트가 페이지번호를 누르면 인자 값으로 받아야 할 것

		//알고리즘. 내가 볼 범위의 번호를 구해야 한다. 1~10
		//start
		int startNavi=(currentPage-1)/naviCountPerPage*naviCountPerPage+1;
		//end
		int endNavi=startNavi+naviCountPerPage-1;
		if(endNavi>pageTotalCount) {endNavi=pageTotalCount;}

		//화살표 붙이기
		boolean needNext=true;
		boolean needPrev=true;
		//각 화살표 필요없는 경우
		if(startNavi==1) {needPrev=false;}
		if(endNavi==pageTotalCount) {needNext=false;}


		//출력
		if(needPrev==true) {System.out.print("< ");}
		for(int i=startNavi; i<=endNavi; i++) {
			System.out.print(i+" ");
		}
		if(needNext==true) {System.out.print(" >");}


	}*/

}
