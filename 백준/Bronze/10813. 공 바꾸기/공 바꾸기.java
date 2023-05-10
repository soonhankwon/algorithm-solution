import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] baskets = new int[n];
        
        IntStream.range(0, n).forEach(i -> baskets[i] = i + 1);
        IntStream.range(0, scanner.nextInt()).forEach(i -> {
            int basket1 = scanner.nextInt() - 1;
            int basket2 = scanner.nextInt() - 1;
            int temp = baskets[basket1];
            baskets[basket1] = baskets[basket2];
            baskets[basket2] = temp;
        });
        Arrays.stream(baskets).mapToObj(basket -> basket + " ")
                .forEach(System.out::print);
    }
}