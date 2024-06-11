import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] cards;
    static int n, m, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];

        cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        recursion(0, 0, 0);
        System.out.println(max);
        br.close();
    }

    private static void recursion(int depth, int start, int sum) {
        if (depth == 3) {
            if (sum <= m) {
                max = Math.max(max, sum);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            recursion(depth + 1, i + 1, sum + cards[i]);
        }
    }
}
