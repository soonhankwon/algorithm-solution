import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * 숨바꼭질
 * 1. x - 1 or x + 1
 * 2. x * 2
 */
public class Main {

    static int n, k, answer;
    static int[] dx = {-1, 1};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; //start
        k = inputs[1]; //goal

        answer = Integer.MAX_VALUE;
        visited = new boolean[100_001];
        bfs(new Node(n, 0));
        System.out.println(answer);
        br.close();
    }

    private static void bfs(Node startNode) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode.x] = true;

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            if (nowNode.x == k) {
                answer = Math.min(answer, nowNode.len);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int x1 = i != 2 ? nowNode.x + dx[i] : nowNode.x * 2;

                if (isMovable(x1) && !visited[x1]) {
                    queue.add(new Node(x1, nowNode.len + 1));
                    visited[x1] = true;
                }
            }
        }
    }

    private static boolean isMovable(int x) {
        return x >= 0 && x < 100_001;
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
