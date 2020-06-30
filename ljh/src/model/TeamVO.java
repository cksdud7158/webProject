package model;
import java.util.ArrayList;
public class TeamVO {
	private int teamId;
	private String teamName;
	private String emblem;
	private String area1;
	private String area2="없음";
	private String area3="없음";
	private int stadiumId;
	ArrayList<TeamMemberVO> tmvList;
	private TeamInfoVO ti;
	private StadiumVO sVo;
	
	public TeamVO() {
		super();
	}
	public TeamVO(int teamId, String teamName, String emblem, String area1, String area2, String area3,
			int stadiumId) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.emblem = emblem;
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
		this.stadiumId = stadiumId;
	}
	public TeamVO(int teamId, String teamName, String emblem, String area1, String area2, String area3, int stadiumId,
			ArrayList<TeamMemberVO> tmvList) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.emblem = emblem;
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
		this.stadiumId = stadiumId;
		this.tmvList = tmvList;
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
	public int getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}
	public ArrayList<TeamMemberVO> getTmvList() {
		return tmvList;
	}
	public void setTmvList(ArrayList<TeamMemberVO> tmvList) {
		this.tmvList = tmvList;
	}	
	
	public TeamInfoVO getTi() {
		return ti;
	}
	public StadiumVO getsVo() {
		return sVo;
	}
	public void setsVo(StadiumVO sVo) {
		this.sVo = sVo;
	}
	public void setTi(TeamInfoVO ti) {
		this.ti = ti;
	}
	@Override
	public String toString() {
		return "TeamVO [teamId=" + teamId + ", teamName=" + teamName + ", emblem=" + emblem + ", area1=" + area1
				+ ", area2=" + area2 + ", area3=" + area3 + ", stadiumId=" + stadiumId + ", tmvList=" + tmvList
				+ ", ti=" + ti + ", sVo=" + sVo + "]";
	}
	
}