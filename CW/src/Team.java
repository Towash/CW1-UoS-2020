import java.util.ArrayList; 
/**
 * @author Daniel Valchev
 *
 */
public abstract class Team {
	String name;
	ArrayList<Character> members;

	// Constructor to initialise a Team object.
	Team(String name) {
		this.name = name;
		members = new ArrayList<Character>();
	}
	

	// Nothing to see here, just a getter.
	public String getName() {
		return name;
	}

	// Method that converts the ArrayList to an array using the ArrayList.toArray().
	public Character[] getMembers() {
		Character[] membersArray = members.toArray(new Character[members.size()]);
		return membersArray;
	}

	public int addMember(Character member) {
		Character[] tempMembers = getMembers();
		// Checks if there is already a member with this name in the Team.
		// There is probably a better way to do that but oh well.
		for (Character mem : tempMembers)
			if (member.getName().equals(mem.getName())) {
				return -1;
			}

		// Checks if there are already 5 members in the team.
		if (members.size() == 5)
			return -2;

		// If all is good adds a member and returns the size.
		members.add(member);
		member.setTeam(this);
		return members.size();
	}
	
	//Checks if the team has more than 1 alive member.
	//Will be used with the CSStudent
	public boolean hasAliveMembers() {
		Character[] membersArray = this.getMembers();
		int counter = 0;
		for (int i = 0; i < membersArray.length; i++) {
			if (membersArray[i].isAlive()) {
				counter++;
				if (counter >= 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getSize() {
		return members.size();
	}

	public abstract void move(Character member, Team enemyTeam) throws Exception;

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
		throw new Exception("No alive members");
	}
}
