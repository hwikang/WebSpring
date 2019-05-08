package kr.goott.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCP {
	protected Connection conn;
	protected PreparedStatement pstmt;	
	protected ResultSet rs;
	
	public DBCP() {
		
	}
	public void getConn() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
			
		} catch (Exception e) {
			System.out.println("db connection error");
			e.printStackTrace();
		}
	}
	public void getClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
			
		} catch (Exception e) {
			System.out.println("db close error");
			e.printStackTrace();
		}
	}
	
}
