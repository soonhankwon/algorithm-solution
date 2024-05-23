import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];
        // dp[n번째][비용] -> dp[0][0] -> 0번째 입력 앱 사용시 비용 0으로 확보가능한 최대 메모리 크기
        int[][] dp = new int[n][n * 100 + 1];

        List<App> apps = new ArrayList<>();
        int[] memories = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] costs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            apps.add(new App(memories[i], costs[i]));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            App app = apps.get(i);
            int memory = app.memory;
            int cost = app.cost;

            for (int j = 0; j <= n * 100; j++) {
                if (i == 0) {
                    if (j >= cost) {
                        dp[i][j] = memory;
                    }
                } else {
                    if (j >= cost) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }
}
