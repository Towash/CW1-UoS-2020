/**
 * @author Daniel Valchev
 *
 */
public class CyberStudent extends Student {
	CyberStudent(String name) {
		super(name, 7, 7, 5, 6, 6);
	}

	// cyberAttack that attacks all of the ALIVE characters in the enemy team
	public void cyberAttack(Team enemyTeam) throws Exception {
		if (this.hasMaxKP()) {
			Character[] members = enemyTeam.getMembers();
			for (Character member : members) {
				if (member.isAlive()) {
					member.decreaseHP((100 * this.getAttack()) / (100 + member.getDefence()));

					// Checks if the enemy will be killed after the attack and awards EP if yes.
					if (!member.isAlive())
						this.increaseEP(4);
				}
			}
			this.increaseEP(4);
			this.resetKP();
		} else
			throw new Exception("Not enough KP");
	}
}
