
public class Quiz05 {
	public static void main(String[] args) {
//		int i;
//		
//		for(i=1; i<=10; i++) {
//			System.out.println("i="+i);
//		}
		
//		for(int i=1; i<=10; i++) {
//			if(i==5) {
//				break; //바로 위 반복문 종속
//			}
//			System.out.println(i);
//		}
		
//		for(int i=1; i<=10; i++) {
//			if(i==5) {
//				continue;
//			}
//			System.out.println(i);
//		}
//		//1,2,3,4,6,7,8,9,10 5빼고 출력됨.
		
		for(int i=1; i<=10; i++) {
			if(i==2||i==5) continue;
			System.out.println(i);
			if(i==8) break;
		}
		
	}

}
