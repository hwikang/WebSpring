package kr.goott.webapp.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import kr.goott.webapp.Constants;

public class BoardDAO implements BoardDAOService {
	public JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public BoardDAO() {
		template= Constants.template;
	}

	@Override
	public List<BoardVO> getAllSelect() {
		String sql ="select * from freeboard";
		//query() 메소드 - 레코드선택->컬렉션으로 리턴
		
		return template.query(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}

	@Override
	public int boardInsert(final BoardVO vo) {
		String sql = "insert into freeboard values(boardsq.nextval,?,?,?,0,?,sysdate)";
		
		return template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getUserid());
				ps.setString(2, vo.getTitle());
				ps.setString(3, vo.getContent());
				ps.setString(4, vo.getIp());
				System.out.println("=================="+vo.getTitle());
			}
		});
	}

	@Override
	public BoardVO getSelect(int recordNo) {
		String sql = "select recordNo,userid,title,content,regdate,hit from freeboard where recordNo = ?";
		
		//return template.queryForObject(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));  ?처리
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class),recordNo);
		
	}

	@Override
	public int updateRecord(final BoardVO vo) {
		String sql = "update freeboard set title=? , content=?,ip=? where recordno=?";
		
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getContent());
				ps.setString(3, vo.getIp());
				ps.setInt(4,vo.getRecordNo());
				
			}
		});
	}

	@Override
	public int deleteRecord(int recordNo) {
		String sql = "delete from freeboard where recordno="+recordNo;
		
		return template.update(sql);
	}
	
	//조회수
		public void hitCount(final int recordNo) {
			String sql = "update freeboard set hit = hit+1 where recordNo=?";
			
			template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// 쿼리문에 ? 셋팅
					//PreparedStatementSetter에서 사용하는 변수는 final변수
					ps.setInt(1, recordNo);
				}
			});
		}
		
	//댓글
	public List<BoardReplyVO> getReplySelect(final int recordNo){
		String sql = "select replyNo,recordNo, userid,replyContent from freeboardreply where recordno =?";
		return template.query(sql, new BeanPropertyRowMapper<BoardReplyVO>(BoardReplyVO.class),recordNo);
	}
	public List<BoardReplyVO> replyInsert(final BoardReplyVO vo){
		String sql = "insert into freeboardreply values(replysq.nextVal,?,?,?,?,sysdate)";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, vo.getRecordNo());
				ps.setString(2, vo.getUserid());
				ps.setString(3, vo.getReplyContent());
				ps.setString(4, vo.getIp());
			}
			
		});
		return getReplySelect(vo.getRecordNo());
	}
	
	
	
}
