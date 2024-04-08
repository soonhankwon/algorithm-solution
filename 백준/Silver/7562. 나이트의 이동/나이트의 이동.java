import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 최소 - BFS
 */
public class Main {

    static boolean[][] visited;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int n, gx, gy, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            // n * n 체스판
            visited = new boolean[n][n];

            int[] inputs1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            //목표 좌표
            gx = inputs1[0];
            gy = inputs1[1];

            int[] inputs2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            //현재 좌표
            int nx = inputs2[0];
            int ny = inputs2[1];

            answer = Integer.MAX_VALUE;

            bfs(new Pair(nx, ny, 0));

            System.out.println(answer);
        }
        br.close();
    }

    static class Pair {
        int x;
        int y;
        int len;

        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    private static void bfs(Pair pair) {
        //현재 좌표와 목표 좌표가 같으면 0(움직일 필요 없음)
        if (pair.x == gx && pair.y == gy) {
            answer = 0;
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        visited[pair.x][pair.y] = true;

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            for (int i = 0; i < 8; i++) {
                int x1 = node.x + dx[i];
                int y1 = node.y + dy[i];

                if (isMovable(x1, y1) && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    queue.add(new Pair(x1, y1, node.len + 1));
                }

                if (x1 == gx && y1 == gy) {
                    answer = Math.min(answer, node.len + 1);
                    break;
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
