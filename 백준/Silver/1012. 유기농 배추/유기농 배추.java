import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * BFS
 */
public class Main {

    static int t, m, n, k, answer;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            m = inputs[0];
            n = inputs[1];
            k = inputs[2];

            map = new int[m][n];
            for (int i = 0; i < k; i++) {
                int[] data = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int x1 = data[0];
                int y1 = data[1];
                map[x1][y1] = 1;
            }

            visited = new boolean[m][n];
            answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        answer++;
                        bfs(new Point(i, j));
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
    }

    private static void bfs(Point startPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        while (!queue.isEmpty()) {
            Point node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (!isMovable(nx, ny) || map[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
