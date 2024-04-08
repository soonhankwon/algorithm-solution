import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue;
    static int[] visited;
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        // n 개의 정점, m 개의 간선 그리고 무방향 그래프이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0]; // vertex 5
        m = inputs[1]; // edge 5
        r = inputs[2]; // 시작 정점 1

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int v1 = row[0];
            int v2 = row[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (ArrayList<Integer> g : graph) {
            Collections.sort(g);
        }

        visited = new int[n];
        queue = new LinkedList<>();
        bfs(r);

        for (int order : visited) {
            System.out.println(order);
        }
        br.close();
    }

    private static void bfs(int startVertex) {
        queue.add(startVertex);
        int cnt = 1;

        visited[startVertex - 1] = cnt++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            ArrayList<Integer> edges = graph.get(node);
            for (Integer n : edges) {
                if (visited[n - 1] != 0) {
                    continue;
                }
                queue.add(n);
                visited[n - 1] = cnt++;
            }
        }
    }
}
