
public class CyberStudent extends Student {
	CyberStudent(String name) {
		super(name, 7, 7, 5, 6, 6);
	}

	// cyberAttack that attacks all of the characters in the enemy team
	void cyberAttack(Team enemyTeam) {
		if (this.getCurrentKP() == this.getMaxKP()) {

			Character[] members = enemyTeam.getMembers();
			for (Character member : members) {
				member.currentHP -= (int) Math.round((100 * this.getMaxAtk()) / (100 + member.getMaxDef()));

				// TODO Again - same shit
				this.increaseEP(4);
				this.resetKP();
			}
		}
	}
}
