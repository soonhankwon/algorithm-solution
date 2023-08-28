import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];
        for (int[] i : dp) {
            Arrays.fill(i, 0);
        }
        int[][] cost = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 3; j++) {
                cost[i][j] = data[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) // RED
                    dp[i][j] = Math.min(dp[i - 1][1] + cost[i - 1][1], dp[i - 1][2] + cost[i - 1][2]);
                if (j == 1) // GREEN
                    dp[i][j] = Math.min(dp[i - 1][0] + cost[i - 1][0], dp[i - 1][2] + cost[i - 1][2]);
                if (j == 2) // BLUE
                    dp[i][j] = Math.min(dp[i - 1][0] + cost[i - 1][0], dp[i - 1][1] + cost[i - 1][1]);
            }
        }

        int min = Arrays.stream(dp[n]).min().orElseThrow();
        System.out.println(min);
    }
}