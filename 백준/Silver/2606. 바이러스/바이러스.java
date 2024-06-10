import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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
        visited = new boolean[n + 1];
        bfs();
        System.out.println(answer - 1);
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            answer++;
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
