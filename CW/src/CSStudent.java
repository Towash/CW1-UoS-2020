
public class CSStudent extends Student {
	CSStudent(String name) {
		super(name, 7, 6, 6, 6, 4);
	}

	// pairWorking attack that allows two students to attack the same enemy.
	void pairWorking(Character friend, Character enemy) {
		if (this.getCurrentKP() == this.getMaxKP()) {
			enemy.currentHP -= (int) Math.round((100 * friend.getMaxAtk()) / (100 + enemy.getMaxDef()));
			enemy.currentHP -= (int) Math.round((100 * this.getMaxAtk()) / (100 + enemy.getMaxDef()));

			// TODO Maybe NullKP again.
			this.resetKP();
		}
	}

	// support skill that heals a friend based on the CS's defence.
	void support(Character friend) {
		if (this.getCurrentKP() == this.getMaxKP()) {
			// TODO Again - same shit
			this.increaseEP(4);
			this.resetKP();
			friend.increaseHP(this.getMaxDef());
		}
	}
}
