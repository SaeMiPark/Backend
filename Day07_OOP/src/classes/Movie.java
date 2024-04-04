package classes;

public class Movie {
	//new를 했을 때 셋팅하는 값
	private String platform="영화관";
	private String title;
	private String genre;
	
	public Movie() {
		
	}
	
	//생성자
	public Movie(String platform, String title, String genre) {
		this.platform=platform;
		this.title=title;
		this.genre=genre;
	}
	
	//setter 값을 받아서 셋팅하는
	public void setPlatform(String platform) {
		this.platform=platform;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setGenre(String genre) {
		this.genre=genre;
	}
	
	//getter 값을 가져와주는 
	public String getPlatform() {
		return this.platform;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	
	

}
