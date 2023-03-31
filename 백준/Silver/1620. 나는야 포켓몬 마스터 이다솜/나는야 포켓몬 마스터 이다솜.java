import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // pocket monster's quantity
		int m = sc.nextInt(); // questions's quantity

		HashMap<Integer, String> map_1 = new HashMap<>();
		HashMap<String, Integer> map_2 = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String moster = sc.next();
			map_1.put(i, moster);
			map_2.put(moster, i);
		}

		for (int i = 0; i < m; i++) {
			String next = sc.next();
			if (!map_2.containsKey(next)) {
				System.out.println(map_1.get(Integer.parseInt(next)));
			} else {
				System.out.println(map_2.get(next));
			}
		}

	}

}
