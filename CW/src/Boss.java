import java.util.Random;

/**
 * @author Daniel Valchev
 *
 */
public class Boss extends Character implements Monster {

	Boss(String name) {
		super(name, 8, 7, 8, 7);
	}

	// Strike method that calls the different attacks depending on RNG
	@Override
	public void strike(Character enemy) {
		this.increaseEP(3);
		// Random number used for probabilities
		// TODO - try to find a better way
		Random rand = new Random();
		int rng = rand.nextInt(100);
		if (rng >= 0 && rng < 50)
			SyntaxError(enemy);
		else if (rng > 50 && rng < 65)
			NullPointerException();
		else if (rng >= 65 && rng < 80)
			ArrayIndexOutOfBoundException(enemy);
		else if (rng >= 80 && rng < 90)
			NoneTermination();
		else
			ConcurrentModificationException(enemy);
	}

	// The basic attack of the Monster deals damage like JavaProgramming();
	@Override
	public void SyntaxError(Character enemy) {
		enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));

		enemy.increaseEP(3);

		if (enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}

		if (!enemy.isAlive())
			this.increaseEP(4);
	}

	// Heals the Monster by its defence stat. (Love how Eclipse says the right way
	// to spell "Defence" is "defense")
	@Override
	public void NullPointerException() {
		this.increaseHP(this.getDefence());
	}

	// Attack dealing double damage.
	@Override
	public void ArrayIndexOutOfBoundException(Character enemy) {
		enemy.decreaseHP((((100 * this.getAttack()) / (100 + enemy.getDefence())) * 2));
		enemy.increaseEP(3);

		if (enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}

		if (!enemy.isAlive())
			this.increaseEP(4);
	}

	// Revives all members of the team.
	@Override
	public void NoneTermination() {
		Character[] members = this.getTeam().getMembers();
		for (Character member : members) {
			if (member.isAlive())
				member.increaseHP(member.getMaxHP());
		}
	}

	// Attacks all members of the enemy team.
	@Override
	public void ConcurrentModificationException(Character enemy) {
		Character[] members = enemy.getTeam().getMembers();
		for (Character member : members) {
			if (member.isAlive()) {

				member.increaseEP(3);

				if (member instanceof Student) {
					((Student) member).increaseKP(3);
				}
				member.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));

				if (!member.isAlive()) {
					this.increaseEP(4);
				}
			}
		}
	}

}
