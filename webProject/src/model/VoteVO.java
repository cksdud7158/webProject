package model;

public class VoteVO {
	private int voteId;
	private String userId;
	private int attendance;
	private String contents;
	private String dueDate;
	private int teamId;
	private String matchId;
	
	public VoteVO(int voteId, String userId, int attendance, String dueDate, int teamId, String matchId) {
		super();
		this.voteId = voteId;
		this.userId = userId;
		this.attendance = attendance;
		this.dueDate = dueDate;
		this.teamId = teamId;
		this.matchId = matchId;
	}
	public VoteVO(int voteId, String userId, int attendance, String contents, String dueDate, int teamId,
			String matchId) {
		super();
		this.voteId = voteId;
		this.userId = userId;
		this.attendance = attendance;
		this.contents = contents;
		this.dueDate = dueDate;
		this.teamId = teamId;
		this.matchId = matchId;
	}
	
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	@Override
	public String toString() {
		return "VoteVO [voteId=" + voteId + ", userId=" + userId + ", attendance=" + attendance + ", contents="
				+ contents + ", dueDate=" + dueDate + ", teamId=" + teamId + ", matchId=" + matchId + "]";
	}
}