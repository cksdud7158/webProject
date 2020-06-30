package model;

public class StadiumVO {
	private int stadiumId;
	private String stadiumName;
	private String stadiumAddr;
	private int stadiumCost;
	private String stadiumType;
	
	public StadiumVO() {}
	public StadiumVO(int stadiumId, String stadiumName, String stadiumAddr, int stadiumCost, String stadiumType) {
		super();
		this.stadiumId = stadiumId;
		this.stadiumName = stadiumName;
		this.stadiumAddr = stadiumAddr;
		this.stadiumCost = stadiumCost;
		this.stadiumType = stadiumType;
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
	public String getStadiumAddr() {
		return stadiumAddr;
	}
	public void setStadiumAddr(String stadiumAddr) {
		this.stadiumAddr = stadiumAddr;
	}
	public int getStadiumCost() {
		return stadiumCost;
	}
	public void setStadiumCost(int stadiumCost) {
		this.stadiumCost = stadiumCost;
	}
	public String getStadiumType() {
		return stadiumType;
	}
	public void setStadiumType(String stadiumType) {
		this.stadiumType = stadiumType;
	}
	
	@Override
	public String toString() {
		return "Stadium [stadiumId=" + stadiumId + ", stadiumName=" + stadiumName + ", stadiumAddr=" + stadiumAddr
				+ ", stadiumCost=" + stadiumCost + ", stadiumType=" + stadiumType + "]";
	}
	
}
