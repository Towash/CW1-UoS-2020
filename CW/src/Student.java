
public class Student extends Character {

	int maxKP;
	int currentKP = 0;

	// Constructor extended from the Character constructor.
	Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
		super(name, baseHP, baseAtk, baseDef, baseSpd);
		this.maxKP = maxKP;
	}

	public void increaseKP(int amount) {
		currentKP += amount;
		if (currentKP > maxKP)
			currentKP = maxKP;
	}

	public void javaProgramming(Character enemy) {
		this.increaseEP(3);
		this.increaseKP(1);
		enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
		enemy.increaseEP(2);

		// Checks if the enemy is an instance of the Student class;
		// Increases its KP if it is.

		if (enemy instanceof Student)
			((Student) enemy).increaseKP(3);

		// Checks if the enemy will be killed after the attack and awards EP if yes.
		if (!enemy.isAlive())
			this.increaseEP(4);
	}

	public void selfStudy() {
		this.increaseHP(2);
		this.increaseEP(6);
		this.increaseKP(2);
	}

	// getKP methods to keep encapsulation
	public int getCurrentKP() {
		return this.currentKP;
	}

	public int getMaxKP() {
		return this.maxKP;
	}

	// Resets the character's KP to 0 (Used this to preserve encapsulation)
	public void resetKP() {
		this.currentKP = 0;
	}
	
	//Checks if a character has maxKP so they can perform a special attack
	public boolean hasMaxKP() {
		if(this.getCurrentKP()==this.getMaxKP())
			return true;
		else return false;
	}
	
}
