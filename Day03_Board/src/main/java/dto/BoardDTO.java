package dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int seq;
	private String writer;
	private String title;
	private String contents;
	private Timestamp write_date;
	private int view_cout;
	
	public BoardDTO() {};
	
	public BoardDTO(int seq, String writer, String title, String contents, Timestamp write_date, int view_cout) {
		this.seq=seq;
		this.writer=writer;
		this.title=title;
		this.contents=contents;
		this.write_date=write_date;
		this.view_cout=view_cout;
		
	};
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String wrtier) {
		this.writer = wrtier;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getView_cout() {
		return view_cout;
	}
	public void setView_cout(int view_cout) {
		this.view_cout = view_cout;
	}
	
	

}
