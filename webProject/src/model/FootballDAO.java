package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.UserVO;

public interface FootballDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//Business Logics
	//로그인
	UserVO login(String userId, String password) throws SQLException;
	
	//회원가입 및 등록	
	void registerUser(UserVO vo) throws SQLException;
	void requestToJoin(PlayerInfoVo pVo, TeamMemberVO tVo) throws SQLException;
	void allowToJoin(PlayerInfoVo pVo, TeamMemberVO tVo) throws SQLException;
	void rejectToJoin(PlayerInfoVo pVo, TeamMemberVO tVo) throws SQLException;
	void makeTeam(TeamVO vo) throws SQLException;
	
	
	//검색
	ArrayList<UserVO> showAllMember() throws SQLException;
	UserVO findByUserId(String userId) throws SQLException;
	UserVO findByNickName(String nickName) throws SQLException;
	TeamVO findByTeamName(String teamName) throws SQLException;
	ArrayList<TeamVO> myTeamList(String userId) throws SQLException; 
	
	
	//전적조회
	ArrayList<MatchResultVO> matchHistory() throws SQLException;
	

	ArrayList<MatchResultVO> recommendMatch(String area) throws SQLException;
	
	void makeVote(VoteVO vVo, MatchResultVO mVo) throws SQLException;
	void insertVoteResult(VoteVO vVo) throws SQLException;
	void insertMatch(MatchResultVO mVo) throws SQLException;
	void insertMarchResult(MatchResultVO vo) throws SQLException;
	ArrayList<MatchResultVO> recommendSquad(VoteVO vo) throws SQLException;
	ArrayList<MatchResultVO> TeamSchedule(String teamId) throws SQLException;
	ArrayList<MatchResultVO> userSchedule(String userId) throws SQLException;
	
	//delete
	void deleteUser(String userId, String pass) throws SQLException;
	void deleteTeam(String teamId, String teamName) throws SQLException;
	
	//update
	void updateUser(UserVO uVo) throws SQLException;
	void updateTeam(TeamVO tVo) throws SQLException;
}
