import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        /*
         * 1 1 1 2 2 3 4 5 7 9 12 16 21 28 37
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine()); //6
            dp = new long[101];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for (int j = 3; j <= n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            sb.append(dp[n - 1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
