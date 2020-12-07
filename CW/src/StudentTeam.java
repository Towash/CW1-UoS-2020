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
					 System.out.println(member.getName() + " used MachineLearning on " + getLeastTanky(enemyTeam).getName());
					((AIStudent) member).machineLearning(getLeastTanky(enemyTeam));
				} else {
					((AIStudent) member).naturalLanguageProcessing();
					System.out.println(member.getName() + " used NaturalLanguageProcessing and healed themselves ");
				}

			} else {
				System.out.println(member.getName() + " used JavaProgramming on " + getLeastTanky(enemyTeam).getName());
				((AIStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}
		}

		// CSStudent
		else if (member instanceof CSStudent) {
			if (((CSStudent) member).hasMaxKP()) {
				for (Character mem : member.getTeam().getMembers()) {
					if (!mem.HPAbove50()) {
						System.out.println(member.getName() + " used Support and healed " + mem.getName());
						((CSStudent) member).support(mem);
						break;
					}
				}
			}
			if (((CSStudent) member).hasMaxKP()) {
				System.out.println(member.getName() + " used PairWorking along with " + maxAttackFriend(member).getName() + " on " + getLeastTanky(enemyTeam).getName());
					((CSStudent) member).pairWorking(maxAttackFriend(member), getLeastTanky(enemyTeam));
			}
			else {
				System.out.println(member.getName() + " used JavaProgramming on " + getLeastTanky(enemyTeam).getName());
				((CSStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}
		}
		// CyberStudent
		else if (member instanceof CyberStudent) {
			if (((CyberStudent) member).hasMaxKP()) {
				System.out.println(member.getName() + " used CyberAttack attacking the whole enemy team! ");
				((CyberStudent) member).cyberAttack(enemyTeam);
			} else {
				System.out.println(member.getName() + " used JavaProgramming on " + getLeastTanky(enemyTeam).getName());
				((CyberStudent) member).javaProgramming(getLeastTanky(enemyTeam));
			}

		}

		// SEStudent
		else if (member instanceof SEStudent) {
			if (((SEStudent) member).hasMaxKP()) {
				if (friendsNeedHealing(member)) {
					System.out.println(member.getName() + " used groupDiscussion and healed all allies! ");
					((SEStudent) member).groupDiscussion();
				} else {
					System.out.println(member.getName() + " used groupWork on" + getLeastTanky(enemyTeam).getName());
					((SEStudent) member).groupWork(getLeastTanky(enemyTeam));
				}
			} else {
				System.out.println(member.getName() + " used JavaProgramming on " + getLeastTanky(enemyTeam).getName());
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