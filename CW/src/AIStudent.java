
/**
 * @author Daniel Valchev
 *
 */
public class AIStudent extends Student {

	AIStudent(String name) {
		super(name, 6, 7, 7, 5, 3);
	}

	// Machine learning attack that deals double damage.
	public void machineLearning(Character enemy) throws Exception {
		if (this.hasMaxKP()) {
			enemy.decreaseHP((((100 * this.getAttack()) / (100 + enemy.getDefence())) * 2));

			// Checks if the enemy will be killed after the attack and awards EP if yes.
			if (!enemy.isAlive())
				this.increaseEP(4);

			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}

	// Skill that allows the AIStudent to heal itself
	public void naturalLanguageProcessing() throws Exception {
		if (this.hasMaxKP()) {
			this.increaseHP(this.getDefence());
			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}

}
