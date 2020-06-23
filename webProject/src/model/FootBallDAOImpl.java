package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import config.ServerInfo;
import controller.ModelAndView;
import util.DataSourceManager;

public class FootBallDAOImpl implements FootballDAO {
	private DataSource ds; 
	
	// singletone
	private static FootBallDAOImpl dao = new FootBallDAOImpl();
	private FootBallDAOImpl () {
		ds = DataSourceManager.getInstance().getDataSource(); 
	}
	public static FootBallDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}
	
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	// Business Logics
	
	
	
	// for unit test
	/*public void main(String[] args) {
		SoccerDAOImpl dao = SoccerDAOImpl.getInstance();
		
		//DriverManager 방식의 DB Connection
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		try {
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
		//dao.method();
	}*/
}
