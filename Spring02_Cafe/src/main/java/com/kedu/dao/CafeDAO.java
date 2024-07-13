package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.CafeDTO;

@Repository
public class CafeDAO {
	
	@Autowired
	private BasicDataSource bds;
	
	public int insert(CafeDTO dto) throws Exception{
		
		String sql="insert into cafe values(cafe_seq.nextval,?,?)";
		
		try(Connection con=bds.getConnection();
				PreparedStatement ps= con.prepareStatement(sql);){
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPrice());
			return ps.executeUpdate();
		}
		
		
	}

}
