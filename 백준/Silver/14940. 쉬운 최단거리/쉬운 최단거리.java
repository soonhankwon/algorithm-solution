import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map, dist;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        m = inputs[1];
        map = new int[n][m];
        dist = new int[n][m];
        Point startPoint = null;
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                int p1 = data[j];
                map[i][j] = p1;
                if (p1 == 2) {
                    startPoint = new Point(i, j, 0);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        visited = new boolean[n][m];
        bfs(startPoint);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs(Point startNode) {
        queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!queue.isEmpty()) {
            Point nowNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if (!isMovable(nx, ny) || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, nowNode.len + 1));
                dist[nx][ny] = nowNode.len + 1;
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Point {
        int x;
        int y;
        int len;

        public Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
