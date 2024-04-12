import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Prim 알고리즘 - 최소 스패닝 트리
 */
public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int sum, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int v = inputs[0]; // vertex
        int e = inputs[1]; // edge

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int v1 = data[0];
            int v2 = data[1];
            int v3 = data[2];

            graph.get(v1).add(new Edge(v2, v3));
            graph.get(v2).add(new Edge(v1, v3));
        }

        // 선택된 정점에서 가중치가 가장 작은 간선을 선택해서 추가해야 함
        pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        visited = new boolean[v + 1];
        prim();
        System.out.println(sum - max);
        br.close();
    }

    private static void prim() {
        while (!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            int nowNode = nowEdge.node;
            int cost = nowEdge.cost;

            if (!visited[nowNode]) {
                visited[nowNode] = true;
                // 가중치의 합 - prim
                sum += cost;
                // 가중치의 최대값 갱신
                max = Math.max(max, cost);

                ArrayList<Edge> adjEdges = graph.get(nowNode);
                for (Edge adjEdge : adjEdges) {
                    if (!visited[adjEdge.node]) {
                        pq.add(adjEdge);
                    }
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
