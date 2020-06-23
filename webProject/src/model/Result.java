package main;

public class Result {
	private String matchId;
	private int score;
	private int toAwayMannerScore;
	private int toHomeMannerScore;
	
	public Result() {}
	public Result(String matchId, int score, int toAwayMannerScore, int toHomeMa) {
		super();
		this.matchId = matchId;
		this.score = score;
		this.toAwayMannerScore = toAwayMannerScore;
		this.toHomeMannerScore = toHomeMa;
	}
	
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getToAwayMannerScore() {
		return toAwayMannerScore;
	}
	public void setToAwayMannerScore(int toAwayMannerScore) {
		this.toAwayMannerScore = toAwayMannerScore;
	}
	public int getToHomeMannerScore() {
		return toHomeMannerScore;
	}
	public void setToHomeMannerScore(int toHomeMannerScore) {
		this.toHomeMannerScore = toHomeMannerScore;
	}
	
	@Override
	public String toString() {
		return "Result [matchId=" + matchId + ", score=" + score + ", toAwayMannerScore=" + toAwayMannerScore
				+ ", toHomeMannerScore=" + toHomeMannerScore + "]";
	}	
}
