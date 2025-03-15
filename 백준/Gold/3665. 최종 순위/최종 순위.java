import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] lastYear = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int m = Integer.parseInt(br.readLine());
            List<int[]> changes = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                changes.add(
                        Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray()
                );
            }
            sb.append(findFinalRanking(n, lastYear, changes)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static String findFinalRanking(int n, int[] lastYear, List<int[]> changes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        // 작년 순위 그래프
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph.get(lastYear[i]).add(lastYear[j]);
                inDegree[lastYear[j]]++;
            }
        }
        // 순위 변경 적용
        for (int[] change : changes) {
            int a = change[0];
            int b = change[1];
            if (graph.get(a).contains(b)) {
                graph.get(a).remove(b);
                graph.get(b).add(a);
                inDegree[b]--;
                inDegree[a]++;
            } else {
                graph.get(b).remove(a);
                graph.get(a).add(b);
                inDegree[a]--;
                inDegree[b]++;
            }
        }
        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 진입차수가 0인 노드부터 탐색(해당 노드로 들어오는 간선이 없음)
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 큐에 여러 노드가 남아있다면, 진입차수가 0인 노드가 여러 개 -> 순위를 정할 수 없음
            if (queue.size() > 1) {
                return "?";
            }
            int current = queue.poll();
            result.add(current);
            for (int neighbor : graph.get(current)) {
                // 위상 정렬에서 다음으로 처리할 노드(진입차수 0)
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() == n) {
            return result.stream()
                    .map(String::valueOf)
                    .reduce((a, b) -> a + " " + b)
                    .orElse("");
        } else {
            return "IMPOSSIBLE";
        }
    }
}