import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Bellman-Ford
 */
public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static int vertex, edge, w;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            vertex = inputs[0];
            edge = inputs[1];
            w = inputs[2];

            dist = new int[vertex + 1];
            graph = new ArrayList<>();
            for (int j = 0; j <= vertex; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < edge + w; j++) {
                int[] data = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int start = data[0];
                int end = data[1];
                int cost = data[2];

                // 도로는 양방향 그래프
                if (j < edge) {
                    graph.get(start).add(new Edge(end, cost));
                    graph.get(end).add(new Edge(start, cost));
                } else {
                    // 웜홀은 단방향 그래프 & 음수 가중치
                    graph.get(start).add(new Edge(end, -cost));
                }
            }

            boolean isMinusCycle = false;
            for (int j = 1; j <= vertex; j++) {
                if (bellmanFord(j)) {
                    isMinusCycle = true;
                    sb.append("YES").append("\n");
                    break;
                }
            }
            if (!isMinusCycle) {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업 반복
        for (int i = 1; i < vertex; i++) {
            update = false;

            // 최단거리 초기화
            for (int j = 1; j <= vertex; j++) {
                ArrayList<Edge> edges = graph.get(j);
                for (Edge e : edges) {
                    if (dist[j] != INF && dist[e.node] > dist[j] + e.cost) {
                        dist[e.node] = dist[j] + e.cost;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않을 경우 반복문 종료
            if (!update) {
                break;
            }
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생할 경우
        // (정점의 개수) 번 업데이트가 발생하면 음수 사이클 발생 의미
        if (update) {
            for (int i = 1; i <= vertex; i++) {
                ArrayList<Edge> edges = graph.get(i);
                for (Edge e : edges) {
                    if (dist[i] != INF && dist[e.node] > dist[i] + e.cost) {
                        return true;
                    }
                }
            }
        }
        return false;
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
