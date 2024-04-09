import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * BFS + 가중치
 */
public class Main {

    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int start, end, answer, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; // vertex
        m = inputs[1]; // edge

        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 만들기 & 최소중량, 최대중량을 구해줌
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int v1 = data[0];
            int v2 = data[1];
            int weight = data[2];

            graph.get(v1).add(new Node(v2, weight));
            graph.get(v2).add(new Node(v1, weight));

            min = Math.min(min, weight);
            max = Math.max(max, weight);
        }
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        start = row[0]; //1
        end = row[1]; //3

        // 이분탐색 + BFS
        while (min <= max) {
            // 방문배열, 중량 저장 배열
            visited = new boolean[n + 1];

            int mid = (min + max) / 2;
            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
                continue;
            }
            max = mid - 1;
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean bfs(int weight) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            if (nowNode.id == end) {
                return true;
            }

            ArrayList<Node> edges = graph.get(nowNode.id);
            for (Node adjNode : edges) {
                if (!visited[adjNode.id] && weight <= adjNode.weight) {
                    visited[adjNode.id] = true;
                    queue.add(adjNode);
                }
            }
        }
        return false;
    }

    private static class Node {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }
}
