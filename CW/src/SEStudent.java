
/**
 * @author Daniel Valchev
 *
 */
public class SEStudent extends Student {
	SEStudent(String name) {
		super(name, 8, 5, 8, 4, 10);
	}

	// groupWork attack - All alive members of the team attack the enemy.
	public void groupWork(Character enemy) throws Exception {
		if (this.hasMaxKP()) {
			Character[] members = this.getTeam().getMembers();
			for (Character member : members) {
				if (member.isAlive())
					enemy.decreaseHP((100 * member.getAttack()) / (100 + enemy.getDefence()));
			}

			this.increaseEP(4);
			this.resetKP();

			// Checks if the enemy will be killed after the attack and awards EP if yes.
			if (!enemy.isAlive())
				this.increaseEP(4);
		} else
			throw new Exception("Not enough KP");

	}

	// groupDiscussion heals all alive team members.
	public void groupDiscussion() throws Exception {
		if (this.hasMaxKP()) {
			if (this.hasMaxKP()) {
				Character[] members = this.getTeam().getMembers();

				for (Character member : members) {
					if (member.isAlive())
						member.increaseHP(this.getDefence() / 2);
				}

			}
			this.resetKP();
			this.increaseEP(4);
		} else
			throw new Exception("Not enough KP");
	}
}
