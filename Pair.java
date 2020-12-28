package aerorpess.app;

public class Pair<T, S> {
	private T first;
	private S second;


	public Pair(T firstElement, S secondElement) {
		first = firstElement;
		second = secondElement;
	}

	public T getFirst() {
		return first;
	}


	public S getSecond() {
		return second;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
