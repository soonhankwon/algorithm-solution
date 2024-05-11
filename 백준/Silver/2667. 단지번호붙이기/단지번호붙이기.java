import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Integer> pq;
    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = row[j];
            }
        }

        visited = new boolean[n][n];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int result = bfs(new Point(i, j));
                    if (result != 0) {
                        pq.add(result);
                        cnt++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int bfs(Point startPoint) {
        int aptCnt = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int x1 = nowPoint.x;
            int y1 = nowPoint.y;

            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if (!isMovable(nx, ny) || map[nx][ny] != 1) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    aptCnt++;
                    visited[nx][ny] = true;
                }
            }
        }
        return aptCnt + 1;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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
