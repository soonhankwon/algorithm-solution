import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 벽 부수고 이동하기
 * 최단경로 - BFS
 * 벽을 부술수 있는 기회는 1번
 */
public class Main {

    static int[][] map;
    static boolean[][][] visited;
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

        // 맵 만들기
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
            }
        }
        
        // 3차원 방문 배열로 벽을 부신경우, 아닌경우 별도 체크
        visited = new boolean[n][m][2];
        bfs(new Node(0, 0, 1, false));
        br.close();
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            if (nowNode.x == n - 1 && nowNode.y == m - 1) {
                System.out.println(nowNode.len);
                return;
            }

            int nextLen = nowNode.len + 1;
            for (int i = 0; i < 4; i++) {
                int x1 = nowNode.x + dx[i];
                int y1 = nowNode.y + dy[i];

                if (!isMovable(x1, y1)) {
                    continue;
                }

                // case1: 벽이 아니라면
                if (map[x1][y1] == 0) {
                    // 벽을 부신적이 없으면
                    if (!nowNode.isBroken && !visited[x1][y1][0]) {
                        queue.add(new Node(x1, y1, nextLen, false));
                        visited[x1][y1][0] = true;
                        continue;
                    }
                    // 벽을 부신적이 있으면
                    if (nowNode.isBroken && !visited[x1][y1][1]) {
                        queue.add(new Node(x1, y1, nextLen, true));
                        visited[x1][y1][1] = true;
                    }
                }
                // case2: 벽이라면
                else {
                    // 부순다
                    if (!nowNode.isBroken) {
                        queue.add(new Node(x1, y1, nextLen, true));
                        visited[x1][y1][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Node {
        int x;
        int y;
        int len;
        boolean isBroken;

        public Node(int x, int y, int len, boolean isBroken) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.isBroken = isBroken;
        }
    }
}
