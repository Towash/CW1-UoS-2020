import java.util.Random;
/**
 * @author Daniel Valchev
 *
 */
public class Minion extends Character implements Monster {

	Minion(String name) {
		super(name, 5, 5, 5, 5);
	}

	// For part 6, creates a new minions that might be more than level 1.
	// And ensures they start with maxHP.
	Minion(String name, int level) {
		super(name, 5, 5, 5, 5);
		this.setLevel(level);
		this.increaseHP(getMaxHP()); // Wont go over max due to how getMaxHP is made.
	}

	// Strike method that calls the different attacks depending on RNG
	@Override
	public void strike(Character enemy) {
		this.increaseEP(3);
		// Random number used for probabilities
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
		System.out.println(this.getName() + " used SyntaxError on " + enemy.getName());
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
		System.out.println(this.getName() + " used NullPointerException and healed itself");
		this.increaseHP(this.getDefence());
	}

	// Attack dealing double damage.
	@Override
	public void ArrayIndexOutOfBoundException(Character enemy) {
		System.out.println(this.getName() + " used ArrayIndexOutOfBoundException on " + enemy.getName());
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
