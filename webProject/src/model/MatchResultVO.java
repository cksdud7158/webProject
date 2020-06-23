package model;

public class MatchResultVO {
	private String matchId;
	private String teamId;
	private String stadiumId;
	private String schedule;
	private String awayId;
	private String homeSquad;
	private String awaySquad;
	private ResultVO result;
	
	public MatchResultVO(String matchId, String teamId, String stadiumId, String schedule) {
		super();
		this.matchId = matchId;
		this.teamId = teamId;
		this.stadiumId = stadiumId;
		this.schedule = schedule;
	}
	public MatchResultVO(String matchId, String teamId, String stadiumId, String schedule, String awayId, String homeSquad,
			String awaySquad, ResultVO result) {
		super();
		this.matchId = matchId;
		this.teamId = teamId;
		this.stadiumId = stadiumId;
		this.schedule = schedule;
		this.awayId = awayId;
		this.homeSquad = homeSquad;
		this.awaySquad = awaySquad;
		this.result = result;
	}
	
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getAwayId() {
		return awayId;
	}
	public void setAwayId(String awayId) {
		this.awayId = awayId;
	}
	public String getHomeSquad() {
		return homeSquad;
	}
	public void setHomeSquad(String homeSquad) {
		this.homeSquad = homeSquad;
	}
	public String getAwaySquad() {
		return awaySquad;
	}
	public void setAwaySquad(String awaySquad) {
		this.awaySquad = awaySquad;
	}
	public ResultVO getResult() {
		return result;
	}
	public void setResult(ResultVO result) {
		this.result = result;
	}
	
	
	@Override
	public String toString() {
		return "MatchVO [matchId=" + matchId + ", teamId=" + teamId + ", stadiumId=" + stadiumId + ", schedule="
				+ schedule + ", awayId=" + awayId + ", homeSquad=" + homeSquad + ", awaySquad=" + awaySquad + "]";
	}
}
