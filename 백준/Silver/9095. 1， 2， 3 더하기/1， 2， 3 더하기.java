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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(recursion(num)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int recursion(int n) {
        if (dp[n] == 0) {
            dp[n] = recursion(n - 1) + recursion(n - 2) + recursion(n - 3);
        }
        return dp[n];
    }
}
