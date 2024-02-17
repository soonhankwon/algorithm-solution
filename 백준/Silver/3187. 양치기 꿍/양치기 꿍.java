import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int n, m, wCnt, sCnt;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        n = inputs[0]; //6
        m = inputs[1]; //6
        wCnt = 0;
        sCnt = 0;

        //create map
        map = new char[n][m];
        visited = new boolean[n][m];

        //add map information
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        //brute force
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char point = map[i][j];
                if (point == '.' && !visited[i][j]) {
                    bfs(new Node(i, j), 0, 0);
                } else if (point == 'v' && !visited[i][j]) {
                    bfs(new Node(i, j), 1, 0);
                } else if (point == 'k' && !visited[i][j]) {
                    bfs(new Node(i, j), 0, 1);
                }
            }
        }

        System.out.println(sCnt + " " + wCnt);
    }

    private static void bfs(Node start, int startWCnt, int startSCnt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        visited[start.x][start.y] = true;

        int tempWCnt = startWCnt;
        int tempSCnt = startSCnt;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (isMovable(nx, ny) && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'v') {
                        tempWCnt++;
                        queue.add(new Node(nx, ny));
                    } else if (map[nx][ny] == 'k') {
                        tempSCnt++;
                        queue.add(new Node(nx, ny));
                    } else {
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
        if (tempWCnt >= tempSCnt) {
            wCnt += tempWCnt;
        } else {
            sCnt += tempSCnt;
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
