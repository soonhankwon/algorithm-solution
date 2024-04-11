import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * 아기상어
 * 안전거리 - 그 칸과 가장 가까운 아기상어와의 거리
 * 안전거리가 가장 큰 칸을 구해보자(BFS)
 */
public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int n, m, answer;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = input[0]; //5
        m = input[1]; //4

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = data[j].charAt(0);
            }
        }

        answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    continue;
                }
                visited = new boolean[n][m];
                int cnt = bfs(new Node(i, j, 0));
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static int bfs(Node startNode) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode.x][startNode.y] = true;

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            for (int i = 0; i < 8; i++) {
                int x1 = nowNode.x + dx[i];
                int y1 = nowNode.y + dy[i];

                if (!isMovable(x1, y1) || visited[x1][y1]) {
                    continue;
                }

                if (map[x1][y1] == '1') {
                    return nowNode.len + 1;
                }

                visited[x1][y1] = true;
                queue.add(new Node(x1, y1, nowNode.len + 1));
            }
        }
        return 0;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Node {
        int x;
        int y;
        int len;

        public Node(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
