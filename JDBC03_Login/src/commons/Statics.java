package commons;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.dbcp2.BasicDataSource;

public class Statics {
	public static BasicDataSource bds=new BasicDataSource();
	
	static {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("keduu");
		bds.setPassword("keduu");
		bds.setInitialSize(20);
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
