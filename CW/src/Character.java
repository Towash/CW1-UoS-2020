public class Character {
	String name;
	int baseHP, baseAtk, baseDef, baseSpd;
	int level = 1;
	int currentEP = 0;
	int currentHP;
	Team team;

	// Basic constructor nothing to explain here wish ya a nice day!
	Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
		this.name = name;
		this.baseHP = baseHP;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpd = baseSpd;
		this.currentHP = getMaxHP();
	}

	public String getName() {
		return name;
	}

	// Have to use (int) because the round() method returns a long and we don't want
	// that.
	// TODO try to find another way;
	public int getMaxHP() {
		return (int) Math.round(baseHP * Math.pow(level, 1.2));
	}

	public int getAttack() {
		return (int) Math.round(baseAtk * Math.pow(level, 1.2));
	}

	public int getDefence() {
		return (int) Math.round(baseDef * Math.pow(level, 1.2));
	}

	public int getSpeed() {
		return (int) Math.round(baseSpd * Math.pow(level, 1.2));
	}

	public int getTargetEP() {
		return (int) Math.round(10 * Math.pow(level, 1.5));
	}

	// Getters for HP/EP
	public int getHP() {
		return currentHP;
	}

	public int getEP() {
		return currentEP;
	}

	// HP/EP manipulation functions
	public void increaseHP(int amount) {
		currentHP += amount;
		if (currentHP > getMaxHP())
			currentHP = getMaxHP();
	}

	public  void decreaseHP(int amount) {
		currentHP -= amount;
		if (currentHP < 0)
			currentHP = 0;
	}

	public void increaseEP(int amount) {
		currentEP += amount;
		if (currentEP >= getTargetEP()) {
			level++;
			currentHP = getMaxHP();
			currentEP = 0;
		}
	}

	// Getter/Setter for the team.
	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}
}
