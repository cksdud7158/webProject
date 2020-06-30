package model;

import java.util.ArrayList;

public class UserVO {
	private String userId;
	private String pass;
	private String name;
	private String phoneNum;
	private String photo;
	private String ssn;
	private String nickName;
	private char gender;
	private String email;
	private String addr;
	private String favTeam1;
	private String favTeam2;
	private String regDate;
	private String country;
	private String recentLogin;
	private ArrayList<TeamMemberVO> tVoList;
	private PlayerInfoVO pVo;
	
	public UserVO() {
		super();
	}

	public UserVO(String userId, String pass, String phoneNum, String photo, String nickName, String email, String addr, String favTeam1,
			String favTeam2, PlayerInfoVO pVo) {
		super();
		this.userId=userId;
		this.pass = pass;
		this.phoneNum = phoneNum;
		this.photo = photo;
		this.nickName = nickName;
		this.email = email;
		this.addr = addr;
		this.favTeam1 = favTeam1;
		this.favTeam2 = favTeam2;
		this.pVo = pVo;
	}
	
	

	public UserVO(String userId, String pass, String name, String phoneNum, String photo, String ssn, String nickName,
			char gender, String email, String addr, String favTeam1, String favTeam2, String country) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.phoneNum = phoneNum;
		this.photo = photo;
		this.ssn = ssn;
		this.nickName = nickName;
		this.gender = gender;
		this.email = email;
		this.addr = addr;
		this.favTeam1 = favTeam1;
		this.favTeam2 = favTeam2;
		this.country = country;
	}

	public UserVO(String userId, String pass, String name, String phoneNum, String ssn, char gender, String email,
			String addr, String regDate, String recentLogin) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.phoneNum = phoneNum;
		this.ssn = ssn;
		this.gender = gender;
		this.email = email;
		this.addr = addr;
		this.regDate = regDate;
		this.recentLogin = recentLogin;
	}

	public UserVO(String userId, String pass, String name, String phoneNum, String photo, String ssn, String nickName,
			char gender, String email, String addr, String favTeam1, String favTeam2, String regDate, String country,
			String recentLogin) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.phoneNum = phoneNum;
		this.photo = photo;
		this.ssn = ssn;
		this.nickName = nickName;
		this.gender = gender;
		this.email = email;
		this.addr = addr;
		this.favTeam1 = favTeam1;
		this.favTeam2 = favTeam2;
		this.regDate = regDate;
		this.country = country;
		this.recentLogin = recentLogin;
	}

	public UserVO(String userId, String pass, String name, String phoneNum, String photo, String ssn, String nickName,
			char gender, String email, String addr, String favTeam1, String favTeam2, String regDate, String country,
			String recentLogin, ArrayList<TeamMemberVO> tVoList, PlayerInfoVO pVo) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.phoneNum = phoneNum;
		this.photo = photo;
		this.ssn = ssn;
		this.nickName = nickName;
		this.gender = gender;
		this.email = email;
		this.addr = addr;
		this.favTeam1 = favTeam1;
		this.favTeam2 = favTeam2;
		this.regDate = regDate;
		this.country = country;
		this.recentLogin = recentLogin;
		this.tVoList = tVoList;
		this.pVo = pVo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getFavTeam1() {
		return favTeam1;
	}

	public void setFavTeam1(String favTeam1) {
		this.favTeam1 = favTeam1;
	}

	public String getFavTeam2() {
		return favTeam2;
	}

	public void setFavTeam2(String favTeam2) {
		this.favTeam2 = favTeam2;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRecentLogin() {
		return recentLogin;
	}

	public void setRecentLogin(String recentLogin) {
		this.recentLogin = recentLogin;
	}

	public ArrayList<TeamMemberVO> gettVoList() {
		return tVoList;
	}

	public void settVoList(ArrayList<TeamMemberVO> tVoList) {
		this.tVoList = tVoList;
	}

	public PlayerInfoVO getpVo() {
		return pVo;
	}

	public void setpVo(PlayerInfoVO pVo) {
		this.pVo = pVo;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", pass=" + pass + ", name=" + name + ", phoneNum=" + phoneNum + ", photo="
				+ photo + ", ssn=" + ssn + ", nickName=" + nickName + ", gender=" + gender + ", email=" + email
				+ ", addr=" + addr + ", favTeam1=" + favTeam1 + ", favTeam2=" + favTeam2 + ", regDate=" + regDate
				+ ", country=" + country + ", recentLogin=" + recentLogin + ", tVoList=" + tVoList + ", pVo=" + pVo
				+ "]";
	}

	
		
	
}
