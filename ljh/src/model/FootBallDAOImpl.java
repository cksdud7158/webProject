package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.json.simple.parser.ParseException;

import util.DataSourceManager;

public class FootBallDAOImpl implements FootballDAO {
	private DataSource ds;

	// singletone
	private static FootBallDAOImpl dao = new FootBallDAOImpl();

	private FootBallDAOImpl() {

		/*
		 * try { Class.forName(ServerInfo.DRIVER_NAME); System.out.println("드라이버 로딩"); }
		 * catch (ClassNotFoundException e) { System.out.println("드라이버 로딩 실패"); }
		 */
		ds = DataSourceManager.getInstance().getConnection();
	}

	public static FootBallDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {

		/*
		 * Connection conn=null; try {
		 * 
		 * conn= DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER,
		 * ServerInfo.PASS); System.out.println("DB 연결 성공"); } catch (SQLException e) {
		 * System.out.println("DB 연결 실패"); }
		 * 
		 * return conn;
		 */

		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerPlayerInfo(PlayerInfoVO pVO) throws SQLException {
		System.out.println("player info");
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO `soccerproject`.`playerinfo` (`userId`, `position`, `mainFoot`, `height`, `weight`,`injury`, `mental`, `speed`, `physical`, `dribble`, `pass`, `defence`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, pVO.getUserId());
			ps.setString(2, pVO.getPosition());
			ps.setString(3, pVO.getMainFoot());
			ps.setInt(4, pVO.getHeight());
			ps.setInt(5, pVO.getWeight());
			ps.setInt(6, pVO.getInjury());
			ps.setInt(7, pVO.getMental());
			ps.setInt(8, pVO.getSpeed());
			ps.setInt(9, pVO.getPhysical());
			ps.setInt(10, pVO.getDribble());
			ps.setInt(11, pVO.getPass());
			ps.setInt(12, pVO.getDefence());

			System.out.println(ps.executeUpdate() + "명 player infroamtrion이 등록되었습니다.");
		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public void registerUser(UserVO vo, PlayerInfoVO pVO) throws SQLException {
		System.out.println("user");
		Connection conn = null;
		PreparedStatement ps = null;

		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));
		System.out.println(str);

		try {
			conn = getConnection();
			String query1 = "INSERT INTO `soccerproject`.`user` (`userId`, `pass`, `name`, `phoneNum`, `photo`, `ssn`, `nickName`, `gender`, `email`, `addr`, `favTeam1`, `favTeam2`, `regDate`, `country`, `recentLogin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = conn.prepareStatement(query1);
			System.out.println(vo.getUserId());
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

			System.out.println(ps.executeUpdate() + "명 user 등록되었습니다.");

			registerPlayerInfo(pVO);
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void requestToJoin(PlayerInfoVO pVo, int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int flag = 1; // 요청 상태 : 1, 가입 상태 : 0

		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));

		try {
			conn = getConnection();
			String query = "INSERT INTO teammember (regDate, status, userId, teamId) VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, str);
			ps.setFloat(2, flag);
			ps.setString(3, pVo.getUserId());
			ps.setInt(4, teamId);

			System.out.println(ps.executeUpdate() + "명, 팀 가입 요청되었습니다.");
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public void requestToJoin(String userId, int teamId) throws SQLException {
		System.out.println("requestToJoin BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 요청 상태 : 1, 가입 상태 : 0
		int flag = 1;

		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));

		try {
			conn = getConnection();
			String query = "INSERT INTO teammember (regDate, manager, participation, status, userId, teamId) VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, str);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setFloat(4, flag);
			ps.setString(5, userId);
			ps.setInt(6, teamId);

			System.out.println(ps.executeUpdate() + "명, 팀 가입 요청되었습니다.");
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public void allowToJoin(int teamMemberId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "update teammember set status=0 where teammemberId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamMemberId);

			System.out.println(ps.executeUpdate() + "명이 팀에 가입되셨습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void rejectToJoin(int teamMemberId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "delete from teammember where teammemberId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamMemberId);

			System.out.println(ps.executeUpdate() + "명이 팀에 가입 거절되셨습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void makeTeam(TeamVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;

		boolean check = isExistStadiumName(vo.getsVo().getStadiumName());
		int tempId = 0;
		try {

			conn = getConnection();

			// 경기장이름이 이미 존재한다면
			if (check == true) {
				String query1 = "select stadiumId from stadium where stadiumName=?";
				ps1 = conn.prepareStatement(query1);
				ps1.setString(1, vo.getsVo().getStadiumName());
				rs1 = ps1.executeQuery();
				if (rs1.next()) {
					tempId = rs1.getInt("stadiumId");
				} // 경기장 아이디를 받아온다.

			} else {
				insertStadium(vo.getsVo());

				String query4 = "select stadiumId from stadium where stadiumName=?";
				PreparedStatement ps4 = conn.prepareStatement(query4);
				ps4.setString(1, vo.getsVo().getStadiumName());
				ResultSet rs4 = ps4.executeQuery();
				if (rs4.next()) {
					tempId = rs4.getInt("stadiumId");
				}

			}

			String query2 = "INSERT INTO team (teamName, emblem, area1, area2, area3, stadiumId) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, vo.getTeamName());
			ps2.setString(2, vo.getEmblem());
			ps2.setString(3, vo.getArea1());
			ps2.setString(4, vo.getArea2());
			ps2.setString(5, vo.getArea3());
			ps2.setInt(6, tempId);
			System.out.println(ps2.executeUpdate() + "개의 팀이 만들어졌습니다.");

			TeamVO tVo = findByTeamName(vo.getTeamName());

			String query3 = "insert into teaminfo(teamId) values(?)";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setInt(1, tVo.getTeamId());

			System.out.println(ps3.executeUpdate() + "개의 TeamInfo가 만들어졌습니다.");

		} finally {
			closeAll(rs1, ps1, conn);
		}

	}

	@Override
	public ArrayList<PlayerInfoVO> showAllMember(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<PlayerInfoVO> list = new ArrayList<PlayerInfoVO>();

		try {
			conn = getConnection();
			String query = "select * from playerinfo where userid in (SELECT userId FROM soccerproject.teammember where teamId=?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new PlayerInfoVO(rs.getString("userId"), rs.getString("position"), rs.getString("mainFoot"),
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("injury"), rs.getInt("mental"),
						rs.getInt("speed"), rs.getInt("physical"), rs.getInt("dribble"), rs.getInt("pass"),
						rs.getInt("defence"), rs.getInt("mental") + rs.getInt("speed") + rs.getInt("physical")
								+ rs.getInt("dribble") + rs.getInt("pass") + rs.getInt("defence")));
			}

		} finally {
			closeAll(rs, ps, conn);
		} // finally

		return list;
	}

	@Override
	public UserVO findByUserId(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		UserVO uVo = null;
		PlayerInfoVO pVo = null;
		ArrayList<TeamMemberVO> tVoList = new ArrayList<>();

		try {
			conn = getConnection();
			String query1 = "SELECT * FROM user WHERE userId=?";
			ps = conn.prepareStatement(query1);
			ps.setString(1, userId);

			rs1 = ps.executeQuery();
			if (rs1.next()) {
				uVo = new UserVO(rs1.getString("userId"), rs1.getString("pass"), rs1.getString("name"),
						rs1.getString("phoneNum"), rs1.getString("photo"), rs1.getString("ssn"),
						rs1.getString("nickName"), rs1.getString("gender").charAt(0), rs1.getString("email"),
						rs1.getString("addr"), rs1.getString("favTeam1"), rs1.getString("favTeam2"),
						rs1.getString("regDate"), rs1.getString("country"), rs1.getString("recentLogin"));
				String query2 = "SELECT * FROM playerinfo WHERE userId=?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, userId);
				rs2 = ps.executeQuery();
				if (rs2.next()) {
					pVo = new PlayerInfoVO(userId, rs2.getString("position"), rs2.getString("mainFoot"),
							rs2.getInt("height"), rs2.getInt("weight"), rs2.getInt("injury"), rs2.getInt("mental"),
							rs2.getInt("speed"), rs2.getInt("physical"), rs2.getInt("dribble"), rs2.getInt("pass"),
							rs2.getInt("defence"), rs2.getInt("mental") + rs2.getInt("speed") + rs2.getInt("physical")
									+ rs2.getInt("dribble") + rs2.getInt("pass") + rs2.getInt("defence"));
					uVo.setpVo(pVo);
				}
				String query3 = "SELECT * FROM teammember WHERE userId=?";
				ps = conn.prepareStatement(query3);
				ps.setString(1, userId);
				rs3 = ps.executeQuery();
				while (rs3.next()) {
					tVoList.add(
							new TeamMemberVO(rs3.getString("userId"), rs3.getInt("teamId"), rs3.getString("regDate"),
									rs3.getInt("manager"), rs3.getFloat("participation"), rs3.getInt("status")));
				}
				uVo.settVoList(tVoList);
			}

		} finally {
			closeAll(rs1, ps, conn);
		}
		return uVo;
	}

	@Override
	public ArrayList<UserVO> attendUser(int voteId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ArrayList<UserVO> auList = new ArrayList<>();

		try {
			conn = getConnection();
			String query = "select teammemberId from voteresult where attendence = 1 and voteId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);
			rs1 = ps.executeQuery();

			while (rs1.next()) {
				auList.add(findByTeamMemberId((rs1.getInt("teammemberId"))));
			}

		} finally {
			closeAll(rs1, ps, conn);

		}
		return auList;
	}

	@Override
	public UserVO findByTeamMemberId(int teamMemberId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String userId = getUserIdByTeamMemberId(teamMemberId);

		UserVO uVo = null;
		PlayerInfoVO pVo = null;
		ArrayList<TeamMemberVO> tVoList = new ArrayList<>();

		try {
			conn = getConnection();
			String query1 = "SELECT * FROM user WHERE userId=?";
			ps = conn.prepareStatement(query1);
			ps.setString(1, userId);

			rs1 = ps.executeQuery();
			if (rs1.next()) {
				uVo = new UserVO(rs1.getString("userId"), rs1.getString("pass"), rs1.getString("name"),
						rs1.getString("phoneNum"), rs1.getString("photo"), rs1.getString("ssn"),
						rs1.getString("nickName"), rs1.getString("gender").charAt(0), rs1.getString("email"),
						rs1.getString("addr"), rs1.getString("favTeam1"), rs1.getString("favTeam2"),
						rs1.getString("regDate"), rs1.getString("country"), rs1.getString("recentLogin"));
				String query2 = "SELECT * FROM playerinfo WHERE userId=?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, userId);
				rs2 = ps.executeQuery();
				if (rs2.next()) {
					pVo = new PlayerInfoVO(userId, rs2.getString("position"), rs2.getString("mainFoot"),
							rs2.getInt("height"), rs2.getInt("weight"), rs2.getInt("injury"), rs2.getInt("mental"),
							rs2.getInt("speed"), rs2.getInt("physical"), rs2.getInt("dribble"), rs2.getInt("pass"),
							rs2.getInt("defence"), rs2.getInt("mental") + rs2.getInt("speed") + rs2.getInt("physical")
									+ rs2.getInt("dribble") + rs2.getInt("pass") + rs2.getInt("defence"));
					uVo.setpVo(pVo);
				}
				String query3 = "SELECT * FROM teammember WHERE userId=?";
				ps = conn.prepareStatement(query3);
				ps.setString(1, userId);
				rs3 = ps.executeQuery();
				while (rs3.next()) {
					tVoList.add(
							new TeamMemberVO(rs3.getString("userId"), rs3.getInt("teamId"), rs3.getString("regDate"),
									rs3.getInt("manager"), rs3.getFloat("participation"), rs3.getInt("status")));
				}
				uVo.settVoList(tVoList);
			}

		} finally {
			closeAll(rs1, ps, conn);
		}
		return uVo;
	}

	@Override
	public String getUserIdByTeamMemberId(int teamMemberId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String teamMId = "";

		try {
			conn = getConnection();
			String query = "SELECT  FROM teammember where teammemberId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamMemberId);
			rs = ps.executeQuery();

			if (rs.next()) {
				teamMId = rs.getString("userId");
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return teamMId;

	}

	@Override
	public TeamVO findByTeamName(String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TeamVO vo = new TeamVO();

		try {
			conn = getConnection();
			String query = "SELECT * FROM team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("teamName").equals(teamName)) {
					vo = new TeamVO(rs.getInt("teamId"), rs.getString("teamName"), rs.getString("emblem"),
							rs.getString("area1"), rs.getString("area2"), rs.getString("area3"),
							rs.getInt("stadiumId"));
				}
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return vo;
	}

	@Override
	public TeamVO findTeamByTeamId(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		TeamVO tVo = new TeamVO();
		;

		try {
			conn = getConnection();
			String query = "SELECT * FROM team ";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt("teamId") == teamId) {
					tVo = new TeamVO(rs.getInt("teamId"), rs.getString("teamName"), rs.getString("emblem"),
							rs.getString("area1"), rs.getString("area2"), rs.getString("area3"),
							rs.getInt("stadiumId"));
				}
			}
			tVo.setTi(getTeamInfo(teamId));
			tVo.setsVo(getStadium(tVo.getStadiumId()));

		} finally {
			closeAll(rs, ps, conn);
		}
		return tVo;
	}

	@Override
	public ArrayList<TeamVO> myTeamList(String userId) throws SQLException {
		System.out.println("myTeamList BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<TeamVO> tvList = new ArrayList<TeamVO>();

		try {
			conn = getConnection();
			String query = "select t.* from `user` u, teammember tm, team t where u.userid=tm.userid and tm.teamid=t.teamid and u.userid=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				tvList.add(new TeamVO(rs.getInt("teamid"), rs.getString("teamname"), rs.getString("emblem"),
						rs.getString("area1"), rs.getString("area2"), rs.getString("area3"), rs.getInt("stadiumId")));
			}

			String query2 = "select tif.* from `user` u, teammember t, teaminfo tif where u.userid=t.userid and t.teamid=tif.teamId and u.userid=?";
			ps = conn.prepareStatement(query2);
			ps.setString(1, userId);
			rs2 = ps.executeQuery();
			int i = 0;
			while (rs2.next()) {
				TeamInfoVO ti = new TeamInfoVO(rs2.getInt("teamId"), rs2.getInt("mannerScore"), rs2.getInt("matchNum"),
						rs2.getInt("ranking"), rs2.getInt("memberNum"), rs2.getInt("teamScore"),
						rs2.getInt("winningScore"));
				tvList.get(i).setTi(ti);
				i++;
			}
			System.out.println("myTeamList BL 호출 성공");
		} finally {
			closeAll(rs, ps, conn);
		}
		return tvList;
	}

	@Override
	public ArrayList<MatchVO> matchHistory(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MatchVO mVo = null;
		ArrayList<MatchVO> vo = new ArrayList<MatchVO>();
		MatchResultVO mrVo = null;
		try {
			conn = getConnection();
			String query = "select m.*, mr.* from `match` m, match_result mr where m.matchId = mr.matchId and (m.teamId=? or m.awayId=?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			ps.setInt(2, teamId);
			rs = ps.executeQuery();
			while (rs.next()) {
				mrVo = new MatchResultVO(rs.getString("score"), rs.getInt("toAwayMannerScore"),
						rs.getInt("toHomeMannerScore"));
				mVo = new MatchVO(rs.getInt("matchId"), rs.getInt("teamId"), rs.getInt("stadiumId"),
						rs.getString("schedule"), rs.getInt("awayId"), rs.getString("homeSquad"),
						rs.getString("awaySquad"), rs.getInt("voteId"));
				mVo.setMrVo(mrVo);
				vo.add(mVo);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(vo);
		System.out.println("matchHistory BL 호출 성공");
		return vo;
	}

	@Override
	public ArrayList<TotalVO> recommendMatch(int teamId, int x, int y, int z, int n, int m)
			throws SQLException, UnsupportedEncodingException, ParseException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<ScoreVO> vo = new ArrayList<>();
		ArrayList<TotalVO> TotalVO = new ArrayList<>();
		ArrayList<TotalVO> rTotalVO = new ArrayList<>();
		double[][] spherical_area = new double[3][2];
		double min;

		int index = 1;
		int count = 0;
		int tmp = 0;

		NearestArea nArea = NearestArea.getInstance();
		GetSphericalCoordinate sCoordinate = GetSphericalCoordinate.getInstance();
		Max getMax = Max.getInstance();
		WeightedScore weighted = WeightedScore.getInstance();

		try {
			conn = getConnection();
			String query = "SELECT * FROM team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}

			while (tmp < (count - 1)) {
				query = "SELECT * FROM team as t LEFT JOIN teamInfo as tinfo ON t.teamId = tinfo.teamId where t.teamId=?;";
				ps = conn.prepareStatement(query);
				ps.setInt(1, index);
				rs = ps.executeQuery();

				if (rs.next()) {
					ScoreVO sVo = new ScoreVO();
					sVo.setTeamId(rs.getInt("teamId"));
					sVo.setArea1(rs.getString("area1"));
					sVo.setArea2(rs.getString("area2"));
					sVo.setArea3(rs.getString("area3"));
					sVo.setTeamName(rs.getString("teamName"));
					sVo.setMannerScore(rs.getInt("mannerScore"));
					sVo.setMatchNum(rs.getInt("matchNum"));
					sVo.setRanking(rs.getInt("ranking"));
					sVo.setMemberNum(rs.getInt("memberNum"));
					sVo.setWinningScore(rs.getInt("winningScore"));
					vo.add(sVo);
					tmp++;
				}
				index++;
			}

			// Area 1, 2, 3;
			spherical_area = sCoordinate.getSphericalCoordinate(teamId, vo);
			index = 1;
			tmp = 0;
			while (tmp < (count - 1)) {

				query = "SELECT * FROM team as t LEFT JOIN teamInfo as tinfo ON t.teamId = tinfo.teamId where t.teamId=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, index);
				rs = ps.executeQuery();

				if (teamId != index) {
					if (rs.next()) {
						TotalVO.add(new TotalVO(rs.getInt("teamId"), rs.getString("emblem"), rs.getString("teamName"),
								rs.getInt("stadiumId"), rs.getDouble("ranking"),
								nArea.NearestAreaMethod(teamId, vo.get(tmp), spherical_area),
								rs.getDouble("mannerScore"), rs.getDouble("matchNum"), rs.getDouble("memberNum"),
								rs.getDouble("winningScore")));
						TotalVO.get(tmp)
								.setStadiumName(findStadiumByStadiumId(rs.getInt("stadiumId")).getStadiumName());
						tmp++;
					}
				}
				index++;
			}
			// Unit
			// distance_min
			// manners_Score
			// matchNum
			// memberNum
			// winningScore
			double distance = getMax.getMax(TotalVO, "distance_min");
			double manners = getMax.getMax(TotalVO, "manners_Score");
			double match = getMax.getMax(TotalVO, "matchNum");
			double member = getMax.getMax(TotalVO, "memberNum");
			double winning = getMax.getMax(TotalVO, "winningScore");

			for (int i = 0; i < count - 1; i++) {

				if (TotalVO.get(i).getDistance_min() == 0)
					TotalVO.get(i).setDistance_min_normalised(100);
				else
					TotalVO.get(i).setDistance_min_normalised((TotalVO.get(i).getDistance_min() / distance) * 100);

				TotalVO.get(i).setMannersScore_normalised((TotalVO.get(i).getMannersScore() / manners) * 100);
				TotalVO.get(i).setMatchNum_normalised((TotalVO.get(i).getMatchNum() / match) * 100);
				TotalVO.get(i).setMemberNum_noramlised((TotalVO.get(i).getMemberNum() / member) * 100);
				TotalVO.get(i).setWinningScore_normalised((TotalVO.get(i).getWinningScore() / winning) * 100);
			}

			for (int i = 0; i < count - 1; i++) {
				TotalVO.get(i).setTotal_score(weighted.weightedScore(TotalVO.get(i), x, y, z, n, m));
				// System.out.println(TotalVO.get(i));
			}
			SortDescending.getInstance().sortDescending(TotalVO);
			
			for (int i = 0; i < count - 1; i++) {
				System.out.println(TotalVO.get(i));
			}

			ArrayList<Integer> result1 = datePossibleTeam();

			for (Integer i : result1) {

				for (TotalVO tv : TotalVO) {
					if (tv.getTeamId() == possibleCountTeam(i)) {
						tv.setMatchId(findMatchIdbyVoteId(i));
						rTotalVO.add(tv);
						System.out.println(i+"voteId이고, "+tv.getTeamId()+"팀아이디입니다.");
					}

				}
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		//SortDescending.getInstance().sortDescending(rTotalVO);
		for (int i = 0; i < rTotalVO.size(); i++) {
			System.out.println(rTotalVO.get(i));
		}
		return rTotalVO;
	}

	private int possibleCountTeam(int voteId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int teamId=0;
		try {
			conn = getConnection();
			String query = "select a.teamid from (select m.teamid, convert(substr(s.stadiumType, 1, (instr(s.stadiumType, \":\"))-1),  signed)*2 as sType from `match` m, stadium s where m.stadiumId=s.stadiumId and m.voteid=?) a, (select count(*) as cnt from voteresult where voteid=? and attendence = 1) b where b.cnt-a.sType<0";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);
			ps.setInt(2, voteId);
			rs = ps.executeQuery();
			if(rs.next()) {
				teamId=rs.getInt("teamid");
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(teamId+"팀아이디입니다.");
		return teamId;
	}

	private ArrayList<Integer> datePossibleTeam() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> voteIdList = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "select a.voteId from (select v.dueDate, curdate(), m.schedule, floor(datediff(curdate(), v.dueDate)) as col1, floor(datediff(curdate(), m.schedule)) as col2, v.voteId from vote v, `match` m where v.voteid=m.voteid) a where col1>0 and col2<0";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getInt("voteId")+"보트아이디입니다..");
				voteIdList.add(rs.getInt("voteId"));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return voteIdList;
	}

	@Override
	public UserVO login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		UserVO uVo = null;
		PlayerInfoVO pVo = null;
		ArrayList<TeamMemberVO> tVoList = new ArrayList<>();
		try {
			conn = getConnection();
			String query1 = "SELECT * FROM user WHERE userId=? AND pass=?";
			ps = conn.prepareStatement(query1);
			ps.setString(1, userId);
			ps.setString(2, password);

			rs1 = ps.executeQuery();
			if (rs1.next()) {
				uVo = new UserVO(rs1.getString("userId"), rs1.getString("pass"), rs1.getString("name"),
						rs1.getString("phoneNum"), rs1.getString("photo"), rs1.getString("ssn"),
						rs1.getString("nickName"), rs1.getString("gender").charAt(0), rs1.getString("email"),
						rs1.getString("addr"), rs1.getString("favTeam1"), rs1.getString("favTeam2"),
						rs1.getString("regDate"), rs1.getString("country"), rs1.getString("recentLogin"));
				String query2 = "SELECT * FROM playerinfo WHERE userId=?";
				ps = conn.prepareStatement(query2);
				ps.setString(1, userId);
				rs2 = ps.executeQuery();
				if (rs2.next()) {
					pVo = new PlayerInfoVO(userId, rs2.getString("position"), rs2.getString("mainFoot"),
							rs2.getInt("height"), rs2.getInt("weight"), rs2.getInt("injury"), rs2.getInt("mental"),
							rs2.getInt("speed"), rs2.getInt("physical"), rs2.getInt("dribble"), rs2.getInt("pass"),
							rs2.getInt("defence"), rs2.getInt("total"));
					uVo.setpVo(pVo);
				}
				String query3 = "SELECT * FROM teammember WHERE userId=?";
				ps = conn.prepareStatement(query3);
				ps.setString(1, userId);
				rs3 = ps.executeQuery();
				while (rs3.next()) {
					tVoList.add(
							new TeamMemberVO(rs3.getString("userId"), rs3.getInt("teamId"), rs3.getString("regDate"),
									rs3.getInt("manager"), rs3.getFloat("participation"), rs3.getInt("status")));
				}
				uVo.settVoList(tVoList);
			}

		} finally {
			closeAll(rs1, ps, conn);
		}
		return uVo;
	}

	/*
	 * @Override public ArrayList<UserVO> recommendSquad(int participationIndex, int
	 * totalAbilityIndex, int teamId) throws SQLException { Connection conn = null;
	 * PreparedStatement ps = null; ResultSet rs1 = null; ResultSet rs2 = null; int
	 * matchNum = 0; UserVO uVo = new UserVO(); ArrayList<UserVO> auList = new
	 * ArrayList<>();
	 * 
	 * try { conn = getConnection(); // 임의의 team 내에서 참석 가능하다고 투표한 사람의 성실도, 종합능력치
	 * String query2 = "select matchnum from teaminfo where teamid=?"; ps =
	 * conn.prepareStatement(query2); ps.setInt(1, teamId); rs2 = ps.executeQuery();
	 * if (rs2.next()) { matchNum = rs2.getInt(1); } System.out.println(matchNum);
	 * 
	 * 
	 * 
	 * 
	 * String query1 =
	 * "select e.*, (prt*(?)+avg_ability*(?))/10 as wavg from (select d.userid, c.participation/? as prt, ((d.mental+d.speed+d.physical+d.physical+d.dribble+d.pass+d.defence)/6) as avg_ability from (select a.userid, a.participation, b.* from teammember a, (select * from voteresult where voteid = (select max(v1.voteid) from vote v1, voteresult v2 where v1.teamid=? and v1.voteid=v2.voteid)) b where a.teammemberid = b.teammemberid and b.attendence=1) c, playerinfo d where c.userid=d.userid) e order by wavg desc"
	 * ; ps = conn.prepareStatement(query1); ps.setInt(1, matchNum); ps.setInt(2,
	 * participationIndex); ps.setInt(3, totalAbilityIndex); ps.setInt(4, teamId);
	 * rs1 = ps.executeQuery(); System.out.println(participationIndex + "/" +
	 * totalAbilityIndex);
	 * 
	 * while (rs1.next()) { System.out.println(rs1.getString("userid")); uVo =
	 * findByUserId(rs1.getString("userid"));
	 * uVo.getpVo().setTotal((int)rs1.getFloat("wavg"));
	 * System.out.println(rs1.getString("prt")+"가중치 점수 입니다.");
	 * 
	 * auList.add(uVo); } } finally { closeAll(rs1, ps, conn); }
	 * System.out.println(auList); return auList; }
	 */

	@Override
	public ArrayList<UserVO> recommendSquad(int participation, int totalAbility, int teamid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		int matchNum = 0;
		ArrayList<UserVO> uvoList = new ArrayList<>();
		PlayerInfoVO pVo = null;
		UserVO uVo = null;
		try {
			// 점수 계산에 필요한 참여도(teammember), 능력치(playerinfo) 불러온 뒤 playerinfo의 total에 저장
			conn = getConnection();
			String query = "select c.*, d.matchNum, d.participation from (select b.userId, b.teammemberId, p.position, p.mainFoot, p.height, p.weight, p.injury, p.mental, p.pass, p.dribble, p.defence, p.physical, p.speed from (select a.teammemberId, a.userId from (select t.teamId, tm.userId, tm.teammemberId from team t, teammember tm where t.teamid=tm.teamid and status=0) a, (select v1.* from voteresult v1, vote v2 where v1.voteId=v2.voteId and v2.voteId = (select max(voteId) from vote where teamId=?)) v where a.teammemberId=v.teammemberId and v.attendence=1) b, playerinfo p where b.userid=p.userid) c, (select tif.matchNum, tm.participation, tm.teammemberId from teaminfo tif, teammember tm where tif.teamId=tm.teamid and tm.teamid=? and tm.status=0) d where c.teammemberId=d.teammemberId;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamid);
			ps.setInt(2, teamid);
			rs1 = ps.executeQuery();
			while (rs1.next()) {
				int total = (int) Math.round((((rs1.getInt("mental") + rs1.getInt("speed") + rs1.getInt("physical")
						+ rs1.getInt("dribble") + rs1.getInt("pass") + rs1.getInt("defence")) / 6) * (totalAbility)
						+ (rs1.getInt("participation") / rs1.getInt("matchNum")) * (participation)) / 10);
				pVo = new PlayerInfoVO(rs1.getString("userId"), rs1.getString("position"), rs1.getString("mainFoot"),
						rs1.getInt("height"), rs1.getInt("weight"), rs1.getInt("injury"), rs1.getInt("mental"),
						rs1.getInt("speed"), rs1.getInt("physical"), rs1.getInt("dribble"), rs1.getInt("pass"),
						rs1.getInt("defence"), total);
				System.out.println(rs1.getString("userid"));
				uVo = findByUserId(rs1.getString("userid"));
				uVo.setpVo(pVo);
				uvoList.add(uVo);
			}

		} finally {
			closeAll(rs1, ps, conn);
		}
		// System.out.println(uvo);
		Collections.sort(uvoList);
		System.out.println(uvoList + "정렬된 리스트입니다.");

		return uvoList;
	}

	@Override
	public void makeVote(VoteVO vVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int voteId = 0;
		try {
			conn = getConnection();
			String query = "insert into vote (contents, dueDate, writer, teamId) values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vVo.getContents());
			ps.setString(2, vVo.getDueDate());
			ps.setString(3, vVo.getWriter());
			ps.setInt(4, vVo.getTeamId());

			System.out.println(ps.executeUpdate() + "명 추가 완료");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public VoteVO findVoteByTeamId(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VoteVO vVo = new VoteVO();
		try {
			conn = getConnection();
			String query = "select * from vote where teamId = ? order by voteId desc limit 1";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs = ps.executeQuery();
			if (rs.next()) {

				vVo.setVoteId(rs.getInt("voteId"));
				vVo.setContents(rs.getString("contents"));
				vVo.setDueDate(rs.getString("dueDate"));
				vVo.setTeamId(rs.getInt("teamId"));
				vVo.setDueDate(rs.getString("dueDate"));
				vVo.setWriter(rs.getString("writer"));
				vVo.setmVo(findMatchByVoteId(rs.getInt("voteId")));
				vVo.setVrVoList(findVoteResultByVoteId(rs.getInt("voteId")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return vVo;
	}

	@Override
	public ArrayList<VoteResultVO> findVoteResultByVoteId(int voteId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<VoteResultVO> vrVoList = new ArrayList<VoteResultVO>();
		try {
			conn = getConnection();
			String query = "select * from voteresult where voteId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);

			rs = ps.executeQuery();
			while (rs.next()) {
				VoteResultVO vrVo = new VoteResultVO();
				vrVo.setVoteId(rs.getInt("voteId"));
				vrVo.setTeamMemberId(rs.getInt("teamMemberId"));
				vrVo.setAttendance(rs.getInt("attendence"));
				vrVoList.add(vrVo);
			}
		} finally {
			closeAll(ps, conn);
		}
		return vrVoList;

	}

	@Override
	public MatchVO findMatchByVoteId(int voteId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MatchVO mVo = new MatchVO();
		try {
			conn = getConnection();
			String query = "select * from soccerproject.match where voteId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);
			rs = ps.executeQuery();
			if (rs.next()) {
				mVo.setMatchId(rs.getInt("matchId"));
				mVo.setTeamId(rs.getInt("teamId"));
				mVo.setStadiumId(rs.getInt("stadiumId"));
				mVo.setSchedule(rs.getString("schedule"));
				mVo.setAwayId(rs.getInt("awayId"));
				mVo.setHomeSquad(rs.getString("homeSquad"));
				mVo.setAwaySquad(rs.getString("awaySquad"));
				mVo.setVoteId(rs.getInt("voteId"));
				mVo.setsVo(findStadiumByStadiumId(rs.getInt("stadiumId")));
				mVo.setMrVo(findMatchResultByMatchId(rs.getInt("matchId")));
			}

		} finally {
			closeAll(ps, conn);
		}
		return mVo;

	}
	@Override
	public int findMatchIdbyVoteId(int voteId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int matchId = 0;
		try {
			conn = getConnection();
			String query = "select * from `match` where voteId = ? ";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);
			rs = ps.executeQuery();
			if (rs.next()) {
				matchId = rs.getInt("matchId");
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return matchId;
	}
	
	@Override
	public StadiumVO findStadiumByStadiumId(int StadiumId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StadiumVO sVo = new StadiumVO();
		try {
			conn = getConnection();
			String query = "select * from stadium where stadiumId = ? ";
			ps = conn.prepareStatement(query);
			ps.setInt(1, StadiumId);
			rs = ps.executeQuery();
			if (rs.next()) {
				sVo.setStadiumId(rs.getInt("stadiumId"));
				sVo.setStadiumName(rs.getString("stadiumName"));
				sVo.setStadiumAddr(rs.getString("stadiumAddr"));
				sVo.setStadiumCost(rs.getInt("stadiumCost"));
				sVo.setStadiumType(rs.getString("stadiumType"));
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return sVo;

	}

	@Override
	public MatchResultVO findMatchResultByMatchId(int matchId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MatchResultVO mrVo = new MatchResultVO();
		try {
			conn = getConnection();
			String query = "select * from match_result where matchId = ? ";
			ps = conn.prepareStatement(query);
			ps.setInt(1, matchId);
			rs = ps.executeQuery();
			if (rs.next()) {
				mrVo.setMatchId(rs.getInt("matchId"));
				mrVo.setScore(rs.getString("score"));
				mrVo.setToAwayMannerScore(rs.getInt("toAwayMannerScore"));
				mrVo.setToHomeMannerScore(rs.getInt("toHomeMannerScore"));
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return mrVo;

	}

	@Override
	public TeamVO getSelectedTeam(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		TeamVO tVo = new TeamVO();

		try {
			conn = getConnection();
			String query = "select * from team where teamId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs1 = ps.executeQuery();
			if (rs1.next()) {
				tVo.setTeamId(rs1.getInt("teamId"));
				tVo.setTeamName(rs1.getString("teamName"));
				tVo.setEmblem(rs1.getString("emblem"));
				tVo.setArea1(rs1.getString("area1"));
				tVo.setArea2(rs1.getString("area2"));
				tVo.setArea3(rs1.getString("area3"));
				tVo.setStadiumId(rs1.getInt("stadiumId"));
				tVo.setsVo(getStadium(rs1.getInt("stadiumId")));
			}
			tVo.setTmvList(getTeamMemberList(teamId));
			tVo.setTi(getTeamInfo(teamId));

		} finally {
			closeAll(rs1, ps, conn);
		}

		return tVo;
	}

	@Override
	public ArrayList<TeamMemberVO> getTeamMemberList(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		ArrayList<TeamMemberVO> tmvList = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "select * from teammember where teamId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs1 = ps.executeQuery();
			while (rs1.next()) {
				TeamMemberVO tmVo = new TeamMemberVO();
				tmVo.setTeamId(rs1.getInt("teamId"));
				tmVo.setUserId(rs1.getString("userId"));
				tmVo.setRegDate(rs1.getString("regDate"));
				tmVo.setManager(rs1.getInt("manager"));
				tmVo.setParticipation(rs1.getFloat("participation"));
				tmVo.setStatus(rs1.getInt("status"));
				tmvList.add(tmVo);
			}
		} finally {
			closeAll(rs1, ps, conn);
		}

		return tmvList;
	}

	@Override
	public TeamInfoVO getTeamInfo(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		TeamInfoVO tiVo = new TeamInfoVO();
		try {
			conn = getConnection();
			String query = "select * from teaminfo where teamId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs1 = ps.executeQuery();
			if (rs1.next()) {
				TeamMemberVO tmVo = new TeamMemberVO();
				tiVo.setTeamId(rs1.getInt("teamId"));
				tiVo.setMannerScore(rs1.getInt("mannerScore"));
				tiVo.setMatchNum(rs1.getInt("matchNum"));
				tiVo.setRanking(rs1.getInt("ranking"));
				tiVo.setMemberNum(rs1.getInt("MemberNum"));
				tiVo.setTeamScore(rs1.getInt("teamScore"));
				tiVo.setWinningScore(rs1.getInt("winningScore"));
			}
		} finally {
			closeAll(rs1, ps, conn);
		}

		return tiVo;
	}

	@Override
	public StadiumVO getStadium(int stadiumId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		StadiumVO sVo = new StadiumVO();
		try {
			conn = getConnection();
			String query = "select * from stadium where stadiumId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, stadiumId);
			rs1 = ps.executeQuery();
			if (rs1.next()) {
				TeamMemberVO tmVo = new TeamMemberVO();
				sVo.setStadiumId(rs1.getInt("stadiumId"));
				sVo.setStadiumName(rs1.getString("stadiumName"));
				sVo.setStadiumAddr(rs1.getString("stadiumAddr"));
				sVo.setStadiumCost(rs1.getInt("stadiumCost"));
				sVo.setStadiumType(rs1.getString("stadiumType"));
			}
		} finally {
			closeAll(rs1, ps, conn);
		}

		return sVo;
	}

	@Override
	public int voteResultCount(int voteId) throws SQLException {
		int voteResultCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String query = "select count(case when voteId = ? and attendence = 1 then 1 end) okCount from voteresult";
			ps = conn.prepareStatement(query);
			ps.setInt(1, voteId);
			rs = ps.executeQuery();
			if (rs.next()) {
				voteResultCount = rs.getInt("okCount");
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return voteResultCount;
	}

	@Override
	public boolean isVoteDone(int teamMemberId, int VoteId) throws SQLException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String query = "select * from voteresult where teammemberId =? and VoteId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamMemberId);
			ps.setInt(2, VoteId);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return flag;

	}

	@Override
	public void VoteUpdate(VoteResultVO vRVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "update voteresult set attendence = ? where teammemberId =? and VoteId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vRVo.getAttendance());
			ps.setInt(2, vRVo.getTeamMemberId());
			ps.setInt(3, vRVo.getVoteId());
			System.out.println(ps.executeUpdate() + "명 투표 수정하였습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void insertStadium(StadiumVO sVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into stadium (stadiumName, stadiumAddr, stadiumCost, stadiumType) values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, sVo.getStadiumName());
			ps.setString(2, sVo.getStadiumAddr());
			ps.setInt(3, sVo.getStadiumCost());
			ps.setString(4, sVo.getStadiumType());
			System.out.println(ps.executeUpdate() + "개의 스타디움이 추가 되었습니다.");
		} finally {
			closeAll(ps, conn);

		}
	}

	@Override
	public void insertVoteResult(VoteResultVO vRVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into voteresult(voteId,teammemberId, attendence) values(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vRVo.getVoteId());
			ps.setInt(2, vRVo.getTeamMemberId());
			ps.setInt(3, vRVo.getAttendance());
			System.out.println(ps.executeUpdate() + "개 추가 되었습니다.");

		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public int getTeamMemberId(String userId, int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int teamMemberId = 0;
		try {
			conn = getConnection();
			String query = "select teamMemberId from teammember where userId=? and teamId =? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setInt(2, teamId);
			rs = ps.executeQuery();
			if (rs.next()) {
				teamMemberId = rs.getInt("teamMemberId");
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return teamMemberId;
	}

	@Override
	public void insertMatch(MatchVO mVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO soccerproject.match (schedule, awayId, stadiumId, homeSquad, awaySquad, teamId, voteId) VALUES(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, mVo.getSchedule());
			ps.setInt(2, mVo.getAwayId());
			ps.setInt(3, mVo.getStadiumId());
			ps.setString(4, mVo.getHomeSquad());
			ps.setString(5, mVo.getAwaySquad());
			ps.setInt(6, mVo.getTeamId());
			ps.setInt(7, mVo.getVoteId());
			System.out.println(ps.executeUpdate() + "매치 추가 성공");
		} finally {
			closeAll(ps, conn);

		}

	}

	@Override
	public void insertMatchResult(MatchResultVO mrvo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO match_result VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, mrvo.getScore());
			ps.setInt(2, mrvo.getToAwayMannerScore());
			ps.setInt(3, mrvo.getToHomeMannerScore());
			ps.setInt(4, mrvo.getMatchId());
			System.out.println(ps.executeUpdate() + "개 매치 결과에 기입 하였습니다.");

		} catch (SQLException e) {
			String query2 = "update match_result set  toHomeMannerScore = ?, toAwayMannerScore = ?, score = ? where matchId = ?";
			try {
				ps = conn.prepareStatement(query2);
				ps.setString(3, mrvo.getScore());
				ps.setInt(2, mrvo.getToAwayMannerScore());
				ps.setInt(1, mrvo.getToHomeMannerScore());
				ps.setInt(4, mrvo.getMatchId());
				System.out.println(ps.executeUpdate() + "개 매체 결과에 업데이트 하였습니다.");
			} catch (SQLException e1) {
				System.out.println(e1);
			}

		} finally {

			try {
				closeAll(ps, conn);
			} catch (SQLException e) {
				System.out.println(e);
			}
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
			while (rs1.next()) {
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
				if (rs2.next()) {
					MatchResultVO mrVo = new MatchResultVO();
					mrVo.setMatchId(vo.getMatchId());
					mrVo.setScore(rs2.getString("score"));
					mrVo.setToAwayMannerScore(rs2.getInt("to	AwayMannerScore"));
					mrVo.setToHomeMannerScore(rs2.getInt("toHomeMannerScore"));
					vo.setMrVo(mrVo);
				}
				mVo.add(vo);
			}
		} finally {
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
		try {
			conn = getConnection();
			String query = "SELECT v.*, m.* FROM voteresult v, `match` m WHERE v.teammemberid = ? AND v.attendence=? And v.voteid=m.voteid";
			// 투표 결과 테이블에서 본인이 속한 팀의 일정이면서 참석하겠다고 투표한 일정만 불러온다.
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamMemberId);
			ps.setInt(2, 1); // 참석구분 0,1
			rs = ps.executeQuery();
			while (rs.next()) {
				schedule.add(new MatchVO(rs.getInt("matchId"), rs.getInt("teamid"), rs.getInt("stadiumId"),
						rs.getString("schedule"), rs.getInt("awayId"), rs.getString("homesquad"),
						rs.getString("awaysquad"), rs.getInt("voteid")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(schedule);
		return schedule;
	}

	@Override
	public void deleteUser(String userId, String pass) throws SQLException {// 지워졌을 때랑 지워지지 않았을때, 로그인 로직으로 갈것인지, 실패 했을때랑
																			// 성공햇을 때 리턴값을 가지고 갈것인지.
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "delete from user where userId = ? and pass =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, pass);
			System.out.println(ps.executeUpdate() + "명 삭제 하였습니다.");

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteTeam(int teamId, String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "delete from team where teamId = ? and teamName =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			ps.setString(2, teamName);
			System.out.println(ps.executeUpdate() + "팀 삭제 하였습니다.");

		} finally {
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

			ps = conn.prepareStatement(query2);
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
	public TeamVO updateTeam(TeamVO tVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		PreparedStatement ps1 = null;
		ResultSet rs1 = null;

		PreparedStatement ps2 = null;

		PreparedStatement ps3 = null;
		ResultSet rs3 = null;

		TeamVO vo = new TeamVO();
		int tempStadiumId = 0;

		boolean flag = isExistStadiumName(tVo.getsVo().getStadiumName());// 기존에 팀이름이 있는지 확인

		conn = getConnection();

		if (flag == true) {// 있으면
			String query1 = "select stadiumId from stadium where stadiumName=?";
			ps1 = conn.prepareStatement(query1);
			ps1.setString(1, tVo.getsVo().getStadiumName());

			rs1 = ps1.executeQuery();

			if (rs1.next()) {
				tempStadiumId = rs1.getInt("stadiumId");
			}
		} else {// 없으면
			String query2 = "insert into stadium(stadiumName, stadiumAddr, stadiumCost, stadiumType) values(?,?,?,?)";
			ps2 = conn.prepareStatement(query2);

			ps2.setString(1, tVo.getsVo().getStadiumName());
			ps2.setString(2, tVo.getsVo().getStadiumAddr());
			ps2.setInt(3, tVo.getsVo().getStadiumCost());
			ps2.setString(4, tVo.getsVo().getStadiumType());

			ps2.executeUpdate();

			String query3 = "select stadiumId from stadium where stadiumName=?";
			ps3 = conn.prepareStatement(query3);
			ps3.setString(1, tVo.getsVo().getStadiumName());

			rs3 = ps3.executeQuery();

			if (rs3.next()) {
				tempStadiumId = rs3.getInt("stadiumId");
			}
		}

		try {
			String query = "update team set emblem=?, area1=?, area2=?, area3=?, stadiumId=? where teamId =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, tVo.getEmblem());
			ps.setString(2, tVo.getArea1());
			ps.setString(3, tVo.getArea2());
			ps.setString(4, tVo.getArea3());
			ps.setInt(5, tempStadiumId);
			ps.setInt(6, tVo.getTeamId());
			System.out.println(ps.executeUpdate() + "팀 수정 성공!!");

		} finally {
			closeAll(rs, ps, conn);
		}

		vo = getSelectedTeam(tVo.getTeamId());

		return vo;

	}

	@Override
	public VoteVO mostResentMatch(int teamId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VoteVO vVo = new VoteVO();
		int team = 0;
		try {
			conn = getConnection();
			String query = "select * from soccerproject.match where teamid = ? or awayId=? order by schedule desc limit 1";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			ps.setInt(2, teamId);
			rs = ps.executeQuery();

			if (rs.next()) {
				team = rs.getInt("teamId");
			}
			System.out.println(team);
			vVo = findVoteByTeamId(team);
		} finally {
			closeAll(rs, ps, conn);
		}
		return vVo;
	}

	@Override
	public void updateTeamInfo(TeamInfoVO tiVo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "update teaminfo set mannerScore=?, matchNum=?, teamScore=?, winningScore=? where teamId =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, tiVo.getMannerScore());
			System.out.println(tiVo.getMannerScore() + "getManerscore입니다.");
			ps.setInt(2, tiVo.getMatchNum());
			ps.setInt(3, tiVo.getTeamScore());
			ps.setInt(4, tiVo.getWinningScore());
			ps.setInt(5, tiVo.getTeamId());
			System.out.println(ps.executeUpdate() + "," + tiVo.getTeamId() + "팀아이디, 수정 성공!!");
			sortRanking();
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<UserVO> getJoinRequest(int teamId) throws SQLException {
		// (팀매니저 기준)현재 우리팀에 가입 요청한 회원들을 모두 불러오는 로직
		System.out.println("getJoinRequest BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList<UserVO> uVoList = new ArrayList<>();
		PlayerInfoVO pVo = null;

		try {
			conn = getConnection();
			String query = "SELECT u.pass as `password`, u.name, u.phoneNum, u.photo, u.ssn, u.nickName, u.gender, u.email, u.addr, u.favTeam1, u.favTeam2, u.regDate, u.country, u.recentLogin, p.* FROM teammember tm, team t, playerinfo p, `user` u WHERE tm.teamid=t.teamid AND tm.userid=p.userid AND p.userid=u.userid AND t.teamid=? AND tm.status=1;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, teamId);
			rs = ps.executeQuery();
			while (rs.next()) {
				pVo = new PlayerInfoVO(rs.getString("userId"), rs.getString("position"), rs.getString("mainFoot"),
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("injury"), rs.getInt("mental"),
						rs.getInt("speed"), rs.getInt("physical"), rs.getInt("dribble"), rs.getInt("pass"),
						rs.getInt("defence"), rs.getInt("total"));
				UserVO uVo = new UserVO(rs.getString("userId"), rs.getString("pass"), rs.getString("name"),
						rs.getString("phoneNum"), rs.getString("photo"), rs.getString("ssn"), rs.getString("nickName"),
						rs.getString("gender").charAt(0), rs.getString("email"), rs.getString("addr"),
						rs.getString("favTeam1"), rs.getString("favTeam2"), rs.getString("regDate"),
						rs.getString("country"), rs.getString("recentLogin"));
				uVo.setpVo(pVo);
				uVoList.add(uVo);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("실행 완료");
		return uVoList;
	}

	public ArrayList<TeamVO> showAllTeam() throws SQLException {
		System.out.println("ShowAllTeam BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TeamVO> tvList = new ArrayList<TeamVO>();
		TeamVO tVo = null;

		try {
			conn = getConnection();
			String query = "SELECT * FROM team t, teaminfo ti WHERE t.teamid=ti.teamid";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				tVo = new TeamVO(rs.getInt("teamId"), rs.getString("teamName"), rs.getString("emblem"),
						rs.getString("area1"), rs.getString("area2"), rs.getString("area3"), rs.getInt("stadiumId"));
				tVo.setTi(new TeamInfoVO(rs.getInt("teamId"), rs.getInt("mannerScore"), rs.getInt("matchNum"),
						rs.getInt("ranking"), rs.getInt("memberNum"), rs.getInt("teamScore"),
						rs.getInt("winningScore")));
				tvList.add(tVo);

			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return tvList;
	}

	@Override
	public boolean isExistTeamMember(String userId, int teamId) throws SQLException {
		System.out.println("팀 가입 중복 확인(isExistTeamMember) BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean check = false;

		try {
			conn = getConnection();
			String query = "SELECT * FROM teammember WHERE userid = ? AND teamId = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setInt(2, teamId);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("이미 가입한 팀입니다.");
				check = true;
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return check;
	}

	@Override
	public int FindTeamIdByTeamName(String teamName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int teamId = 0;

		try {
			conn = getConnection();
			String query = "SELECT * FROM team WHERE teamName=?";
			ps = conn.prepareCall(query);
			ps.setString(1, teamName);
			rs = ps.executeQuery();
			if (rs.next()) {
				teamId = rs.getInt("teamId");
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return teamId;
	}

	public boolean isExistStadiumName(String stadiumName) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean check = false;

		try {
			conn = getConnection();
			String query = "select stadiumName from stadium where stadiumName=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, stadiumName);

			rs = ps.executeQuery();

			if (rs.next()) {
				check = true;
			}

		} finally {
			closeAll(rs, ps, conn);
		}
		return check;
	}

	public void iAmManager(String userId, String teamName) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));

		int teamId = 0;
		System.out.println("iAmManager 안에 들어옴 ");
		try {
			conn = getConnection();

			String query1 = "select teamId from team where teamName=?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, teamName);

			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				teamId = rs.getInt("teamId");
			}

			String query = "insert into teammember(regDate, manager, status, userId, teamId) values(?,1,0,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, str);
			ps.setString(2, userId);
			ps.setInt(3, teamId);

			System.out.println(ps.executeUpdate() + "명 매니저 등록 완료");

		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public void sortRanking() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 1;
		int ranking = 0;

		try {
			conn = getConnection();
			String query = "select teamId, teamScore from teaminfo";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				map.put(rs.getInt("teamId"), rs.getInt("teamScore"));
			}

			List<Integer> keySetList = new ArrayList<>(map.keySet());

			Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

			for (Integer key : keySetList) {
				System.out.println("key : " + key + " / " + "value : " + map.get(key));

				String query1 = "update teaminfo set ranking=? where teamId=?";
				PreparedStatement ps1 = conn.prepareStatement(query1);
				ps1.setInt(1, i);
				ps1.setInt(2, key);

				System.out.println(i + "위 랭킹 팀" + ps1.executeUpdate() + "한개 변경");
				i++;
			}

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateMatch(int awayId, int matchId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "update soccerproject.match set awayId=? where matchId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, awayId);
			ps.setInt(2, matchId);
			System.out.println(ps.executeUpdate() + "어웨이팀 추가되어 경기 잡혔습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	public boolean isExistMatch(int awayId, int matchId) throws SQLException {
		System.out.println("경기 신청 중복 확인(isExistMatch) BL 호출");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean check = false;

		try {
			conn = getConnection();
			String query = "SELECT * FROM `match` where awayId = ? and matchId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, awayId);
			ps.setInt(2, matchId);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
				System.out.println("이미 경기 신청되어있음");
			}
		} finally {
			closeAll(ps, conn);
		}
		return check;
	}

	/*
	 * public static void main(String[] args) throws SQLException,
	 * UnsupportedEncodingException, ParseException { FootBallDAOImpl dao =
	 * FootBallDAOImpl.getInstance(); dao.recommendMatch(4, 10, 20, 30, 20, 20);
	 * 
	 * // DriverManager 방식의 DB Connection
	 * 
	 * // registerUser, registerPlayerinfo // dao.registerUser(new UserVO("id2",
	 * "pass1", "name1", "phoneNum1", "photo1", // "ssn1", "nickName1", 'm',
	 * "email1", "addr1", "favTeam11", "favTeam21", // "korea"), new
	 * PlayerInfoVO("id2","st", "left", 180, 70, 100, 100, 100, 100, // 100, 100));
	 * // dao.registerPlayerInfo(new PlayerInfoVO("id2","st", "left", 180, 70, 100,
	 * // 100, 100, 100, 100, 100));
	 * 
	 * // requestToJoin // dao.requestToJoin(new PlayerInfoVO("id1", "st","right",
	 * 180, 70, 100, 100, // 100, 100, 100, 100, 100), 2);
	 * 
	 * // allowToJoin // dao.allowToJoin(40);
	 * 
	 * // rejectToJoin // dao.rejectToJoin(40);
	 * 
	 * // makeTeam // ???
	 * 
	 * // showAllMember // System.out.println(dao.showAllMember(3));
	 * 
	 * // findByUserId // System.out.println(dao.findByUserId("aaa"));
	 * 
	 * // findByTeamName // System.out.println(dao.findByTeamName("FCaaa"));
	 * 
	 * // matchHistory // dao.matchHistory(2);
	 * 
	 * // login // UserVO vo = dao.login("aaa", "aaa"); // System.out.println(vo);
	 * 
	 * // recommend squad // dao.recommendSquad(3, 7, 1);
	 * 
	 * // makeVote // dao.makeVote(new VoteVO("안녕하세요. 반갑습니다.", "2020-07-02", "aaa",
	 * 1));
	 * 
	 * // insert VoteResult // VoteResultVO vVo = new VoteResultVO(7, 41, 0); //
	 * dao.insertVoteResult(vVo);
	 * 
	 * // insertMatchVO // dao.insertMatch(new MatchVO(2, 2, "2020-07-12", 3,
	 * "homeSquad", "awaySquad", // 7));
	 * 
	 * // insert match result // MatchResultVO mrvo = new MatchResultVO(7, "3:4", 5,
	 * 7); // dao.insertMatchResult(mrvo);
	 * 
	 * // TeamSchedule // System.out.println(dao.TeamSchedule(2));
	 * 
	 * // user schedule // dao.userSchedule(1);
	 * 
	 * /// delete // dao.deleteUser("zzz", "zzz"); // dao.deleteTeam(6, "FCfff");
	 * 
	 * // update // UserVO uVo = new UserVO("aaa", "aaa", "010-5621-4472",
	 * "img/aaa.jpg", "이재헌", // "111@gmail.com", "답십리", "바르셀로나", "레알마드리드", new
	 * PlayerInfoVO("LWF", "왼발", 190, // 80, 1, 80, 80, 80, 80, 80, 80, 0)); //
	 * dao.updateUser(uVo);
	 * 
	 * // update team // TeamVO tVo = new TeamVO(5, "FCeee", "img/FCeee.jpg", "서울",
	 * "제주", "강원도", 1); // dao.updateTeam(tVo);
	 * 
	 * }
	 */

}
