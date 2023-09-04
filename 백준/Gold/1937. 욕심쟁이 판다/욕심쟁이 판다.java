import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final static List<int[]> availableMoves =
            List.of(new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0});
    private static int x;
    private static int y;
    private static int n;
    private static int[][] graph;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(data, 0, graph[i], 0, n);
        }

        // 모든 점을 방문한다!
        // 방문한 뒤에 이동할 수 있는 모든 경우의 수를 재귀로 구현한다.
        // 재귀로 구현한 뒤 DP로 바꾼다.
        dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, 0);
        }

        int maxCount = Integer.MIN_VALUE;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                maxCount = Math.max(recursion(y, x), maxCount);
            }
        }

        System.out.println(maxCount + 1);
    }

    private static int recursion(int dy, int dx) {
        if (dp[dy][dx] != 0)
            return dp[dy][dx];

        for (int[] m : availableMoves) {
            y = dy + m[1];
            x = dx + m[0];

            if (0 <= y && y < n && 0 <= x && x < n) {
                if (graph[y][x] > graph[dy][dx]) {
                    dp[dy][dx] = Math.max(dp[dy][dx], recursion(y, x) + 1);
                }
            }
        }
        return dp[dy][dx];
    }
}