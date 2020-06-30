package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FootballDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	
	
	//회원가입 및 등록	
	void registerUser(UserVO vo, PlayerInfoVO pVO) throws SQLException;
	void registerPlayerInfo(PlayerInfoVO pVO)throws SQLException;
	void requestToJoin(PlayerInfoVO pVo, int teamId) throws SQLException;
	void allowToJoin(int teamMemberId) throws SQLException;
	void rejectToJoin(int teamMemberId) throws SQLException;
	void insertStadium(StadiumVO sVo) throws SQLException;
	void makeTeam(TeamVO vo) throws SQLException;
	
	
	//검색
	ArrayList<PlayerInfoVO> showAllMember(int teamId) throws SQLException;
	UserVO findByUserId(String userId) throws SQLException;
	TeamVO findByTeamName(String teamName) throws SQLException;
	ArrayList<TeamVO> myTeamList(String userId) throws SQLException; 
	
	
	//전적조회
	ArrayList<MatchVO> matchHistory(int teamId) throws SQLException;
	

	ArrayList<MatchVO> recommendMatch(String area) throws SQLException;
		
	
	
	
	
	//Business Logics
		//로그인
	UserVO login(String userId, String password) throws SQLException;
	ArrayList<UserVO> recommendSquad(int participation, int totalAbility, int teamid) throws SQLException;
		
	void makeVote(VoteVO vVo) throws SQLException;
	void insertVoteResult(VoteResultVO vRVo) throws SQLException;
	void insertMatch(MatchVO mVo) throws SQLException;
	void insertMatchResult(MatchResultVO vo) throws SQLException;
	
	ArrayList<MatchVO> TeamSchedule(int teamId) throws SQLException;
	ArrayList<MatchVO> userSchedule(int teamMemberId) throws SQLException;
	
	//delete
	void deleteUser(String userId, String pass) throws SQLException;
	void deleteTeam(int teamId, String teamName) throws SQLException;
	
	//update
	void updateUser(UserVO uVo) throws SQLException;
	void updateTeam(TeamVO tVo) throws SQLException;
	MatchResultVO findMatchResultByMatchId(int matchId) throws SQLException;
	MatchVO findMatchByVoteId(int VoteId) throws SQLException;
	ArrayList<VoteResultVO> findVoteResult(int voteId) throws SQLException;
	TeamVO getSelectedTeam(String userId, int teamId) throws SQLException;
	VoteVO findVoteByTeamId(int teamId) throws SQLException;
	
}
