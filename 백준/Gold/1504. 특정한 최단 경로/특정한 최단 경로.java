import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static List<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int[] dist;
    static int n, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        e = inputs[1];

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
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
            graph.get(v2).add(new Edge(v1, cost));
        }
        int[] requiredNodes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int node1 = requiredNodes[0];
        int node2 = requiredNodes[1];

        int cost1 = dijkstra(1, node1);
        cost1 += dijkstra(node1, node2);
        cost1 += dijkstra(node2, n);

        int cost2 = dijkstra(1, node2);
        cost2 += dijkstra(node2, node1);
        cost2 += dijkstra(node1, n);

        System.out.println(dist[n] == Integer.MAX_VALUE ? -1 : Math.min(cost1, cost2));
        br.close();
    }

    private static int dijkstra(int start, int destination) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        visited = new boolean[n + 1];
        pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int nowNode = pq.poll().node;
            if (visited[nowNode]) {
                continue;
            }
            visited[nowNode] = true;

            ArrayList<Edge> edges = graph.get(nowNode);
            for (Edge edge : edges) {
                int adjNode = edge.node;
                int adjCost = edge.cost;

                if (dist[adjNode] > dist[nowNode] + adjCost) {
                    dist[adjNode] = dist[nowNode] + adjCost;
                    pq.add(new Edge(adjNode, dist[adjNode]));
                }
            }
        }
        return dist[destination];
    }

    private static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
