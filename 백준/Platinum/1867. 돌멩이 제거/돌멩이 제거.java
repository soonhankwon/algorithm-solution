import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Minimum Vertex Cover
 * 최소한의 정점 선택 -> 모든 간선들의 양 끝점 중 하나는 선택된 정점이어야 함
 * 이분 그래프의 최대 유량 문제와 동일함
 */
public class Main {

    static List<ArrayList<Edge>> graph;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n1 = row[0];
            int n2 = row[1];
            graph.get(n1).add(new Edge(n2));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).isEmpty()) {
                continue;
            }
            visited = new boolean[n + 1];
            if (isMatch(i)) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean isMatch(int num) {
        ArrayList<Edge> edges = graph.get(num);
        for (Edge edge : edges) {
            int nowNode = edge.node;
            if (visited[nowNode]) {
                continue;
            }
            visited[nowNode] = true;
            if (arr[nowNode] == -1 || isMatch(arr[nowNode])) {
                arr[nowNode] = num;
                return true;
            }
        }
        return false;
    }

    private static class Edge {
        int node;

        public Edge(int node) {
            this.node = node;
        }
    }
}
