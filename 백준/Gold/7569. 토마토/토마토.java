import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static boolean[][][] visited;
    static int h, m, n, unripeCnt, ripeCnt, emptySpaceCnt;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        m = inputs[0]; //5
        n = inputs[1]; //3
        h = inputs[2];

        map = new int[h][n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                int[] row = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int k = 0; k < m; k++) {
                    int element = row[k];
                    if (element == 0) {
                        unripeCnt++;
                        continue;
                    }
                    if (element == 1) {
                        queue.add(new Point(j, k, i, 0));
                        ripeCnt++;
                    }
                    if (element == -1) {
                        emptySpaceCnt++;
                    }
                    map[i][j][k] = element;
                }
            }
        }
        if (emptySpaceCnt + ripeCnt == h * m * n) {
            System.out.println(0);
            return;
        }
        visited = new boolean[h][n][m];
        int answer = bfs();
        if (unripeCnt > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
        br.close();
    }

    private static int bfs() {
        int day = 0;
        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            visited[nowPoint.h][nowPoint.x][nowPoint.y] = true;

            int x1 = nowPoint.x;
            int y1 = nowPoint.y;
            int h1 = nowPoint.h;
            day = Math.max(day, nowPoint.len);

            for (int i = 0; i < 6; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                int nh = h1 + dh[i];
                if (!isMovable(nx, ny, nh) || visited[nh][nx][ny] || map[nh][nx][ny] == -1) {
                    continue;
                }

                queue.add(new Point(nx, ny, nh, nowPoint.len + 1));
                visited[nh][nx][ny] = true;

                if (map[nh][nx][ny] == 0) {
                    unripeCnt--;
                }
            }
        }
        return day;
    }

    private static boolean isMovable(int x, int y, int height) {
        return height >= 0 && height < h && x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Point {
        int x;
        int y;
        int h;
        int len;

        public Point(int x, int y, int h, int len) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.len = len;
        }
    }
}
