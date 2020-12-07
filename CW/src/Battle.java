
import java.util.Arrays;

/**
 * @author Daniel Valchev
 *
 */
public class Battle {
	Team team1;
	Team team2;
	Character[] allCharacters; // Array of allCharacters - used for the fight method.

	Battle(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
		// Copies the characters of both teams into 1 array.
		allCharacters = new Character[team1.getMembers().length + team2.getMembers().length];
		System.arraycopy(team1.getMembers(), 0, allCharacters, 0, team1.getMembers().length);
		System.arraycopy(team2.getMembers(), 0, allCharacters, team1.getMembers().length, team2.getMembers().length);
	}

	public Team fight() throws Exception {

		// System.out.println("The battle between Team: " + team1.getName() + " - and
		// Team: " + team2.getName() + " - begins!");
		System.out.println();

		// 30 Max Rounds
		for (int i = 1; i <= 30; i++) {
			System.out.println("----------Round " + i + "----------");

			// Sort all characters depending on their speed in the descending order.
			// See Character class - compareTo();
			Arrays.sort(allCharacters);

			displayTeams();
			for (Character c : allCharacters) {
				if (c.isAlive()) {
					// Checks which team the character is from and attacks the other team.
					if (c.getTeam().equals(team1)) {
						c.getTeam().move(c, team2);
						if (checkWinner() != null) {
							System.out.println("Team " + checkWinner().getName() + " wins!!");
							return checkWinner();
						}

					} else {
						c.getTeam().move(c, team1);
						if (checkWinner() != null) {
							System.out.println("Team " + checkWinner().getName() + " wins!!");
							return checkWinner();
						}
					}
				}
			}
		}
		throw new Exception("The battle has no clear winner and will continue over the ages");
	}

	// Displays information about the teams at the beginning of every round
	public void displayTeams() {
		System.out.println("Team: " + team1.getName());
		for (Character member : team1.getMembers()) {
			System.out.println(member.getName() + " " + member.getHP() + "/" + member.getMaxHP() + "HP" + " LVL:"
					+ member.getLevel() + " SPD:" + member.getSpeed());
		}

		System.out.println("-----------------------");

		System.out.println("Team: " + team2.getName());
		for (Character member : team2.getMembers()) {
			System.out.println(member.getName() + " " + member.getHP() + "/" + member.getMaxHP() + "HP" + "  LVL:"
					+ member.getLevel() + " SPD:" + member.getSpeed());
		}
		System.out.println();
	}

	// Check if there is an established winner returns true if yes.
	public Team checkWinner() {
		if (!team1.hasAliveMembers()) {
			return team2;
		} else if (!team2.hasAliveMembers()) {
			return team1;
		} else {
			return null;
		}
	}
}
