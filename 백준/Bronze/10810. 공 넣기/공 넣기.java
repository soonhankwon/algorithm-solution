import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] baskets = new int[n];

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt();
            int ball = scanner.nextInt();
            IntStream.range(start, end).forEach(j -> baskets[j] = ball);
        }
        Arrays.stream(baskets).forEach(i -> System.out.print(i + " "));
    }
}