package quiz;

import java.io.Serializable;
import java.util.Date;

public class MovieDTO implements Serializable{
	private String id;
	private String title;
	private String genre;
	private Date date;
	
	//생성자
	public MovieDTO() {};
	public MovieDTO(String id, String title, String genre, Date date) {
		this.id=id;
		this.title=title;
		this.genre=genre;
		this.date=date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
