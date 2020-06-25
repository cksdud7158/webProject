package model;

public class VoteVO {
	private int voteId;
	private String contents;
	private String dueDate;
	private String writer;
	private int teamId;
	private MatchVO mVo;
	private VoteResultVO vVo;
	public VoteVO() {
		super();
	}
	
	
	public VoteVO(String contents, String dueDate, String writer, int teamId) {
		super();
		this.contents = contents;
		this.dueDate = dueDate;
		this.writer = writer;
		this.teamId = teamId;
	}


	public VoteVO(int voteId, String contents, String dueDate, String writer, int teamId) {
		super();
		this.voteId = voteId;
		this.contents = contents;
		this.dueDate = dueDate;
		this.writer = writer;
		this.teamId = teamId;
	}


	public VoteVO(int voteId, String contents, String dueDate, String writer, int teamId, MatchVO mVo,
			VoteResultVO vVo) {
		super();
		this.voteId = voteId;
		this.contents = contents;
		this.dueDate = dueDate;
		this.writer = writer;
		this.teamId = teamId;
		this.mVo = mVo;
		this.vVo = vVo;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public MatchVO getmVo() {
		return mVo;
	}
	public void setmVo(MatchVO mVo) {
		this.mVo = mVo;
	}
	public VoteResultVO getvVo() {
		return vVo;
	}
	public void setvVo(VoteResultVO vVo) {
		this.vVo = vVo;
	}
	@Override
	public String toString() {
		return "VoteVO [voteId=" + voteId + ", contents=" + contents + ", dueDate=" + dueDate + ", writer=" + writer
				+ ", teamId=" + teamId + ", mVo=" + mVo + "]";
	}
	
}