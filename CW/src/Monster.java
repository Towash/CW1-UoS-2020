
//Monster interface containing the attacks the monsters will use.
public interface Monster {
	
	void strike(Character enemy);
	void SyntaxError(Character enemy);
	void NullPointerException();
	void ArrayIndexOutOfBoundException(Character enemy);
	void NoneTermination();
	void ConcurrentModificationException(Character enemy);
}
