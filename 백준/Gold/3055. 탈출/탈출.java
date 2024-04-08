import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 탈출 - water, user 각각 BFS
 */
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;
    static char[][] map;
    static Queue<Node> queue;

    static int r, c;
    static Node start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        r = inputs[0];
        c = inputs[1];

        queue = new LinkedList<>();

        // 맵 만들기
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'S') {
                    start = new Node(i, j, 0);
                    continue;
                }
                if (map[i][j] == 'D') {
                    end = new Node(i, j, 0);
                    continue;
                }

                if (map[i][j] == '*') {
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        // 매 분마다 이동가능
        // 매 분마다 물이 인접칸으로 찬다.
        visited = new boolean[r][c];
        bfs();
        br.close();
    }

    private static void bfs() {
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            // water process
            Node node = queue.poll();

            if (node.x == end.x && node.y == end.y) {
                System.out.println(node.len);
                return;
            }

            if (map[node.x][node.y] == '*') {
                // water process
                for (int i = 0; i < 4; i++) {
                    int x1 = node.x + dx[i];
                    int y1 = node.y + dy[i];

                    if (!isMovable(x1, y1) || visited[x1][y1] || map[x1][y1] == 'D' || map[x1][y1] == 'X') {
                        continue;
                    }

                    queue.add(new Node(x1, y1, node.len));
                    visited[x1][y1] = true;
                    map[x1][y1] = '*';
                }
            } else {
                // user process
                for (int i = 0; i < 4; i++) {
                    int x1 = node.x + dx[i];
                    int y1 = node.y + dy[i];

                    if (!isMovable(x1, y1) || visited[x1][y1] || map[x1][y1] == '*' || map[x1][y1] == 'X') {
                        continue;
                    }

                    queue.add(new Node(x1, y1, node.len + 1));
                    visited[x1][y1] = true;
                }
            }
        }
        System.out.println("KAKTUS");
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    private static class Node {
        int x;
        int y;
        int len;

        public Node(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
