import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp, costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집의 수

        // RGB - [집][세가지 경우]
        dp = new int[n + 1][3]; // i번째 집을 j색으로 칠할때 최소비용
        costs = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // eg) 1(i)번 집의 R 비용
            costs[i][0] = row[0]; // R
            costs[i][1] = row[1]; // G
            costs[i][2] = row[2]; // B
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            // 첫 번째 집의 색상 초기화
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = costs[1][j];
                    continue;
                }
                // 다른 부분 선택은 큰 값으로 초기화(선택 X)
                dp[1][j] = 1000 * 1000;
            }

            // 두 번째 집부터 n번째 집까지의 최소 비용 계산
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + costs[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + costs[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + costs[j][2];
            }

            // 최소비용 결정
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    answer = Math.min(answer, dp[n][j]);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
