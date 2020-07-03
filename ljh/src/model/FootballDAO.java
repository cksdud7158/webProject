package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface FootballDAO {
	Connection getConnection() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	// 회원가입 및 등록
	void registerUser(UserVO vo, PlayerInfoVO pVO) throws SQLException;

	void registerPlayerInfo(PlayerInfoVO pVO) throws SQLException;

	void requestToJoin(PlayerInfoVO pVo, int teamId) throws SQLException;

	void allowToJoin(int teamMemberId) throws SQLException;

	void rejectToJoin(int teamMemberId) throws SQLException;

	void insertStadium(StadiumVO sVo) throws SQLException;

	void makeTeam(TeamVO vo) throws SQLException;

	// 검색
	ArrayList<PlayerInfoVO> showAllMember(int teamId) throws SQLException;

	UserVO findByUserId(String userId) throws SQLException;

	TeamVO findByTeamName(String teamName) throws SQLException;

	ArrayList<TeamVO> myTeamList(String userId) throws SQLException;

	// 전적조회
	ArrayList<MatchVO> matchHistory(int teamId) throws SQLException;

	// Business Logics
	// 로그인
	UserVO login(String userId, String password) throws SQLException;

	ArrayList<UserVO> recommendSquad(int participationIndex, int totalAbilityIndex, int teamId) throws SQLException;

	void makeVote(VoteVO vVo) throws SQLException;

	void insertVoteResult(VoteResultVO vRVo) throws SQLException;

	void insertMatch(MatchVO mVo) throws SQLException;

	void insertMatchResult(MatchResultVO mrvo) throws SQLException;

	ArrayList<MatchVO> TeamSchedule(int teamId) throws SQLException;

	ArrayList<MatchVO> userSchedule(int teamMemberId) throws SQLException;

	// delete
	void deleteUser(String userId, String pass) throws SQLException;

	void deleteTeam(int teamId, String teamName) throws SQLException;

	// update
	void updateUser(UserVO uVo) throws SQLException;

	TeamVO updateTeam(TeamVO tVo) throws SQLException;

	MatchResultVO findMatchResultByMatchId(int matchId) throws SQLException;

	MatchVO findMatchByVoteId(int VoteId) throws SQLException;


	TeamVO getSelectedTeam(int teamId) throws SQLException;

	VoteVO findVoteByTeamId(int teamId) throws SQLException;

	StadiumVO findStadiumByStadiumId(int StadiumsId) throws SQLException;

	int getTeamMemberId(String userId, int teamId) throws SQLException;

	ArrayList<VoteResultVO> findVoteResultByVoteId(int voteId) throws SQLException;

	boolean isVoteDone(int teamMemberId, int VoteId) throws SQLException;

	void VoteUpdate(VoteResultVO vRVo) throws SQLException;

	int voteResultCount(int voteId) throws SQLException;

	ArrayList<TeamMemberVO> getTeamMemberList(int teamId) throws SQLException;

	TeamInfoVO getTeamInfo(int teamId) throws SQLException;

	StadiumVO getStadium(int stadiumId) throws SQLException;

	TeamVO findTeamByTeamId(int TeamId) throws SQLException;

	String getUserIdByTeamMemberId(int teamMemberId) throws SQLException;

	UserVO findByTeamMemberId(int teamMemberId) throws SQLException;

	ArrayList<UserVO> attendUser(int voteId) throws SQLException;

	VoteVO mostResentMatch(int teamId) throws SQLException;

	void updateTeamInfo(TeamInfoVO tiVo) throws SQLException;

	ArrayList<UserVO> getJoinRequest(int teamId) throws SQLException;

	void requestToJoin(String userId, int teamId) throws SQLException;

	boolean isExistTeamMember(String userId, int teamId) throws SQLException;

	int FindTeamIdByTeamName(String teamName) throws SQLException;

	void sortRanking() throws SQLException;

	ArrayList<TotalVO> recommendMatch(int teamId, int x, int y, int z, int n, int m)
			throws SQLException, UnsupportedEncodingException, ParseException, org.json.simple.parser.ParseException;

	void updateMatch(int awayId, int matchId) throws SQLException;

	int findMatchIdbyVoteId(int voteId) throws SQLException;

}
