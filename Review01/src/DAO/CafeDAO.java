package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.CafeDTO;

public class CafeDAO{
	String dbURL="jdbc:oracle:thin:@localhost:1521:xe"; 
	String dbID="keduu";
	String dbPW="keduu";

	//WrapperMethod
	//여기오면 DBMS 세션만큼 생기게 된다.
	//커넥션 함수를 따로 만들자
	private Connection getConnection() throws Exception{
		return DriverManager.getConnection(dbURL,dbID,dbPW);
	}


	//추가 기능-insert
	public int adddto(CafeDTO dto) throws Exception {
		String sql="insert into cafe values(cafe_seq.nextval,'"+dto.getName()+"',"+dto.getPrice()+")";
		//지역변수여야지 동시접속자 수를 줄일 수 있다.
		try(Connection con=this.getConnection();
			Statement stat=con.createStatement();){
			//보안이 취약하다
			//statement 종류가 여러가지다.->공통코드라고 할 수 없다.
			int result =stat.executeUpdate(sql);
			return result;
		}
		//dtos.add(dto);
		//con이 함수 밖이라면 공유하는 변수이기 때문에 여기서 닫으면 닫은 걸 모두 공유하게 된다.
		//인스턴스가 생성될 때 con은 한번만 실행된다.
	}

	//전체 목록 출력-select
	public List<CafeDTO> selectAll() throws Exception {
		String sql="select * from cafe order by 1";	
		try(Connection con=DriverManager.getConnection(dbURL, dbPW, dbID);
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);){
			
			List<CafeDTO> list=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				list.add(new CafeDTO(id,name,price));
			}
			return list;
		}
	}

	//이름으로 메뉴 검색-select
	public ArrayList<CafeDTO> searchByName(String searchname) throws Exception{
		String sql="select * from cafe where name like '%"+searchname+"%'";	
		
		try(Connection con=this.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);){
			
			ArrayList<CafeDTO> findlist=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				findlist.add(new CafeDTO(id,name,price));
			}
			return findlist;	
		}
	}


	//메뉴 삭제-delete
	public int deleteById(int deleteid) throws Exception {
		String sql="delete from cafe where id ="+deleteid;
		try(Connection con=this.getConnection();
			Statement stat=con.createStatement();){
			int result=stat.executeUpdate(sql);
			return result;
		}

	}

	//메뉴 수정-update
	public int updateById(int modifyid, String name, int price) throws Exception {
		String sql="update cafe set name='"+name+"', price="+price+" where id="+modifyid;
		try(Connection con= this.getConnection();
			Statement stat=con.createStatement();){
			int result=stat.executeUpdate(sql);
			return result;
		}

	}

	//id 중복 체크
	public boolean isIdExist(int id) throws Exception {
		String sql="select * from cafe where id="+id;
		try(Connection con=this.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);){	
			boolean result=rs.next();
			return result;	
		}
	}

}

