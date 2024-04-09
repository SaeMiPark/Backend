import java.util.ArrayList;

public class Exam02 {
	public static void main(String[] args) {
		//초기화, 타입지정 필요 없다.
		ArrayList arr=new ArrayList();
		//삽입
		arr.add("Hello");
		arr.add("WOrld");
		arr.add("java");
		arr.add(10);
		arr.add(3.14);
		
		//<스트링> 제너릭 에레이 리스트
		ArrayList<String> strarr=new ArrayList<>();
		
		
		//출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		//삭제
		arr.remove(0);
		
		System.out.println("======");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		
		//비순차적 삽입
		arr.add(1, "Collection");
		System.out.println("======");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		
		
		System.out.println(arr.size());
	}

}
