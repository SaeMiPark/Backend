package dto;

import java.sql.Timestamp;

public class MovieDTO {
	private int id;
	private String title;
	private String genre;
	private Timestamp opendate;
	
	public MovieDTO() {}
	
	public MovieDTO(int id, String title, String genre, Timestamp opendate) {
		this.id=id;
		this.title=title;
		this.genre=genre;
		this.opendate=opendate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Timestamp getOpendate() {
		return opendate;
	}
	public void setOpendate(Timestamp opendate) {
		this.opendate = opendate;
	}

}
