package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.sql.DataSource;

import config.ServerInfo;
import util.DataSourceManager;

public class FootBallDAOImpl1 implements FootballDAO {
	private DataSource ds; 
	
	// singletone
	private static FootBallDAOImpl1 dao = new FootBallDAOImpl1();
	private FootBallDAOImpl1 () {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		//ds = DataSourceManager.getInstance().getDataSource(); 
	}
	public static FootBallDAOImpl1 getInstance() {
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
		Connection conn = null;
		PreparedStatement ps = null;
		
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));
		System.out.println(str);
		
		try {
			conn = getConnection();
			String query = "INSERT INTO `soccerproject`.`user` (`userId`, `pass`, `name`, `phoneNum`, `photo`, `ssn`, `nickName`, `gender`, `email`, `addr`, `favTeam1`, `favTeam2`, `regDate`, `country`, `recentLogin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getUserId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getPhoneNum());
			ps.setString(5, vo.getPhoto());
			ps.setString(6, vo.getSsn());
			ps.setString(7, vo.getNickName());
			ps.setString(8, String.valueOf(vo.getGender()));
			ps.setString(9, vo.getEmail());
			ps.setString(10, vo.getAddr());
			ps.setString(11, vo.getFavTeam1());
			ps.setString(12, vo.getFavTeam2());
			ps.setString(13, str);
			ps.setString(14, vo.getCountry());
			ps.setString(15, str);
			
			System.out.println(ps.executeUpdate()+"명 user 등록되었습니다.");
		} finally {
			closeAll(ps, conn);
		}
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
			String query = "INSERT INTO teammember (teammemberId, regDate, manager, participation, status, userId, teamId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, tVo.getTeamId());
			ps.setString(2, str);
			ps.setInt(3, tVo.getManager());
			ps.setFloat(4, tVo.getParticipation());
			ps.setInt(5, tVo.getStatus());
			ps.setString(6, pVo.getUserId());
			ps.setInt(7, tVo.getTeamId());
			
			rs = ps.executeQuery();
			
			flag = tVo.getStatus();
			
			if(flag == 1) {
				query = "DELETE FROM teammember WHERE userId = ?";
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
				ps.setInt(2, flag);
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
			String query = "SELECT * FROM playerinfo WHERE userId = ?";
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
			String query = "SELECT * FROM playerinfo WHERE userId = ?";
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
				ps.setInt(1, vo.getTeamId());
				ps.setString(2, vo.getTeamName());
				ps.setString(3, vo.getEmblem());
				ps.setString(4, vo.getArea1());
				ps.setString(5, vo.getArea2());
				ps.setString(6, vo.getArea3());
				ps.setInt(7, vo.getStadiumId());
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public ArrayList<UserVO> showAllMember(String teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		int count = 0;

		ArrayList<PlayerInfoVO> player = new ArrayList<PlayerInfoVO>();
		ArrayList<TeamMemberVO> team = new ArrayList<TeamMemberVO>();
		ArrayList<UserVO> user = new ArrayList<UserVO>();
		
		try {
			// teammember에서 teammember 정보들을 추출
			conn = getConnection();
			String query = "SELECT * FROM teammember WHERE teamId = ?";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				team.add(
						new TeamMemberVO(
								rs.getString("userId"),
								rs.getInt("teamId"),
								rs.getString("regDate"),
								rs.getInt("manager"),
								rs.getFloat("participation"),
								rs.getInt("status")
						)
						);
				
				String query1 = "SELECT * FROM playerinfo WHERE userId =? ";
				ps = conn.prepareStatement(query1);
				ps.setString(1, team.get(count).getUserId());
				rs1 = ps.executeQuery();
				
				if(rs1.next()) {
					player.add(
							new PlayerInfoVO(
									rs1.getString("userId"),
									rs1.getString("position"),
									rs1.getString("mainFoot"),
									rs1.getInt("height"),
									rs1.getInt("weight"),
									rs1.getInt("injury"),
									rs1.getInt("mental"),
									rs1.getInt("speed"),
									rs1.getInt("physical"),
									rs1.getInt("dribble"),
									rs1.getInt("pass"),
									rs1.getInt("defence"),
									rs1.getInt("total")
									)
							);
				}
				
				
				String query2 = "SELECT * FROM user WHERE userId = ?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, team.get(count).getUserId());
				rs2 = ps.executeQuery();
							
				if(rs2.next()) {			
					String str = rs2.getString("gender");
					UserVO tmp = new UserVO(
							rs2.getString("userId"),
							rs2.getString("pass"),
							rs2.getString("name"),
							rs2.getString("phoneNum"),
							rs2.getString("photo"),
							rs2.getString("ssn"),
							rs2.getString("nickName"),
							str.charAt(0),
							rs2.getString("email"),
							rs2.getString("addr"),
							rs2.getString("favTeam1"),
							rs2.getString("favTeam2"),
							rs2.getString("regDate"),
							rs2.getString("country"),
							rs2.getString("recentLogin"),
							team,
							player.get(count)
							);
					
					user.add(tmp);
				}
				
				count++;
			} // while
			
		} finally {
			closeAll(rs, ps, conn);
		} // finally
		
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
				vo.add(new MatchVO(rs.getInt("matchId"), rs.getInt("teamId"), rs.getInt("stadiumId"), rs.getString("schedule"),  rs.getInt("awayId"), rs.getString("homeSquad"), rs.getString("awaySquad"),  rs.getInt("voteId")));
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	
	
	
	
	
	@Override
	public ArrayList<MatchVO> recommendMatch(String area) throws SQLException {

		
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
	public ArrayList<UserVO> recommendSquad(int participation, int totalAbility, int teamid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int matchNum=0;
		ArrayList<UserVO> uvo = new ArrayList<>();
		
		try {
			conn = getConnection();
			// 임의의 team 내에서 참석 가능하다고 투표한 사람의 성실도, 종합능력치
			String query2 = "select matchnum from teaminfo where teamid=?";
			ps = conn.prepareStatement(query2);
			ps.setInt(1, teamid);
			rs2 = ps.executeQuery();
			if(rs2.next()) {
				matchNum = rs2.getInt(1);
			}
			System.out.println(matchNum);
			
			String query1 = "select e.*, (prt*(?)+avg_ability*(?))/10 as wavg from (select d.userid, c.participation/? as prt, ((d.mental+d.speed+d.physical+d.physical+d.dribble+d.pass+d.defence)/6) as avg_ability from (select a.userid, a.participation, b.* from teammember a, (select * from voteresult where voteid = (select max(v1.voteid) from vote v1, voteresult v2 where v1.teamid=? and v1.voteid=v2.voteid)) b where a.teammemberid = b.teammemberid and b.attendence=1) c, playerinfo d where c.userid=d.userid) e order by wavg desc";
			ps = conn.prepareStatement(query1);
			ps.setInt(1, matchNum);
			ps.setInt(2, participation);
			ps.setInt(3, totalAbility);
			ps.setInt(4, teamid);
			rs1 = ps.executeQuery();
			System.out.println(participation + "/" + totalAbility);
			
			while(rs1.next()) {
				System.out.println(rs1.getString("userid"));
				//uvo.add(findByUserId(rs1.getString("userid")));
			}
		} finally {
			closeAll(rs1, ps, conn);
		}
		//System.out.println(uvo);
		return uvo;
	}
	
	@Override
	public void makeVote(VoteVO vVo) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				String query = "insert into vote (contents, dueDate, writer, teamId) values(?,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, vVo.getContents());
				ps.setString(2, vVo.getDueDate());
				ps.setString(3, vVo.getWriter());
				ps.setInt(4, vVo.getTeamId());
				
				System.out.println(ps.executeUpdate()+"명 추가 완료");
				
			}finally{
				closeAll(ps, conn);
			}
		
	}
	@Override
	public void insertVoteResult(VoteResultVO vRVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query ="insert into voteresult(voteId,teammemberId, attendence) values(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vRVo.getVoteId());
			ps.setInt(2, vRVo.getTeamMemberId());
			ps.setInt(3, vRVo.getAttendance());
			System.out.println(ps.executeUpdate()+"개 추가 되었습니다.");
			
		}finally{
			closeAll(ps, conn);
		}
	
	}
	@Override
	public void insertMatch(MatchVO mVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query ="INSERT INTO soccerproject.match (schedule, awayId, stadiumId, homeSquad, awaySquad, teamId, voteId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, mVo.getSchedule());
			ps.setInt(2, mVo.getAwayId());
			ps.setInt(3, mVo.getStadiumId());
			ps.setString(4, mVo.getHomeSquad());
			ps.setString(5, mVo.getAwaySquad());
			ps.setInt(6, mVo.getTeamId());
			ps.setInt(7, mVo.getVoteId());
			System.out.println(ps.executeUpdate()+"매치 추가 성공");
		}finally {
			closeAll(ps, conn);
			
		}
		
	}
	@Override
	public void insertMatchResult(MatchResultVO vo) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			try{
			conn = getConnection();
			String query = "INSERT INTO match_result VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getScore());
			ps.setInt(2, vo.getToAwayMannerScore());
			ps.setInt(3, vo.getToHomeMannerScore());
			ps.setInt(4, vo.getMatchId());
			System.out.println(ps.executeUpdate() +"개의 경기결과 입력");
			} finally {
				closeAll(ps, conn);
			}
		}


	@Override
	public ArrayList<MatchVO> TeamSchedule(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<MatchVO> mVo = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "select * from soccerproject.match where teamid = ? order by schedule desc";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			
			rs1 = ps.executeQuery();
			while(rs1.next()) {
				MatchVO vo = new MatchVO();
				vo.setMatchId(rs1.getInt("matchId"));
				vo.setTeamId(rs1.getInt("teamId"));
				vo.setStadiumId(rs1.getInt("stadiumId"));
				vo.setVoteId(rs1.getInt("voteId"));
				vo.setSchedule(rs1.getString("schedule"));
				vo.setAwayId(rs1.getInt("awayId"));
				vo.setHomeSquad(rs1.getString("homeSquad"));
				vo.setAwaySquad(rs1.getString("awaySquad"));
				
				String query2 = "select * from match_result where matchId = ?";
				ps = conn.prepareStatement(query2);
				ps.setInt(1, vo.getMatchId());
				rs2 = ps.executeQuery();
				if(rs2.next()) {
					MatchResultVO mrVo = new MatchResultVO();
					mrVo.setMatchId(vo.getMatchId());
					mrVo.setScore(rs2.getString("score"));
					mrVo.setToAwayMannerScore(rs2.getInt("toAwayMannerScore"));
					mrVo.setToHomeMannerScore(rs2.getInt("toHomeMannerScore"));
					vo.setMrVo(mrVo);
				}
				mVo.add(vo);
			}
		}finally {
			closeAll(rs1, ps, conn);
		}
		return mVo;
	}
	
	@Override
	public ArrayList<MatchVO> userSchedule(int teamMemberId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MatchVO> schedule = new ArrayList<>();
		try{
		conn = getConnection();
		String query = "SELECT v.*, m.* FROM voteresult v, `match` m WHERE v.teammemberid = ? AND v.attendence=? And v.voteid=m.voteid";
		// 투표 결과 테이블에서 본인이 속한 팀의 일정이면서 참석하겠다고 투표한 일정만 불러온다.
		ps=conn.prepareStatement(query);
		ps.setInt(1, teamMemberId);
		ps.setInt(2, 1); //참석구분 0,1
		rs = ps.executeQuery();
		while(rs.next()){
		schedule.add(new MatchVO(rs.getInt("matchId"), rs.getInt("teamid"),
				rs.getInt("stadiumId"), rs.getString("schedule"),
				rs.getInt("awayId"), rs.getString("homesquad"),
				rs.getString("awaysquad"), rs.getInt("voteid")));
		}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(schedule);
		return schedule;
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
	public void deleteTeam(int teamId, String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
		conn = getConnection();
			String query = "delete from team where teamId = ? and teamName =?";
			ps= conn.prepareStatement(query);
			ps.setInt(1, teamId);
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
			ps.setString(13, uVo.getUserId());
			
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
	FootBallDAOImpl1 dao = FootBallDAOImpl1.getInstance();
	
	//DriverManager 방식의 DB Connection
	
	//registerUser
	
	dao.registerUser(new UserVO("id1", "pass1", "name1", "phoneNum1", "photo1", "ssn1", "nickName1", 'm', "email1", "addr1", "favTeam11", "favTeam21", "korea"));

	/*//login
	UserVO vo = dao.login("aaa", "aaa");
	System.out.println(vo);*/
	
	// recommend squad
	//dao.recommendSquad(3, 7, 1);
	
	//makeVote
	//dao.makeVote(new VoteVO("안녕하세요. 반갑습니다.", "2020-07-02", "aaa", 1));
	
	// insert VoteResult
	//VoteResultVO vVo = new VoteResultVO(7, 41, 0);
	//dao.insertVoteResult(vVo);
	
	
	//insertMatchVO
	//dao.insertMatch(new MatchVO(2, 2, "2020-07-12", 3, "homeSquad", "awaySquad", 7));	
	
	// insert match result
/*	MatchResultVO mrvo = new MatchResultVO(7, "3:4", 5, 7);
	dao.insertMatchResult(mrvo);*/
	
	//TeamSchedule
	//System.out.println(dao.TeamSchedule(2));
	
	// user schedule
	//dao.userSchedule(1);
	
	///delete
	//dao.deleteUser("zzz", "zzz");
	//dao.deleteTeam(6, "FCfff");
		
	/*// update
	UserVO uVo = new UserVO("aaa", "aaa", "010-5621-4472", "img/aaa.jpg", "이재헌", "111@gmail.com", "답십리", "바르셀로나", "레알마드리드", new PlayerInfoVO("LWF", "왼발", 190, 80, 1, 80, 80, 80, 80, 80, 80, 0));
	dao.updateUser(uVo);
	*/
	
	/*// update team
	TeamVO tVo = new TeamVO(5, "FCeee", "img/FCeee.jpg", "서울", "제주", "강원도", 1);
	dao.updateTeam(tVo);*/

	}
}
