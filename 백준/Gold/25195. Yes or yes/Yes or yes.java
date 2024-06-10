import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static List<ArrayList<Integer>> graph;
    static Set<Integer> set;
    static boolean isEnd;

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
            int v1 = row[0];
            int v2 = row[1];
            graph.get(v1).add(v2);
        }

        br.readLine();
        set = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());

        if (set.contains(1)) {
            System.out.println("Yes");
            return;
        }

        dfs(1);
        // isEnd(경로 탐색) -> true 라면 팬을 만나지 않고 경로를 탐색했다는 뜻 -> yes
        System.out.println(isEnd ? "yes" : "Yes");
        br.close();
    }

    private static void dfs(int node) {
        if (isEnd || set.contains(node)) {
            return;
        }
        ArrayList<Integer> adjNodes = graph.get(node);
        if (adjNodes.isEmpty()) {
            isEnd = true;
            return;
        }
        for (Integer adjNode : adjNodes) {
            dfs(adjNode);
        }
    }
}
