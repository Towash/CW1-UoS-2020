import java.util.ArrayList;

public class Team {
	String name;
	ArrayList<Character> members;

	// Constructor to initialise a Team object.
	Team(String name) {
		this.name = name;
		members = new ArrayList<Character>();
	}

	// Nothing to see here, just a getter.
	String getName() {
		return name;
	}

	// Method that converts the ArrayList to an array using the ArrayList.toArray().
	Character[] getMembers() {
		Character[] membersArray = members.toArray(new Character[members.size()]);
		return membersArray;
	}


	int addMember(Character member) {
		Character[] tempMembers = getMembers();
		//Checks if there is already a member with this name in the Team.
		//There is probably a better way to do that but oh well.
		for (Character mem : tempMembers)
			if (member.getName().equals(mem.getName())) {
				return -1;
			}
		
		//Checks if there are already 5 members in the team.
		if (members.size() == 5)
			return -2;
		
		//If all is good adds a member and returns the size.
		members.add(member);
		member.setTeam(this);
		return members.size();

	}
}
