import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Daniel Valchev
 *
 */
public class Guild {
	ArrayList<Character> members;
	
	Guild(){
		members = new ArrayList<Character>();
	}
	
	public void addMember(Character member) {
		members.add(member);
	}
	
	public Collection<Character> getMembers() {
		return this.members;
	}
	
	/*
	 * Adds the first 5 alive members from the guild into the team.
	 * If there are less it adds however many there are.
	 */
	public Team getTeam(Team enemyTeam, String name) {
		Team tempTeam = new StudentTeam(name);
		for(int i=0;i<members.size();i++) {
			if(members.get(i).isAlive())
				tempTeam.addMember(members.get(i));
			if(tempTeam.getSize()==5 || tempTeam.getSize() == members.size()) {
				break;
			}
		}
		return tempTeam;
	}
}
