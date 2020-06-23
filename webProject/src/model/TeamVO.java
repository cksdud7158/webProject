package model;

public class TeamVO {
	private String teamId;
	private String teamName;
	private String emblem;
	private String area1;
	private String area2;
	private String area3;
	private String stadiumId;
	
	public TeamVO(String teamId, String teamName, String emblem, String area1, String area2, String area3,
			String stadiumId) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.emblem = emblem;
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
		this.stadiumId = stadiumId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getEmblem() {
		return emblem;
	}

	public void setEmblem(String emblem) {
		this.emblem = emblem;
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

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	@Override
	public String toString() {
		return "TeamVO [teamId=" + teamId + ", teamName=" + teamName + ", emblem=" + emblem + ", area1=" + area1
				+ ", area2=" + area2 + ", area3=" + area3 + ", stadiumId=" + stadiumId + "]";
	}
	
	
}
