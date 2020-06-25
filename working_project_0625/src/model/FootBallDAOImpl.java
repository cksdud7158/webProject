package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import servlet.model.MemberVO;
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
		ResultSet rs = null;
		UserVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(id, password, rs.getString("name"), rs.getString("address"));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return vo;
		return null;
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
