//TODO: Add comments explaining the logic behind the AI of each class
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
					if (mem.HPAbove50()) {
						((CSStudent) member).support(mem);
						break;
					}
				}
			}

			if (((CSStudent) member).hasMaxKP()) {
				if (member.getTeam().hasAliveMembers()) {
					((CSStudent) member).pairWorking(maxAttackFriend(member), getLeastTanky(enemyTeam));
				}
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
	 * Gets the enemy which would be the easiest to kill depending on their
	 * "tankiness stat".
	 */
	public Character getLeastTanky(Team enemyTeam) throws Exception {
		Character[] membersArray = enemyTeam.getMembers();
		int n = membersArray.length;
		int[] tankiness = new int[membersArray.length];
		// Calculates the "tankiness" of the enemy members in order to prioritise which
		// one will be attacked.
		// Tankiness is the HP+DEF - Attack;
		for (int i = 0; i < n; i++) {
			tankiness[i] = membersArray[i].getHP();
			tankiness[i] += membersArray[i].getDefence();
			tankiness[i] -= membersArray[i].getAttack();
		}

		// Bubble sort that will sort the characters in the order in which they will be
		// attacked.
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (tankiness[j] > tankiness[j + 1]) {

					int temp = tankiness[j];
					tankiness[j] = tankiness[j + 1];
					tankiness[j + 1] = temp;

					Character tempChar = membersArray[j];
					membersArray[j] = membersArray[j + 1];
					membersArray[j + 1] = tempChar;
				}

		// Returns the next alive target
		for (Character member : membersArray) {
			if (member.isAlive())
				return member;
		}

		// Here just for syntax sake the program will check if there are alive members
		// in another way.
		throw new Exception("No alive members");
	}

	/*
	 * Used for the CSStudent's pairworking skill in order to get the ally with the
	 * most attack to attack the enemy
	 */
	public Character maxAttackFriend(Character member) throws Exception {
		int max = 0;
		int maxi = -1;
		Character[] membersArray = member.getTeam().getMembers();
		// Stores the alive member with the highest attack that is not the CSStudent
		// himself.
		for (int i = 0; i < membersArray.length; i++) {
			if (!(member.getName().equals(membersArray[i].getName())) && membersArray[i].isAlive()) {
				if (max < membersArray[i].getAttack()) {
					max = membersArray[i].getAttack();
					maxi = i;
				}
			}
		}
		if (maxi == -1)
			throw new Exception("No alive allies");
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
			if (!mem.HPAbove50())
				counter++;
		}
		if (counter >= 2)
			return true;
		else
			return false;
	}
}