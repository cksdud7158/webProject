package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class FootBallDAOImpl2 implements FootballDAO {
	private DataSource ds; 
	
	// singletone
	private static FootBallDAOImpl2 dao = new FootBallDAOImpl2();
	private FootBallDAOImpl2 () {
		ds = DataSourceManager.getInstance().getDataSource(); 
	}
	public static FootBallDAOImpl2 getInstance() {
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
	@Override
	public void registerUser(UserVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void requestToJoin(PlayerInfoVO pVo, TeamMemberVO tVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void allowToJoin(PlayerInfoVO pVo, TeamMemberVO tVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void rejectToJoin(PlayerInfoVO pVo, TeamMemberVO tVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void makeTeam(TeamVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<UserVO> showAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserVO findByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserVO findByNickName(String nickName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TeamVO findByTeamName(String teamName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<TeamVO> myTeamList(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<MatchVO> matchHistory() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<MatchVO> recommendMatch(String area) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public UserVO login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		UserVO uVo = null;
		PlayerInfoVO pVo= null;
		try {
			conn = getConnection();
			String query1 = "SELECT * FROM user WHERE userId=? AND pass=?";
			ps = conn.prepareStatement(query1);
			ps.setString(1, userId);
			ps.setString(2, password);

			rs1 = ps.executeQuery();
			if (rs1.next()) {
				uVo = new UserVO(rs1.getString("userId"), rs1.getString("pass"), rs1.getString("name"), rs1.getString("phoneNum"), rs1.getString("photo"), rs1.getString("ssn"), rs1.getString("nickName"), rs1.getString("gender").charAt(0), rs1.getString("email"), rs1.getString("addr"), rs1.getString("favTeam1"), rs1.getString("favTeam2"), rs1.getString("regDate"),  rs1.getString("country"), rs1.getString("recentLogin"));
				String query2 = "SELECT * FROM playerinfo WHERE userId=?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, userId);
				rs2=ps.executeQuery();
				if(rs2.next()) {
					pVo = 
					
				}
				
			
			
			}
			
			
			
		} finally {
			closeAll(rs1, ps, conn);
		}
		return vo;
	}
	@Override
	public ArrayList<MatchVO> recommendSquad(VoteVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void makeVote(VoteVO vVo, MatchVO mVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertVoteResult(VoteVO vVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertMatch(MatchVO mVo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertMatchResult(MatchResultVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<MatchVO> TeamSchedule(String teamId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<MatchVO> userSchedule(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteUser(String userId, String pass) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteTeam(String teamId, String teamName) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateUser(UserVO uVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "update member set password=?, name=?, address=? where id =?";
			ps = conn.prepareStatement(query);

			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getId());
			System.out.println(ps.executeUpdate() + "명 수정 성공!!");

		} finally {
			closeAll(ps, conn);
		}		
		
	}
	@Override
	public void updateTeam(TeamVO tVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "update member set password=?, name=?, address=? where id =?";
			ps = conn.prepareStatement(query);

			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getId());
			System.out.println(ps.executeUpdate() + "명 수정 성공!!");

		} finally {
			closeAll(ps, conn);
		}		
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
