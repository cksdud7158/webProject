package model;

public class ScoreVO {
	private String area1;
	private String area2;
	private String area3;
	private double nearest_distance; 
	private int ranking_distance;
	private int mannerScore;
	private int matchNum;
	private int ranking;
	private int memberNum;
	private int winningScore;
	private int teamId;
	private String teamName;
	
	public ScoreVO() {};
	public ScoreVO(String area1, String area2, String area3, double nearest_distance, int ranking_distance,
			int mannerScore, int matchNum, int ranking, int memberNum, int winningScore, int teamId, String teamName) {
		super();
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
		this.nearest_distance = nearest_distance;
		this.ranking_distance = ranking_distance;
		this.mannerScore = mannerScore;
		this.matchNum = matchNum;
		this.ranking = ranking;
		this.memberNum = memberNum;
		this.winningScore = winningScore;
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getArea3() {
		return area3;
	}
	public void setArea3(String area3) {
		this.area3 = area3;
	}
	public double getNearest_distance() {
		return nearest_distance;
	}
	public void setNearest_distance(double nearest_distance) {
		this.nearest_distance = nearest_distance;
	}
	public int getRanking_distance() {
		return ranking_distance;
	}
	public void setRanking_distance(int ranking_distance) {
		this.ranking_distance = ranking_distance;
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
	public int getWinningScore() {
		return winningScore;
	}
	public void setWinningScore(int winningScore) {
		this.winningScore = winningScore;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "ScoreVO [area1=" + area1 + ", area2=" + area2 + ", area3=" + area3 + ", nearest_distance="
				+ nearest_distance + ", ranking_distance=" + ranking_distance + ", mannerScore=" + mannerScore
				+ ", matchNum=" + matchNum + ", ranking=" + ranking + ", memberNum=" + memberNum + ", winningScore="
				+ winningScore + ", teamId=" + teamId + ", teamName=" + teamName + "]";
	}
}
