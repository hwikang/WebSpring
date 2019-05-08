package kr.goott.web.board;

import java.util.List;

public interface BoardDAOInterface {
	//��ü��ϼ���
	public List<BoardVO> selectAll();
	//�ۼ���
	public BoardVO selectOne(int recordNo);
	//����
	public int updateRecord(BoardVO vo);
	//����
	public int deleteRecord();
	
	//����
	public int insertRecord(BoardVO vo);
	//��ȸ�� ����
}
