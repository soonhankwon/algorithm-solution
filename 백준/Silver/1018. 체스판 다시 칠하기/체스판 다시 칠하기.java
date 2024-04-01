import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); //행
        int m = Integer.parseInt(inputs[1]); //열
        // 입력값 저장
        board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }
        // 2가지 케이스가 있음
        // 1. 시작이 B로 시작 또는 W로 시작
        // 2. 2가지 케이스를 모두 완전 탐색해서 최소값을 프린트해줌
        // 3. 8 * 8 로 자른다. -> 체스판 템플릿을 이동시긴다 생각해보자
        // 4. WBWBWBWB 와 BWBWBWBW 를 따로 생각해줌
        // 가로검색 횟수 -> n - 8, 세로검색 횟수 -> m - 8
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                cnt = Math.min(cnt, getMinimumRequiredCnt(i, j));
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static int getMinimumRequiredCnt(int startRow, int startCol) {
        // 두패턴이 짝,홀 또는 홀,짝으로 반복된다.
        String[] patterns = {"WBWBWBWB", "BWBWBWBW"};
        int whiteRequiredCnt = 0;
        // 8 * 8 사이즈를 검색하면서 카운트
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != patterns[row % 2].charAt(j)) {
                    whiteRequiredCnt++;
                }
            }
        }
        // 아래 경우로 W, B로 시작하는 모든 경우를 커버할 수 있음(정확히 반대이기 때문에)
        return Math.min(whiteRequiredCnt, 64 - whiteRequiredCnt);
    }
}
