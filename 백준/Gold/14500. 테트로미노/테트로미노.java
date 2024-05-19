import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n, m, answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        m = inputs[1];

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int y, int x, int cnt, int sum) {
        if (cnt >= 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }

            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    private static void check(int y, int x) {
        if (y < n - 2 && x < m - 1) {
            answer = Math.max(answer, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
        }

        if (y < n - 2 && x > 0) {
            answer = Math.max(answer, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);
        }

        if (y < n - 1 && x < m - 2) {
            answer = Math.max(answer, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
        }

        if (y > 0 && x < m - 2) {
            answer = Math.max(answer, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
        }
    }
}
