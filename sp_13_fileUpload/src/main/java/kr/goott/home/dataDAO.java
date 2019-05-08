package kr.goott.home;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class dataDAO {
	
	public JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public dataDAO() {
		template = Constant.template;
		
	}
	
	public int insertRecord(final dataVO vo) {
		String sql ="insert into data values(boardsq.nextval,?,?,?,?,sysdate,0)";
		
		return template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				System.out.println(vo.getFilename());
				ps.setString(1, vo.getUserid());
				ps.setString(2, vo.getTitle());
				ps.setString(3, vo.getFilename());
				ps.setString(4, vo.getFilename2());
				
				
			}
		});
	}
	
	public List<dataVO> addSellect(){
		String sql  ="select * from data order by recordNo desc";
		return template.query(sql, new BeanPropertyRowMapper<dataVO>(dataVO.class));
	}
	
	public void downCount(final int recordNo) {
		String sql ="update data set downcount = downcount+1 where recordno =?";
		template.update(sql , new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, recordNo);
				
			}
		});
	}
	
}
