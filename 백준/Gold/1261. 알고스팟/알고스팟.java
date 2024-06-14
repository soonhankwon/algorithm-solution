import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int[][] map;
    static int[][] dist;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[1];
        m = inputs[0];

        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra();
        System.out.println(dist[n - 1][m - 1]);
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        dist[0][0] = 0;
        pq.add(new Edge(0, 0, 0));
        while (!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            int x1 = nowEdge.x;
            int y1 = nowEdge.y;

            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                int nowCost = nowEdge.cost;
                if (!isMovable(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    nowCost++;
                }
                if (dist[nx][ny] > nowCost) {
                    dist[nx][ny] = nowCost;
                    pq.add(new Edge(nx, ny, dist[nx][ny]));
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Edge {
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
