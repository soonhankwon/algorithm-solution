import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] map;
    static int whiteCnt, blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
            }
        }

        partition(0, 0, n);
        System.out.println(whiteCnt + "\n" + blueCnt);
    }

    private static void partition(int row, int col, int size) {
        // 현재 파티션이 모두 같은 색상이라면 색상 카운트를 증가시키고 종료
        if (isColorSame(row, col, size)) {
            if (map[row][col] == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
            return;
        }

        // 사이즈를 절반으로 줄임
        int newSize = size / 2;
        // recursion
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    // 분할한 종이의 컬러가 같은지 체크
    private static boolean isColorSame(int row, int col, int size) {
        int color = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
