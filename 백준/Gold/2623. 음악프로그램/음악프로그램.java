import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] inDegree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; // 노드의 수
        m = inputs[1]; // 간선의 수

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 배열
        inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int length = row[0];
            for (int j = 1; j < length; j++) {
                int v1 = row[j];
                int v2 = row[j + 1];
                graph.get(v1).add(v2);
                inDegree[v2]++;
            }
        }
        sb = new StringBuilder();
        topologicalSort();
        System.out.println(sb);
        br.close();
    }

    private static void topologicalSort() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        // 진입 차수가 0인 정점을 추가
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0; //처리된 노드의 수
        while (!queue.isEmpty()) {
            Integer nowNode = queue.poll();
            sb.append(nowNode).append("\n");
            cnt++;
            ArrayList<Integer> edges = graph.get(nowNode);
            for (Integer nextNode : edges) {
                inDegree[nextNode]--;

                if (inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }
        // 순서가 불가능한 경우
        if (cnt != n) {
            sb.setLength(0);
            sb.append(0);
        }
    }
}
