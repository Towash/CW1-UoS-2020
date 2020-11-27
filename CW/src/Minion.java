import java.util.Random;

/**
 * @author Daniel Valchev
 *
 */
public class Minion extends Character implements Monster {

	// Constructor for the minion class
	Minion(String name) {
		super(name, 5, 5, 5, 5);
	}

	// Strike method that calls the different attacks depending on RNG
	@Override
	public void strike(Character enemy) {
		this.increaseEP(3);
		// Random number used for probabilities
		// TODO - try to find a better way
		Random rand = new Random();
		int rng = rand.nextInt(100);
		if (rng >= 0 && rng < 75)
			SyntaxError(enemy);
		else if (rng >= 75 && rng < 90)
			NullPointerException();
		else
			ArrayIndexOutOfBoundException(enemy);
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

	// Heals the Monster by its defense stat.
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

	// Empty because they are exclusively Boss attacks but the implement requires
	// them.
	@Override
	public void NoneTermination() {
	}

	@Override
	public void ConcurrentModificationException(Character enemy) {
	}

}
