//TODO: Add comments explaining the logic behind the AI of each class
/**
 * @author Daniel Valchev
 *
 */
public class StudentTeam extends Team {

	StudentTeam(String name) {
		super(name);
	}

	@Override
	public void move(Character member, Team enemyTeam) throws Exception {
		// AIStudent
		if (member instanceof AIStudent) {
			if (((AIStudent) member).hasMaxKP()) {
				if (((AIStudent) member).HPAbove50()) {
					((AIStudent) member).machineLearning(getLeastTanky(enemyTeam));
				} else {
					((AIStudent) member).naturalLanguageProcessing();
				}

			} else {
				((AIStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}
		}

		// CSStudent
		else if (member instanceof CSStudent) {
			if (((CSStudent) member).hasMaxKP()) {
				for (Character mem : member.getTeam().getMembers()) {
					if (!mem.HPAbove50()) {
						((CSStudent) member).support(mem);
						break;
					}
				}
			}

			if (((CSStudent) member).hasMaxKP()) {
					((CSStudent) member).pairWorking(maxAttackFriend(member), getLeastTanky(enemyTeam));
			}

			else {
				((CSStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}
		}
		// CyberStudent
		else if (member instanceof CyberStudent) {
			if (((CyberStudent) member).hasMaxKP()) {
				((CyberStudent) member).cyberAttack(enemyTeam);
			} else {
				((CyberStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}

		}

		// SEStudent
		else if (member instanceof SEStudent) {
			if (((SEStudent) member).hasMaxKP()) {
				if (friendsNeedHealing(member)) {
					((SEStudent) member).groupDiscussion();
				} else
					((SEStudent) member).groupWork(getLeastTanky(enemyTeam));

			} else {
				((SEStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}
		}
	}
	

	/*
	 * Used for the CSStudent's pairworking skill in order to get the ally with the
	 * most attack to attack the enemy
	 */
	public Character maxAttackFriend(Character member) throws Exception {
		int max = 0;
		int maxi = -1;
		Character[] membersArray = member.getTeam().getMembers();
		// Stores the alive member with the highest attack 
		for (int i = 0; i < membersArray.length; i++) {
			if (membersArray[i].isAlive()) {
				if (max < membersArray[i].getAttack()) {
					max = membersArray[i].getAttack();
					maxi = i;
				}
			}
		}
		return membersArray[maxi];
	}

	/*
	 * Checks if more than one person on the team needs healing Will be used in
	 * SEStudents groupDiscussion
	 */
	public boolean friendsNeedHealing(Character member) {
		int counter = 0; // number of friends that need healing
		Character[] membersArray = member.getTeam().getMembers();
		for (Character mem : membersArray) {
			if (!mem.HPAbove50() && mem.isAlive())
				counter++;
		}
		if (counter >= 2)
			return true;
		else
			return false;
	}
}