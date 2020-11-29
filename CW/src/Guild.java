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
	
	public void removeMember(Character member) {
		members.remove(member);
	}
	
	//Adds the first 5 members of the Guild to the team because i couldn't be bothered to create an algorithm for that.
	public Team getTeam(Team enemyTeam) {
		Team tempTeam = new StudentTeam("TempTeam");
		for(int i=0;i<5;i++) {
			tempTeam.addMember(members.get(i));
		}
		return tempTeam;
	}
}
