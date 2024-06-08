import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] result;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];
        int r = inputs[2];
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
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
        graph.forEach(Collections::sort);

        visited = new boolean[n + 1];
        result = new int[n];
        num = 1;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        result[node - 1] = num;
        ArrayList<Integer> adjNodes = graph.get(node);
        for (Integer adjNode : adjNodes) {
            if (!visited[adjNode]) {
                num++;
                dfs(adjNode);
            }
        }
    }
}
