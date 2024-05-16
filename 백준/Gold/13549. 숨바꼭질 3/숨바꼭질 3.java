import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[] visited;
    static int n, k, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        k = inputs[1];

        visited = new boolean[100_001];
        answer = Integer.MAX_VALUE;
        bfs(new Point(n, 0));
        System.out.println(answer);
        br.close();
    }

    private static void bfs(Point startPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int x1 = nowPoint.x;
            visited[x1] = true;
            if (x1 == k) {
                answer = Math.min(answer, nowPoint.len);
            }

            if (x1 * 2 < 100_001 && !visited[x1 * 2]) {
                queue.add(new Point(x1 * 2, nowPoint.len));
            }
            if (x1 + 1 < 100_001 && !visited[x1 + 1]) {
                queue.add(new Point(x1 + 1, nowPoint.len + 1));
            }
            if (x1 - 1 >= 0 && !visited[x1 - 1]) {
                queue.add(new Point(x1 - 1, nowPoint.len + 1));
            }
        }
    }

    private static class Point {
        int x;
        int len;

        public Point(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }
}
