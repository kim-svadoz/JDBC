package jdbc.board.exam;

import java.sql.Date;

public class BoardDTO {
	private int boardNum;
	private String id;
	private String title;
	private String Content;
	private Date writeDate;
	private int hit;
	public BoardDTO() {
		
	}

	// insert 용도
	public BoardDTO(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		Content = content;
	}
	
	public BoardDTO(String title) {
		super();
		this.title = title;
	}
	
	

	// select 용도
	public BoardDTO(int boardNum, String id, String title, String content, Date writeDate, int hit) {
		super();
		this.boardNum = boardNum;
		this.id = id;
		this.title = title;
		Content = content;
		this.writeDate = writeDate;
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", id=" + id + ", title=" + title + ", Content=" + Content
				+ ", writeDate=" + writeDate + ", hit=" + hit + "]";
	}

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
}
