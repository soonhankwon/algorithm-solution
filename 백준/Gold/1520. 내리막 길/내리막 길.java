import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int[][] graph;
    private static int[][] dp;
    private static int m;
    private static int n;
    private static int tempY;
    private static int tempX;
    private static int count;
    private static final List<int[]> availableMoves =
            List.of(new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0});

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0]; // 4
        n = input[1]; // 5

        // 제일 왼쪽 위 칸 -> 제일 오른쪽 아래 칸
        // 가능한 힘을 적게 들이고 목표 지점
        graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(data, 0, graph[i], 0, n);
        }

        dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        tempY = 0;
        tempX = 0;
        recursion(0, 0);
        System.out.println(count);
    }

    private static int recursion(int y, int x) {
        if (dp[y][x] != -1) // 모든 지점에서 계산이 한번이라도 된다면 재사용
            return dp[y][x];

        if (tempY == m - 1 && tempX == n - 1) {
            return 1;
        }

        count = 0;
        for (int[] move : availableMoves) {
            tempY = y + move[0];
            tempX = x + move[1];

            if (0 <= tempY && tempY < m && 0 <= tempX && tempX < n) {
                if (graph[tempY][tempX] < graph[y][x]) {
                    count += recursion(tempY, tempX);
                }
            }
        }
        dp[y][x] = count;
        return dp[y][x];
    }
}