import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.*;

/**
 * @author Daniel Valchev
 *
 */
public class TowerOfMonsters {

	private static boolean monsterWin = false;
	private static Guild studentGuild = new Guild();
	private static BufferedReader reader;
	
	//Edit these for the team names.
	private static String teamName1 = "StudentTeam";
	private static String teamName2 = "MonsterTeam";
	
	static Team studentTeam = new StudentTeam(teamName1);
	static Team monsterTeam = new MonsterTeam(teamName2);
	

	public static void main(String[] args) throws Exception {

		studentGuild.addMember(new AIStudent("AIstudent_1"));
		studentGuild.addMember(new AIStudent("AIstudent_2"));
		studentGuild.addMember(new CSStudent("CSstudent_1"));
		studentGuild.addMember(new CSStudent("CSstudent_2"));
		studentGuild.addMember(new SEStudent("SEstudent_1"));
		studentGuild.addMember(new SEStudent("SEstudent_2"));
		studentGuild.addMember(new CyberStudent("Cyberstudent_1"));
		studentGuild.addMember(new CyberStudent("Cyberstudent_2"));

		File filename = null;

		// Exits if there is no file specified.
		if (args.length == 0) {
			System.out.println("File name not specified.");
			System.exit(1);
		}

		// Takes the file as an argument from the command line
		if (0 < args.length) {
			filename = new File(args[0]);
		} else {
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(0);
		}

		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file " + filename);
			e.printStackTrace();
		}
		
		
		/*
		 * Creates a battle for every line of the .txt or until the studentGuild has no members left.
		 */
		String line;
		int floor = 1;
		while ((line = reader.readLine()) != null) {
			System.out.println("Floor - " + floor + " begins!");
			
			monsterTeam = addCharactersToMonsterTeam(line);
			
			studentTeam = studentGuild.getTeam(monsterTeam,teamName1);
			Battle battle = new Battle(studentTeam,monsterTeam);
			battle.fight();
			if (battle.checkWinner().equals(monsterTeam)){
				System.out.println("\n" + "The fight has ended at floor " + floor + " with the winner being " + monsterTeam.getName());
				monsterWin = true;
				break;
			}
			floor++;
		}
		
		
		if(!monsterWin) {
			System.out.println("\n" + "The fight has ended at floor " + (floor-1) + " with the winner being " + studentTeam.getName());
		}
		
		
	}

	// Adds characters to the monster guild based on the .txt file.
	public static Team addCharactersToMonsterTeam(String line) throws Exception {

		/*
		 * This method reads the lines in the .txt as the following components[0 + i] -
		 * Name components[1 + i] - Class (minion/boss) components[2 + i] - Level And
		 * creates a new character with the according name class and level.
		 */
			Team tempTeam = new MonsterTeam(teamName2);
			int i = 0;
			String[] components = line.split("\\(|\\,|\\);|\\)");

			do {
				Class<?> c = Class.forName(components[1]);
				Constructor<?> cons = c.getDeclaredConstructor(String.class, int.class);
				tempTeam.addMember((Character) cons.newInstance(components[0 + i].toString(),
						Integer.parseInt(components[2 + i])));
				i += 3;
			} while ((i >= 0) && (i < components.length));
			return tempTeam;
	}
}
