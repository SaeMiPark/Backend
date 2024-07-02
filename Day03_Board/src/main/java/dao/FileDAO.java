package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.FileDTO;

public class FileDAO {
	// singletone
	private FileDAO() {
	}

	public static FileDAO instance;

	public synchronized static FileDAO getInstance() {
		if (instance == null) {
			instance = new FileDAO();
		}
		return instance;
	}

	// JNDI
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	// 1. 글 추가하기 insert
	public int insert(FileDTO dto) throws Exception {
		String sql = "insert into files values(files_seq.nextval,?,?,?)";
		try (Connection con = this.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, dto.getOriname());
			ps.setString(2, dto.getSysname());
			ps.setInt(3, dto.getParent_seq());
			return ps.executeUpdate();
		}
	}

	//2. 전체 출력 select
	public ArrayList<FileDTO> selectAll() throws Exception{
		String sql="select * from files order by 1";

		try(Connection con=this.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();){
			ArrayList<FileDTO> list=new ArrayList<FileDTO>();
			while(rs.next()){
				int seq=rs.getInt(1);
				String oriname=rs.getString(2);
				String sysname=rs.getString(3);
				int parent_seq=rs.getInt(4);

				list.add(new FileDTO(seq, oriname, sysname, parent_seq));

			}
			return list;
		}
	}

	//3. 보드에 포함된 file 가져오기
	public FileDTO selectByParentSeq(int boardseq) throws Exception{
		String sql="select * from files where parent_seq=?";

		try(Connection con=this.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1,boardseq);
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					int seq=rs.getInt(1);
					String oriname=rs.getString(2);
					String sysname=rs.getString(3);
					int parent_seq=rs.getInt(4);

					return new FileDTO(seq, oriname, sysname, parent_seq);

				}
				return null;
			}
		}
	}


}
