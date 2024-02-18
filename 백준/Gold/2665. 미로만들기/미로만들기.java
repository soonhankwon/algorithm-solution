import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static char[][] map;
    static int[][] dist;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //8

        //create map
        map = new char[n][n];

        //create distance array
        dist = new int[n][n];

        //add map info
        for (int i = 0; i < n; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs.charAt(j);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(new Node(0, 0));

        System.out.println(dist[n - 1][n - 1]);
    }

    private static void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (isMovable(nx, ny) && dist[nx][ny] > dist[node.x][node.y]) {
                    char point = map[nx][ny];
                    if (point == '1') {
                        dist[nx][ny] = dist[node.x][node.y];
                        queue.add(new Node(nx, ny));
                    } else {
                        dist[nx][ny] = dist[node.x][node.y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
