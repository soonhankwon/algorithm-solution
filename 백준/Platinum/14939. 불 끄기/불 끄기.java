import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 10 * 10 격자에서 모든 전구를 끄는 최소 횟수
 * 1. 첫 번째 행의 전구 상태를 결정하는 1024가지 경우의 수를 비트 마스킹을 사용해 탐색
 * 2. 각 경우의 수마다 map 배열을 tempMap 배열로 복사하여 임시 배열을 초기화
 * 3. 비트 마스크에 해당하는 전구 ON -> 각 비트는 행의 각 열 -> 비트가 1이면 전구를 누름 on
 * 4. 두 번째 행부터 9번째 행까지 켜져 있는 전구가 있으면 해당 전구 아래 있는 전구를 on
 * 5. 마지막 열에 켜진 전구가 있는지 확인
 * 6. 모두 꺼져있다면 성공 -> 전구를 누른 횟수 갱신
 */
public class Main {

    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, -1, 1, 0, 0};
    static boolean[][] map, tempMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[10][10];
        tempMap = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (row[j] == 'O') {
                    map[i][j] = true;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 1024; i++) {
            copy();
            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                if (((1 << j) & i) != 0) {
                    on(0, j);
                    cnt++;
                }
            }
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    if (tempMap[j][k]) {
                        on(j + 1, k);
                        cnt++;
                    }
                }
            }
            if (isLight()) {
                answer = Math.min(answer, cnt);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean isLight() {
        for (int i = 0; i < 10; i++) {
            if (tempMap[9][i]) {
                return false;
            }
        }
        return true;
    }

    private static void copy() {
        for (int i = 0; i < 10; i++) {
            tempMap[i] = map[i].clone();
        }
    }

    private static void on(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isMovable(nx, ny)) {
                tempMap[nx][ny] = !tempMap[nx][ny];
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
