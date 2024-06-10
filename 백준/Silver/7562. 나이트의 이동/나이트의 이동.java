import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static boolean[][] visited;
    static Point targetPoint;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int[] row1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] row2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            targetPoint = new Point(row2[0], row2[1], 0);
            visited = new boolean[n][n];
            int res = bfs(new Point(row1[0], row1[1], 0));
            sb.append(res).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int bfs(Point startPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;
        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            if (nowPoint.x == targetPoint.x && nowPoint.y == targetPoint.y) {
                return nowPoint.len;
            }
            for (int i = 0; i < 8; i++) {
                int nx = nowPoint.x + dx[i];
                int ny = nowPoint.y + dy[i];
                if (!isMovable(nx, ny)) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    queue.add(new Point(nx, ny, nowPoint.len + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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
