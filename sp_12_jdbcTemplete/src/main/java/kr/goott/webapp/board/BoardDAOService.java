package kr.goott.webapp.board;

import java.util.List;

public interface BoardDAOService {
	//전체선택
	public List<BoardVO> getAllSelect();
	//추가
	public int boardInsert(BoardVO vo);
	//선택
	public BoardVO getSelect(int recordNo);
	//수정
	public int updateRecord(BoardVO vo);
	//삭제
	public int deleteRecord(int recordNo);
	
}
