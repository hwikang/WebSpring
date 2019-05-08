package kr.goott.home;

public class dataVO {
	private int recordNo;
	private String userid;
	private String title;
	private String filename;
	private String filename2;
	private String regdate;
	private int downCount;
	private String[] newFilename3;
	
	public String[] getNewFilename3() {
		return newFilename3;
	}
	public void setNewFilename3(String[] newFilename3) {
		this.newFilename3 = newFilename3;
		filename = newFilename3[0];
		filename2 = newFilename3[1];
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilename2() {
		return filename2;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getDownCount() {
		return downCount;
	}
	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}
	
	
}
