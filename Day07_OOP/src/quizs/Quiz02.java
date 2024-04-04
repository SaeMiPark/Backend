package quizs;
import classes.Movie;

public class Quiz02 {
	public static void main(String[] args) {
		
	//초기화 값 설정하는 인스턴스 1개
	Movie movie1=new Movie("Netflix","범죄도시3","액션/코미디");
	Movie movie2=new Movie();
	Movie movie3=new Movie(null,null,null);
	//생성자 하나 더 만들던지, null값으로 셋팅하던지
	
	movie2.setPlatform("tiving");
	movie2.setTitle("파묘");
	movie2.setGenre("스릴러");
	
	movie3.setPlatform("tiving");
	movie3.setTitle("파묘");
	movie3.setGenre("스릴러");
	
	System.out.println(movie1.getPlatform()+movie1.getTitle()+movie1.getGenre());
	System.out.println(movie2.getPlatform()+movie2.getTitle()+movie2.getGenre());
	System.out.println(movie3.getPlatform()+movie3.getTitle()+movie3.getGenre());
	}
	
}
