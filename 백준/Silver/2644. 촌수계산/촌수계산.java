import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<ArrayList<Node>> graph;
    static boolean[] visited;
    static int target;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] relation = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        target = relation[1];
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
            graph.get(v1).add(new Node(v2, 0));
            graph.get(v2).add(new Node(v1, 0));
        }

        visited = new boolean[n + 1];
        answer = -1;
        bfs(new Node(relation[0], 0));
        System.out.println(answer);
        br.close();
    }

    private static void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode.x] = true;
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int x = nowNode.x;
            if (x == target) {
                answer = nowNode.len;
                break;
            }
            ArrayList<Node> adjNodes = graph.get(x);
            for (Node node : adjNodes) {
                int x1 = node.x;
                if (!visited[x1]) {
                    queue.add(new Node(x1, nowNode.len + 1));
                    visited[x1] = true;
                }
            }
        }
    }

    private static class Node {
        int x;
        int len;

        public Node(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }
}
