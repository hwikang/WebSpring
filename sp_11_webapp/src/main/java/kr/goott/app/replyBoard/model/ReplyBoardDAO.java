package kr.goott.app.replyBoard.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.goott.app.DBCP;

public class ReplyBoardDAO extends DBCP implements ReplyBoardInterface {

	public ReplyBoardDAO() {}
	public static ReplyBoardDAO getInstance() {
		return new ReplyBoardDAO();
	}
	@Override
	public int insertRecord(ReplyBoardVO vo) {
		int cnt =0;
		try {
			getConn();
			String sql = "insert into replyboard values(boardsq.nextval,?,?,?,0,sysdate,boardsq.currval,1,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContent());
			
			System.out.println(vo.getWriter());
			System.out.println(vo.getSubject());
			System.out.println(vo.getContent());
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert record error");
		}finally {
			getClose();
		}
		return cnt;
	}

	@Override
	public List<ReplyBoardVO> replySelectAll() {
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		try {
			getConn();
			String sql = "select * from replyboard order by ref desc, step asc";
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				ReplyBoardVO vo =new ReplyBoardVO();
				vo.setRegNum(rs.getInt("regnum"));
				vo.setWriter(rs.getString("writer"));
				vo.setSubject(rs.getString("subject"));
				vo.setHit(rs.getInt("hit"));
				vo.setRegDate(rs.getString("regdate"));
				vo.setLev(rs.getInt("lev"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select list error");
		}finally{
			getClose();
		}
		return list;
	}

	@Override
	public int replyEdit(ReplyBoardVO vo) {
		int cnt =0;
		try {
			getConn();
			String sql = "update replyboard set subject =? , content =? where regNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getRegNum());
			cnt = pstmt.executeUpdate();
			System.out.println(vo.getContent());
			System.out.println(vo.getRegNum());
			System.out.println(cnt);
		} catch (Exception e) {
			e.getMessage();
			
		}finally {
			getClose();
		}
		return cnt;
	}

	@Override
	public int replyDelete(int regNum) {
		int cnt= 0;
		try {
			getConn();
			String sql = "update replyboard set subject='삭제된글입니다', content='삭제된글입니다'  where regNum=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regNum);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			getClose();
		}
		return cnt;
	}

	@Override
	public int replyInsert(ReplyBoardVO vo) {
		int cnt =0;
		try {
			getConn();
			conn.setAutoCommit(false); //자동 커밋 해제
			//원 글의 ref 와 step level 불러옴
			String sql = "select ref, step,lev from replyboard where regNum=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRegNum());
			rs = pstmt.executeQuery();   //원래 이때 바로 커밋됨
			if(rs.next()) {
				vo.setRef(rs.getInt("ref"));
				vo.setStep(rs.getInt("step"));
				vo.setLev(rs.getInt("lev"));
			}else {  //원글ㅇ ㅣ지워졌거나 없을때
				throw new Exception();  //강제 예외발생
			}
			
			//원글의 step 보다 큰 step(이미존재하는 대댓글) 은 step를 1씩증가, ref 가같은애들만.
			sql = "update replyboard set step=step+1 where ref=? and step >?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRef());
			pstmt.setInt(2, vo.getStep());
			pstmt.executeUpdate();
			
			//답글 추가
			sql = "insert into replyboard values(boardsq.nextval,?,?,?,0,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getRef());
			pstmt.setInt(5, vo.getStep()+1);
			pstmt.setInt(6, vo.getLev()+1);
			cnt = pstmt.executeUpdate();
			if(cnt>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getClose();
		}
		return cnt;
	}

	@Override
	public ReplyBoardVO replySelect(int regNum) {
		ReplyBoardVO vo = new ReplyBoardVO();
		try {
			getConn();
			String sql = "select * from replyboard where regnum=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, regNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setRegNum(rs.getInt("regnum"));
				vo.setWriter(rs.getString("writer"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setRegDate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select reply error");
		}finally {
			getClose();
		}
		return vo;
	}

	@Override
	public void hitCount(int regNum) {
		int cnt =0;
		try {
			getConn();
			String sql = "update replyboard set hit = hit +1 where regnum =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regNum);
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("count raise error");
		}finally {
			getClose();
		}

	}
	@Override
	public int totalRecord() {
		int totalRecord=0;
		try {
			getConn();
			String sql = "select count(regNum) from replyboard";
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				totalRecord= rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return totalRecord;
	}

}
