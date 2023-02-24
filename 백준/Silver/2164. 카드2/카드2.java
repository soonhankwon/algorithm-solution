import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Card> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(new Card(i));
		}
		while (queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll().getNumber());
	}

}

class Card {
	int number;

	public Card(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
