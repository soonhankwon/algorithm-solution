import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 위상정렬: 작업의 순서가 정해져 있음, DAG(Directed Acyclic Graph - 방향그래프)
public class Main {

    static int n, k, w;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist, inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            n = inputs[0]; // 노드의 수
            k = inputs[1]; // 간선의 수

            dist = new int[n + 1];
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 1; i <= n; i++) {
                dist[i] = row[i - 1];
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 진입차수 배열
            inDegree = new int[n + 1];

            for (int i = 0; i < k; i++) {
                int[] data = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int v1 = data[0];
                int v2 = data[1];
                graph.get(v1).add(new Edge(v2));
                inDegree[v2]++;
            }

            w = Integer.parseInt(br.readLine());
            int result = topologicalSort();
            sb.append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int topologicalSort() {
        Queue<Edge> queue = new LinkedList<>();
        int[] res = new int[n + 1];

        // 건물 소요 기본 소요시간 dist[i]
        for (int i = 1; i <= n; i++) {
            res[i] = dist[i];
            // 진입 차수가 0인 정점을 추가
            if (inDegree[i] == 0) {
                queue.add(new Edge(i));
            }
        }

        while (!queue.isEmpty()) {
            Edge nowNode = queue.poll();

            ArrayList<Edge> edges = graph.get(nowNode.node);
            for (Edge edge : edges) {
                int nextNode = edge.node;
                res[nextNode] = Math.max(res[nextNode], res[nowNode.node] + dist[nextNode]);
                // 연결되 있던 간선 제거
                inDegree[nextNode]--;

                if (inDegree[nextNode] == 0) {
                    queue.add(new Edge(nextNode));
                }
            }
        }
        return res[w];
    }

    private static class Edge {
        int node;

        public Edge(int node) {
            this.node = node;
        }
    }
}
