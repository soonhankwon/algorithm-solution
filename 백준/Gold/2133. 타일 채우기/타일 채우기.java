import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 타일채우기
 * 3 * n 벽을 2 * 1, 1 * 2 타일로 채우는 경우의 수 -> 점화식(top-down)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 3 * 1 -> 0
         * 3 * 2 -> 3
         * 3 * 3 -> 0
         * 3 * 4 -> 11
         * f(4) = f(2) * 3 + 2
         * n 이 홀수라면 불가능
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[Math.max(n / 2, 2)];
        dp[0] = 3;
        dp[1] = 11;
        int num = 0;
        for (int i = 2; i < n / 2; i++) {
            dp[i] = dp[i - 1] * 3 + 2 + (num += dp[i - 2] * 2);
        }

        System.out.println(dp[n / 2 - 1]);
        br.close();
    }
}
