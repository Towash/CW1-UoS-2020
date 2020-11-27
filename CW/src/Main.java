
/**
 * @author Daniel Valchev
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Character georgi = new AIStudent("Georgi");
		Character pesho = new CyberStudent("Pesho");
		Character ico = new SEStudent("Ico");
		Team da = new StudentTeam("da");
		
		
		da.addMember(georgi);
		da.addMember(ico);
		da.addMember(pesho);
		
		Character georgi2 = new AIStudent("Georgi2");
		Character pesho2 = new SEStudent("Pesho2");
		Team da2 = new StudentTeam("da2");
		
		da2.addMember(georgi2);
		da2.addMember(pesho2);
		
		Battle battle = new Battle(da,da2);
		battle.fight();
		
	}
}
