package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import config.ServerInfo;

public class FootBallDAOImpl2 implements FootballDAO {
	private DataSource ds; 
	
	// singletone
	private static FootBallDAOImpl2 dao = new FootBallDAOImpl2();
	private FootBallDAOImpl2 () {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		//ds = DataSourceManager.getInstance().getDataSource(); 
	}
	public static FootBallDAOImpl2 getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		try {
			
			conn= DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
		return conn;
		//return ds.getConnection();
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
		ResultSet rs3 = null;
		UserVO uVo = null;
		PlayerInfoVO pVo= null;
		ArrayList<TeamMemberVO> tVoList = new ArrayList<>();
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
					pVo = new PlayerInfoVO(userId, rs2.getString("position"),rs2.getString("mainFoot") , rs2.getInt("height"), rs2.getInt("weight"), rs2.getInt("injury"), rs2.getInt("mental"), rs2.getInt("speed"), rs2.getInt("physical"), rs2.getInt("dribble"), rs2.getInt("pass"), rs2.getInt("defence"), rs2.getInt("total"));
					uVo.setpVo(pVo);
					
				}
				String query3 = "SELECT * FROM teammember WHERE userId=?";
				ps = conn.prepareStatement(query3);
				ps.setString(1, userId);
				rs3 = ps.executeQuery();
				while(rs3.next()) {
					tVoList.add(new TeamMemberVO(rs3.getString("userId"), rs3.getInt("teamId"), rs3.getString("regDate"), rs3.getInt("manager"), rs3.getFloat("participation"), rs3.getInt("status"))); 
				}
				uVo.settVoList(tVoList);			
			}
			
		} finally {
			closeAll(rs1, ps, conn);
		}
		return uVo;
	}
	@Override
	public ArrayList<MatchVO> recommendSquad(VoteVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void makeVote(VoteVO vVo, MatchVO mVo) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				String query = "insert into vote (contents, dueDate, teamId, matchId) values(";
				
			}finally{
				
			}
		
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

		return null;
	}
	@Override
	public ArrayList<MatchVO> userSchedule(String userId) throws SQLException {

		return null;
	}
	@Override
	public void deleteUser(String userId, String pass) throws SQLException {//지워졌을 때랑 지워지지 않았을때, 로그인 로직으로 갈것인지, 실패 했을때랑 성공햇을 때 리턴값을 가지고 갈것인지.
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
		conn = getConnection();
			String query = "delete from user where userId = ? and pass =?";
			ps= conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, pass);
			System.out.println(ps.executeUpdate()+"명 삭제 하였습니다.");			
			
		}finally {
			closeAll(ps, conn);
		}
	}
	@Override
	public void deleteTeam(String teamId, String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
		conn = getConnection();
			String query = "delete from team where teamId = ? and teamName =?";
			ps= conn.prepareStatement(query);
			ps.setString(1, teamId);
			ps.setString(2, teamName);
			System.out.println(ps.executeUpdate()+"팀 삭제 하였습니다.");			
			
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void updateUser(UserVO uVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query1 = "update user set pass=?, phoneNum =?, photo=?, nickName=?, email=?, addr=?, favTeam1=?, favTeam2=? where userId =?";
			ps = conn.prepareStatement(query1);

			ps.setString(1, uVo.getPass());
			ps.setString(2, uVo.getPhoneNum());
			ps.setString(3, uVo.getPhoto());
			ps.setString(4, uVo.getNickName());
			ps.setString(5, uVo.getEmail());
			ps.setString(6, uVo.getAddr());
			ps.setString(7, uVo.getFavTeam1());
			ps.setString(8, uVo.getFavTeam2());
			ps.setString(9, uVo.getUserId());
			
			System.out.println(ps.executeUpdate() + "명 수정 성공1_!!");

			String query2 = "update playerinfo set Position=?, MainFoot =?, Height=?, Weight=?, Injury=?, Mental=?, Speed=?, Physical=?, Dribble=?, Pass=?, Defence=?, Total=? where userId =?";
			
			ps=conn.prepareStatement(query2);
			ps.setString(1, uVo.getpVo().getPosition());
			ps.setString(2, uVo.getpVo().getMainFoot());
			ps.setInt(3, uVo.getpVo().getHeight());
			ps.setInt(4, uVo.getpVo().getWeight());
			ps.setInt(5, uVo.getpVo().getInjury());
			ps.setInt(6, uVo.getpVo().getMental());
			ps.setInt(7, uVo.getpVo().getSpeed());
			ps.setInt(8, uVo.getpVo().getPhysical());
			ps.setInt(9, uVo.getpVo().getDribble());
			ps.setInt(10, uVo.getpVo().getPass());
			ps.setInt(11, uVo.getpVo().getDefence());
			ps.setInt(12, uVo.getpVo().getTotal());
			ps.setString(13, uVo.getpVo().getUserId());
			
			System.out.println(ps.executeUpdate() + "명 수정 성공2_!!");
			
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
			String query = "update team set emblem=?, area1=?, area2=?, area3=?, stadiumId=? where teamId =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, tVo.getEmblem());
			ps.setString(2, tVo.getArea1());
			ps.setString(3, tVo.getArea2());
			ps.setString(4, tVo.getArea3());
			ps.setInt(5, tVo.getStadiumId());
			ps.setInt(6, tVo.getTeamId());
			System.out.println(ps.executeUpdate() + "팀 수정 성공!!");
		} finally {
			closeAll(ps, conn);
		}
	}
public static void main(String[] args) throws SQLException {
	FootBallDAOImpl2 dao = FootBallDAOImpl2.getInstance();
	
	//DriverManager 방식의 DB Connection

	
	
	/*//login
	UserVO vo = dao.login("111", "111");
	System.out.println(vo);*/
	
	/*///delete
	dao.deleteUser("111", "111");
	dao.deleteTeam("1", "1");*/
	
	
	// update
	UserVO uVo = new UserVO("111", "111", "111", "img/111.jpg", "이재헌", "111@111.com", "답십리", "바르셀로나", "레알마드리드", new PlayerInfoVO("111", "LWF", "왼발", 190, 80, 1, 80, 80, 80, 80, 80, 80, 0));
	dao.updateUser(uVo);
	
	

	
	//dao.method();
}
}
