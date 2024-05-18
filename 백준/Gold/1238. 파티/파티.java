import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int[] dist;
    static int v, e, x, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        v = inputs[0]; //n개 마을
        e = inputs[1]; //m개 단방향 도로
        x = inputs[2]; //목적지

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int v1 = row[0];
            int v2 = row[1];
            int cost = row[2];
            graph.get(v1).add(new Edge(v2, cost));
        }

        for (int i = 1; i <= v; i++) {
            int goCost = dijkstra(i, x);
            int comeCost = dijkstra(x, i);
            max = Math.max(max, goCost + comeCost);
        }
        System.out.println(max);
        br.close();
    }

    private static int dijkstra(int start, int destination) {
        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        visited = new boolean[v + 1];
        pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

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
        return dist[destination];
    }

    private static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
