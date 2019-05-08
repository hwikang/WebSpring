package kr.goott.webapp.board;

import java.util.List;

public interface BoardDAOService {
	//��ü����
	public List<BoardVO> getAllSelect();
	//�߰�
	public int boardInsert(BoardVO vo);
	//����
	public BoardVO getSelect(int recordNo);
	//����
	public int updateRecord(BoardVO vo);
	//����
	public int deleteRecord(int recordNo);
	
}
