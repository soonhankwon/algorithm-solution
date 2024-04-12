import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 다익스트라 - 단일출발점 최단거리
 */
public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static int[] dist;
    static boolean[] visited;
    static int destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine()); //vertex
        int e = Integer.parseInt(br.readLine()); //edge

        // 인접리스트 - 그래프 만들기
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 1. 초기화
        // 최단거리 메모 배열
        dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int v1 = inputs[0];
            int v2 = inputs[1];
            int cost = inputs[2];

            // 단방향 그래프
            graph.get(v1).add(new Edge(v2, cost));
        }

        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startVertex = data[0];
        destination = data[1];
        pq = new PriorityQueue<>();
        pq.add(new Edge(startVertex, 0));
        // 출발점의 거리 = 0
        dist[startVertex] = 0;

        // 2. S=V 가 될때까지 반복
        visited = new boolean[v + 1];
        dijkstra();
        System.out.println(dist[destination]);
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
