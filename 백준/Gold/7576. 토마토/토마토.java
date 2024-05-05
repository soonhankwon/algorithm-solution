import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int m, n, unRipeTomatoCnt, answer;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> queue;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        m = inputs[0];
        n = inputs[1];

        map = new int[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                int p = data[j];
                map[i][j] = p;
                if (p == 0) {
                    unRipeTomatoCnt++;
                }
                if (p == 1) {
                    queue.add(new Point(i, j, 0));
                }
            }
        }
        visited = new boolean[n][m];
        answer = Integer.MIN_VALUE;
        if (unRipeTomatoCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        if (unRipeTomatoCnt > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point nowNode = queue.poll();
            answer = Math.max(answer, nowNode.len);

            for (int i = 0; i < 4; i++) {
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if (!isMovable(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == -1 || map[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, nowNode.len + 1));
                unRipeTomatoCnt--;
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
