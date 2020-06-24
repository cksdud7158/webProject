package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.sql.DataSource;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import servlet.model.MemberVO;
import util.DataSourceManager;

public class FootBallDAOImpl1 implements FootballDAO {
	private DataSource ds; 
	
	// singletone
	private static FootBallDAOImpl1 dao = new FootBallDAOImpl1();
	private FootBallDAOImpl1 () {
		ds = DataSourceManager.getInstance().getDataSource(); 
	}
	public static FootBallDAOImpl1 getInstance() {
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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		int flag = 1; // 요청 상태  : 1, 가입 상태 : 0

		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));

		try {
			conn = getConnection();
			String query = "INSERT INTO teammemberId (teammemberId, regDate, manager, participation, status, userId, teamId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, tVo.getTeamId());
			ps.setString(2, str);
			ps.setInt(3, tVo.getManager());
			ps.setFloat(4, tVo.getParticipation());
			ps.setFloat(5, tVo.getStatus());
			ps.setString(6, pVo.getUserId());
			ps.setString(7, tVo.getTeamId());
			
			rs = ps.executeQuery();
			
			flag = tVo.getStatus();
			
			if(flag == 1) {
				query = "DELETE FROM teammember WHERE id = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, pVo.getUserId());
				rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("this user has been deleted...");
				} 
			}
			else {
				time = System.currentTimeMillis(); 
				dayTime = new SimpleDateFormat("yyyy-MM-dd");
				str = dayTime.format(new Date(time));
				query = "UPDATE teammember SET regDate = ?, status = ? WHERE userId = ?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, str);
				ps.setFloat(2, flag);
				ps.setString(3, pVo.getUserId());
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					System.out.println("this user has been added...");
				}
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public int allowToJoin(PlayerInfoVO pVo, TeamMemberVO tVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PlayerInfoVO vo = new PlayerInfoVO();
		
		// 임시로 해둔 것
		Scanner sc = new Scanner(System.in);
		
		int flag = 1;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM playerinfo WHERE userid = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, pVo.getUserId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new PlayerInfoVO(rs.getString("userId"), rs.getString("position"), rs.getString("mainFoot"), rs.getInt("height"), rs.getInt("weight"), rs.getInt("injury"), rs.getInt("mental"), rs.getInt("speed"), rs.getInt("physical"), rs.getInt("dribble"), rs.getInt("pass"), rs.getInt("defence"), rs.getInt("total"));
			}
			
			System.out.println(rs.getString("uesrId") + " | Do you want to accept this user as a team member (true/false)?");
			boolean input = sc.nextBoolean();
			
			if(input) {
				flag = 0;
				return flag;
			}
			else
				return flag;
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public int rejectToJoin(PlayerInfoVO pVo, TeamMemberVO tVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PlayerInfoVO vo = new PlayerInfoVO();
		
		// 임시로 해둔 것
		Scanner sc = new Scanner(System.in);
		
		int flag = 1;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM playerinfo WHERE userid = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, pVo.getUserId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new PlayerInfoVO(rs.getString("userId"), rs.getString("position"), rs.getString("mainFoot"), rs.getInt("height"), rs.getInt("weight"), rs.getInt("injury"), rs.getInt("mental"), rs.getInt("speed"), rs.getInt("physical"), rs.getInt("dribble"), rs.getInt("pass"), rs.getInt("defence"), rs.getInt("total"));
			}
			
			System.out.println(rs.getString("uesrId") + " | Do you want to accept this user as a team member (true/false)?");
			boolean input = sc.nextBoolean();
			
			if(input) {
				flag = 0;
				return flag;
			}
			else
				return flag;
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public void makeTeam(TeamVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean flag = true;
		
		try {
			conn = getConnection();
			String query = "SELECT teamName From team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				if(rs.getString("teamName").equals(vo.getTeamName())) 
					flag = false;
			}
			
			if(flag) {
				query = "INSERT INTO team (teamId, teamName, emblem, area1, area2, area3, stadiumId) VALUES(?, ?, ?, ?, ?, ?, ?)";
				ps.setString(1, vo.getTeamId());
				ps.setString(2, vo.getTeamName());
				ps.setString(3, vo.getEmblem());
				ps.setString(4, vo.getArea1());
				ps.setString(5, vo.getArea2());
				ps.setString(6, vo.getArea3());
				ps.setString(7, vo.getStadiumId());
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public ArrayList<UserVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0;

		ArrayList<PlayerInfoVO> player = new ArrayList<PlayerInfoVO>();
		ArrayList<UserVO> user = new ArrayList<UserVO>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM playerinfo";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				player.add(new PlayerInfoVO(rs.getString("userId"), rs.getString("position"), rs.getString("mainFoot"), rs.getInt("height"), rs.getInt("weight"), rs.getInt("injury"), rs.getInt("mental"), rs.getInt("speed"), rs.getInt("physical"), rs.getInt("dribble"), rs.getInt("pass"), rs.getInt("defence"), rs.getInt("total")));
			}
					
			query = "SELECT * FROM user";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {			
				String str = rs.getString("gender");
				UserVO tmp = new UserVO(
						rs.getString("userId"),
						rs.getString("pass"),
						rs.getString("name"),
						rs.getString("phoneNum"),
						rs.getString("photo"),
						rs.getString("ssn"),
						rs.getString("nickName"),
						str.charAt(0),
						rs.getString("email"),
						rs.getString("addr"),
						rs.getString("favTeam1"),
						rs.getString("favTeam2"),
						rs.getString("regDate"),
						rs.getString("country"),
						rs.getString("recentLogin"),
						player.get(count)
						);
				
				user.add(tmp);
				count++;
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return user;
	}
	@Override
	public UserVO findByUserId(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM user";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("userId").equals(userId)) {
					String str = rs.getString("gender");
					vo = new UserVO(rs.getString("userId"), rs.getString("pass"), rs.getString("name"), rs.getString("phoneNum"), rs.getString("photo"), rs.getString("ssn"), rs.getString("nickName"), str.charAt(0), rs.getString("email"), rs.getString("addr"), rs.getString("favTeam1"), rs.getString("favTeam2"), rs.getString("regDate"), rs.getString("country"), rs.getString("recentLogin"));
				}
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	@Override
	public UserVO findByNickName(String nickName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM user";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("nickName").equals(nickName)) {
					String str = rs.getString("gender");
					vo = new UserVO(rs.getString("userId"), rs.getString("pass"), rs.getString("name"), rs.getString("phoneNum"), rs.getString("photo"), rs.getString("ssn"), rs.getString("nickName"), str.charAt(0), rs.getString("email"), rs.getString("addr"), rs.getString("favTeam1"), rs.getString("favTeam2"), rs.getString("regDate"), rs.getString("country"), rs.getString("recentLogin"));
				}
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	@Override
	public TeamVO findByTeamName(String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		TeamVO vo = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("teamName").equals(teamName)) {
					vo = new TeamVO(rs.getInt("teamId"), rs.getString("teamName"), rs.getString("emblem"), rs.getString("area1"), rs.getString("area2"), rs.getString("area3"), rs.getInt("stadiumId"));
				}
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	@Override
	public ArrayList<TeamVO> myTeamList(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<TeamVO> vo = new ArrayList<TeamVO>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM user";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	@Override
	public ArrayList<MatchVO> matchHistory() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<MatchVO> vo = new ArrayList<MatchVO>();
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM match";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo.add(new MatchVO(rs.getInt("matchId"), rs.getString("schedule"), rs.getString("awayId"), rs.getString("homeSquad"), rs.getString("awaySquad"), rs.getInt("teamId"), rs.getInt("voteId")));
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
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
