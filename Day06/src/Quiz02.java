
public class Quiz02 {
	
	
	//문자열 안에서 대문자 A가 몇 개인가?
	public static int countA(String str) {
		int count=0;
		char[] arr=str.toCharArray();
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='A') count++;
		}
		return count;
	}
	
	public static int countA2(String str) {
		int count=0;
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if(ch=='A') count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str="AlkfjaoiwjflikA::KSD2781"
				+"LKDJIFJWEkfjdkahkdj"
				+"djklafjeldjfIHDKHHGK"
				+"AAAAAAA";
		
		int count=countA(str);
		System.out.println(count);
	}

}
