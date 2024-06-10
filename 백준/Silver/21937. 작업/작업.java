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
    static int target, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x1 = row[0];
            int x2 = row[1];
            // 역방향 그래프
            graph.get(x2).add(x1);
        }
        target = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        bfs(target);
        // 루트 노드는 카운팅에서 제외
        System.out.println(answer - 1);
        br.close();
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            // 역방향 시작 루트 노드에서 탐색할 수 있는 모든 노드의 수를 카운팅 해줌
            answer++;

            ArrayList<Integer> adjNodes = graph.get(nowNode);
            for (Integer adjNode : adjNodes) {
                int x1 = adjNode;
                if (!visited[x1]) {
                    queue.add(x1);
                    visited[x1] = true;
                }
            }
        }
    }
}
