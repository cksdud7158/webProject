package model;

public class VoteResultVO {
	private int voteId;
	private int teamMemberId;
	private int attendance;

	public VoteResultVO() {
		super();
	}

	public VoteResultVO(int voteId, int teamMemberId, int attendance) {
		super();
		this.voteId = voteId;
		this.teamMemberId = teamMemberId;
		this.attendance = attendance;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public int getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(int teamMemberId) {
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
