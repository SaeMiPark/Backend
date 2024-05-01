package Exam;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Exam01 {
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
	

	public static void main(String[] args) {
		//비밀번호 암호화하기
		
		String text=getSHA512("비밀메세지");
		System.out.println(text);
		

	}

}
