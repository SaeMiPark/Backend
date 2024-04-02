
public class Exam02 {
	public static void main(String[] args) {
		String str="Hello Java World";
		int num=str.length();
		System.out.println(num);
		
		char c=str.charAt(0);
		System.out.println(c);
		
		
//어떤 문자열로 시작하는지 확인해 boolean으로 알려 주는 함수
		System.out.println(str.startsWith("Ho"));
		System.out.println(str.endsWith("abc"));
//문자열 안에 자바라는 단어가 포함되는지 알고 싶다면?
		System.out.println(str.contains("rld"));
	
		String str2="ABCED";
		char[] arr=str2.toCharArray();
		System.out.println(arr[0]);
		
		String str3="Apple#Orange#Strawberry";
		String[] fruits=str3.split("#");
		System.out.println(fruits[0]);
	}
}
