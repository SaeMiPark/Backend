package quizs;
import classes.Movie;

public class Quiz03 {
	public static void main(String[] args) {
		
		//무비형 배열만들기
		Movie[] movies=new Movie[2];
		//배열을 heap메모리에 저장한 것.
		//오른쪽은 변수들의 집합이다. 인스턴스 집합X
		//==Movie a, b;
		//movies는 참조변수 스택에 있고 주소값을 갖는다. nullX
		//new Movie[2]는 인스턴스를 만든게 아니라 Movie형 변수를 2개 만든 것이다.
		
		movies[0]=new Movie("Netflix","범죄도시3","액션"); //이때 인스턴스가 생성된다.
		movies[1]=new Movie("MegaBox","파묘","오컬트");
		System.out.println(movies[1].getTitle());
		
	}

}
