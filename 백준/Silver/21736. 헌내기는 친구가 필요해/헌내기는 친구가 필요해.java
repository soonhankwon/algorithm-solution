import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        m = inputs[1];

        map = new char[n][m];
        Point startPoint = null;
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'I') {
                    startPoint = new Point(i, j);
                }
            }
        }
        visited = new boolean[n][m];
        int answer = bfs(startPoint);
        if (answer == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(answer);
        br.close();
    }

    private static int bfs(Point startPoint) {
        int cnt = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int x1 = nowPoint.x;
            int y1 = nowPoint.y;
            if (map[x1][y1] == 'P') {
                cnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if (!isMovable(nx, ny) || map[nx][ny] == 'X') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
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
