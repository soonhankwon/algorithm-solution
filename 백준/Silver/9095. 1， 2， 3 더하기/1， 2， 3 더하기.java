import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 경우의 수 점화식
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int data = Integer.parseInt(br.readLine());
            sb.append(dp[data]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
