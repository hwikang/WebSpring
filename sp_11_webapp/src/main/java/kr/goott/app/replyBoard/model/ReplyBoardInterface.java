
package kr.goott.app.replyBoard.model;

import java.util.List;

public interface ReplyBoardInterface {
	//�۾���
	public int insertRecord(ReplyBoardVO vo);
	//�۸��
	public List<ReplyBoardVO> replySelectAll();
	//�ۼ���
	public int replyEdit(ReplyBoardVO vo);
	//�ۻ���
	public int replyDelete(int regNum);
	//��۾���
	public int replyInsert(ReplyBoardVO vo);
	//�ۼ���
	public ReplyBoardVO replySelect(int regNum);
	//��ȸ��
	public void hitCount(int regNum);
	//��ۻ���
	//�� ���ڵ��
	public int totalRecord();

	
}
