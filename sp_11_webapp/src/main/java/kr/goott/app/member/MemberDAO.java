package kr.goott.app.member;

import kr.goott.app.DBCP;

public class MemberDAO extends DBCP{
	public MemberDAO() {
		
	}
	public static MemberDAO getInstance() {
		return new MemberDAO();
	}
	
	//·Î±×ÀÎ
	public void loginCheck(MemberVO vo) {
		try {
			getConn();
			String sql ="select userpwd , username from register where userid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUsername(rs.getString("username"));
				vo.setLogStatus("Y");
			}else {
				System.out.println("id error");
				vo.setLogStatus("N");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			getClose();
		}
	}
}
