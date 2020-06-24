package model;

public class TeamMemberVO {
	private String userId;
	private int teamId;
	private String regDate;
	private int manager;
	private float participation;
	private int status;
	public TeamMemberVO() {
		super();
	}
	public TeamMemberVO(String userId, int teamId, String regDate, int manager, float participation, int status) {
		super();
		this.userId = userId;
		this.teamId = teamId;
		this.regDate = regDate;
		this.manager = manager;
		this.participation = participation;
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public float getParticipation() {
		return participation;
	}
	public void setParticipation(float participation) {
		this.participation = participation;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TeamMemberVO [userId=" + userId + ", teamId=" + teamId + ", regDate=" + regDate + ", manager=" + manager
				+ ", participation=" + participation + ", status=" + status + "]";
	}
	
	
}
