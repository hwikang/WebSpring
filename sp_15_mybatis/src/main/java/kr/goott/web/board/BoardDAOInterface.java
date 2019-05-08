package kr.goott.web.board;

import java.util.List;

public interface BoardDAOInterface {
	//전체목록선택
	public List<BoardVO> selectAll();
	//글선택
	public BoardVO selectOne(int recordNo);
	//수정
	public int updateRecord(BoardVO vo);
	//삭제
	public int deleteRecord();
	
	//쓰기
	public int insertRecord(BoardVO vo);
	//조회수 증가
}
