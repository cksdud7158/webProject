package model;

public class TeamInfoVO {
	private int teamId;
	private int mannerScore;
	private int matchNum;
	private int ranking;
	private int memberNum;
	private int teamScore;
	private int winningScore;
	
	public TeamInfoVO() {}
	public TeamInfoVO(int teamId, int mannerScore, int matchNum, int ranking, int memberNum, int teamScore,
			int winningScore) {
		super();
		this.teamId = teamId;
		this.mannerScore = mannerScore;
		this.matchNum = matchNum;
		this.ranking = ranking;
		this.memberNum = memberNum;
		this.teamScore = teamScore;
		this.winningScore = winningScore;
	}
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getMannerScore() {
		return mannerScore;
	}
	public void setMannerScore(int mannerScore) {
		this.mannerScore = mannerScore;
	}
	public int getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getTeamScore() {
		return teamScore;
	}
	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}
	public int getWinningScore() {
		return winningScore;
	}
	public void setWinningScore(int winningScore) {
		this.winningScore = winningScore;
	}
	
	@Override
	public String toString() {
		return "TeamInfo [teamId=" + teamId + ", mannerScore=" + mannerScore + ", matchNum=" + matchNum + ", ranking="
				+ ranking + ", memberNum=" + memberNum + ", teamScore=" + teamScore + ", winningScore=" + winningScore
				+ "]";
	}		
}
