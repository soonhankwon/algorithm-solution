import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = 3
        // dp[4] = 2
        // dp[5] = 2
        // dp[6] = 3
        // dp[7] = (7하고 가장 가까운 제곱 2^2 = 1개) + dp[3](해당 제곱수를 뺀 나머지 DP)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int answer = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                answer = Math.min(answer, dp[i - (j * j)]);
            }
            dp[i] = answer + 1;
        }
        System.out.println(dp[n]);
        br.close();
    }
}
