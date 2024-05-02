package commons;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.dbcp2.BasicDataSource;

public class Statics {
	public static BasicDataSource bds=new BasicDataSource();
	
	static {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kedu01");
		bds.setPassword("kedu01");
		bds.setInitialSize(20); //만들어 놓을 커넥션 사이즈
		
	}
	
	public static String getSHA512(String input){
		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	

}
