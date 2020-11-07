
public class AIStudent extends Student {

	AIStudent(String name) {
		super(name, 6, 7, 7, 5, 3);
	}

	// Machine learning attack that deals double damage.
	void machineLearning(Character enemy) {
		if (this.getCurrentKP() == this.getMaxKP()) {
			enemy.currentHP -= (int) Math.round((100 * this.getMaxAtk()) / (100 + enemy.getMaxDef()) * 2);
			
			// TODO maybe create a reduceKP/nullKP method for encapsulation.
			this.increaseEP(4);
			this.resetKP();
		}
	}

	// Skill that allows the character to heal themselves.ss
	void naturalLanguageProcessing() {
		if (this.getCurrentKP() == this.getMaxKP()) {
			this.increaseHP(this.getMaxDef());
			// TODO maybe create a reduceKP/nullKP method for encapsulation.
			this.increaseEP(4);
			this.resetKP();
		}
	}

}
