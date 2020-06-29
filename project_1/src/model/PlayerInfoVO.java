package model;

public class PlayerInfoVO {
	private String userId;
	private String position;
	private String mainFoot;
	private int height;
	private int weight;
	private int injury;
	private int mental;
	private int speed;
	private int physical;
	private int dribble;
	private int pass;
	private int defence;
	private int total;
	
	public PlayerInfoVO() {}
	
	
	public PlayerInfoVO(String userId, String position, String mainFoot, int height, int weight, int mental, int speed,
			int physical, int dribble, int pass, int defence, int total) {
		super();
		this.userId = userId;
		this.position = position;
		this.mainFoot = mainFoot;
		this.height = height;
		this.weight = weight;
		this.mental = mental;
		this.speed = speed;
		this.physical = physical;
		this.dribble = dribble;
		this.pass = pass;
		this.defence = defence;
		this.total = total;
	}

	public PlayerInfoVO(String userId,String position, String mainFoot, int height, int weight, int mental, int speed,
			int physical, int dribble, int pass, int defence) {
		super();
		this.userId = userId;
		this.position = position;
		this.mainFoot = mainFoot;
		this.height = height;
		this.weight = weight;
		this.mental = mental;
		this.speed = speed;
		this.physical = physical;
		this.dribble = dribble;
		this.pass = pass;
		this.defence = defence;
	}

	public PlayerInfoVO(String position, String mainFoot, int height, int weight, int injury, int mental,
			int speed, int physical, int dribble, int pass, int defence, int total) {
		super();
		this.position = position;
		this.mainFoot = mainFoot;
		this.height = height;
		this.weight = weight;
		this.injury = injury;
		this.mental = mental;
		this.speed = speed;
		this.physical = physical;
		this.dribble = dribble;
		this.pass = pass;
		this.defence = defence;
		this.total = total;
	}
	public PlayerInfoVO(String userId, String position, String mainFoot, int height, int weight, int injury, int mental,
			int speed, int physical, int dribble, int pass, int defence, int total) {
		super();
		this.userId = userId;
		this.position = position;
		this.mainFoot = mainFoot;
		this.height = height;
		this.weight = weight;
		this.injury = injury;
		this.mental = mental;
		this.speed = speed;
		this.physical = physical;
		this.dribble = dribble;
		this.pass = pass;
		this.defence = defence;
		this.total = total;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMainFoot() {
		return mainFoot;
	}

	public void setMainFoot(String mainFoot) {
		this.mainFoot = mainFoot;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getInjury() {
		return injury;
	}

	public void setInjury(int injury) {
		this.injury = injury;
	}

	public int getMental() {
		return mental;
	}

	public void setMental(int mental) {
		this.mental = mental;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPhysical() {
		return physical;
	}

	public void setPhysical(int physical) {
		this.physical = physical;
	}

	public int getDribble() {
		return dribble;
	}

	public void setDribble(int dribble) {
		this.dribble = dribble;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PlayerInfoVo [userId=" + userId + ", position=" + position + ", mainFoot=" + mainFoot + ", height="
				+ height + ", weight=" + weight + ", injury=" + injury + ", mental=" + mental + ", speed=" + speed
				+ ", physical=" + physical + ", dribble=" + dribble + ", pass=" + pass + ", defence=" + defence
				+ ", total=" + total + "]";
	}
	
	
	
	
	

	
	
}

