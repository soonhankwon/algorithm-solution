import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * N명의 사람을 N/2명으로 나누어 능력치 차이의 최솟값을 구하는 프로그램
 */
public class Main {

    static int[][] abilities; // 능력치
    static boolean[] visited; // 팀 구분 -> true, false
    static int n; // 총 인원
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        abilities = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            abilities[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dfs(0, 0);
        System.out.println(min);
        br.close();
    }

    private static void dfs(int depth, int index) {
        // 스타트팀에 N/2명이 배정되면 계산
        if (depth == n / 2) {
            calculateDifference();
            return;
        }
        // N/2명을 스타트팀에 배정하는 모든 조합 탐색
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 다음 선수 배정
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 두 선수가 모두 스타트팀인 경우
                if (visited[i] && visited[j]) {
                    startTeam += abilities[i][j] + abilities[j][i];
                }
                // 두 선수가 모두 링크팀인 경우
                else if (!visited[i] && !visited[j]) {
                    linkTeam += abilities[i][j] + abilities[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(startTeam - linkTeam));
    }
}