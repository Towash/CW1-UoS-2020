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
	
	private static Guild monsterGuild = new Guild();
	private static BufferedReader reader;
	
	public static void main(String[] args) throws Exception {
		
		File filename = null;
		
		//Exits if there is no file specified.
		if(args.length == 0) {
            System.out.println("File name not specified.");
            System.exit(1);
        }
		
		//Takes the file as an argument from the command line
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
		
		addCharacters();
	}
	
	//Creates a character based on the txt file.
	public static void addCharacters() throws Exception {
		
		//TODO:Have fun commenting this one sucker.
		//Nice varargs.
			String line;
			while((line = reader.readLine()) != null) {
				int i=0;
				
				String[] components = line.split("\\(|\\,|\\);|\\)");
				
				do {
				Class<?> c = Class.forName(components[1]);
				Constructor<?> cons = c.getDeclaredConstructor(String.class, int.class);
				
				monsterGuild.addMember((Character) cons.newInstance(components[0+i].toString(),Integer.parseInt(components[2+i])));
				i+=3;
				}
				while ((i >= 0) && (i < components.length));
		}
	}
}
