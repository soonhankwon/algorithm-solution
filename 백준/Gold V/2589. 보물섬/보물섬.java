import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Pair {
        int x, y, len;

        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int n, m, answer;

    //move
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        n = inputs[0]; //5 - 세로
        m = inputs[1]; //7 - 가로

        // create map
        map = new char[n][m];
        answer = 0;

        // add map information
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        //완전 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    bfs(new Pair(i, j, 0));
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        visited[pair.x][pair.y] = true;

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 안에 있으며 방문하지 않고 육지인 경우
                if (isMovable(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny, node.len + 1));
                    answer = Math.max(answer, node.len + 1);
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}