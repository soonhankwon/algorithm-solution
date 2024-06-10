import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        graph = new ArrayList<>();
        int n = inputs[0];
        int m = inputs[1];
        int r = inputs[2];

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
        bfs(r);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int startNode) {
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            result[nowNode - 1] = ++index;
            ArrayList<Integer> adjNodes = graph.get(nowNode);
            for (Integer adjNode : adjNodes) {
                if (!visited[adjNode]) {
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}
