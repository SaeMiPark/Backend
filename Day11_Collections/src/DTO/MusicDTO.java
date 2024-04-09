package DTO;

import java.util.Date;

public class MusicDTO {
	private String id, title, singer;
	private Date writedate=new Date();
	
	//생성자
	public MusicDTO(){};
	
	public MusicDTO(String id, String title, String singer, Date writedate) {
		this.id=id;
		this.title=title;
		this.singer=singer;
		this.writedate=writedate;
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

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public Date getDate() {
		return writedate;
	}

	public void setDate(Date writedate) {
		this.writedate = writedate;
	}
	

}
