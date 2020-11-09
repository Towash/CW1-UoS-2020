
public class CSStudent extends Student {
	CSStudent(String name) {
		super(name, 7, 6, 6, 6, 4);
	}

	// pairWorking attack that allows two students to attack the same enemy.
	void pairWorking(Character friend, Character enemy) throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {
			enemy.decreaseHP((100 * friend.getAttack()) / (100 + enemy.getDefence()));
			enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));

			// Checks if the enemy will be killed after the attack and awards EP if yes.
			if (enemy.getHP() == 0)
				this.increaseEP(4);

			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}

	// support skill that heals a friend based on the CS's defense.
	void support(Character friend) throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {

			this.increaseEP(4);
			this.resetKP();
			friend.increaseHP(this.getDefence());
		} else
			throw new Exception("Not enough KP");
	}
}
