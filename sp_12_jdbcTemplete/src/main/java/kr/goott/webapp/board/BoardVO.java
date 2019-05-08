package kr.goott.webapp.board;

public class BoardVO {
	private int recordNo;
	private String userid;
	private String title;
	private String content;
	private int hit;
	private String ip;
	private String regdate;
	//����¡ �ʿ��� ����
	private int num = 1;//���� ������ 
	private int totalRecord=0;//�� ���ڵ� ��
	private int totalPage=1;//�� ������ ��
	private int onePageRecord=5;//1page�� ǥ���� ���ڵ� ��
	private int startPage =1;//���� ������
	private int pageNumCount=5;//�ѹ��� ����� ������ ��ȣ ��
	//�˻���, �˻�Ű
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
		//���������� num(����������) pageNumCount(�ѹ��� ����� ������ ��)
		//����������%�������� =  
		//  1    %    5  =1 
		// 5    %   5  = 0 
		if(num%pageNumCount==0) { //������������ 5�� ����϶�
			startPage = (num/pageNumCount-1)*pageNumCount+1;
		}else {//5�� ����� �ƴҶ�
			startPage = (num/pageNumCount)*pageNumCount+1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		//�� ��������
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
