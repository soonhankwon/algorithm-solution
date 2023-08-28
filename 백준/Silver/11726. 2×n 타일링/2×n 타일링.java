import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = i;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
            }
        }
        System.out.println(dp[n]);
    }
}