import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int n = sc.nextInt();
			if (n != 0)
				stack.push(n);
			else
				stack.pop();
		}

		int sum = Arrays.stream(stack.toArray(new Integer[0]))
				.mapToInt(Integer::intValue)
				.sum();
		System.out.println(sum);
	}
}
