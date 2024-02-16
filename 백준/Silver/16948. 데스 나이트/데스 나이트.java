import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node {
        int x, y, len;

        public Node(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static int n, answer;
    static boolean isPossible;
    static boolean[][] visited;

    //move
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 7 * 7

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Node start = new Node(inputs[0], inputs[1], 0);
        Node end = new Node(inputs[2], inputs[3], 0);

        visited = new boolean[n][n];
        answer = Integer.MAX_VALUE;
        isPossible = false;

        bfs(start, end);

        if (isPossible) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 안에 있으며 방문하지 않은 경우
                if (isMovable(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.len + 1));
                }

                if (nx == end.x && ny == end.y) {
                    isPossible = true;
                    answer = Math.min(answer, node.len + 1);
                    break;
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
