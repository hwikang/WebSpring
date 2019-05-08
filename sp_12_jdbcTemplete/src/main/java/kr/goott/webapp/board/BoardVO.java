package kr.goott.webapp.board;

public class BoardVO {
	private int recordNo;
	private String userid;
	private String title;
	private String content;
	private int hit;
	private String ip;
	private String regdate;
	//페이징 필요한 변수
	private int num = 1;//현재 페이지 
	private int totalRecord=0;//총 레코드 수
	private int totalPage=1;//총 페이지 수
	private int onePageRecord=5;//1page당 표시할 레코드 수
	private int startPage =1;//시작 페이지
	private int pageNumCount=5;//한번에 출력할 페이지 번호 수
	//검색어, 검색키
	private String searchKey = null;
	private String searchWord = null;
	
	public BoardVO() {
		
	}
	
	//toString
	public String toString() {
		String str = "";
		 str += "recordNo="+recordNo;
		 str += ",userid="+userid;
		 str += ",title="+title;
		 str += ",content="+content;
		 str += ",hit="+hit;
		 str += ",ip="+ip;
		 str += ",regdate="+regdate;
		 str += ",num="+num;
		 str += ",totalRecord="+totalRecord;
		 str += ",totalPage="+totalPage;
		 str += ",onePageRecord="+onePageRecord;
		 str += ",startPage="+startPage;
		 str += ",pageNumCount="+pageNumCount;
		 str += ",searchKey="+searchKey;
		 str += "searchWord="+searchWord;
		 System.out.println(str);
		return "";
	}
	
	//getter/setter
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		//시작페이지 num(현재페이지) pageNumCount(한번에 출력할 페이지 수)
		//현재페이지%페이지수 =  
		//  1    %    5  =1 
		// 5    %   5  = 0 
		if(num%pageNumCount==0) { //현재페이지가 5의 배수일때
			startPage = (num/pageNumCount-1)*pageNumCount+1;
		}else {//5의 배수가 아닐때
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//총 페이지수
		totalPage = (int) Math.ceil(totalRecord / (double)onePageRecord);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageNumCount() {
		return pageNumCount;
	}

	public void setPageNumCount(int pageNumCount) {
		this.pageNumCount = pageNumCount;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
}
