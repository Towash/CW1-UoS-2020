
public class SEStudent extends Student {
	SEStudent(String name) {
		super(name, 8, 5, 8, 4, 10);
	}

	// groupWork attack - All alive members of the team attack the enemy.
	public void groupWork(Character enemy) throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {
			Character[] members = this.getTeam().getMembers();
			for (Character member : members) {
				if (member.getHP() > 0)
					enemy.decreaseHP((100 * member.getAttack()) / (100 + enemy.getDefence()));
			}

			this.increaseEP(4);
			this.resetKP();

			// Checks if the enemy will be killed after the attack and awards EP if yes.
			if (enemy.getHP() == 0)
				this.increaseEP(4);
		} else
			throw new Exception("Not enough KP");

	}

	// groupDiscussion heals all alive team members.
	public void groupDiscussion() throws Exception {
		if (this.getCurrentKP() == this.getMaxKP()) {
			if (this.getCurrentKP() == this.getMaxKP()) {
				Character[] members = this.getTeam().getMembers();

				for (Character member : members) {
					if (member.getHP() > 0)
						member.increaseHP(this.getDefence() / 2);
				}

			}
			this.resetKP();
			this.increaseEP(4);
		} else
			throw new Exception("Not enough KP");
	}
}
