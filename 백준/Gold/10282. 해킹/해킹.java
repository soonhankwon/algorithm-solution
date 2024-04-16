import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 다익스트라
 */
public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = inputs[0]; // vertex's number
            int d = inputs[1]; // edge's number
            int c = inputs[2]; // start

            // 인접리스트 - 그래프 만들기
            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // 1. 초기화
            // 최단거리 메모 배열
            dist = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                dist[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < d; j++) {
                int[] data = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int v1 = data[0];
                int v2 = data[1];
                int cost = data[2];

                // 그래프 의존성 방향 주의!
                graph.get(v2).add(new Edge(v1, cost));
            }

            pq = new PriorityQueue<>();
            pq.add(new Edge(c, 0));
            // 출발점의 거리 = 0
            dist[c] = 0;

            visited = new boolean[n + 1];
            dijkstra();
            
            long cnt = Arrays.stream(dist)
                    .filter(dist -> dist != Integer.MAX_VALUE)
                    .count();
            int max = Arrays.stream(dist)
                    .filter(dist -> dist != Integer.MAX_VALUE)
                    .max().orElse(0);

            sb.append(cnt).append(" ").append(max).append("\n");
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
