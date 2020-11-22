
public class MonsterTeam extends Team {

	MonsterTeam(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Character member, Team enemyTeam) throws Exception {
		if (member instanceof Monster) {
					((Monster) member).strike(getLeastTanky(enemyTeam));
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
}
