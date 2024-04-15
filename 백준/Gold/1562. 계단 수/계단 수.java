import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][][] dp = new long[n + 1][11][1 << 10];

        // 1 << i: 0~9 비트마스킹
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                        continue;
                    }
                    if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                        continue;
                    }
                    dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i][1023]) % MOD;
        }
        System.out.println(sum);
        br.close();
    }
}
