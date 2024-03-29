
public class Quiz02 {
	public static void main(String[] args) {
		byte b=10;
		short s=20;
		char c='A';
		int i;
		float f;
		long l=100L;
		
		s=b;
		c=(char)b; //대소관계 일치 하지 않다.
		//byte에 음수가 있었으면 짤릴 것. char은 음수가 없다.
		
		s=(short)c; //32767이상 짤림
		c=(char)s; //음수 짤림
		i=(int)100L; //캐스팅
		l=500;
		f=l; //실수형은 항상 정수형보다 크다.
		
		f=5.11f;
		
		//5.11==double
		//자바에서 실수만 입력하면 무조건 double
		
	}

}
