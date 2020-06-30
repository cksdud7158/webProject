package model;

public class MatchVO {
	private int matchId;
	private int teamId;
	private int stadiumId;
	private String schedule;
	private int awayId;
	private String homeSquad;
	private String awaySquad;
	private int voteId;
	private MatchResultVO mrVo ;
	private StadiumVO sVo;
	public StadiumVO getsVo() {
		return sVo;
	}


	public void setsVo(StadiumVO sVo) {
		this.sVo = sVo;
	}


	public MatchVO() {
		super();
	}
	
	
	public MatchVO(int teamId, int stadiumId, String schedule, int awayId, String homeSquad, String awaySquad,
			int voteId) {
		super();
		this.teamId = teamId;
		this.stadiumId = stadiumId;
		this.schedule = schedule;
		this.awayId = awayId;
		this.homeSquad = homeSquad;
		this.awaySquad = awaySquad;
		this.voteId = voteId;
	}


	public MatchVO(int matchId, int teamId, int stadiumId, String schedule, int awayId, String homeSquad,
			String awaySquad, int voteId) {
		super();
		this.matchId = matchId;
		this.teamId = teamId;
		this.stadiumId = stadiumId;
		this.schedule = schedule;
		this.awayId = awayId;
		this.homeSquad = homeSquad;
		this.awaySquad = awaySquad;
		this.voteId = voteId;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public int getAwayId() {
		return awayId;
	}
	public void setAwayId(int awayId) {
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
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public MatchResultVO getMrVo() {
		return mrVo;
	}
	public void setMrVo(MatchResultVO mrVo) {
		this.mrVo = mrVo;
	}
	@Override
	public String toString() {
		return "MatchVO [matchId=" + matchId + ", teamId=" + teamId + ", stadiumId=" + stadiumId + ", schedule="
				+ schedule + ", awayId=" + awayId + ", homeSquad=" + homeSquad + ", awaySquad=" + awaySquad
				+ ", voteId=" + voteId + ", mrVo=" + mrVo + "]";
	}
	
	
}
