import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 녹색 옷 입은 애가 젤다지?
 * 잃는 금액을 최소로하여 도착지까지 이동해야 한다.
 * 다익스트라 알고리즘 - 단일 출발점
 */
public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] visited;
    static int[] dist;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;

    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            // 1. 초기화
            map = new int[n][n];
            dist = new int[n * n];
            graph = new ArrayList<>();
            for (int i = 0; i < n * n; i++) {
                graph.add(new ArrayList<>());
            }

            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < n; j++) {
                    map[i][j] = inputs[j];
                }
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int x1 = i + dx[k];
                        int y1 = j + dy[k];
                        if (!isMovable(x1, y1)) {
                            continue;
                        }
                        graph.get(index).add(new Edge((x1 * n) + y1, map[x1][y1]));
                    }
                    index++;
                }
            }
            pq = new PriorityQueue<>();
            pq.add(new Edge(0, map[0][0]));
            dist[0] = map[0][0];

            visited = new boolean[(n * n) + 1];
            dijkstra();
            sb.append("Problem ").append(cnt).append(": ").append(dist[dist.length - 1]).append("\n");
            cnt++;
        }
        System.out.println(sb);
        br.close();
    }

    private static void dijkstra() {
        while (!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            int nowNode = nowEdge.node;
            if (visited[nowNode]) {
                continue;
            }
            visited[nowNode] = true;

            ArrayList<Edge> adjEdges = graph.get(nowNode);
            for (Edge adjEdge : adjEdges) {
                int adjNode = adjEdge.node;
                int adjCost = adjEdge.cost;

                if (dist[adjNode] > dist[nowNode] + adjCost) {
                    dist[adjNode] = dist[nowNode] + adjCost;
                    pq.add(new Edge(adjNode, dist[adjNode]));
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
