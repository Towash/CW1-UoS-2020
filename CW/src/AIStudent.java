
public class AIStudent extends Student {

	AIStudent(String name) {
		super(name, 6, 7, 7, 5, 3);
	}

	// Machine learning attack that deals double damage.
	void machineLearning(Character enemy) throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {
			enemy.decreaseHP((((100 * this.getAttack()) / (100 + enemy.getDefence())) * 2));

			// Checks if the enemy will be killed after the attack and awards EP if yes.
			if (enemy.getHP() == 0)
				this.increaseEP(4);

			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}

	// Skill that allows the character to heal themselves.ss
	void naturalLanguageProcessing() throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {
			this.increaseHP(this.getDefence());
			// TODO maybe create a reduceKP/nullKP method for encapsulation.
			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}

}
