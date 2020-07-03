package model;

public class TotalVO {
	private int teamId;
	private String emblem; 
	private String teamName;
	private int stadiumId;
	private String stadiumName;
	private double ranking;
	private double distance_min;
	private double distance_min_normalised; 
	private double mannersScore;
	private double mannersScore_normalised;
	private double matchNum;
	private double matchNum_normalised;
	private double memberNum;
	private double memberNum_noramlised;
	private double winningScore;
	private double winningScore_normalised;
	private double total_score;
	private int matchId;
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public TotalVO() {}
	public TotalVO(double distance_min) {
		super();
		this.distance_min = distance_min;
	}
	public TotalVO(int teamId, String emblem, String teamName, int stadiumId, double ranking, double distance_min, double mannersScore, double matchNum, double memberNum, double winningScore) {
		super();
		this.teamId = teamId;
		this.emblem = emblem;
		this.teamName = teamName;
		this.stadiumId = stadiumId;
		this.ranking = ranking;
		this.distance_min = distance_min;
		this.mannersScore = mannersScore;
		this.matchNum = matchNum;
		this.memberNum = memberNum;
		this.winningScore = winningScore;
	}
	public TotalVO(int teamId, String emblem, String teamName, int stadiumId, String stadiumName, double ranking, double distance_min, double mannersScore, double matchNum, double memberNum, double winningScore) {
		super();
		this.teamId = teamId;
		this.emblem = emblem;
		this.teamName = teamName;
		this.stadiumId = stadiumId;
		this.stadiumName = stadiumName;
		this.ranking = ranking;
		this.distance_min = distance_min;
		this.mannersScore = mannersScore;
		this.matchNum = matchNum;
		this.memberNum = memberNum;
		this.winningScore = winningScore;
	}
	public TotalVO(int teamId, String emblem, String teamName, double ranking, double distance_min,
			double distance_min_normalised, double mannersScore, double mannersScore_normalised, double matchNum,
			double matchNum_normalised, double memberNum, double memberNum_noramlised, double winningScore,
			double winningScore_normalised, double total_score) {
		super();
		this.teamId = teamId;
		this.emblem = emblem;
		this.teamName = teamName;
		this.ranking = ranking;
		this.distance_min = distance_min;
		this.distance_min_normalised = distance_min_normalised;
		this.mannersScore = mannersScore;
		this.mannersScore_normalised = mannersScore_normalised;
		this.matchNum = matchNum;
		this.matchNum_normalised = matchNum_normalised;
		this.memberNum = memberNum;
		this.memberNum_noramlised = memberNum_noramlised;
		this.winningScore = winningScore;
		this.winningScore_normalised = winningScore_normalised;
		this.total_score = total_score;
	}
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getEmblem() {
		return emblem;
	}
	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getRanking() {
		return ranking;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	public double getDistance_min() {
		return distance_min;
	}
	public void setDistance_min(double distance_min) {
		this.distance_min = distance_min;
	}
	public double getDistance_min_normalised() {
		return distance_min_normalised;
	}
	public void setDistance_min_normalised(double distance_min_normalised) {
		this.distance_min_normalised = distance_min_normalised;
	}
	public double getMannersScore() {
		return mannersScore;
	}
	public void setMannersScore(double mannersScore) {
		this.mannersScore = mannersScore;
	}
	public double getMannersScore_normalised() {
		return mannersScore_normalised;
	}
	public void setMannersScore_normalised(double mannersScore_normalised) {
		this.mannersScore_normalised = mannersScore_normalised;
	}
	public double getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(double matchNum) {
		this.matchNum = matchNum;
	}
	public double getMatchNum_normalised() {
		return matchNum_normalised;
	}
	public void setMatchNum_normalised(double matchNum_normalised) {
		this.matchNum_normalised = matchNum_normalised;
	}
	public double getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(double memberNum) {
		this.memberNum = memberNum;
	}
	public double getMemberNum_noramlised() {
		return memberNum_noramlised;
	}
	public void setMemberNum_noramlised(double memberNum_noramlised) {
		this.memberNum_noramlised = memberNum_noramlised;
	}
	public double getWinningScore() {
		return winningScore;
	}
	public void setWinningScore(double winningScore) {
		this.winningScore = winningScore;
	}
	public double getWinningScore_normalised() {
		return winningScore_normalised;
	}
	public void setWinningScore_normalised(double winningScore_normalised) {
		this.winningScore_normalised = winningScore_normalised;
	}
	public double getTotal_score() {
		return total_score;
	}
	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}
	
	
	
	public int getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	@Override
	public String toString() {
		return "TotalVO [teamId=" + teamId + ", emblem=" + emblem + ", teamName=" + teamName + ", stadiumId="
				+ stadiumId + ", stadiumName=" + stadiumName + ", ranking=" + ranking + ", distance_min=" + distance_min
				+ ", distance_min_normalised=" + distance_min_normalised + ", mannersScore=" + mannersScore
				+ ", mannersScore_normalised=" + mannersScore_normalised + ", matchNum=" + matchNum
				+ ", matchNum_normalised=" + matchNum_normalised + ", memberNum=" + memberNum
				+ ", memberNum_noramlised=" + memberNum_noramlised + ", winningScore=" + winningScore
				+ ", winningScore_normalised=" + winningScore_normalised + ", total_score=" + total_score + "]";
	}

}
