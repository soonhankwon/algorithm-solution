import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> items = new ArrayList<>();
    static int answer;
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];
        // 물건, 무게
        dp = new int[n][100_001];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            items.add(Arrays.stream(br.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }
        answer = Integer.MIN_VALUE;
        answer = recursion(0, 0);
        System.out.println(answer);
    }

    private static int recursion(int depth, int w) {
        if (w > k) {
            return Integer.MIN_VALUE;
        }

        if (depth == n) {
            return 0;
        }

        if (dp[depth][w] != -1) {
            return dp[depth][w];
        }

        dp[depth][w] = Math.max(
                recursion(depth + 1, w + items.get(depth)[0]) + items.get(depth)[1],
                recursion(depth + 1, w));

        return dp[depth][w];
    }
}