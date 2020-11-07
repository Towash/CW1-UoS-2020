
public class SEStudent extends Student {
	SEStudent(String name) {
		super(name, 8, 5, 8, 4, 10);
	}

	//groupWork attack - All alive members of the team attack the enemy.
	void groupWork(Character enemy) {
		if (this.getCurrentKP() == this.getMaxKP()) {
			Character[] members = this.getTeam().getMembers();
			for (Character member : members)
				if (member.getHP() > 0)
					enemy.currentHP -= (int) Math.round((100 * member.getMaxAtk()) / (100 + enemy.getMaxDef()));

			// TODO Again - same shit
			this.increaseEP(4);
			this.resetKP();
		}
		
	}
	
	//groupDiscussion heals all alive team members.
	void groupDiscussion() {
		if (this.getCurrentKP() == this.getMaxKP()) {
			if (this.getCurrentKP() == this.getMaxKP()) {
				Character[] members = this.getTeam().getMembers();
				for (Character member : members)
					if (member.getHP() > 0) 
						member.increaseHP(this.getMaxDef() / 2);
			}
			this.resetKP();
			this.increaseEP(4);
		}
	}
}

//TODO Exception when not max KP