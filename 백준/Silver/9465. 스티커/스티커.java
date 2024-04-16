import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp, map;
    static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                int[] inputs = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int k = 1; k <= n; k++) {
                    map[j][k] = inputs[k - 1];
                }
            }

            // 자기 자신 시작
            dp = new int[2][n + 1];
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for (int j = 2; j <= n; j++) {
                // 경우의 수 2개: 자기자신 대각선 아래, 그리고 대각선 아래 왼쪽
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
                // 경우의 수 2개: 자기자신 대각선 위, 그리고 대각선 위 왼쪽
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
        br.close();
    }
}
