import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 적록색약
 */
public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // map 생성 - R, G, B
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
            }
        }

        //적록 색약 - 빨강/초록을 같은 구역으로 봄
        visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은 좌표에서 다시 dfs 를 진행하여 영역을 구한다.
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        //적록색약인 경우 G를 R로 바꿔준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        int abnormalCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    abnormalCnt++;
                }
            }
        }
        System.out.println(cnt + " " + abnormalCnt);
        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char color = map[x][y];
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (!isMovable(x1, y1)) {
                continue;
            }
            if (!visited[x1][y1] && map[x1][y1] == color) {
                dfs(x1, y1);
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
