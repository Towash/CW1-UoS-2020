/**
 * @author Daniel Valchev
 *
 */
public class MonsterTeam extends Team {

	MonsterTeam(String name) {
		super(name);
	}

	@Override
	public void move(Character member, Team enemyTeam) throws Exception {
		if (member instanceof Monster) {
					((Monster) member).strike(getLeastTanky(enemyTeam));
		}
	}	
}
