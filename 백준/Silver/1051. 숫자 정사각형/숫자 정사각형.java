import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
            }
        }
        // n * n 정사각형 틀
        int index = 1;
        for (int i = n; i > 0; i--) {
            if (hasAnswer(i)) {
                index = i;
                break;
            }
        }
        System.out.println(index * index);
        br.close();
    }

    private static boolean hasAnswer(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x1 = i + num - 1;
                int y1 = j + num - 1;
                if (isMovable(x1, y1)) {
                    int v1 = map[i][j];
                    int v2 = map[i][j + num - 1];
                    int v3 = map[x1][j];
                    int v4 = map[x1][j + num - 1];
                    if (v1 == v2 && v2 == v3 && v3 == v4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
