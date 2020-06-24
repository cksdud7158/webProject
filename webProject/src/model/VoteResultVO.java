package model;

public class VoteResultVO {
	private String voteId;
	private String teamMemberId;
	private int attendance;
	
	public VoteResultVO(String voteId, String teamMemberId, int attendance) {
		super();
		this.voteId = voteId;
		this.teamMemberId = teamMemberId;
		this.attendance = attendance;
	}

	public String getVoteId() {
		return voteId;
	}

	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}

	public String getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(String teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "VoteResultVO [voteId=" + voteId + ", teamMemberId=" + teamMemberId + ", attendance=" + attendance
				+ ", getVoteId()=" + getVoteId() + ", getTeamMemberId()=" + getTeamMemberId() + ", getAttendance()="
				+ getAttendance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
