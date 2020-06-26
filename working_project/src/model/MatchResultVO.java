package model;

public class MatchResultVO {
	private int matchId;
	private String score;
	private int toAwayMannerScore;
	private int toHomeMannerScore;
	
	public MatchResultVO() {}
	public MatchResultVO(String score, int toAwayMannerScore, int toHomeMa) {
		this.score = score;
		this.toAwayMannerScore = toAwayMannerScore;
		this.toHomeMannerScore = toHomeMa;
	}
	public MatchResultVO(int matchId, String score, int toAwayMannerScore, int toHomeMa) {
		super();
		this.matchId = matchId;
		this.score = score;
		this.toAwayMannerScore = toAwayMannerScore;
		this.toHomeMannerScore = toHomeMa;
	}
	
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
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
