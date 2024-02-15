import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BFS
public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //7
        int m = Integer.parseInt(br.readLine()); //6

        // 리스트 배열 초기화
        graph = new ArrayList[n + 1];
        // 리스트 배열에 빈 리스트 넣어줌(노드에 맞춰서)
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        // 방문 배열 초기화
        visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int input1 = inputs[0]; //1
            int input2 = inputs[1]; //2
            graph[input1].add(input2);
            graph[input2].add(input1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            for (Integer i : graph[node]) {
                if (!visited[i]) {
                    queue.add(i);
                }
            }
        }
        int cnt = 0;
        for (boolean isVisited : visited) {
            if (isVisited) {
                cnt++;
            }
        }
        System.out.println(cnt - 1);
    }
}