
public class Main {
	public static void main(String[] args) throws Exception {
		Character georgi = new AIStudent("Georgi");
		Character pesho = new CyberStudent("Pesho");
		Team da = new StudentTeam("da");
		
		da.addMember(georgi);
		da.addMember(pesho);
		Character georgi2 = new AIStudent("Georgi2");
		Character pesho2 = new SEStudent("Pesho2");
		Team da2 = new StudentTeam("da2");
		
		((Student) pesho).increaseKP(50);
		da2.addMember(georgi2);
		da2.addMember(pesho2);
		
		System.out.println(pesho2.getHP()+ "  " + georgi2.getHP());
		da.move(pesho, da2);
		System.out.println(pesho2.getHP()+ "  " + georgi2.getHP());
		
	}
}
