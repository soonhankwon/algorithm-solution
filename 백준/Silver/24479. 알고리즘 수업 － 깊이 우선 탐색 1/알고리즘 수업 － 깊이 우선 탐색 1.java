import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * DFS
 */
public class Main {

    static boolean[] visited;
    static int[] memo;
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m, r, cnt;

    public static void main(String[] args) throws IOException {
        // n 개의 정점, m 개의 간선 그리고 무방향 그래프이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0]; //vertex 5
        m = inputs[1]; //edge 5
        r = inputs[2]; //start 1

        // 간선이 1부터 시작하므로 인덱스 때문에 0~n 까지 추가
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

        cnt = 1;
        memo = new int[n];
        visited = new boolean[n + 1];
        dfs(r);
        for (int m : memo) {
            System.out.println(m);
        }
        br.close();
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;
        memo[vertex - 1] = cnt;

        ArrayList<Integer> edges = graph.get(vertex);
        for (int nextVertex : edges) {
            if (!visited[nextVertex]) {
                cnt++;
                dfs(nextVertex);
            }
        }
    }
}
