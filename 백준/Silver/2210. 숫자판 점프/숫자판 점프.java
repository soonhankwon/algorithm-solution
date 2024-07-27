import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] map;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new String[5][5];
        for (int i = 0; i < 5; i++) {
            String[] row = br.readLine().split(" ");
            System.arraycopy(row, 0, map[i], 0, 5);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, map[i][j]);
            }
        }
        System.out.println(set.size());
        br.close();
    }

    private static void dfs(int x, int y, int cnt, String value) {
        if (cnt == 5) {
            set.add(value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isMovable(nx, ny)) {
                dfs(nx, ny, cnt + 1, value + map[nx][ny]);
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}