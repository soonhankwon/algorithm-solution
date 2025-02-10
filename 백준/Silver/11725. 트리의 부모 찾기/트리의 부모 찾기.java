import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            tree[arr[0]].add(arr[1]);
            tree[arr[1]].add(arr[0]);
        }

        int[] answer = new int[n + 1];
        dfs(1, visited, tree, answer);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int node, boolean[] visited, List<Integer>[] tree, int[] answer) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Integer i : tree[node]) {
            if (!visited[i]) {
                answer[i] = node;
            }
            dfs(i, visited, tree, answer);
        }

    }
}
