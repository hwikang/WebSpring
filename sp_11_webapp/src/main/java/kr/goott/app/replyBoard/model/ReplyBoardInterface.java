
package kr.goott.app.replyBoard.model;

import java.util.List;

public interface ReplyBoardInterface {
	//글쓰기
	public int insertRecord(ReplyBoardVO vo);
	//글목록
	public List<ReplyBoardVO> replySelectAll();
	//글수정
	public int replyEdit(ReplyBoardVO vo);
	//글삭제
	public int replyDelete(int regNum);
	//답글쓰기
	public int replyInsert(ReplyBoardVO vo);
	//글선택
	public ReplyBoardVO replySelect(int regNum);
	//조회수
	public void hitCount(int regNum);
	//답글삭제
	//총 레코드수
	public int totalRecord();

	
}
