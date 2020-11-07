
public class Main {
	public static void main(String[] args) {
		Team team = new Team("Pesho");
		Character georgi = new Character("Georgi",10,10,10,10);
		System.out.println(georgi.getMaxHP());
		georgi.increaseEP(200);
		System.out.println(georgi.getMaxHP());
		
		System.out.println(georgi.getTeam());
		team.addMember(georgi);
		System.out.println(georgi.getTeam().name);
		
	}
}
